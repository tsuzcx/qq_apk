package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.core.functions.animation.GlAnimation.InnerAnimationListener;

final class Animation$a
  implements GlAnimation.InnerAnimationListener
{
  private AnimationListener a;
  
  public Animation$a(AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }
  
  public final void onAnimationFinish()
  {
    AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd();
    }
  }
  
  public final void onAnimationStart()
  {
    AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Animation.a
 * JD-Core Version:    0.7.0.1
 */