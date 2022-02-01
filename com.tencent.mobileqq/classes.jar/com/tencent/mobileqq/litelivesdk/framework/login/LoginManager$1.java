package com.tencent.mobileqq.litelivesdk.framework.login;

import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;

class LoginManager$1
  implements IBizLoginObserver
{
  LoginManager$1(LoginManager paramLoginManager, ILiveLoginTicketListener paramILiveLoginTicketListener) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(BizLoginRequest paramBizLoginRequest)
  {
    this.b.a(LoginManager.a(paramBizLoginRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.login.LoginManager.1
 * JD-Core Version:    0.7.0.1
 */