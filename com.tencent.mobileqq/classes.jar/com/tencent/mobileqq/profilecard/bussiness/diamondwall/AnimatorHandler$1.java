package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class AnimatorHandler$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AnimatorHandler$1(AnimatorHandler paramAnimatorHandler, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$view.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.1
 * JD-Core Version:    0.7.0.1
 */