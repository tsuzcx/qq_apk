package com.tencent.mobileqq.dinifly.model.animatable;

import android.support.annotation.Nullable;

public class AnimatableTextProperties
{
  @Nullable
  public final AnimatableColorValue color;
  @Nullable
  public final AnimatableColorValue stroke;
  @Nullable
  public final AnimatableFloatValue strokeWidth;
  @Nullable
  public final AnimatableFloatValue tracking;
  
  public AnimatableTextProperties(@Nullable AnimatableColorValue paramAnimatableColorValue1, @Nullable AnimatableColorValue paramAnimatableColorValue2, @Nullable AnimatableFloatValue paramAnimatableFloatValue1, @Nullable AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.color = paramAnimatableColorValue1;
    this.stroke = paramAnimatableColorValue2;
    this.strokeWidth = paramAnimatableFloatValue1;
    this.tracking = paramAnimatableFloatValue2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties
 * JD-Core Version:    0.7.0.1
 */