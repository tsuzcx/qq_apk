package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.open.api.WebViewOpenSdkApi;
import com.tencent.smtt.sdk.DownloadListener;
import mqq.app.AppRuntime;

public class WebViewWrapperWithActivity
  extends WebViewWrapper
{
  protected Activity i;
  
  public WebViewWrapperWithActivity(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppRuntime, paramWebViewCallback, paramIntent, paramTouchWebView);
    this.i = paramActivity;
    f();
  }
  
  public WebViewWrapperWithActivity(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppRuntime, paramWebViewCallback, paramIntent, paramActivity, paramBoolean);
    this.i = paramActivity;
    f();
  }
  
  protected boolean e()
  {
    Activity localActivity = this.i;
    return (localActivity != null) && (localActivity.isFinishing());
  }
  
  public void f()
  {
    DownloadListener localDownloadListener = (DownloadListener)WebViewOpenSdkApi.a().a(this.i, this.b, this.d, this.e);
    this.d.setDownloadListener(localDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity
 * JD-Core Version:    0.7.0.1
 */