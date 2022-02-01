package com.tencent.mobileqq.richstatus;

import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class ActionUrlActivity$UrlActionWebChromeClient
  extends WebChromeClient
{
  private ActionUrlActivity$UrlActionWebChromeClient(ActionUrlActivity paramActionUrlActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramString);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity.UrlActionWebChromeClient
 * JD-Core Version:    0.7.0.1
 */