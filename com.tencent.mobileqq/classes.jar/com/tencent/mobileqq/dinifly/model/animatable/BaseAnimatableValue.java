package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class BaseAnimatableValue<V, O>
  implements AnimatableValue<V, O>
{
  final V initialValue;
  final List<Keyframe<V>> keyframes;
  
  BaseAnimatableValue(V paramV)
  {
    this(Collections.emptyList(), paramV);
  }
  
  BaseAnimatableValue(List<Keyframe<V>> paramList, V paramV)
  {
    this.keyframes = paramList;
    this.initialValue = paramV;
  }
  
  O convertType(V paramV)
  {
    return paramV;
  }
  
  public O getInitialValue()
  {
    return convertType(this.initialValue);
  }
  
  public boolean hasAnimation()
  {
    return !this.keyframes.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=").append(this.initialValue);
    if (!this.keyframes.isEmpty()) {
      localStringBuilder.append(", values=").append(Arrays.toString(this.keyframes.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.BaseAnimatableValue
 * JD-Core Version:    0.7.0.1
 */