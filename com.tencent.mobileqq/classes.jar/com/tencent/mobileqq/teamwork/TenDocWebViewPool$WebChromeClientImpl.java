package com.tencent.mobileqq.teamwork;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class TenDocWebViewPool$WebChromeClientImpl
  extends WebChromeClient
{
  TenDocWebViewPool$WebChromeClientImpl(TenDocWebViewPool paramTenDocWebViewPool) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
    paramWebView = new StringBuilder();
    paramWebView.append("tendocpreload onProgressChanged = ");
    paramWebView.append(paramInt);
    QLog.i("TenDocWebViewPool", 1, paramWebView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocWebViewPool.WebChromeClientImpl
 * JD-Core Version:    0.7.0.1
 */