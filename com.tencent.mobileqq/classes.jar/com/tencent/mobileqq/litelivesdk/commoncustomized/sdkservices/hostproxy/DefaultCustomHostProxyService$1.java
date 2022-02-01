package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy;

import com.tencent.falco.base.libapi.hostproxy.HostLoginInterface;
import com.tencent.falco.base.libapi.hostproxy.LoginRequestCallback;
import com.tencent.falco.base.libapi.hostproxy.LoginResultCallback;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;

class DefaultCustomHostProxyService$1
  implements HostLoginInterface
{
  DefaultCustomHostProxyService$1(DefaultCustomHostProxyService paramDefaultCustomHostProxyService) {}
  
  public void onGetLoginRequestInfo(LoginRequestCallback paramLoginRequestCallback)
  {
    if (paramLoginRequestCallback != null)
    {
      if (LoginManager.c.d() != null)
      {
        paramLoginRequestCallback.onGetSuccess(LoginManager.c.d());
        return;
      }
      paramLoginRequestCallback.onGetFail();
    }
  }
  
  public void onLoginInvalid()
  {
    LoginManager.c.a();
  }
  
  public void onQQConnectLogin(LoginResultCallback paramLoginResultCallback) {}
  
  public void onReLogin()
  {
    LoginManager.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService.1
 * JD-Core Version:    0.7.0.1
 */