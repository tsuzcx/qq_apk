package com.tencent.mobileqq.nearby.verify;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity;
import mqq.app.AppRuntime;

public class FaceVerifyWebViewWrapper
  extends WebViewWrapperWithActivity
{
  public FaceVerifyWebViewWrapper(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppRuntime, paramActivity, paramWebViewCallback, paramIntent, paramBoolean);
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    super.a(paramTouchWebView, paramAppRuntime, paramIntent);
    WBH5FaceVerifySDK.a().a(paramTouchWebView, paramAppRuntime.getApplicationContext());
    paramTouchWebView.setWebChromeClient(new FaceVerifyWebViewWrapper.1(this));
    return paramTouchWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.FaceVerifyWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */