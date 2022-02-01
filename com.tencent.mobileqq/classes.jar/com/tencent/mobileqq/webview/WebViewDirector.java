package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;

public class WebViewDirector
{
  public long a;
  private IWebViewBuilder a;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  
  public WebViewDirector(IWebViewBuilder paramIWebViewBuilder)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder = paramIWebViewBuilder;
  }
  
  public void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_init_webview_plugin", true))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.preInitWebviewPlugin();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_get_key", true))) {
      WebAccelerateHelper.getInstance().preGetKey(paramIntent, paramAppInterface);
    }
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildLayout();
    long l1 = System.currentTimeMillis();
    this.b = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildContentView(paramBundle);
    l2 = System.currentTimeMillis();
    this.e = (l2 - l1);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildTitleBar();
    l1 = System.currentTimeMillis();
    this.c = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildBottomBar();
    l2 = System.currentTimeMillis();
    this.d = (l2 - l1);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildWebView(paramAppInterface);
    l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Long = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewBuildIWebViewBuilder.buildData();
    this.f = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel()) {
      QLog.i("WebViewDirector", 2, "buildLayoutTime : " + this.b + ", buildContentTime " + this.e + ", buildTitleTime " + this.c + ", buildWebViewTime " + this.jdField_a_of_type_Long + ", buildBottomTime " + this.d + ", buildDataTime " + this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewDirector
 * JD-Core Version:    0.7.0.1
 */