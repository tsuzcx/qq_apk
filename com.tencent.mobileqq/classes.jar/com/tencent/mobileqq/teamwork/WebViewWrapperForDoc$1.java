package com.tencent.mobileqq.teamwork;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
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
    if (this.a.a != null) {
      return this.a.a.getVideoLoadingProgressView();
    }
    return null;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (this.a.a != null) {
      this.a.a.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    if (this.a.a != null) {
      this.a.a.onHideCustomView();
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (this.a.a != null) {
      this.a.a.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "onProgressChanged:" + paramInt);
    }
    if (this.a.a != null) {
      this.a.a.onProgressChanged(paramWebView, paramInt);
    }
    if ((paramInt > 30) && (!paramWebView.getSettings().getLoadsImagesAutomatically())) {
      paramWebView.getSettings().setLoadsImagesAutomatically(true);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.onReceivedTitle(paramWebView, paramString);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.a.a != null) {
      this.a.a.showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.a.a != null) {
      this.a.a.showCustomView(paramView, 10, paramCustomViewCallback);
    }
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if ((paramValueCallback != null) && (this.a.a != null)) {
      return this.a.a.onShowFileChooser(paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.1
 * JD-Core Version:    0.7.0.1
 */