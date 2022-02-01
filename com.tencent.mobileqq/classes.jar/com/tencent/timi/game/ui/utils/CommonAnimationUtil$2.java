package com.tencent.timi.game.ui.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class CommonAnimationUtil$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CommonAnimationUtil$2(float paramFloat1, float paramFloat2, View paramView, float paramFloat3, float paramFloat4, CommonAnimationUtil.AnimationCallback paramAnimationCallback) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.a;
    float f3 = this.b;
    this.c.setAlpha(f2 + (f3 - f2) * f1);
    f2 = this.d;
    f2 += (this.e - f2) * f1;
    this.c.setScaleX(f2);
    this.c.setScaleY(f2);
    paramValueAnimator = this.f;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.a(this.c, f1);
      if (f1 >= 1.0F) {
        this.f.b(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.CommonAnimationUtil.2
 * JD-Core Version:    0.7.0.1
 */