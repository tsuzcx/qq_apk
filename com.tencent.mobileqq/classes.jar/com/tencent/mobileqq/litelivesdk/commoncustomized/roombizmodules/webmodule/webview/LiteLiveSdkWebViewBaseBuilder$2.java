package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.graphics.Bitmap;
import com.tencent.biz.ui.CustomWebViewClient;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;

class LiteLiveSdkWebViewBaseBuilder$2
  extends CustomWebViewClient
{
  LiteLiveSdkWebViewBaseBuilder$2(LiteLiveSdkWebViewBaseBuilder paramLiteLiveSdkWebViewBaseBuilder, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.onPageFinished(paramWebView, paramString);
    super.onPageFinished(paramWebView, paramString);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    QLog.d("AbsWebView", 1, "shouldOverrideUrlLoading: setWebViewClient");
    if (LiteLiveSdkWebViewBaseBuilder.a(this.a, paramString)) {}
    while (super.shouldOverrideUrlLoading(paramWebView, paramString)) {
      return true;
    }
    return this.a.a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewBaseBuilder.2
 * JD-Core Version:    0.7.0.1
 */