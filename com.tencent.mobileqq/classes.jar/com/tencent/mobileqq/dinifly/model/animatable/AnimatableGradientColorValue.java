package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.GradientColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableGradientColorValue
  extends BaseAnimatableValue<GradientColor, GradientColor>
{
  public AnimatableGradientColorValue(List<Keyframe<GradientColor>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation()
  {
    return new GradientColorKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue
 * JD-Core Version:    0.7.0.1
 */