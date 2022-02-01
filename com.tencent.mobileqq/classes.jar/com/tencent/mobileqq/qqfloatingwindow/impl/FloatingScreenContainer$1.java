package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;

class FloatingScreenContainer$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatingScreenContainer$1(FloatingScreenContainer paramFloatingScreenContainer, int paramInt1, int paramInt2, WindowManager.LayoutParams paramLayoutParams, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (this.a >= -this.b) {
      this.c.x = ((int)(this.d + paramValueAnimator.floatValue() * (this.a - this.d)));
    }
    if (this.e >= this.f) {
      this.c.y = ((int)(this.g + paramValueAnimator.floatValue() * (this.e - this.g)));
    }
    this.h.a(this.c);
    FloatingScreenContainer.a(this.h).setFloatingCenterX(this.c.x);
    FloatingScreenContainer.a(this.h).setFloatingCenterY(this.c.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer.1
 * JD-Core Version:    0.7.0.1
 */