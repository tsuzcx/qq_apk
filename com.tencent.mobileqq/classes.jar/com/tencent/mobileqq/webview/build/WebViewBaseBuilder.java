package com.tencent.mobileqq.webview.build;

import ajye;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class WebViewBaseBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public View a;
  public FrameLayout a;
  public LinearLayout a;
  public RelativeLayout a;
  public WebViewTitlerBar a;
  public SystemBarCompact a;
  public View b;
  public FrameLayout b;
  public AppInterface b;
  public Intent d;
  public boolean e = true;
  public Context f;
  public boolean f;
  public Activity h;
  public String j;
  public String k;
  
  public WebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_AndroidContentContext = paramContext;
    this.jdField_h_of_type_AndroidAppActivity = paramActivity;
    this.d = paramIntent;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  @TargetApi(14)
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "initLayout");
    }
    View localView = LayoutInflater.from(this.jdField_f_of_type_AndroidContentContext).inflate(2130971674, null);
    this.jdField_h_of_type_AndroidAppActivity.setContentView(localView);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131375267);
    if ((this.e) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(this.jdField_f_of_type_Boolean);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366324));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372909));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367095));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363031));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375268);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364094));
    if ((this.d != null) && (!this.d.getBooleanExtra("webview_hide_progress", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131366727));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout");
    }
    j();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(this.jdField_f_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setId(2131362556);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onCreate");
    }
    if ((this.d != null) && (this.d.getBooleanExtra("window_no_title", true))) {
      this.jdField_h_of_type_AndroidAppActivity.requestWindowFeature(1);
    }
    if ((this.e) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_h_of_type_AndroidAppActivity.getWindow().addFlags(67108864);
      int i = this.jdField_h_of_type_AndroidAppActivity.getResources().getColor(2131494247);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this.jdField_h_of_type_AndroidAppActivity, true, i);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    super.b(this.d);
  }
  
  public void a(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public final void a(AppInterface paramAppInterface)
  {
    super.b(paramAppInterface);
    e();
  }
  
  public void a(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "adjustLayout");
    }
    int i = ImmersiveUtils.a(this.jdField_f_of_type_AndroidContentContext);
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin = i;
      paramImmersiveParam.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localLayoutParams.addRule(3, 0);
      paramImmersiveParam.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = i;
    paramImmersiveParam.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)paramImmersiveParam.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = (i + DisplayUtil.a(this.jdField_f_of_type_AndroidContentContext, 50.0F));
    paramImmersiveParam.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  @TargetApi(14)
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onResume");
    }
    super.u();
  }
  
  @TargetApi(14)
  public void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout...context");
    }
    j();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramContext);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setId(2131362556);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void b(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onImmersive");
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
      paramImmersiveParam.jdField_b_of_type_AndroidViewView.getBackground().setAlpha(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
    }
    paramImmersiveParam.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845743);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.a(255, 0);
  }
  
  public void b_(boolean paramBoolean) {}
  
  public void c()
  {
    super.v();
  }
  
  public void c(Bundle paramBundle) {}
  
  public void c(View paramView)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public final void c(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "setTittlebarImmersive");
    }
    a(paramBoolean, paramImmersiveParam);
    b(paramBoolean, paramImmersiveParam);
  }
  
  public final void c_()
  {
    super.y();
  }
  
  public void d()
  {
    super.w();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onWebViewReady");
    }
    String str = this.d.getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildTitleBar");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar = new WebViewTitlerBar(this.jdField_h_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130845743);
    if (this.d != null)
    {
      this.j = this.d.getStringExtra("webview_title");
      this.k = this.d.getStringExtra("webview_left_name");
      if (!TextUtils.isEmpty(this.j)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.c(this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.a(this.k);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.a(new ajye(this));
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.WebViewBaseBuilder
 * JD-Core Version:    0.7.0.1
 */