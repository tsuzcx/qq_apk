package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O>
  implements AnimatableValue<V, O>
{
  final List<Keyframe<V>> keyframes;
  
  BaseAnimatableValue(V paramV)
  {
    this(Collections.singletonList(new Keyframe(paramV)));
  }
  
  BaseAnimatableValue(List<Keyframe<V>> paramList)
  {
    this.keyframes = paramList;
  }
  
  public List<Keyframe<V>> getKeyframes()
  {
    return this.keyframes;
  }
  
  public boolean isStatic()
  {
    return (this.keyframes.isEmpty()) || ((this.keyframes.size() == 1) && (((Keyframe)this.keyframes.get(0)).isStatic()));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!this.keyframes.isEmpty()) {
      localStringBuilder.append("values=").append(Arrays.toString(this.keyframes.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.BaseAnimatableValue
 * JD-Core Version:    0.7.0.1
 */