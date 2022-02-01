package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.GradientFillContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class GradientFill
  implements ContentModel
{
  private final AnimatablePointValue endPoint;
  private final Path.FillType fillType;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  private final boolean hidden;
  @Nullable
  private final AnimatableFloatValue highlightAngle;
  @Nullable
  private final AnimatableFloatValue highlightLength;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  
  public GradientFill(String paramString, GradientType paramGradientType, Path.FillType paramFillType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean)
  {
    this.gradientType = paramGradientType;
    this.fillType = paramFillType;
    this.gradientColor = paramAnimatableGradientColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.startPoint = paramAnimatablePointValue1;
    this.endPoint = paramAnimatablePointValue2;
    this.name = paramString;
    this.highlightLength = paramAnimatableFloatValue1;
    this.highlightAngle = paramAnimatableFloatValue2;
    this.hidden = paramBoolean;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return this.endPoint;
  }
  
  public Path.FillType getFillType()
  {
    return this.fillType;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return this.gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return this.gradientType;
  }
  
  @Nullable
  AnimatableFloatValue getHighlightAngle()
  {
    return this.highlightAngle;
  }
  
  @Nullable
  AnimatableFloatValue getHighlightLength()
  {
    return this.highlightLength;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  public AnimatablePointValue getStartPoint()
  {
    return this.startPoint;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientFillContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.GradientFill
 * JD-Core Version:    0.7.0.1
 */