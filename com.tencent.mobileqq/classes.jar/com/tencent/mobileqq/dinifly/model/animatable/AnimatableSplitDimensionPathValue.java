package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.SplitDimensionPathKeyframeAnimation;

public class AnimatableSplitDimensionPathValue
  implements AnimatableValue<PointF, PointF>
{
  private final AnimatableFloatValue animatableXDimension;
  private final AnimatableFloatValue animatableYDimension;
  
  AnimatableSplitDimensionPathValue(AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.animatableXDimension = paramAnimatableFloatValue1;
    this.animatableYDimension = paramAnimatableFloatValue2;
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    return new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
  }
  
  public boolean hasAnimation()
  {
    return (this.animatableXDimension.hasAnimation()) || (this.animatableYDimension.hasAnimation());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue
 * JD-Core Version:    0.7.0.1
 */