package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.utils.GammaEvaluator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public ColorKeyframeAnimation(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  public int getIntValue()
  {
    return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
  }
  
  public int getIntValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    int i = ((Integer)paramKeyframe.startValue).intValue();
    int j = ((Integer)paramKeyframe.endValue).intValue();
    if (this.valueCallback != null)
    {
      paramKeyframe = (Integer)this.valueCallback.getValueInternal(paramKeyframe.startFrame, paramKeyframe.endFrame.floatValue(), Integer.valueOf(i), Integer.valueOf(j), paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
      if (paramKeyframe != null) {
        return paramKeyframe.intValue();
      }
    }
    return GammaEvaluator.evaluate(MiscUtils.clamp(paramFloat, 0.0F, 1.0F), i, j);
  }
  
  Integer getValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramKeyframe, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */