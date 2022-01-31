package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A>
{
  @Nullable
  private Keyframe<K> cachedKeyframe;
  private boolean isDiscrete = false;
  private final List<? extends Keyframe<K>> keyframes;
  final List<AnimationListener> listeners = new ArrayList();
  private float progress = 0.0F;
  
  BaseKeyframeAnimation(List<? extends Keyframe<K>> paramList)
  {
    this.keyframes = paramList;
  }
  
  private Keyframe<K> getCurrentKeyframe()
  {
    if (this.keyframes.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    if ((this.cachedKeyframe != null) && (this.cachedKeyframe.containsProgress(this.progress))) {
      return this.cachedKeyframe;
    }
    int i = 0;
    Keyframe localKeyframe2 = (Keyframe)this.keyframes.get(0);
    Keyframe localKeyframe1 = localKeyframe2;
    if (this.progress < localKeyframe2.getStartProgress())
    {
      this.cachedKeyframe = localKeyframe2;
      return localKeyframe2;
    }
    while ((!localKeyframe1.containsProgress(this.progress)) && (i < this.keyframes.size()))
    {
      localKeyframe1 = (Keyframe)this.keyframes.get(i);
      i += 1;
    }
    this.cachedKeyframe = localKeyframe1;
    return localKeyframe1;
  }
  
  private float getCurrentKeyframeProgress()
  {
    if (this.isDiscrete) {}
    Keyframe localKeyframe;
    do
    {
      return 0.0F;
      localKeyframe = getCurrentKeyframe();
    } while (localKeyframe.isStatic());
    float f1 = this.progress;
    float f2 = localKeyframe.getStartProgress();
    float f3 = localKeyframe.getEndProgress();
    float f4 = localKeyframe.getStartProgress();
    return localKeyframe.interpolator.getInterpolation((f1 - f2) / (f3 - f4));
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getEndProgress()
  {
    if (this.keyframes.isEmpty()) {
      return 1.0F;
    }
    return ((Keyframe)this.keyframes.get(this.keyframes.size() - 1)).getEndProgress();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getStartDelayProgress()
  {
    if (this.keyframes.isEmpty()) {
      return 0.0F;
    }
    return ((Keyframe)this.keyframes.get(0)).getStartProgress();
  }
  
  public void addUpdateListener(AnimationListener paramAnimationListener)
  {
    this.listeners.add(paramAnimationListener);
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public A getValue()
  {
    return getValue(getCurrentKeyframe(), getCurrentKeyframeProgress());
  }
  
  abstract A getValue(Keyframe<K> paramKeyframe, float paramFloat);
  
  public void setIsDiscrete()
  {
    this.isDiscrete = true;
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f;
    if (paramFloat < getStartDelayProgress())
    {
      f = 0.0F;
      if (f != this.progress) {
        break label37;
      }
    }
    for (;;)
    {
      return;
      f = paramFloat;
      if (paramFloat <= getEndProgress()) {
        break;
      }
      f = 1.0F;
      break;
      label37:
      this.progress = f;
      int i = 0;
      while (i < this.listeners.size())
      {
        ((AnimationListener)this.listeners.get(i)).onValueChanged();
        i += 1;
      }
    }
  }
  
  public static abstract interface AnimationListener
  {
    public abstract void onValueChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */