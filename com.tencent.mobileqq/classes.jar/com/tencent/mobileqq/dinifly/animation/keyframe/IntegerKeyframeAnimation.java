package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.List;

public class IntegerKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public IntegerKeyframeAnimation(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  Integer getValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(MiscUtils.lerp(((Integer)paramKeyframe.startValue).intValue(), ((Integer)paramKeyframe.endValue).intValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.IntegerKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */