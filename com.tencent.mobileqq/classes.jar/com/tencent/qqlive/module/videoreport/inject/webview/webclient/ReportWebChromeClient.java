package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public class ReportWebChromeClient
  extends WebChromeClient
{
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebChromeClient
 * JD-Core Version:    0.7.0.1
 */