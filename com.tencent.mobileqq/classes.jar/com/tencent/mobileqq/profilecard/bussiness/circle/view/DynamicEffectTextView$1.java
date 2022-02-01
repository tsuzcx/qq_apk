package com.tencent.mobileqq.profilecard.bussiness.circle.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DynamicEffectTextView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  DynamicEffectTextView$1(DynamicEffectTextView paramDynamicEffectTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    DynamicEffectTextView.access$002(this.this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.view.DynamicEffectTextView.1
 * JD-Core Version:    0.7.0.1
 */