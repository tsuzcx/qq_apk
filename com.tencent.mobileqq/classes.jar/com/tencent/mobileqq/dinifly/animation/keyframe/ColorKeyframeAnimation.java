package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.utils.GammaEvaluator;
import java.util.List;

public class ColorKeyframeAnimation
  extends KeyframeAnimation<Integer>
{
  public ColorKeyframeAnimation(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  public Integer getValue(Keyframe<Integer> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(GammaEvaluator.evaluate(paramFloat, ((Integer)paramKeyframe.startValue).intValue(), ((Integer)paramKeyframe.endValue).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */