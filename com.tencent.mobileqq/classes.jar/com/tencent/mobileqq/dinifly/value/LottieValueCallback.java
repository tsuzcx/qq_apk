package com.tencent.mobileqq.dinifly.value;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T>
{
  @Nullable
  private BaseKeyframeAnimation<?, ?> animation;
  private final LottieFrameInfo<T> frameInfo = new LottieFrameInfo();
  @Nullable
  protected T value = null;
  
  public LottieValueCallback() {}
  
  public LottieValueCallback(@Nullable T paramT)
  {
    this.value = paramT;
  }
  
  @Nullable
  public T getValue(LottieFrameInfo<T> paramLottieFrameInfo)
  {
    return this.value;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public final T getValueInternal(float paramFloat1, float paramFloat2, T paramT1, T paramT2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return getValue(this.frameInfo.set(paramFloat1, paramFloat2, paramT1, paramT2, paramFloat3, paramFloat4, paramFloat5));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public final void setAnimation(@Nullable BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation)
  {
    this.animation = paramBaseKeyframeAnimation;
  }
  
  public final void setValue(@Nullable T paramT)
  {
    this.value = paramT;
    if (this.animation != null) {
      this.animation.notifyListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieValueCallback
 * JD-Core Version:    0.7.0.1
 */