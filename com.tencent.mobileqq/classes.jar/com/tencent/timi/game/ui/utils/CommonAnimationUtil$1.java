package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.OvershootInterpolator;

final class CommonAnimationUtil$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CommonAnimationUtil$1(boolean paramBoolean, float paramFloat1, float paramFloat2, View paramView, CommonAnimationUtil.AnimationCallback paramAnimationCallback) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f1 = f2;
    if (this.a) {
      f1 = new OvershootInterpolator().getInterpolation(f2);
    }
    f2 = this.b;
    f2 += (this.c - f2) * f1;
    this.d.setScaleX(f2);
    this.d.setScaleY(f2);
    paramValueAnimator = this.e;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.a(this.d, f1);
      if (f1 >= 1.0F) {
        this.e.b(this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil.1
 * JD-Core Version:    0.7.0.1
 */