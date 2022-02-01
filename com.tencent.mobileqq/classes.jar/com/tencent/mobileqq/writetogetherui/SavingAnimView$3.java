package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SavingAnimView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SavingAnimView$3(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    SavingAnimView.a(paramValueAnimator, (SavingAnimView.b(paramValueAnimator) + f) % 1.0F);
    paramValueAnimator = this.a;
    SavingAnimView.b(paramValueAnimator, (f + SavingAnimView.c(paramValueAnimator)) % 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.3
 * JD-Core Version:    0.7.0.1
 */