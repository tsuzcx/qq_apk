package com.tencent.richmediabrowser.animation;

public final class AnimateUtils
{
  private static float END_TENSION = 0.0F;
  private static final int NB_SAMPLES = 100;
  private static final float[] SPLINE = new float[101];
  private static float START_TENSION = 0.4F;
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  private static float sViscousFluidScale;
  
  static
  {
    END_TENSION = 1.0F - START_TENSION;
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
        float f8 = START_TENSION;
        float f9 = END_TENSION;
        float f6 = f3 * f3 * f3;
        f7 = (f7 * f8 + f9 * f3) * f5 + f6;
        if (Math.abs(f7 - f4) < 1.E-005D)
        {
          SPLINE[i] = (f5 + f6);
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
    SPLINE[100] = 1.0F;
    sViscousFluidScale = 8.0F;
    sViscousFluidNormalize = 1.0F;
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat *= sViscousFluidScale;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F;
    }
    return paramFloat * sViscousFluidNormalize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimateUtils
 * JD-Core Version:    0.7.0.1
 */