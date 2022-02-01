package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimationSet;

public class AnimationSet
  extends Animation
{
  public AnimationSet(boolean paramBoolean)
  {
    if (this.glAnimation == null) {
      this.glAnimation = new GlAnimationSet(paramBoolean);
    }
  }
  
  public boolean addAnimation(Animation paramAnimation)
  {
    if (paramAnimation == null) {}
    while ((paramAnimation.glAnimation == null) || (this.glAnimation == null)) {
      return false;
    }
    ((GlAnimationSet)this.glAnimation).addAnimation(paramAnimation.glAnimation);
    return true;
  }
  
  public void cleanAnimation()
  {
    if (this.glAnimation == null) {
      return;
    }
    ((GlAnimationSet)this.glAnimation).cleanAnimation();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AnimationSet
 * JD-Core Version:    0.7.0.1
 */