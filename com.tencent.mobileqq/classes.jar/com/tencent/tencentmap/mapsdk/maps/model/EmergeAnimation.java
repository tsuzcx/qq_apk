package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlEmergeAnimation;

public class EmergeAnimation
  extends Animation
{
  private LatLng a = null;
  
  public EmergeAnimation(LatLng paramLatLng)
  {
    if (this.glAnimation == null) {
      this.glAnimation = new GlEmergeAnimation(paramLatLng);
    }
    this.a = paramLatLng;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
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
    if (this.glAnimation != null)
    {
      if (paramInterpolator == null) {
        return;
      }
      this.glAnimation.setInterpolator(paramInterpolator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation
 * JD-Core Version:    0.7.0.1
 */