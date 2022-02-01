package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class VideofeedsUserGuideController
{
  private boolean a = true;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private LinearLayout f;
  private View g;
  private TranslateAnimation h;
  private TranslateAnimation i;
  private AnimatorSet j;
  private AppRuntime k;
  private Context l;
  private Activity m;
  private Handler n = new VideofeedsUserGuideController.5(this, Looper.getMainLooper());
  
  public VideofeedsUserGuideController(Activity paramActivity, AppRuntime paramAppRuntime, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.g = paramView;
    this.k = paramAppRuntime;
    this.d = paramBoolean1;
    this.l = paramActivity.getApplicationContext();
    this.m = paramActivity;
    this.e = paramBoolean2;
    this.f = ((LinearLayout)this.g.findViewById(2131449241));
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.j == null) {
        this.j = new AnimatorSet();
      }
      this.j.playTogether(new Animator[] { paramView1, paramView2 });
      this.j.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    this.b = true;
    this.n.sendEmptyMessageDelayed(1, 5000L);
    ((TextView)this.f.findViewById(2131449246)).setText(paramString);
    paramString = this.h;
    if (paramString != null) {
      paramString.cancel();
    }
    paramString = this.i;
    if (paramString != null) {
      paramString.cancel();
    }
    this.h = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.h.setDuration(200L);
    this.h.setFillAfter(true);
    this.i = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.i.setDuration(300L);
    this.i.setFillAfter(true);
    this.h.setAnimationListener(new VideofeedsUserGuideController.2(this));
    this.i.setAnimationListener(new VideofeedsUserGuideController.3(this));
    this.n.postDelayed(new VideofeedsUserGuideController.4(this), 300L);
  }
  
  @TargetApi(11)
  public void a()
  {
    if (!this.b) {
      return;
    }
    if (this.f.getVisibility() == 8) {
      return;
    }
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideofeedsUserGuideController", 2, "hide user guide");
    }
    b();
    this.n.post(new VideofeedsUserGuideController.1(this));
  }
  
  @TargetApi(11)
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.a)
    {
      if (this.e) {
        return;
      }
      if (this.f.getVisibility() != 0)
      {
        if (this.c) {
          return;
        }
        int i1 = ReadInJoyHelper.as(this.k);
        if (i1 < 3)
        {
          ReadInJoyHelper.B(this.k, i1 + 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feedsVideofeedsUserGuideController", 2, "show user guide");
          }
          if (!TextUtils.isEmpty(paramVideoInfo.l)) {
            paramVideoInfo = HardCodeUtil.a(2131913368);
          } else {
            paramVideoInfo = HardCodeUtil.a(2131913367);
          }
          a(paramVideoInfo);
        }
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, View.OnClickListener paramOnClickListener)
  {
    if (this.f.getVisibility() != 0)
    {
      if (this.c) {
        return;
      }
      a(paramECommerceEntranceInfo.a);
      this.f.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.f.getAnimation() != null)
    {
      this.f.getAnimation().setAnimationListener(null);
      this.f.getAnimation().cancel();
      this.f.clearAnimation();
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.h.cancel();
      this.h = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.i.cancel();
      this.i = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.j;
      if (localObject != null)
      {
        localObject = ((AnimatorSet)localObject).getChildAnimations().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Animator localAnimator = (Animator)((Iterator)localObject).next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.j.end();
        this.j.cancel();
      }
      this.j = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideofeedsUserGuideController
 * JD-Core Version:    0.7.0.1
 */