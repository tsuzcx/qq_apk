package com.tencent.smtt.sdk;

class SystemWebChromeClient$d
  implements com.tencent.smtt.export.external.interfaces.JsPromptResult
{
  android.webkit.JsPromptResult a;
  
  SystemWebChromeClient$d(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsPromptResult paramJsPromptResult)
  {
    this.a = paramJsPromptResult;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void confirm()
  {
    this.a.confirm();
  }
  
  public void confirm(String paramString)
  {
    this.a.confirm(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.d
 * JD-Core Version:    0.7.0.1
 */