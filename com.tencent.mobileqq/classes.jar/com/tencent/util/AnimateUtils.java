package com.tencent.util;

public final class AnimateUtils
{
  private static float a = 0.4F;
  private static float b = 1.0F - a;
  private static final float[] c = new float[101];
  private static float d;
  private static float e = 1.0F / a(1.0F);
  
  static
  {
    float f2 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f1 = 1.0F;
      for (;;)
      {
        float f3 = (f1 - f2) / 2.0F + f2;
        float f7 = 1.0F - f3;
        float f5 = 3.0F * f3 * f7;
        float f8 = a;
        float f9 = b;
        float f6 = f3 * f3 * f3;
        f7 = (f7 * f8 + f9 * f3) * f5 + f6;
        if (Math.abs(f7 - f4) < 1.E-005D)
        {
          c[i] = (f5 + f6);
          i += 1;
          break;
        }
        if (f7 > f4) {
          f1 = f3;
        } else {
          f2 = f3;
        }
      }
    }
    c[100] = 1.0F;
    d = 8.0F;
    e = 1.0F;
  }
  
  public static float a(float paramFloat)
  {
    paramFloat *= d;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F;
    }
    return paramFloat * e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.AnimateUtils
 * JD-Core Version:    0.7.0.1
 */