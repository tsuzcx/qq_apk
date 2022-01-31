package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.IntegerKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableIntegerValue
  extends BaseAnimatableValue<Integer, Integer>
{
  public AnimatableIntegerValue()
  {
    super(Integer.valueOf(100));
  }
  
  public AnimatableIntegerValue(List<Keyframe<Integer>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<Integer, Integer> createAnimation()
  {
    return new IntegerKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue
 * JD-Core Version:    0.7.0.1
 */