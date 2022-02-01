package com.tencent.mobileqq.dinifly.animation.keyframe;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

final class BaseKeyframeAnimation$SingleKeyframeWrapper<T>
  implements BaseKeyframeAnimation.KeyframesWrapper<T>
{
  private float cachedInterpolatedProgress = -1.0F;
  @NonNull
  private final Keyframe<T> keyframe;
  
  BaseKeyframeAnimation$SingleKeyframeWrapper(List<? extends Keyframe<T>> paramList)
  {
    this.keyframe = ((Keyframe)paramList.get(0));
  }
  
  public Keyframe<T> getCurrentKeyframe()
  {
    return this.keyframe;
  }
  
  public float getEndProgress()
  {
    return this.keyframe.getEndProgress();
  }
  
  public float getStartDelayProgress()
  {
    return this.keyframe.getStartProgress();
  }
  
  public boolean isCachedValueEnabled(float paramFloat)
  {
    if (this.cachedInterpolatedProgress == paramFloat) {
      return true;
    }
    this.cachedInterpolatedProgress = paramFloat;
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isValueChanged(float paramFloat)
  {
    return this.keyframe.isStatic() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.SingleKeyframeWrapper
 * JD-Core Version:    0.7.0.1
 */