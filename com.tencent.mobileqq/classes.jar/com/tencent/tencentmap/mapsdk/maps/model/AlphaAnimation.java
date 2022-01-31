package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAlphaAnimation;
import com.tencent.map.core.functions.animation.GlAnimation;

public class AlphaAnimation
  extends Animation
{
  public AlphaAnimation(float paramFloat1, float paramFloat2)
  {
    if (this.glAnimation == null) {
      this.glAnimation = new GlAlphaAnimation(paramFloat1, paramFloat2);
    }
  }
  
  public void setDuration(long paramLong)
  {
    if (this.glAnimation == null) {
      return;
    }
    this.glAnimation.setDuration(paramLong);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (this.glAnimation == null) {}
    while (paramInterpolator == null) {
      return;
    }
    this.glAnimation.setInterpolator(paramInterpolator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation
 * JD-Core Version:    0.7.0.1
 */