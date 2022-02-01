package com.tencent.mobileqq.teamwork;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

class WebViewWrapperForDoc$1
  extends CustomWebChromeClient
{
  WebViewWrapperForDoc$1(WebViewWrapperForDoc paramWebViewWrapperForDoc) {}
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    if (WebViewWrapperForDoc.i(this.f) != null) {
      return WebViewWrapperForDoc.j(this.f).getVideoLoadingProgressView();
    }
    return null;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (WebViewWrapperForDoc.k(this.f) != null) {
      WebViewWrapperForDoc.l(this.f).onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    if (WebViewWrapperForDoc.g(this.f) != null) {
      WebViewWrapperForDoc.h(this.f).onHideCustomView();
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (WebViewWrapperForDoc.s(this.f) != null) {
      WebViewWrapperForDoc.t(this.f).onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("WebLog_WebViewWrapper", 2, localStringBuilder.toString());
    }
    if (WebViewWrapperForDoc.a(this.f) != null) {
      WebViewWrapperForDoc.b(this.f).onProgressChanged(paramWebView, paramInt);
    }
    if ((paramInt > 30) && (!paramWebView.getSettings().getLoadsImagesAutomatically())) {
      paramWebView.getSettings().setLoadsImagesAutomatically(true);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (WebViewWrapperForDoc.m(this.f) != null) {
      WebViewWrapperForDoc.n(this.f).onReceivedTitle(paramWebView, paramString);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (WebViewWrapperForDoc.e(this.f) != null) {
      WebViewWrapperForDoc.f(this.f).showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (WebViewWrapperForDoc.c(this.f) != null) {
      WebViewWrapperForDoc.d(this.f).showCustomView(paramView, 10, paramCustomViewCallback);
    }
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if ((paramValueCallback != null) && (WebViewWrapperForDoc.q(this.f) != null)) {
      return WebViewWrapperForDoc.r(this.f).onShowFileChooser(paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (WebViewWrapperForDoc.o(this.f) != null) {
      WebViewWrapperForDoc.p(this.f).openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.1
 * JD-Core Version:    0.7.0.1
 */