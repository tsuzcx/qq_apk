package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SavingAnimView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SavingAnimView$1(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    SavingAnimView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 0.25F);
    SavingAnimView.b(this.a, SavingAnimView.a(this.a) * 0.1F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.1
 * JD-Core Version:    0.7.0.1
 */