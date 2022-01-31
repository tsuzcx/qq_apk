package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.List;

public class FloatKeyframeAnimation
  extends KeyframeAnimation<Float>
{
  public FloatKeyframeAnimation(List<Keyframe<Float>> paramList)
  {
    super(paramList);
  }
  
  Float getValue(Keyframe<Float> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Float.valueOf(MiscUtils.lerp(((Float)paramKeyframe.startValue).floatValue(), ((Float)paramKeyframe.endValue).floatValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */