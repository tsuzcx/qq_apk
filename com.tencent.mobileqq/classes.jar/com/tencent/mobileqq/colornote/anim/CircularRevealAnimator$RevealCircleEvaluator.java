package com.tencent.mobileqq.colornote.anim;

import android.animation.TypeEvaluator;

final class CircularRevealAnimator$RevealCircleEvaluator
  implements TypeEvaluator<CircularRevealAnimator.RevealCircle>
{
  private CircularRevealAnimator.RevealCircle a;
  
  public CircularRevealAnimator.RevealCircle a(float paramFloat, CircularRevealAnimator.RevealCircle paramRevealCircle1, CircularRevealAnimator.RevealCircle paramRevealCircle2)
  {
    float f1 = paramRevealCircle1.a + (paramRevealCircle2.a - paramRevealCircle1.a) * paramFloat;
    float f2 = paramRevealCircle1.b + (paramRevealCircle2.b - paramRevealCircle1.b) * paramFloat;
    paramFloat = paramRevealCircle1.c + (paramRevealCircle2.c - paramRevealCircle1.c) * paramFloat;
    paramRevealCircle1 = this.a;
    if (paramRevealCircle1 == null)
    {
      this.a = new CircularRevealAnimator.RevealCircle(f1, f2, paramFloat);
    }
    else
    {
      paramRevealCircle1.a = f1;
      paramRevealCircle1.b = f2;
      paramRevealCircle1.c = paramFloat;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.CircularRevealAnimator.RevealCircleEvaluator
 * JD-Core Version:    0.7.0.1
 */