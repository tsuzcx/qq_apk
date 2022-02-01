package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.GradientStrokeContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.List;

public class GradientStroke
  implements ContentModel
{
  private final ShapeStroke.LineCapType capType;
  @Nullable
  private final AnimatableFloatValue dashOffset;
  private final AnimatablePointValue endPoint;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  private final boolean hidden;
  private final ShapeStroke.LineJoinType joinType;
  private final List<AnimatableFloatValue> lineDashPattern;
  private final float miterLimit;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  private final AnimatableFloatValue width;
  
  public GradientStroke(String paramString, GradientType paramGradientType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, float paramFloat, List<AnimatableFloatValue> paramList, @Nullable AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean)
  {
    this.name = paramString;
    this.gradientType = paramGradientType;
    this.gradientColor = paramAnimatableGradientColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.startPoint = paramAnimatablePointValue1;
    this.endPoint = paramAnimatablePointValue2;
    this.width = paramAnimatableFloatValue1;
    this.capType = paramLineCapType;
    this.joinType = paramLineJoinType;
    this.miterLimit = paramFloat;
    this.lineDashPattern = paramList;
    this.dashOffset = paramAnimatableFloatValue2;
    this.hidden = paramBoolean;
  }
  
  public ShapeStroke.LineCapType getCapType()
  {
    return this.capType;
  }
  
  @Nullable
  public AnimatableFloatValue getDashOffset()
  {
    return this.dashOffset;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return this.endPoint;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return this.gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return this.gradientType;
  }
  
  public ShapeStroke.LineJoinType getJoinType()
  {
    return this.joinType;
  }
  
  public List<AnimatableFloatValue> getLineDashPattern()
  {
    return this.lineDashPattern;
  }
  
  public float getMiterLimit()
  {
    return this.miterLimit;
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
  
  public AnimatableFloatValue getWidth()
  {
    return this.width;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientStrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.GradientStroke
 * JD-Core Version:    0.7.0.1
 */