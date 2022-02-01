package com.tencent.mobileqq.qqgift.webview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class QQGiftHalfTranslucentBrowserActivity
  extends QQBrowserActivity
{
  private int a = 0;
  private int b = 0;
  private View c;
  private View d;
  private View e;
  
  public QQGiftHalfTranslucentBrowserActivity()
  {
    this.mFragmentClass = QQGiftHalfTranslucentBrowserActivity.QQGiftRechargeBrowserFragment.class;
  }
  
  private View a(@NonNull DisplayMetrics paramDisplayMetrics, View paramView, int paramInt)
  {
    if (this.c == null)
    {
      this.c = new View(getApplicationContext());
      this.c.setId(2131444400);
      this.c.setBackgroundColor(0);
      this.c.setOnClickListener(new QQGiftHalfTranslucentBrowserActivity.1(this));
      int i = paramDisplayMetrics.heightPixels;
      this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, i - paramInt));
    }
    return this.c;
  }
  
  private View a(ViewParent paramViewParent, int paramInt)
  {
    if ((this.d == null) && ((paramViewParent instanceof ViewGroup)))
    {
      this.d = LayoutInflater.from(getApplicationContext()).inflate(2131627979, (ViewGroup)paramViewParent, false);
      this.d.setVisibility(8);
      paramViewParent = new FrameLayout.LayoutParams(-1, paramInt);
      paramViewParent.gravity = 80;
      this.d.setLayoutParams(paramViewParent);
      this.d.setBackgroundColor(Color.parseColor("#FF1B1C26"));
    }
    return this.d;
  }
  
  private TranslateAnimation a(Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(125L);
    localTranslateAnimation.setAnimationListener(paramAnimationListener);
    return localTranslateAnimation;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, QQGiftHalfTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.setData(Uri.parse(paramString));
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("extra_web_recharge_callback_key", paramInt1);
    localIntent.putExtra("extra_web_open_recharge_process_id_key", MobileQQ.sProcessId);
    localIntent.putExtra("finish_animation_none", true);
    localIntent.putExtra("extra_web_scene_id_key", paramInt2);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_left_button", true);
    localIntent.putExtra("hide_more_button", true);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivity(localIntent);
      return;
    }
    localIntent.setFlags(268435456);
    MobileQQ.getContext().startActivity(localIntent);
  }
  
  private void b()
  {
    if (this.e != null)
    {
      View localView = this.d;
      if (localView != null)
      {
        localView.setVisibility(8);
        this.e.setVisibility(4);
        this.e.postDelayed(new QQGiftHalfTranslucentBrowserActivity.2(this), 100L);
      }
    }
  }
  
  private TranslateAnimation c()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setAnimationListener(new QQGiftHalfTranslucentBrowserActivity.3(this));
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  private void d()
  {
    View localView = this.e;
    if (localView != null) {
      localView.startAnimation(a(new QQGiftHalfTranslucentBrowserActivity.4(this)));
    }
    localView = this.d;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.d.startAnimation(a(new QQGiftHalfTranslucentBrowserActivity.5(this)));
    }
  }
  
  @Nullable
  public View a()
  {
    return this.d;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167360);
    paramBundle = findViewById(2131429740);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131168376);
    }
    this.e = findViewById(2131431345);
    paramBundle = getApplication().getResources().getDisplayMetrics();
    if (paramBundle == null)
    {
      QLog.e("QQGiftHalfTranslucentBrowserActivity", 1, "doOnCreate dm is null");
      return bool;
    }
    int i = (int)(paramBundle.scaledDensity * 393.0F);
    Object localObject = new FrameLayout.LayoutParams(-1, i);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.e.getParent();
    if ((localObject instanceof FrameLayout))
    {
      FrameLayout localFrameLayout = (FrameLayout)localObject;
      localFrameLayout.addView(a(paramBundle, this.e, i));
      localFrameLayout.addView(a((ViewParent)localObject, i));
    }
    b();
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getIntent().getIntExtra("extra_web_scene_id_key", 0);
    this.b = getIntent().getIntExtra("extra_web_recharge_callback_key", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate sceneId:");
      paramBundle.append(this.a);
      paramBundle.append(", callbackKey:");
      paramBundle.append(this.b);
      QLog.d("QQGiftHalfTranslucentBrowserActivity", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */