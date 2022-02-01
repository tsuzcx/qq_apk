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
    SavingAnimView.a(this.a, (SavingAnimView.b(this.a) + f) % 1.0F);
    SavingAnimView.b(this.a, (f + SavingAnimView.c(this.a)) % 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.3
 * JD-Core Version:    0.7.0.1
 */