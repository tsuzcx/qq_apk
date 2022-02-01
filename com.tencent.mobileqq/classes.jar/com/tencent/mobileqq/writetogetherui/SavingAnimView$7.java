package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SavingAnimView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  SavingAnimView$7(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    float f1 = f2;
    if (SavingAnimView.a(paramValueAnimator) == 0) {
      f1 = 1.0F - f2;
    }
    SavingAnimView.e(paramValueAnimator, f1);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.7
 * JD-Core Version:    0.7.0.1
 */