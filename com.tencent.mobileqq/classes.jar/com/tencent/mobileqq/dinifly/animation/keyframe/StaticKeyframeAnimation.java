package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.support.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.Collections;

public class StaticKeyframeAnimation<K, A>
  extends BaseKeyframeAnimation<K, A>
{
  private final A initialValue;
  
  public StaticKeyframeAnimation(A paramA)
  {
    super(Collections.emptyList());
    this.initialValue = paramA;
  }
  
  public void addUpdateListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener) {}
  
  public A getValue()
  {
    return this.initialValue;
  }
  
  public A getValue(Keyframe<K> paramKeyframe, float paramFloat)
  {
    return this.initialValue;
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */