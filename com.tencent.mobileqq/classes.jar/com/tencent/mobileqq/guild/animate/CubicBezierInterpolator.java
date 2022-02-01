package com.tencent.mobileqq.guild.animate;

import android.view.animation.Interpolator;

public class CubicBezierInterpolator
  implements Interpolator
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  
  public CubicBezierInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  private float a(float paramFloat)
  {
    return a(paramFloat, this.a, this.c);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = paramFloat1;
    if (paramFloat1 != 0.0F)
    {
      if (paramFloat1 == 1.0F) {
        return paramFloat1;
      }
      f = b(0.0F, paramFloat2, paramFloat1);
      paramFloat2 = b(paramFloat2, paramFloat3, paramFloat1);
      paramFloat3 = b(paramFloat3, 1.0F, paramFloat1);
      f = b(b(f, paramFloat2, paramFloat1), b(paramFloat2, paramFloat3, paramFloat1), paramFloat1);
    }
    return f;
  }
  
  private float b(float paramFloat)
  {
    return a(paramFloat, this.b, this.d);
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  private float c(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int k = 0;
    float f1 = paramFloat;
    int i = 0;
    float f4 = 0.0F;
    float f3 = 1.0F;
    float f5 = 0.0F;
    float f2;
    int j;
    float f6;
    float f7;
    for (;;)
    {
      f2 = f1;
      j = k;
      f6 = f4;
      f7 = f3;
      if (i >= 8) {
        break;
      }
      f5 = a(f1);
      double d2 = (a(f1 + 1.0E-006F) - f5) / 1.0E-006F;
      f2 = f5 - paramFloat;
      if (Math.abs(f2) < 1.0E-006F) {
        return f1;
      }
      if (Math.abs(d2) < 9.999999974752427E-007D)
      {
        f2 = f1;
        j = k;
        f6 = f4;
        f7 = f3;
        break;
      }
      if (f5 < paramFloat) {
        f4 = f1;
      } else {
        f3 = f1;
      }
      double d1 = f1;
      double d3 = f2;
      Double.isNaN(d3);
      Double.isNaN(d2);
      d2 = d3 / d2;
      Double.isNaN(d1);
      f1 = (float)(d1 - d2);
      i += 1;
    }
    while ((Math.abs(f5 - paramFloat) > 1.0E-006F) && (j < 8))
    {
      if (f5 < paramFloat)
      {
        f1 = (f2 + f7) / 2.0F;
        f6 = f2;
      }
      else
      {
        f1 = (f2 + f6) / 2.0F;
        f7 = f2;
      }
      f5 = a(f1);
      j += 1;
      f2 = f1;
    }
    return f2;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return b(c(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.CubicBezierInterpolator
 * JD-Core Version:    0.7.0.1
 */