package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlRotateAnimation;

public class RotateAnimation
  extends Animation
{
  public RotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (this.glAnimation == null) {
      this.glAnimation = new GlRotateAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
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
    if (this.glAnimation == null) {
      return;
    }
    if (paramInterpolator == null) {
      return;
    }
    this.glAnimation.setInterpolator(paramInterpolator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.RotateAnimation
 * JD-Core Version:    0.7.0.1
 */