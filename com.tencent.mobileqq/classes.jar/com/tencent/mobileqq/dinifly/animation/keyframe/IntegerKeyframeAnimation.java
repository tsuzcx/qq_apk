package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public IntegerKeyframeAnimation(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  public int getIntValue()
  {
    return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  int getIntValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    if (this.valueCallback != null)
    {
      Integer localInteger = (Integer)this.valueCallback.getValueInternal(paramKeyframe.startFrame, paramKeyframe.endFrame.floatValue(), paramKeyframe.startValue, paramKeyframe.endValue, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
      if (localInteger != null) {
        return localInteger.intValue();
      }
    }
    return MiscUtils.lerp(paramKeyframe.getStartValueInt(), paramKeyframe.getEndValueInt(), paramFloat);
  }
  
  Integer getValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramKeyframe, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.IntegerKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */