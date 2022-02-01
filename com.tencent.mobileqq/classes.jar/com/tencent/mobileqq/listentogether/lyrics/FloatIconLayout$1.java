package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class FloatIconLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatIconLayout$1(FloatIconLayout paramFloatIconLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout.1
 * JD-Core Version:    0.7.0.1
 */