package com.tencent.mobileqq.dinifly.animation.keyframe;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

final class BaseKeyframeAnimation$KeyframesWrapperImpl<T>
  implements BaseKeyframeAnimation.KeyframesWrapper<T>
{
  private Keyframe<T> cachedCurrentKeyframe = null;
  private float cachedInterpolatedProgress = -1.0F;
  @NonNull
  private Keyframe<T> currentKeyframe;
  private final List<? extends Keyframe<T>> keyframes;
  
  BaseKeyframeAnimation$KeyframesWrapperImpl(List<? extends Keyframe<T>> paramList)
  {
    this.keyframes = paramList;
    this.currentKeyframe = findKeyframe(0.0F);
  }
  
  private Keyframe<T> findKeyframe(float paramFloat)
  {
    Object localObject = this.keyframes;
    localObject = (Keyframe)((List)localObject).get(((List)localObject).size() - 1);
    if (paramFloat >= ((Keyframe)localObject).getStartProgress()) {
      return localObject;
    }
    int i = this.keyframes.size() - 2;
    while (i >= 1)
    {
      localObject = (Keyframe)this.keyframes.get(i);
      if ((this.currentKeyframe != localObject) && (((Keyframe)localObject).containsProgress(paramFloat))) {
        return localObject;
      }
      i -= 1;
    }
    return (Keyframe)this.keyframes.get(0);
  }
  
  @NonNull
  public Keyframe<T> getCurrentKeyframe()
  {
    return this.currentKeyframe;
  }
  
  public float getEndProgress()
  {
    List localList = this.keyframes;
    return ((Keyframe)localList.get(localList.size() - 1)).getEndProgress();
  }
  
  public float getStartDelayProgress()
  {
    return ((Keyframe)this.keyframes.get(0)).getStartProgress();
  }
  
  public boolean isCachedValueEnabled(float paramFloat)
  {
    if ((this.cachedCurrentKeyframe == this.currentKeyframe) && (this.cachedInterpolatedProgress == paramFloat)) {
      return true;
    }
    this.cachedCurrentKeyframe = this.currentKeyframe;
    this.cachedInterpolatedProgress = paramFloat;
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isValueChanged(float paramFloat)
  {
    if (this.currentKeyframe.containsProgress(paramFloat)) {
      return this.currentKeyframe.isStatic() ^ true;
    }
    this.currentKeyframe = findKeyframe(paramFloat);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapperImpl
 * JD-Core Version:    0.7.0.1
 */