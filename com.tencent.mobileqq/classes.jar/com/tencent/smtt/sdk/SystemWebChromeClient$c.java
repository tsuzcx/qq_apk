package com.tencent.smtt.sdk;

class SystemWebChromeClient$c
  implements com.tencent.smtt.export.external.interfaces.JsPromptResult
{
  android.webkit.JsPromptResult a;
  
  SystemWebChromeClient$c(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsPromptResult paramJsPromptResult)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.c
 * JD-Core Version:    0.7.0.1
 */