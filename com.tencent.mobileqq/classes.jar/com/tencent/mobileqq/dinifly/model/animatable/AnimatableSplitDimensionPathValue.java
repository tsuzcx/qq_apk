package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableSplitDimensionPathValue
  implements AnimatableValue<PointF, PointF>
{
  private final AnimatableFloatValue animatableXDimension;
  private final AnimatableFloatValue animatableYDimension;
  
  public AnimatableSplitDimensionPathValue(AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.animatableXDimension = paramAnimatableFloatValue1;
    this.animatableYDimension = paramAnimatableFloatValue2;
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    return new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
  }
  
  public List<Keyframe<PointF>> getKeyframes()
  {
    throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
  }
  
  public boolean isStatic()
  {
    return (this.animatableXDimension.isStatic()) && (this.animatableYDimension.isStatic());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableSplitDimensionPathValue
 * JD-Core Version:    0.7.0.1
 */