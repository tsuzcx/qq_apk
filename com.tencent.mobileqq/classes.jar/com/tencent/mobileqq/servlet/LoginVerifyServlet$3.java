package com.tencent.mobileqq.servlet;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

final class LoginVerifyServlet$3
  implements LoginVerifyServlet.IHttpsCallback
{
  LoginVerifyServlet$3(BusinessObserver paramBusinessObserver) {}
  
  public void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dataErrorMsg", paramString);
    localBundle.putInt("dataErrorCode", paramInt);
    this.a.onReceive(0, false, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", paramString.getBytes());
    localBundle.putString("cmd", "getAppConfig");
    this.a.onReceive(0, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.LoginVerifyServlet.3
 * JD-Core Version:    0.7.0.1
 */