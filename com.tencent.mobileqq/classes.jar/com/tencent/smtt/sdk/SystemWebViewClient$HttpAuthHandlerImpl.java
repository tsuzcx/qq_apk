package com.tencent.smtt.sdk;

class SystemWebViewClient$HttpAuthHandlerImpl
  implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
{
  private android.webkit.HttpAuthHandler mHandler;
  
  SystemWebViewClient$HttpAuthHandlerImpl(android.webkit.HttpAuthHandler paramHttpAuthHandler)
  {
    this.mHandler = paramHttpAuthHandler;
  }
  
  public void cancel()
  {
    this.mHandler.cancel();
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    this.mHandler.proceed(paramString1, paramString2);
  }
  
  public boolean useHttpAuthUsernamePassword()
  {
    return this.mHandler.useHttpAuthUsernamePassword();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.HttpAuthHandlerImpl
 * JD-Core Version:    0.7.0.1
 */