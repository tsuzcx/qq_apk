package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public abstract interface AnimatableValue<K, A>
{
  public abstract BaseKeyframeAnimation<K, A> createAnimation();
  
  public abstract List<Keyframe<K>> getKeyframes();
  
  public abstract boolean isStatic();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue
 * JD-Core Version:    0.7.0.1
 */