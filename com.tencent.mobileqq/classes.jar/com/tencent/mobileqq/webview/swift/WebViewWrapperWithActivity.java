package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener;

public class WebViewWrapperWithActivity
  extends WebViewWrapper
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private UniformDownload.UniDownloadListener jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener;
  
  public WebViewWrapperWithActivity(AppInterface paramAppInterface, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, paramWebViewCallback, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public WebViewWrapperWithActivity(AppInterface paramAppInterface, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, paramWebViewCallback, paramIntent, paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener = new UniformDownload.UniDownloadListener((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity
 * JD-Core Version:    0.7.0.1
 */