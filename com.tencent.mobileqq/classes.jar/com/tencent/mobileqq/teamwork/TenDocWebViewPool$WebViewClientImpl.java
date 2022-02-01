package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class TenDocWebViewPool$WebViewClientImpl
  extends WebViewClient
{
  TenDocWebViewPool$WebViewClientImpl(TenDocWebViewPool paramTenDocWebViewPool) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = new StringBuilder();
    paramWebView.append("tendocpreload onPageFinished = ");
    paramWebView.append(paramString);
    QLog.i("TenDocWebViewPool", 1, paramWebView.toString());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    paramWebView = new StringBuilder();
    paramWebView.append("tendocpreload onPageStarted = ");
    paramWebView.append(paramString);
    QLog.i("TenDocWebViewPool", 1, paramWebView.toString());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocWebViewPool.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */