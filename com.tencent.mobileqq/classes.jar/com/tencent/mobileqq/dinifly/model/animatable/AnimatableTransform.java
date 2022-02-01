package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.ModifierContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class AnimatableTransform
  implements ModifierContent, ContentModel
{
  @Nullable
  private final AnimatablePathValue anchorPoint;
  @Nullable
  private final AnimatableFloatValue endOpacity;
  @Nullable
  private final AnimatableIntegerValue opacity;
  @Nullable
  private final AnimatableValue<PointF, PointF> position;
  @Nullable
  private final AnimatableFloatValue rotation;
  @Nullable
  private final AnimatableScaleValue scale;
  @Nullable
  private final AnimatableFloatValue skew;
  @Nullable
  private final AnimatableFloatValue skewAngle;
  @Nullable
  private final AnimatableFloatValue startOpacity;
  
  public AnimatableTransform()
  {
    this(null, null, null, null, null, null, null, null, null);
  }
  
  public AnimatableTransform(@Nullable AnimatablePathValue paramAnimatablePathValue, @Nullable AnimatableValue<PointF, PointF> paramAnimatableValue, @Nullable AnimatableScaleValue paramAnimatableScaleValue, @Nullable AnimatableFloatValue paramAnimatableFloatValue1, @Nullable AnimatableIntegerValue paramAnimatableIntegerValue, @Nullable AnimatableFloatValue paramAnimatableFloatValue2, @Nullable AnimatableFloatValue paramAnimatableFloatValue3, @Nullable AnimatableFloatValue paramAnimatableFloatValue4, @Nullable AnimatableFloatValue paramAnimatableFloatValue5)
  {
    this.anchorPoint = paramAnimatablePathValue;
    this.position = paramAnimatableValue;
    this.scale = paramAnimatableScaleValue;
    this.rotation = paramAnimatableFloatValue1;
    this.opacity = paramAnimatableIntegerValue;
    this.startOpacity = paramAnimatableFloatValue2;
    this.endOpacity = paramAnimatableFloatValue3;
    this.skew = paramAnimatableFloatValue4;
    this.skewAngle = paramAnimatableFloatValue5;
  }
  
  public TransformKeyframeAnimation createAnimation()
  {
    return new TransformKeyframeAnimation(this);
  }
  
  @Nullable
  public AnimatablePathValue getAnchorPoint()
  {
    return this.anchorPoint;
  }
  
  @Nullable
  public AnimatableFloatValue getEndOpacity()
  {
    return this.endOpacity;
  }
  
  @Nullable
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  @Nullable
  public AnimatableValue<PointF, PointF> getPosition()
  {
    return this.position;
  }
  
  @Nullable
  public AnimatableFloatValue getRotation()
  {
    return this.rotation;
  }
  
  @Nullable
  public AnimatableScaleValue getScale()
  {
    return this.scale;
  }
  
  @Nullable
  public AnimatableFloatValue getSkew()
  {
    return this.skew;
  }
  
  @Nullable
  public AnimatableFloatValue getSkewAngle()
  {
    return this.skewAngle;
  }
  
  @Nullable
  public AnimatableFloatValue getStartOpacity()
  {
    return this.startOpacity;
  }
  
  @Nullable
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform
 * JD-Core Version:    0.7.0.1
 */