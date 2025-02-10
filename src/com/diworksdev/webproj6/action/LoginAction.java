package com.diworksdev.webproj6.action;


import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webproj6.dao.LoginDAO;
import com.diworksdev.webproj6.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();


	public String execute() {
		String ret=ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao=new LoginDAO();
		LoginDTOList=dao.select(username, password);
		if(this.username.equals(LoginDTOList.get(0).getUsername()) &&
	this.password.equals(LoginDTOList.get(0).getPassword())){
			ret= SUCCESS;
	}else{
		ret=ERROR;
	}
	return ret;
	}


	public String getUsername( ) {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword ( ) {
		return password;
	}

	public void setPassword(String password ) {
		this.password = password;
	}

	public List<LoginDTO> getLoginDTOList() {
		return LoginDTOList;
	}

	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		LoginDTOList = loginDTOList;
	}

}
