package com.tencent.mobileqq.profile.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class BreatheEffectView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  BreatheEffectView$3(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setBounds((Rect)paramValueAnimator.getAnimatedValue());
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView.3
 * JD-Core Version:    0.7.0.1
 */