package com.tencent.mobileqq.now.enter;

import agak;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class NowFestivalWebViewFragment
  extends WebViewFragment
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private View g;
  
  private void h()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { 0.7F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { 0.7F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.start();
  }
  
  private void i()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "translationY", new float[] { 0.0F, -500.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setInterpolator(new AccelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.start();
    ThreadManager.getUIHandler().postDelayed(new agak(this), 300L);
  }
  
  protected int c(Bundle paramBundle)
  {
    int i = super.c(paramBundle);
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      QLog.i("NowFestivalWebViewFragment", 1, "doCreateLoopStep_InitUIContent, mActivity == null");
      return i;
    }
    if (!this.d)
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362855);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362856);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("is_need_zoom_in_anim", true)) {
        h();
      }
      this.d = true;
    }
    i();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    return i;
  }
  
  protected int e(Bundle paramBundle)
  {
    QLog.i("NowFestivalWebViewFragment", 1, "doCreateLoopStep_InitUIFrame");
    int i = super.e(paramBundle);
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      QLog.i("NowFestivalWebViewFragment", 1, "doCreateLoopStep_InitUIFrame, mActivity == null");
    }
    while (this.jdField_c_of_type_Boolean) {
      return i;
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130968609, null);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.findViewById(2131366766);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a = 0;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492924);
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130839544);
    }
    this.jdField_c_of_type_Boolean = true;
    return i;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      new ReportTask(null).a("dc00899").b("Grp_AIO").c("year_icon").d("page_time").a(new String[] { String.valueOf(l1 - l2) }).a();
    }
    QLog.i("NowFestivalWebViewFragment", 1, "receive finish js bc");
    this.jdField_a_of_type_Boolean = true;
    if (!this.d) {
      if (QLog.isColorLevel()) {
        QLog.i("NowFestivalWebViewFragment", 0, "onReceivePageFinishedByJs, but mIsHasInitUIContent == false");
      }
    }
    while ((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    i();
  }
  
  public void g()
  {
    QLog.i("NowFestivalWebViewFragment", 3, "startLoadUrl-----");
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      if (!this.jdField_g_of_type_JavaLangString.contains("auto="))
      {
        if (this.jdField_g_of_type_JavaLangString.contains("?")) {
          this.jdField_g_of_type_JavaLangString += "&auto=fasle";
        }
      }
      else
      {
        QLog.i("NowFestivalWebViewFragment", 3, "startLoadUrl, url = " + this.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_g_of_type_JavaLangString = (this.jdField_g_of_type_JavaLangString + "&t=" + this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      super.g();
      return;
      this.jdField_g_of_type_JavaLangString += "?auto=fasle";
      break;
      QLog.i("NowFestivalWebViewFragment", 1, "startLoadUrl, url is empty");
    }
  }
  
  public void n()
  {
    super.n();
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      new ReportTask(null).a("dc00899").b("Grp_AIO").c("year_icon").d("default_click").a(new String[] { "2" }).a();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (AppNetConnInfo.isNetSupport())
    {
      i();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        g();
      }
    }
    for (;;)
    {
      new ReportTask(null).a("dc00899").b("Grp_AIO").c("year_icon").d("default_click").a(new String[] { "1" }).a();
      return;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, "网络异常，请稍候再试", 0).a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setBackgroundResource(2130839544);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment
 * JD-Core Version:    0.7.0.1
 */