package com.tencent.mobileqq.dinifly.animation.keyframe;

import androidx.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.value.Keyframe;

abstract interface BaseKeyframeAnimation$KeyframesWrapper<T>
{
  public abstract Keyframe<T> getCurrentKeyframe();
  
  @FloatRange(from=0.0D, to=1.0D)
  public abstract float getEndProgress();
  
  @FloatRange(from=0.0D, to=1.0D)
  public abstract float getStartDelayProgress();
  
  public abstract boolean isCachedValueEnabled(float paramFloat);
  
  public abstract boolean isEmpty();
  
  public abstract boolean isValueChanged(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
 * JD-Core Version:    0.7.0.1
 */