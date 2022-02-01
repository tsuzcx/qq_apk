package com.tencent.mobileqq.guild.animate;

import android.animation.TimeInterpolator;

public class AnimateSpringInterpolator
  implements TimeInterpolator
{
  private final float a;
  
  private float a(float paramFloat1, float paramFloat2)
  {
    double d1 = Math.pow(2.0D, -10.0F * paramFloat2);
    double d2 = paramFloat2 - paramFloat1 / 4.0F;
    Double.isNaN(d2);
    double d3 = paramFloat1;
    Double.isNaN(d3);
    return (float)(d1 * Math.sin(d2 * 6.283185307179586D / d3) + 1.0D);
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(this.a, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.AnimateSpringInterpolator
 * JD-Core Version:    0.7.0.1
 */