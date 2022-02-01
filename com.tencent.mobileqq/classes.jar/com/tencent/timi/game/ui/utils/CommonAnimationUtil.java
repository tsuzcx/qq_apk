package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class CommonAnimationUtil
{
  public static void a(View paramView)
  {
    a(paramView, 0.5F, 1.0F, 0.0F, 1.0F, 225L, CommonAnimationUtil.CenterDialogZoomAnimation.a, null);
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong, Interpolator paramInterpolator, CommonAnimationUtil.AnimationCallback paramAnimationCallback)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramLong);
    if (paramInterpolator == null) {
      paramInterpolator = new DecelerateInterpolator();
    }
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new CommonAnimationUtil.2(paramFloat3, paramFloat4, paramView, paramFloat1, paramFloat2, paramAnimationCallback));
    localValueAnimator.start();
    if (paramAnimationCallback != null) {
      paramAnimationCallback.a(paramView);
    }
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Interpolator paramInterpolator, CommonAnimationUtil.AnimationCallback paramAnimationCallback)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramLong);
    if (paramInterpolator == null) {
      paramInterpolator = new DecelerateInterpolator();
    }
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new CommonAnimationUtil.6(paramFloat1, paramFloat2, paramView, paramAnimationCallback));
    localValueAnimator.start();
    if (paramAnimationCallback != null) {
      paramAnimationCallback.a(paramView);
    }
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, CommonAnimationUtil.AnimationCallback paramAnimationCallback, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new CommonAnimationUtil.1(paramBoolean, paramFloat1, paramFloat2, paramView, paramAnimationCallback));
    localValueAnimator.start();
    if (paramAnimationCallback != null) {
      paramAnimationCallback.a(paramView);
    }
  }
  
  public static void a(View paramView, CommonAnimationUtil.AnimationCallback paramAnimationCallback)
  {
    a(paramView, 1.0F, 0.5F, 1.0F, 0.0F, 225L, CommonAnimationUtil.CenterDialogZoomAnimation.b, paramAnimationCallback);
  }
  
  public static void b(View paramView)
  {
    a(paramView, 0.0F, 0.7F, 225L, CommonAnimationUtil.CenterDialogZoomAnimation.a, null);
  }
  
  public static void c(View paramView)
  {
    a(paramView, 0.7F, 0.0F, 225L, CommonAnimationUtil.CenterDialogZoomAnimation.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil
 * JD-Core Version:    0.7.0.1
 */