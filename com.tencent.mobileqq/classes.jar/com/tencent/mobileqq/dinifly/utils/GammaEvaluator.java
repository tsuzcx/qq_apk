package com.tencent.mobileqq.dinifly.utils;

public class GammaEvaluator
{
  private static float EOCF_sRGB(float paramFloat)
  {
    if (paramFloat <= 0.04045F) {
      return paramFloat / 12.92F;
    }
    return (float)Math.pow((0.055F + paramFloat) / 1.055F, 2.400000095367432D);
  }
  
  private static float OECF_sRGB(float paramFloat)
  {
    if (paramFloat <= 0.0031308F) {
      return 12.92F * paramFloat;
    }
    return (float)(Math.pow(paramFloat, 0.416666656732559D) * 1.054999947547913D - 0.05499999970197678D);
  }
  
  public static int evaluate(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = (paramInt1 >> 24 & 0xFF) / 255.0F;
    float f4 = (paramInt1 >> 16 & 0xFF) / 255.0F;
    float f5 = (paramInt1 >> 8 & 0xFF) / 255.0F;
    float f6 = (paramInt1 & 0xFF) / 255.0F;
    float f2 = (paramInt2 >> 24 & 0xFF) / 255.0F;
    float f8 = (paramInt2 >> 16 & 0xFF) / 255.0F;
    float f7 = (paramInt2 >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt2 & 0xFF) / 255.0F;
    f4 = EOCF_sRGB(f4);
    f5 = EOCF_sRGB(f5);
    f6 = EOCF_sRGB(f6);
    f8 = EOCF_sRGB(f8);
    f7 = EOCF_sRGB(f7);
    f3 = EOCF_sRGB(f3);
    f4 = OECF_sRGB(f4 + (f8 - f4) * paramFloat);
    f5 = OECF_sRGB(f5 + (f7 - f5) * paramFloat);
    f3 = OECF_sRGB(f6 + (f3 - f6) * paramFloat);
    return Math.round((f1 + (f2 - f1) * paramFloat) * 255.0F) << 24 | Math.round(f4 * 255.0F) << 16 | Math.round(f5 * 255.0F) << 8 | Math.round(f3 * 255.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.GammaEvaluator
 * JD-Core Version:    0.7.0.1
 */