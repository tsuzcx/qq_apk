package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.value.Keyframe;

final class BaseKeyframeAnimation$EmptyKeyframeWrapper<T>
  implements BaseKeyframeAnimation.KeyframesWrapper<T>
{
  public Keyframe<T> getCurrentKeyframe()
  {
    throw new IllegalStateException("not implemented");
  }
  
  public float getEndProgress()
  {
    return 1.0F;
  }
  
  public float getStartDelayProgress()
  {
    return 0.0F;
  }
  
  public boolean isCachedValueEnabled(float paramFloat)
  {
    throw new IllegalStateException("not implemented");
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isValueChanged(float paramFloat)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.EmptyKeyframeWrapper
 * JD-Core Version:    0.7.0.1
 */