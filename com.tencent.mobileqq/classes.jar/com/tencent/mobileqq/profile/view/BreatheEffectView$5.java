package com.tencent.mobileqq.profile.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class BreatheEffectView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  BreatheEffectView$5(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Rect)paramValueAnimator.getAnimatedValue();
    this.a.setBounds(paramValueAnimator);
    this.b.invalidate(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView.5
 * JD-Core Version:    0.7.0.1
 */