package com.tencent.smtt.sdk;

class SystemWebChromeClient$d
  implements com.tencent.smtt.export.external.interfaces.JsResult
{
  android.webkit.JsResult a;
  
  SystemWebChromeClient$d(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsResult paramJsResult)
  {
    this.a = paramJsResult;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void confirm()
  {
    this.a.confirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.d
 * JD-Core Version:    0.7.0.1
 */