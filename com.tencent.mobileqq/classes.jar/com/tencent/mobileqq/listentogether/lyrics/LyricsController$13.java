package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LyricsController$13
  implements ValueAnimator.AnimatorUpdateListener
{
  LyricsController$13(LyricsController paramLyricsController, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.i.e)
    {
      paramValueAnimator.cancel();
      this.i.A = null;
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = this.a;
    j = (int)(j + (this.b - j) * f1 + 0.5F);
    int k = this.c;
    k = (int)(k + (this.d - k) * f1 + 0.5F);
    int m = this.e;
    m = (int)(m + (this.f - m) * f1 + 0.5F);
    int n = this.g;
    n = (int)(n + (this.h - n) * f1 + 0.5F);
    this.i.i.a(j, k);
    this.i.j.a(m, n);
    this.i.i.b();
    this.i.j.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.13
 * JD-Core Version:    0.7.0.1
 */