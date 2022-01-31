package com.tencent.smtt.sdk;

class SystemWebChromeClient$JsPromptResultImpl
  implements com.tencent.smtt.export.external.interfaces.JsPromptResult
{
  android.webkit.JsPromptResult mJsPromptResult;
  
  SystemWebChromeClient$JsPromptResultImpl(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsPromptResult paramJsPromptResult)
  {
    this.mJsPromptResult = paramJsPromptResult;
  }
  
  public void cancel()
  {
    this.mJsPromptResult.cancel();
  }
  
  public void confirm()
  {
    this.mJsPromptResult.confirm();
  }
  
  public void confirm(String paramString)
  {
    this.mJsPromptResult.confirm(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.JsPromptResultImpl
 * JD-Core Version:    0.7.0.1
 */