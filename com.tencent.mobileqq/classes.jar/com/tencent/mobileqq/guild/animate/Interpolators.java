package com.tencent.mobileqq.guild.animate;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class Interpolators
{
  public static Interpolator a()
  {
    return new LinearInterpolator();
  }
  
  public static Interpolator a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new CubicBezierInterpolator(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator a(Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    return new NormalizeDecorateInterceptor(paramInterpolator, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.Interpolators
 * JD-Core Version:    0.7.0.1
 */