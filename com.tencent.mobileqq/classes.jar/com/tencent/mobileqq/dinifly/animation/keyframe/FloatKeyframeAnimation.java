package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation
  extends KeyframeAnimation<Float>
{
  public FloatKeyframeAnimation(List<Keyframe<Float>> paramList)
  {
    super(paramList);
  }
  
  public float getFloatValue()
  {
    return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  float getFloatValue(Keyframe<Float> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    if (this.valueCallback != null)
    {
      Float localFloat = (Float)this.valueCallback.getValueInternal(paramKeyframe.startFrame, paramKeyframe.endFrame.floatValue(), paramKeyframe.startValue, paramKeyframe.endValue, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
      if (localFloat != null) {
        return localFloat.floatValue();
      }
    }
    return MiscUtils.lerp(paramKeyframe.getStartValueFloat(), paramKeyframe.getEndValueFloat(), paramFloat);
  }
  
  Float getValue(Keyframe<Float> paramKeyframe, float paramFloat)
  {
    return Float.valueOf(getFloatValue(paramKeyframe, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */