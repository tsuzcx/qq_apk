package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A>
{
  private float cachedEndProgress = -1.0F;
  @Nullable
  private A cachedGetValue = null;
  private float cachedStartDelayProgress = -1.0F;
  private boolean isDiscrete = false;
  private final BaseKeyframeAnimation.KeyframesWrapper<K> keyframesWrapper;
  final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList(1);
  protected float progress = 0.0F;
  @Nullable
  protected LottieValueCallback<A> valueCallback;
  
  BaseKeyframeAnimation(List<? extends Keyframe<K>> paramList)
  {
    this.keyframesWrapper = wrap(paramList);
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getStartDelayProgress()
  {
    if (this.cachedStartDelayProgress == -1.0F) {
      this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
    }
    return this.cachedStartDelayProgress;
  }
  
  private static <T> BaseKeyframeAnimation.KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> paramList)
  {
    if (paramList.isEmpty()) {
      return new BaseKeyframeAnimation.EmptyKeyframeWrapper(null);
    }
    if (paramList.size() == 1) {
      return new BaseKeyframeAnimation.SingleKeyframeWrapper(paramList);
    }
    return new BaseKeyframeAnimation.KeyframesWrapperImpl(paramList);
  }
  
  public void addUpdateListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    this.listeners.add(paramAnimationListener);
  }
  
  protected Keyframe<K> getCurrentKeyframe()
  {
    L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
    Keyframe localKeyframe = this.keyframesWrapper.getCurrentKeyframe();
    L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
    return localKeyframe;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  float getEndProgress()
  {
    if (this.cachedEndProgress == -1.0F) {
      this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
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
    float f = getLinearCurrentKeyframeProgress();
    if ((this.valueCallback == null) && (this.keyframesWrapper.isCachedValueEnabled(f))) {
      return this.cachedGetValue;
    }
    Object localObject = getCurrentKeyframe();
    if ((((Keyframe)localObject).xInterpolator != null) && (((Keyframe)localObject).yInterpolator != null)) {
      localObject = getValue((Keyframe)localObject, f, ((Keyframe)localObject).xInterpolator.getInterpolation(f), ((Keyframe)localObject).yInterpolator.getInterpolation(f));
    } else {
      localObject = getValue((Keyframe)localObject, getInterpolatedCurrentKeyframeProgress());
    }
    this.cachedGetValue = localObject;
    return localObject;
  }
  
  abstract A getValue(Keyframe<K> paramKeyframe, float paramFloat);
  
  protected A getValue(Keyframe<K> paramKeyframe, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    throw new UnsupportedOperationException("This animation does not support split dimensions!");
  }
  
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
    if (this.keyframesWrapper.isEmpty()) {
      return;
    }
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
    if (this.keyframesWrapper.isValueChanged(f)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */