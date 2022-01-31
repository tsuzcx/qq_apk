package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableColorValue
  extends BaseAnimatableValue<Integer, Integer>
{
  public AnimatableColorValue(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<Integer, Integer> createAnimation()
  {
    return new ColorKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue
 * JD-Core Version:    0.7.0.1
 */