package com.tencent.mobileqq.qqgift.view.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ComboSendBtnAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ComboSendBtnAnimation$1(ComboSendBtnAnimation paramComboSendBtnAnimation, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setScaleX(f);
    this.a.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.ComboSendBtnAnimation.1
 * JD-Core Version:    0.7.0.1
 */