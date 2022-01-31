package com.tencent.smtt.sdk;

class SystemWebViewClient$SslErrorHandlerImpl
  implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
{
  android.webkit.SslErrorHandler mSslErrorHandler;
  
  SystemWebViewClient$SslErrorHandlerImpl(android.webkit.SslErrorHandler paramSslErrorHandler)
  {
    this.mSslErrorHandler = paramSslErrorHandler;
  }
  
  public void cancel()
  {
    this.mSslErrorHandler.cancel();
  }
  
  public void proceed()
  {
    this.mSslErrorHandler.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.SslErrorHandlerImpl
 * JD-Core Version:    0.7.0.1
 */