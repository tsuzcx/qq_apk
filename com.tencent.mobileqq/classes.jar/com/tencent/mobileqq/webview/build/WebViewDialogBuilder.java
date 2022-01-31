package com.tencent.mobileqq.webview.build;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;

public class WebViewDialogBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public Activity a;
  protected Intent a;
  public Context b;
  protected AppInterface b;
  
  public WebViewDialogBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a() {}
  
  public final void a(AppInterface paramAppInterface)
  {
    super.b(paramAppInterface);
    e();
  }
  
  public void b(Bundle paramBundle) {}
  
  public final void c_()
  {
    super.y();
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.WebViewDialogBuilder
 * JD-Core Version:    0.7.0.1
 */