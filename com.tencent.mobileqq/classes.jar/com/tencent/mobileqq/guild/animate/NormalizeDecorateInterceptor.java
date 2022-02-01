package com.tencent.mobileqq.guild.animate;

import android.view.animation.Interpolator;

public class NormalizeDecorateInterceptor
  implements Interpolator
{
  private final Interpolator a;
  private final float b;
  private final float c;
  private final float d;
  private final boolean e;
  
  public NormalizeDecorateInterceptor(Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    this(paramInterpolator, f1, f2, bool);
  }
  
  private NormalizeDecorateInterceptor(Interpolator paramInterpolator, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.a = paramInterpolator;
    this.b = Math.min(Math.max(0.0F, paramFloat1), 1.0F);
    this.c = Math.min(Math.max(0.0F, paramFloat2), 1.0F);
    this.e = paramBoolean;
    paramFloat1 = this.b;
    paramFloat2 = this.c;
    if (paramFloat1 == paramFloat2)
    {
      this.d = 1.0F;
      return;
    }
    this.d = (paramFloat2 - paramFloat1);
  }
  
  private float a(float paramFloat)
  {
    float f = this.b;
    if (paramFloat < f) {
      return 0.0F;
    }
    if (paramFloat > this.c) {
      return 1.0F;
    }
    return this.a.getInterpolation((paramFloat - f) / this.d);
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = a(paramFloat);
    paramFloat = f;
    if (this.e) {
      paramFloat = 1.0F - f;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.NormalizeDecorateInterceptor
 * JD-Core Version:    0.7.0.1
 */