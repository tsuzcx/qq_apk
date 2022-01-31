package com.tencent.mobileqq.troop.createNewTroop;

import ajbp;
import ajbq;
import ajbr;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewTroopCreateActivity
  extends FragmentActivity
  implements TabBarView.OnTabChangeListener
{
  protected int a;
  protected AnimatorListenerAdapter a;
  protected ValueAnimator.AnimatorUpdateListener a;
  protected Intent a;
  protected View a;
  protected FrameLayout a;
  protected TextView a;
  public AbsNewTroopBaseView a;
  protected NewTroopCateView a;
  protected NewTroopContactView a;
  public TabBarView a;
  protected String a;
  public boolean a;
  protected int b;
  protected TextView b;
  protected int c;
  protected TextView c;
  protected TextView d;
  
  public NewTroopCreateActivity()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new ajbq(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new ajbr(this);
  }
  
  private void a(AbsNewTroopBaseView paramAbsNewTroopBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != paramAbsNewTroopBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView = paramAbsNewTroopBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.b();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_a_of_type_Int, false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView = new NewTroopContactView(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = new NewTroopCateView(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.n();
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getString(2131436227);
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
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_c_of_type_Int }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      localValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
      localValueAnimator.start();
    }
  }
  
  @TargetApi(14)
  protected void b()
  {
    super.setContentView(2130969137);
    View localView = findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localView.setFitsSystemWindows(true);
      }
      localView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362594);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363473));
    this.d = ((TextView)findViewById(2131363428));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131365326));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365327));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131433107));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription(getString(2131433107));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131433108));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(getString(2131433108));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131435990);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (AppSetting.b)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435990));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ajbp(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624738);
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = UIUtils.a(this, 40.0F);
    a();
    b();
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.e();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.b();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a();
    }
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.d();
    }
  }
  
  public void finish()
  {
    super.finish();
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      overridePendingTransition(0, 2131034122);
    case 2: 
      return;
    case 1: 
      overridePendingTransition(2131034129, 2131034130);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a();
    }
    return super.onBackEvent();
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      e();
      return;
    }
    f();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */