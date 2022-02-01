package com.tencent.mobileqq.nearby.verify;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

class FaceVerifyWebViewWrapper$1
  extends WebChromeClient
{
  FaceVerifyWebViewWrapper$1(FaceVerifyWebViewWrapper paramFaceVerifyWebViewWrapper) {}
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    if (FaceVerifyWebViewWrapper.i(this.a) != null) {
      return FaceVerifyWebViewWrapper.j(this.a).getVideoLoadingProgressView();
    }
    return null;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (FaceVerifyWebViewWrapper.k(this.a) != null) {
      FaceVerifyWebViewWrapper.l(this.a).onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    if (FaceVerifyWebViewWrapper.g(this.a) != null) {
      FaceVerifyWebViewWrapper.h(this.a).onHideCustomView();
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (FaceVerifyWebViewWrapper.u(this.a) != null) {
      FaceVerifyWebViewWrapper.v(this.a).onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("WebLog_WebViewWrapper", 2, localStringBuilder.toString());
    }
    if (FaceVerifyWebViewWrapper.a(this.a) != null) {
      FaceVerifyWebViewWrapper.b(this.a).onProgressChanged(paramWebView, paramInt);
    }
    if ((paramInt > 30) && (!paramWebView.getSettings().getLoadsImagesAutomatically())) {
      paramWebView.getSettings().setLoadsImagesAutomatically(true);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (FaceVerifyWebViewWrapper.m(this.a) != null) {
      FaceVerifyWebViewWrapper.n(this.a).onReceivedTitle(paramWebView, paramString);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (FaceVerifyWebViewWrapper.e(this.a) != null) {
      FaceVerifyWebViewWrapper.f(this.a).showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (FaceVerifyWebViewWrapper.c(this.a) != null) {
      FaceVerifyWebViewWrapper.d(this.a).showCustomView(paramView, 10, paramCustomViewCallback);
    }
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (WBH5FaceVerifySDK.a().a(paramWebView, paramValueCallback, FaceVerifyWebViewWrapper.r(this.a), paramFileChooserParams)) {
      return true;
    }
    if ((paramValueCallback != null) && (FaceVerifyWebViewWrapper.s(this.a) != null)) {
      return FaceVerifyWebViewWrapper.t(this.a).onShowFileChooser(paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (WBH5FaceVerifySDK.a().a(paramValueCallback, paramString1, FaceVerifyWebViewWrapper.o(this.a))) {
      return;
    }
    if (FaceVerifyWebViewWrapper.p(this.a) != null) {
      FaceVerifyWebViewWrapper.q(this.a).openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.FaceVerifyWebViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */