package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlTranslateAnimation;
import com.tencent.map.sdk.a.fz;

public class TranslateAnimation
  extends Animation
{
  public TranslateAnimation(LatLng paramLatLng)
  {
    paramLatLng = fz.a(paramLatLng);
    if (this.glAnimation == null) {
      this.glAnimation = new GlTranslateAnimation(paramLatLng);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TranslateAnimation
 * JD-Core Version:    0.7.0.1
 */