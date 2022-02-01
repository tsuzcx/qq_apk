package com.tencent.mobileqq.qqlive.api.impl.login;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LoginLogic;

public class QQLiveModuleLoginImpl
  implements IQQLiveModuleLogin
{
  private final LoginLogic loginLogic = new LoginLogic();
  
  public void destroy()
  {
    this.loginLogic.destroy();
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.loginLogic.getLoginInfo();
  }
  
  public LoginRequest getLoginRequest()
  {
    return this.loginLogic.getLoginRequest();
  }
  
  public int getLoginStatus()
  {
    return this.loginLogic.getLoginStatus();
  }
  
  public LiveUserInfo getUserInfo()
  {
    return this.loginLogic.getUserInfo();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.loginLogic.init(paramIQQLiveSDK);
  }
  
  public boolean isLogined()
  {
    return this.loginLogic.isLogined();
  }
  
  public void logOut()
  {
    this.loginLogic.logOut();
  }
  
  public void login(LoginRequest paramLoginRequest, IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    this.loginLogic.login(paramLoginRequest, paramIQQLiveLoginCallback);
  }
  
  public void reLogin()
  {
    this.loginLogic.reLogin();
  }
  
  public void registerLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    this.loginLogic.registerLoginStateCallback(paramIQQLiveLoginCallback);
  }
  
  public void reset()
  {
    this.loginLogic.reset();
  }
  
  public void unregisterLoginStateCallback(IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    this.loginLogic.unregisterLoginStateCallback(paramIQQLiveLoginCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.login.QQLiveModuleLoginImpl
 * JD-Core Version:    0.7.0.1
 */