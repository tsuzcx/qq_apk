package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.Path;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ShapeKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class AnimatableShapeValue
  extends BaseAnimatableValue<ShapeData, Path>
{
  public AnimatableShapeValue(List<Keyframe<ShapeData>> paramList)
  {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<ShapeData, Path> createAnimation()
  {
    return new ShapeKeyframeAnimation(this.keyframes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue
 * JD-Core Version:    0.7.0.1
 */