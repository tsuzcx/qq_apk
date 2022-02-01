package com.tencent.mobileqq.qqlive.api.login;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;

public abstract interface IQQLiveModuleLogin
  extends IQQLiveModule
{
  public abstract LoginInfo getLoginInfo();
  
  public abstract LoginRequest getLoginRequest();
  
  public abstract int getLoginStatus();
  
  public abstract LiveUserInfo getUserInfo();
  
  public abstract boolean isLogined();
  
  public abstract void logOut();
  
  public abstract void login(LoginRequest paramLoginRequest, IQQLiveLoginCallback paramIQQLiveLoginCallback);
  
  public abstract void reLogin();
  
  public abstract void registerLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback);
  
  public abstract void unregisterLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin
 * JD-Core Version:    0.7.0.1
 */