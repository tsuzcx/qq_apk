package com.tencent.mobileqq.webview;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

class AbsWebView$5
  extends CustomWebChromeClient
{
  AbsWebView$5(AbsWebView paramAbsWebView) {}
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "show custom view called");
    }
    this.f.showCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public View getVideoLoadingProgressView()
  {
    return this.f.getVideoLoadingProgressView();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGeolocationPermissionsShowPrompt:");
      localStringBuilder.append(paramString);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    this.f.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "hide custom view called");
    }
    this.f.onHideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.f.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    if ((this.f.mProgressBarController != null) && (this.f.mProgressBarController.d() == 0)) {
      this.f.mProgressBarController.a((byte)1);
    }
    if (paramInt == 100) {
      this.f.showProgressBar(false);
    }
    this.f.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.f.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, paramInt, paramCustomViewCallback);
  }
  
  @SuppressLint({"InlinedApi"})
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.f.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.5
 * JD-Core Version:    0.7.0.1
 */