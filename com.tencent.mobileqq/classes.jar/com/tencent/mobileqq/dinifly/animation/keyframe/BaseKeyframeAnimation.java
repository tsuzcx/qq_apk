package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A>
{
  private float cachedEndProgress = -1.0F;
  @Nullable
  private A cachedGetValue = null;
  @Nullable
  private Keyframe<K> cachedGetValueKeyframe;
  private float cachedGetValueProgress = -1.0F;
  @Nullable
  private Keyframe<K> cachedKeyframe;
  private float cachedStartDelayProgress = -1.0F;
  private boolean isDiscrete = false;
  private final List<? extends Keyframe<K>> keyframes;
  final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList(1);
  private float progress = 0.0F;
  @Nullable
  protected LottieValueCallback<A> valueCallback;
  
  BaseKeyframeAnimation(List<? extends Keyframe<K>> paramList)
  {
    this.keyframes = paramList;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getStartDelayProgress()
  {
    if (this.cachedStartDelayProgress == -1.0F)
    {
      float f;
      if (this.keyframes.isEmpty()) {
        f = 0.0F;
      } else {
        f = ((Keyframe)this.keyframes.get(0)).getStartProgress();
      }
      this.cachedStartDelayProgress = f;
    }
    return this.cachedStartDelayProgress;
  }
  
  public void addUpdateListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    this.listeners.add(paramAnimationListener);
  }
  
  protected Keyframe<K> getCurrentKeyframe()
  {
    Object localObject = this.cachedKeyframe;
    if ((localObject != null) && (((Keyframe)localObject).containsProgress(this.progress))) {
      return this.cachedKeyframe;
    }
    localObject = this.keyframes;
    Keyframe localKeyframe = (Keyframe)((List)localObject).get(((List)localObject).size() - 1);
    localObject = localKeyframe;
    if (this.progress < localKeyframe.getStartProgress())
    {
      int i = this.keyframes.size() - 1;
      localObject = localKeyframe;
      while (i >= 0)
      {
        localObject = (Keyframe)this.keyframes.get(i);
        if (((Keyframe)localObject).containsProgress(this.progress)) {
          break;
        }
        i -= 1;
      }
    }
    this.cachedKeyframe = ((Keyframe)localObject);
    return localObject;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  float getEndProgress()
  {
    if (this.cachedEndProgress == -1.0F)
    {
      float f;
      if (this.keyframes.isEmpty())
      {
        f = 1.0F;
      }
      else
      {
        List localList = this.keyframes;
        f = ((Keyframe)localList.get(localList.size() - 1)).getEndProgress();
      }
      this.cachedEndProgress = f;
    }
    return this.cachedEndProgress;
  }
  
  protected float getInterpolatedCurrentKeyframeProgress()
  {
    Keyframe localKeyframe = getCurrentKeyframe();
    if (localKeyframe.isStatic()) {
      return 0.0F;
    }
    return localKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
  }
  
  float getLinearCurrentKeyframeProgress()
  {
    if (this.isDiscrete) {
      return 0.0F;
    }
    Keyframe localKeyframe = getCurrentKeyframe();
    if (localKeyframe.isStatic()) {
      return 0.0F;
    }
    return (this.progress - localKeyframe.getStartProgress()) / (localKeyframe.getEndProgress() - localKeyframe.getStartProgress());
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public A getValue()
  {
    Object localObject = getCurrentKeyframe();
    float f = getInterpolatedCurrentKeyframeProgress();
    if ((this.valueCallback == null) && (localObject == this.cachedGetValueKeyframe) && (this.cachedGetValueProgress == f)) {
      return this.cachedGetValue;
    }
    this.cachedGetValueKeyframe = ((Keyframe)localObject);
    this.cachedGetValueProgress = f;
    localObject = getValue((Keyframe)localObject, f);
    this.cachedGetValue = localObject;
    return localObject;
  }
  
  abstract A getValue(Keyframe<K> paramKeyframe, float paramFloat);
  
  public void notifyListeners()
  {
    int i = 0;
    while (i < this.listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setIsDiscrete()
  {
    this.isDiscrete = true;
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.keyframes.isEmpty()) {
      return;
    }
    Keyframe localKeyframe1 = getCurrentKeyframe();
    float f;
    if (paramFloat < getStartDelayProgress())
    {
      f = getStartDelayProgress();
    }
    else
    {
      f = paramFloat;
      if (paramFloat > getEndProgress()) {
        f = getEndProgress();
      }
    }
    if (f == this.progress) {
      return;
    }
    this.progress = f;
    Keyframe localKeyframe2 = getCurrentKeyframe();
    if ((localKeyframe1 != localKeyframe2) || (!localKeyframe2.isStatic())) {
      notifyListeners();
    }
  }
  
  public void setValueCallback(@Nullable LottieValueCallback<A> paramLottieValueCallback)
  {
    LottieValueCallback localLottieValueCallback = this.valueCallback;
    if (localLottieValueCallback != null) {
      localLottieValueCallback.setAnimation(null);
    }
    this.valueCallback = paramLottieValueCallback;
    if (paramLottieValueCallback != null) {
      paramLottieValueCallback.setAnimation(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */