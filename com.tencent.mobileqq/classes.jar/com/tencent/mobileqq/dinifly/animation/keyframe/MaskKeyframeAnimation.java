package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Path;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation
{
  private final List<BaseKeyframeAnimation<ShapeData, Path>> maskAnimations;
  private final List<Mask> masks;
  private final List<BaseKeyframeAnimation<Integer, Integer>> opacityAnimations;
  
  public MaskKeyframeAnimation(List<Mask> paramList)
  {
    this.masks = paramList;
    this.maskAnimations = new ArrayList(paramList.size());
    this.opacityAnimations = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.maskAnimations.add(((Mask)paramList.get(i)).getMaskPath().createAnimation());
      AnimatableIntegerValue localAnimatableIntegerValue = ((Mask)paramList.get(i)).getOpacity();
      this.opacityAnimations.add(localAnimatableIntegerValue.createAnimation());
      i += 1;
    }
  }
  
  public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations()
  {
    return this.maskAnimations;
  }
  
  public List<Mask> getMasks()
  {
    return this.masks;
  }
  
  public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations()
  {
    return this.opacityAnimations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.MaskKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */