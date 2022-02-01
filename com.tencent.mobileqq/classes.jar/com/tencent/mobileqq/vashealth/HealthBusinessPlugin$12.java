package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.view.ISPlayerVideoView;

class HealthBusinessPlugin$12
  implements View.OnClickListener
{
  HealthBusinessPlugin$12(HealthBusinessPlugin paramHealthBusinessPlugin, HealthBusinessPlugin.SportVideoLayoutHolder paramSportVideoLayoutHolder, ISPlayerVideoView paramISPlayerVideoView, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i;
    Object localObject2;
    if (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$SportVideoLayoutHolder.c.setImageResource(2130841963);
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setOnTouchListener(new HealthBusinessPlugin.12.1(this));
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(2131377159).setVisibility(8);
      if (((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setRequestedOrientation(0);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.h = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getScrollX();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.i = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getScrollY();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().scrollTo(0, 0);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, 0);
      localObject1 = ((ViewGroup)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d = ((ViewGroup.LayoutParams)localObject1).height;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
      ((ViewGroup.LayoutParams)localObject1).width = -1;
      ((ViewGroup.LayoutParams)localObject1).height = -1;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_Int = ((FrameLayout.LayoutParams)localObject1).topMargin;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b = ((FrameLayout.LayoutParams)localObject1).leftMargin;
      ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = 0;
      i = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
      int j = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().heightPixels;
      QLog.d("HealthBusinessPlugin", 2, "FullScreenWidth ScreenWidth:" + i);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.e = ((FrameLayout.LayoutParams)localObject2).width;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f = ((FrameLayout.LayoutParams)localObject2).height;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.g = ((FrameLayout.LayoutParams)localObject2).topMargin;
      ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
      ((FrameLayout.LayoutParams)localObject2).width = j;
      ((FrameLayout.LayoutParams)localObject2).height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ViewGroup)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = false)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(2131377159).setVisibility(0);
      if (((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 8);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$SportVideoLayoutHolder.c.setImageResource(2130841962);
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setOnTouchListener(null);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().getAttributes();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setRequestedOrientation(1);
      ((WindowManager.LayoutParams)localObject1).flags &= 0xFFFFFBFF;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().clearFlags(512);
      localObject1 = ((ViewGroup)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).topMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_Int;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b;
      ((ViewGroup.LayoutParams)localObject1).height = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d;
      ((ViewGroup.LayoutParams)localObject1).width = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().scrollTo(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.h, this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.i);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.h, this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.i + this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_ComTencentBizUiTouchWebView.mTotalYoffset);
      i = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
      QLog.d("HealthBusinessPlugin", 2, "onBACKFullScreenWidth ScreenWidth:" + i);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).width = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.e;
      ((FrameLayout.LayoutParams)localObject2).height = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f;
      ((FrameLayout.LayoutParams)localObject2).topMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.g;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ViewGroup)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.12
 * JD-Core Version:    0.7.0.1
 */