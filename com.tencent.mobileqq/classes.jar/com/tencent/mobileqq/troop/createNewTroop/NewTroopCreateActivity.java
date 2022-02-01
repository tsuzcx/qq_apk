package com.tencent.mobileqq.troop.createNewTroop;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopCateView;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewTroopCreateActivity
  extends BaseActivity
  implements TabBarView.OnTabChangeListener
{
  protected int a;
  protected AnimatorListenerAdapter a;
  protected ValueAnimator.AnimatorUpdateListener a;
  protected Intent a;
  protected View a;
  protected FrameLayout a;
  protected TextView a;
  protected AbsNewTroopBaseView a;
  protected NewTroopCateView a;
  protected NewTroopContactView a;
  protected TabBarView2 a;
  protected String a;
  protected boolean a;
  protected int b;
  protected TextView b;
  protected int c;
  protected TextView c;
  protected TextView d;
  
  public NewTroopCreateActivity()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new NewTroopCreateActivity.2(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new NewTroopCreateActivity.3(this);
  }
  
  private void a(AbsNewTroopBaseView paramAbsNewTroopBaseView)
  {
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != paramAbsNewTroopBaseView)
    {
      if (localAbsNewTroopBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView = paramAbsNewTroopBaseView;
      paramAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
      if (paramAbsNewTroopBaseView != null)
      {
        paramAbsNewTroopBaseView.a();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView.b();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelectedTab(this.jdField_a_of_type_Int, false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView = new NewTroopContactView(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView = new NewTroopCateView(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView);
    NewTroopContactView localNewTroopContactView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView;
    if (localNewTroopContactView != null) {
      localNewTroopContactView.n();
    }
    ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "exp_grptype", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getString(2131691274);
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_default_tab", 0);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
  }
  
  public void a(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { -this.jdField_c_of_type_Int, 0 }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      localValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
      localValueAnimator.start();
    }
    else
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_c_of_type_Int }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      localValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
      localValueAnimator.start();
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(14)
  protected void b()
  {
    super.setContentView(2131559501);
    View localView = findViewById(2131376809);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localView.setFitsSystemWindows(true);
      }
      localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378803);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369204));
    this.d = ((TextView)findViewById(2131369233));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131379375));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379376));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(0, getString(2131719981));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(0).setContentDescription(getString(2131719981));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(1, getString(2131719982));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(1).setContentDescription(getString(2131719982));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718706);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718706));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new NewTroopCreateActivity.1(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755317);
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = DisplayUtil.a(this, 40.0F);
    a();
    b();
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView;
    if (localObject != null) {
      ((NewTroopCateView)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView;
    if (localObject != null) {
      ((NewTroopContactView)localObject).e();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.b();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.a();
    }
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.d();
    }
  }
  
  public void finish()
  {
    super.finish();
    int i = this.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          overridePendingTransition(0, 2130771992);
          return;
        }
        overridePendingTransition(0, 0);
      }
    }
    else {
      overridePendingTransition(2130772002, 2130772003);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView;
    if (localAbsNewTroopBaseView != null) {
      return localAbsNewTroopBaseView.a();
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return;
      }
      f();
      return;
    }
    e();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */