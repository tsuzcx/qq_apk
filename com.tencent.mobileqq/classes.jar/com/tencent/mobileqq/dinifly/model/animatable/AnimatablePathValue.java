package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.PointKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue
  implements AnimatableValue<PointF, PointF>
{
  private final List<Keyframe<PointF>> keyframes;
  
  public AnimatablePathValue()
  {
    this.keyframes = Collections.singletonList(new Keyframe(new PointF(0.0F, 0.0F)));
  }
  
  public AnimatablePathValue(List<Keyframe<PointF>> paramList)
  {
    this.keyframes = paramList;
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    if (((Keyframe)this.keyframes.get(0)).isStatic()) {
      return new PointKeyframeAnimation(this.keyframes);
    }
    return new PathKeyframeAnimation(this.keyframes);
  }
  
  public List<Keyframe<PointF>> getKeyframes()
  {
    return this.keyframes;
  }
  
  public boolean isStatic()
  {
    int i = this.keyframes.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (((Keyframe)this.keyframes.get(0)).isStatic()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue
 * JD-Core Version:    0.7.0.1
 */