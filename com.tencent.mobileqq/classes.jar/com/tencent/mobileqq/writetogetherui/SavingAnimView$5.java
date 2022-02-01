package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SavingAnimView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  SavingAnimView$5(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = SavingAnimView.c(this.a) + f1;
    float f3 = f1 + SavingAnimView.d(this.a);
    f1 = f2;
    if (f2 + 1.0E-005F >= 1.0F)
    {
      f1 = 0.0F;
      SavingAnimView.a(this.a, 0.0F);
      SavingAnimView.a(this.a, true);
    }
    f2 = f3;
    if (1.0E-005F + f3 >= 1.0F) {
      f2 = 1.0F;
    }
    if (!SavingAnimView.g(this.a)) {
      SavingAnimView.a(this.a, f1);
    }
    SavingAnimView.b(this.a, f2);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.SavingAnimView.5
 * JD-Core Version:    0.7.0.1
 */