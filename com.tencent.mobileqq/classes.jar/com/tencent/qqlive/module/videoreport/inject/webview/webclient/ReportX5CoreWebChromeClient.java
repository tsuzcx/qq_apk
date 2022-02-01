package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class ReportX5CoreWebChromeClient
  extends WebChromeClient
{
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient
 * JD-Core Version:    0.7.0.1
 */