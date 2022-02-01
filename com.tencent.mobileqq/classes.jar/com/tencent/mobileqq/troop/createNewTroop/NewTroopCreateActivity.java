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
  protected Intent a;
  protected View b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  protected int g;
  protected TabBarView2 h;
  protected FrameLayout i;
  protected String j;
  protected int k;
  protected AbsNewTroopBaseView l;
  protected NewTroopContactView m;
  protected NewTroopCateView n;
  protected int o;
  protected boolean p;
  protected ValueAnimator.AnimatorUpdateListener q = new NewTroopCreateActivity.2(this);
  protected AnimatorListenerAdapter r = new NewTroopCreateActivity.3(this);
  
  private void a(AbsNewTroopBaseView paramAbsNewTroopBaseView)
  {
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != paramAbsNewTroopBaseView)
    {
      if (localAbsNewTroopBaseView != null)
      {
        if (isResume()) {
          this.l.c();
        }
        this.l.d();
      }
      this.l = paramAbsNewTroopBaseView;
      paramAbsNewTroopBaseView = this.l;
      if (paramAbsNewTroopBaseView != null)
      {
        paramAbsNewTroopBaseView.a();
        if (isResume()) {
          this.l.b();
        }
        this.i.removeAllViews();
        this.i.addView(this.l);
      }
    }
  }
  
  private void d()
  {
    this.h.setSelectedTab(this.g, false);
  }
  
  private void e()
  {
    if (this.m == null)
    {
      this.m = new NewTroopContactView(this);
      this.m.a(this);
    }
    a(this.m);
  }
  
  private void f()
  {
    if (this.n == null)
    {
      this.n = new NewTroopCateView(this);
      this.n.a(this);
    }
    a(this.n);
    NewTroopContactView localNewTroopContactView = this.m;
    if (localNewTroopContactView != null) {
      localNewTroopContactView.o();
    }
    ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "exp_grptype", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    this.a = getIntent();
    this.j = this.a.getStringExtra("param_title");
    if (this.j == null) {
      this.j = getString(2131888224);
    }
    this.g = this.a.getIntExtra("param_default_tab", 0);
    this.k = this.a.getIntExtra("param_exit_animation", 0);
  }
  
  public void a(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { -this.o, 0 }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.q);
      localValueAnimator.addListener(this.r);
      localValueAnimator.start();
    }
    else
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.o }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.q);
      localValueAnimator.addListener(this.r);
      localValueAnimator.start();
    }
    this.p = paramBoolean;
  }
  
  @TargetApi(14)
  protected void b()
  {
    super.setContentView(2131625523);
    View localView = findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localView.setFitsSystemWindows(true);
      }
      localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.b = findViewById(2131447484);
    this.c = ((TextView)findViewById(2131436227));
    this.d = ((TextView)findViewById(2131436180));
    this.e = ((TextView)findViewById(2131436182));
    this.f = ((TextView)findViewById(2131436211));
    this.h = ((TabBarView2)findViewById(2131448115));
    this.i = ((FrameLayout)findViewById(2131448116));
    this.h.setTabTitleList(new String[] { getString(2131917586), getString(2131917587) });
    this.h.a(0, getString(2131917586));
    this.h.b(0).setContentDescription(getString(2131917586));
    this.h.a(1, getString(2131917587));
    this.h.b(1).setContentDescription(getString(2131917587));
    this.h.setOnTabChangeListener(this);
  }
  
  protected void c()
  {
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.d.setText(2131916208);
    this.d.setBackgroundResource(0);
    this.d.setPadding(0, 0, 0, 0);
    this.c.setText(this.j);
    if (AppSetting.e)
    {
      this.c.setContentDescription(this.j);
      this.d.setContentDescription(getString(2131916208));
    }
    this.d.setOnClickListener(new NewTroopCreateActivity.1(this));
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
    if (!this.p) {
      a(true);
    }
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131952010);
    super.doOnCreate(paramBundle);
    this.o = DisplayUtil.a(this, 40.0F);
    a();
    b();
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((NewTroopCateView)localObject).e();
    }
    localObject = this.m;
    if (localObject != null) {
      ((NewTroopContactView)localObject).e();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.b();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.a();
    }
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      localAbsNewTroopBaseView.d();
    }
  }
  
  public void finish()
  {
    super.finish();
    int i1 = this.k;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          overridePendingTransition(0, 2130771995);
          return;
        }
        overridePendingTransition(0, 0);
      }
    }
    else {
      overridePendingTransition(2130772005, 2130772006);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    AbsNewTroopBaseView localAbsNewTroopBaseView = this.l;
    if (localAbsNewTroopBaseView != null) {
      return localAbsNewTroopBaseView.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */