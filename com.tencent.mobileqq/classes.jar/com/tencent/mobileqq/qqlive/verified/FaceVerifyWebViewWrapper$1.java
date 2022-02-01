package com.tencent.mobileqq.qqlive.verified;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

class FaceVerifyWebViewWrapper$1
  extends WebChromeClient
{
  FaceVerifyWebViewWrapper$1(FaceVerifyWebViewWrapper paramFaceVerifyWebViewWrapper) {}
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    return FaceVerifyWebViewWrapper.b(this.a);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    FaceVerifyWebViewWrapper.a(this.a, paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    FaceVerifyWebViewWrapper.a(this.a);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (FaceVerifyWebViewWrapper.f(this.a) != null) {
      FaceVerifyWebViewWrapper.g(this.a).onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    FaceVerifyWebViewWrapper.a(this.a, paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    FaceVerifyWebViewWrapper.a(this.a, paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    FaceVerifyWebViewWrapper.a(this.a, paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    FaceVerifyWebViewWrapper.a(this.a, paramView, paramCustomViewCallback);
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (WBH5FaceVerifySDK.a().a(paramWebView, paramValueCallback, FaceVerifyWebViewWrapper.c(this.a), paramFileChooserParams)) {
      return true;
    }
    if ((paramValueCallback != null) && (FaceVerifyWebViewWrapper.d(this.a) != null)) {
      return FaceVerifyWebViewWrapper.e(this.a).onShowFileChooser(paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    FaceVerifyWebViewWrapper.a(this.a, paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyWebViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */