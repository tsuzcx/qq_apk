package com.tencent.mobileqq.webview;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
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
    this.a.showCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public View getVideoLoadingProgressView()
  {
    return this.a.getVideoLoadingProgressView();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    this.a.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "hide custom view called");
    }
    this.a.onHideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
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
      QLog.d("AbsWebView", 2, "onProgressChanged:" + paramInt);
    }
    if ((this.a.mProgressBarController != null) && (this.a.mProgressBarController.b() == 0)) {
      this.a.mProgressBarController.a((byte)1);
    }
    if (paramInt == 100) {
      this.a.showProgressBar(false);
    }
    this.a.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.onReceivedTitle(paramWebView, paramString);
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
    this.a.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.5
 * JD-Core Version:    0.7.0.1
 */