package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public class ReportWebViewClient
  extends WebViewClient
{
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    JsInjector.getInstance().onPageStarted(paramWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebViewClient
 * JD-Core Version:    0.7.0.1
 */