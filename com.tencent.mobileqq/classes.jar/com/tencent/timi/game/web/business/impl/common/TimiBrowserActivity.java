package com.tencent.timi.game.web.business.impl.common;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.utils.ScreenUtils;

public class TimiBrowserActivity
  extends QQBrowserActivity
{
  public String a = "";
  public int b = 0;
  public boolean c = false;
  private View d;
  private View e;
  private TimiGamePageLoadingView f;
  private ObjectAnimator g;
  private int h = 456;
  private String i = "";
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, TimiBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("finish_animation_none", true);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void h()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.a = localIntent.getStringExtra("inscription_data_anchor_id");
      this.b = localIntent.getIntExtra("inscription_data_game_id", 0);
      this.c = localIntent.getBooleanExtra("inscription_data_is_anchor", false);
      this.h = localIntent.getIntExtra("tg_data_height", 456);
      this.i = localIntent.getStringExtra("tg_data_from");
    }
  }
  
  private void i()
  {
    overridePendingTransition(0, 0);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
  }
  
  private void j()
  {
    k();
    l();
    m();
    f();
  }
  
  private void k()
  {
    this.d = findViewById(2131431345);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, (int)UITools.a(this, a()));
    localLayoutParams.gravity = 80;
    this.d.setLayoutParams(localLayoutParams);
    this.d.setVisibility(8);
    int j = c();
    if (j != 0) {
      this.d.setBackgroundResource(j);
    }
    this.d.setOnClickListener(new TimiBrowserActivity.1(this));
    ViewCompat.setElevation(this.d, 1.0F);
  }
  
  private void l()
  {
    View localView = findViewById(2131429740);
    if (localView != null) {
      localView.setBackgroundResource(2131168376);
    }
  }
  
  private void m()
  {
    ViewParent localViewParent = this.d.getParent();
    if ((localViewParent instanceof FrameLayout)) {
      ((FrameLayout)localViewParent).addView(n());
    }
  }
  
  private View n()
  {
    if (this.e == null)
    {
      this.e = new View(getApplicationContext());
      this.e.setBackgroundColor(0);
      this.e.setOnClickListener(new TimiBrowserActivity.2(this));
      this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, (int)(ScreenUtils.b() - UITools.a(this, a()))));
    }
    return this.e;
  }
  
  private void o()
  {
    if (this.f == null)
    {
      this.f = new TimiGamePageLoadingView(this);
      ViewParent localViewParent = this.d.getParent();
      if ((localViewParent instanceof FrameLayout))
      {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, (int)UITools.a(this, a()));
        localLayoutParams.gravity = 80;
        ((FrameLayout)localViewParent).addView(this.f, localLayoutParams);
      }
      this.f.setHintText("加载中");
    }
  }
  
  public int a()
  {
    return this.h;
  }
  
  public Class<? extends WebViewFragment> b()
  {
    return TimiBrowserFragment.class;
  }
  
  public int c()
  {
    if ("tg_timi_browser_from_inscription".equals(this.i)) {
      return 2130853180;
    }
    return 2130853178;
  }
  
  public void d()
  {
    if (this.d == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = this.g;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      return;
    }
    this.g = ObjectAnimator.ofFloat(this.d, "translationY", new float[] { (int)UITools.a(this, a()), 0.0F });
    this.g.setDuration(500L);
    this.g.setInterpolator(CommonAnimationUtil.SlideUpAnimation.a);
    this.g.addListener(new TimiBrowserActivity.3(this));
    this.g.start();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    e();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    h();
    this.mFragmentClass = b();
    i();
    boolean bool = super.doOnCreate(paramBundle);
    j();
    return bool;
  }
  
  public void e()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if (((View)localObject).getVisibility() == 8)
    {
      finish();
      return;
    }
    localObject = ObjectAnimator.ofFloat(this.d, "translationY", new float[] { 0.0F, (int)UITools.a(this, a()) });
    ((ObjectAnimator)localObject).setDuration(500L);
    ((ObjectAnimator)localObject).setInterpolator(CommonAnimationUtil.SlideUpAnimation.b);
    ((ObjectAnimator)localObject).addListener(new TimiBrowserActivity.4(this));
    ((ObjectAnimator)localObject).start();
  }
  
  public void f()
  {
    o();
    this.f.a();
  }
  
  public void g()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.f;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity
 * JD-Core Version:    0.7.0.1
 */