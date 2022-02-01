package com.tencent.mobileqq.mini.entry;

import android.view.animation.Interpolator;

public class MiniAppEntryAdapter$SpringTranslationInterpolator
  implements Interpolator
{
  private float factor;
  
  public MiniAppEntryAdapter$SpringTranslationInterpolator(float paramFloat)
  {
    this.factor = paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    double d1 = Math.pow(2.0D, -10.0F * paramFloat);
    float f = this.factor;
    double d2 = paramFloat - f / 4.0F;
    Double.isNaN(d2);
    double d3 = f;
    Double.isNaN(d3);
    return (float)(d1 * Math.sin(d2 * 6.283185307179586D / d3) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.SpringTranslationInterpolator
 * JD-Core Version:    0.7.0.1
 */