package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;

public class Mask
{
  private final boolean inverted;
  private final Mask.MaskMode maskMode;
  private final AnimatableShapeValue maskPath;
  private final AnimatableIntegerValue opacity;
  
  public Mask(Mask.MaskMode paramMaskMode, AnimatableShapeValue paramAnimatableShapeValue, AnimatableIntegerValue paramAnimatableIntegerValue, boolean paramBoolean)
  {
    this.maskMode = paramMaskMode;
    this.maskPath = paramAnimatableShapeValue;
    this.opacity = paramAnimatableIntegerValue;
    this.inverted = paramBoolean;
  }
  
  public Mask.MaskMode getMaskMode()
  {
    return this.maskMode;
  }
  
  public AnimatableShapeValue getMaskPath()
  {
    return this.maskPath;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  public boolean isInverted()
  {
    return this.inverted;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.Mask
 * JD-Core Version:    0.7.0.1
 */