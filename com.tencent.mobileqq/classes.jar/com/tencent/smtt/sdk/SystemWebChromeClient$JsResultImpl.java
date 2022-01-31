package com.tencent.smtt.sdk;

class SystemWebChromeClient$JsResultImpl
  implements com.tencent.smtt.export.external.interfaces.JsResult
{
  android.webkit.JsResult mJsResult;
  
  SystemWebChromeClient$JsResultImpl(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsResult paramJsResult)
  {
    this.mJsResult = paramJsResult;
  }
  
  public void cancel()
  {
    this.mJsResult.cancel();
  }
  
  public void confirm()
  {
    this.mJsResult.confirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.JsResultImpl
 * JD-Core Version:    0.7.0.1
 */