package com.tencent.mobileqq.mini.entry.desktop;

import android.view.animation.Interpolator;

public class MiniAppDesktopAdapter$SpringTranslationInterpolator
  implements Interpolator
{
  private float factor;
  
  public MiniAppDesktopAdapter$SpringTranslationInterpolator(float paramFloat)
  {
    this.factor = paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat - this.factor / 4.0F) * 6.283185307179586D / this.factor) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SpringTranslationInterpolator
 * JD-Core Version:    0.7.0.1
 */