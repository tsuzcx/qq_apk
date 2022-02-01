package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue
  extends BaseAnimatableValue<Float, Float>
{
  AnimatableFloatValue()
  {
    super(Float.valueOf(0.0F));
  }
  
  public AnimatableFloatValue(List<Keyframe<Float>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<Float, Float> createAnimation()
  {
    return new FloatKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue
 * JD-Core Version:    0.7.0.1
 */