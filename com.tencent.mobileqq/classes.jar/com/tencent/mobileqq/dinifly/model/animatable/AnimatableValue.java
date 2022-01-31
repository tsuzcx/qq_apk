package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;

public abstract interface AnimatableValue<K, A>
{
  public abstract BaseKeyframeAnimation<K, A> createAnimation();
  
  public abstract boolean hasAnimation();
  
  public static abstract interface Factory<V>
  {
    public abstract V valueFromObject(Object paramObject, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue
 * JD-Core Version:    0.7.0.1
 */