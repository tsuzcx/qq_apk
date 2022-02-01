package com.tencent.mobileqq.medalwall;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MedalGuideView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  MedalGuideView$6(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    MedalGuideView.a(this.a, f);
    if (this.a.A != null)
    {
      this.a.A.a(f);
      if (f <= 0.05F) {
        this.a.A.b();
      }
    }
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.6
 * JD-Core Version:    0.7.0.1
 */