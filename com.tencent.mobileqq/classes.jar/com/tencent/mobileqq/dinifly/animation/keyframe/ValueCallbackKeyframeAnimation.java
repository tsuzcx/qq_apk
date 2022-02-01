package com.tencent.mobileqq.dinifly.animation.keyframe;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieFrameInfo;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A>
  extends BaseKeyframeAnimation<K, A>
{
  private final LottieFrameInfo<A> frameInfo = new LottieFrameInfo();
  private final A valueCallbackValue;
  
  public ValueCallbackKeyframeAnimation(LottieValueCallback<A> paramLottieValueCallback)
  {
    this(paramLottieValueCallback, null);
  }
  
  public ValueCallbackKeyframeAnimation(LottieValueCallback<A> paramLottieValueCallback, @Nullable A paramA)
  {
    super(Collections.emptyList());
    setValueCallback(paramLottieValueCallback);
    this.valueCallbackValue = paramA;
  }
  
  float getEndProgress()
  {
    return 1.0F;
  }
  
  public A getValue()
  {
    LottieValueCallback localLottieValueCallback = this.valueCallback;
    Object localObject = this.valueCallbackValue;
    return localLottieValueCallback.getValueInternal(0.0F, 0.0F, localObject, localObject, getProgress(), getProgress(), getProgress());
  }
  
  A getValue(Keyframe<K> paramKeyframe, float paramFloat)
  {
    return getValue();
  }
  
  public void notifyListeners()
  {
    if (this.valueCallback != null) {
      super.notifyListeners();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.progress = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */