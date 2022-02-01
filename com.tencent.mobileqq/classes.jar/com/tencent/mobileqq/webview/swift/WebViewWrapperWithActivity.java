package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.smtt.sdk.DownloadListener;
import mqq.app.AppRuntime;

public class WebViewWrapperWithActivity
  extends WebViewWrapper
{
  protected Activity a;
  
  public WebViewWrapperWithActivity(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppRuntime, paramWebViewCallback, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    c();
  }
  
  public WebViewWrapperWithActivity(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppRuntime, paramWebViewCallback, paramIntent, paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    c();
  }
  
  protected boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    return (localActivity != null) && (localActivity.isFinishing());
  }
  
  public void c()
  {
    DownloadListener localDownloadListener = (DownloadListener)((IWebViewOpenSdkApi)QRoute.api(IWebViewOpenSdkApi.class)).createDownloadListener(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(localDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity
 * JD-Core Version:    0.7.0.1
 */