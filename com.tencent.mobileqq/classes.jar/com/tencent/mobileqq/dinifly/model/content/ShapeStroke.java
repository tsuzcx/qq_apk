package com.tencent.mobileqq.dinifly.model.content;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.StrokeContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.List;

public class ShapeStroke
  implements ContentModel
{
  private final ShapeStroke.LineCapType capType;
  private final AnimatableColorValue color;
  private final boolean hidden;
  private final ShapeStroke.LineJoinType joinType;
  private final List<AnimatableFloatValue> lineDashPattern;
  private final float miterLimit;
  private final String name;
  @Nullable
  private final AnimatableFloatValue offset;
  private final AnimatableIntegerValue opacity;
  private final AnimatableFloatValue width;
  
  public ShapeStroke(String paramString, @Nullable AnimatableFloatValue paramAnimatableFloatValue1, List<AnimatableFloatValue> paramList, AnimatableColorValue paramAnimatableColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue2, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, float paramFloat, boolean paramBoolean)
  {
    this.name = paramString;
    this.offset = paramAnimatableFloatValue1;
    this.lineDashPattern = paramList;
    this.color = paramAnimatableColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.width = paramAnimatableFloatValue2;
    this.capType = paramLineCapType;
    this.joinType = paramLineJoinType;
    this.miterLimit = paramFloat;
    this.hidden = paramBoolean;
  }
  
  public ShapeStroke.LineCapType getCapType()
  {
    return this.capType;
  }
  
  public AnimatableColorValue getColor()
  {
    return this.color;
  }
  
  public AnimatableFloatValue getDashOffset()
  {
    return this.offset;
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
    return new StrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeStroke
 * JD-Core Version:    0.7.0.1
 */