package com.tencent.mobileqq.medalwall;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class MedalGuideView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  MedalGuideView$7(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = ((Integer)this.a.m.evaluate(f, Integer.valueOf(this.a.n), Integer.valueOf(0))).intValue();
    this.a.b.setBackgroundColor(i);
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.7
 * JD-Core Version:    0.7.0.1
 */