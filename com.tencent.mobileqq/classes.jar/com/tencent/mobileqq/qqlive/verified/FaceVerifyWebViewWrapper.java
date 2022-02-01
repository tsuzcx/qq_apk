package com.tencent.mobileqq.qqlive.verified;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class FaceVerifyWebViewWrapper
  extends WebViewWrapperWithActivity
{
  public FaceVerifyWebViewWrapper(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppRuntime, paramActivity, paramWebViewCallback, paramIntent, paramBoolean);
  }
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.c != null) {
      this.c.showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
  
  private void a(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.c != null) {
      this.c.showCustomView(paramView, 10, paramCustomViewCallback);
    }
  }
  
  private void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (WBH5FaceVerifySDK.a().a(paramValueCallback, paramString1, this.i)) {
      return;
    }
    if (this.c != null) {
      this.c.openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
  
  private void a(WebView paramWebView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("WebLog_WebViewWrapper", 2, localStringBuilder.toString());
    }
    if (this.c != null) {
      this.c.onProgressChanged(paramWebView, paramInt);
    }
    if ((paramInt > 30) && (!paramWebView.getSettings().getLoadsImagesAutomatically())) {
      paramWebView.getSettings().setLoadsImagesAutomatically(true);
    }
  }
  
  private void a(WebView paramWebView, String paramString)
  {
    if (this.c != null) {
      this.c.onReceivedTitle(paramWebView, paramString);
    }
  }
  
  private void a(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (this.c != null) {
      this.c.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  private void g()
  {
    if (this.c != null) {
      this.c.onHideCustomView();
    }
  }
  
  @SuppressLint({"InflateParams"})
  private View h()
  {
    if (this.c != null) {
      return this.c.getVideoLoadingProgressView();
    }
    return null;
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    super.a(paramTouchWebView, paramAppRuntime, paramIntent);
    WBH5FaceVerifySDK.a().a(paramTouchWebView, paramAppRuntime.getApplicationContext());
    paramTouchWebView.setWebChromeClient(new FaceVerifyWebViewWrapper.1(this));
    return paramTouchWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */