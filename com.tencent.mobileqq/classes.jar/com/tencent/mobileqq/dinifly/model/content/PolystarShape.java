package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.PolystarContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class PolystarShape
  implements ContentModel
{
  private final boolean hidden;
  private final AnimatableFloatValue innerRadius;
  private final AnimatableFloatValue innerRoundedness;
  private final String name;
  private final AnimatableFloatValue outerRadius;
  private final AnimatableFloatValue outerRoundedness;
  private final AnimatableFloatValue points;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatableFloatValue rotation;
  private final PolystarShape.Type type;
  
  public PolystarShape(String paramString, PolystarShape.Type paramType, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableFloatValue paramAnimatableFloatValue3, AnimatableFloatValue paramAnimatableFloatValue4, AnimatableFloatValue paramAnimatableFloatValue5, AnimatableFloatValue paramAnimatableFloatValue6, boolean paramBoolean)
  {
    this.name = paramString;
    this.type = paramType;
    this.points = paramAnimatableFloatValue1;
    this.position = paramAnimatableValue;
    this.rotation = paramAnimatableFloatValue2;
    this.innerRadius = paramAnimatableFloatValue3;
    this.outerRadius = paramAnimatableFloatValue4;
    this.innerRoundedness = paramAnimatableFloatValue5;
    this.outerRoundedness = paramAnimatableFloatValue6;
    this.hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getInnerRadius()
  {
    return this.innerRadius;
  }
  
  public AnimatableFloatValue getInnerRoundedness()
  {
    return this.innerRoundedness;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableFloatValue getOuterRadius()
  {
    return this.outerRadius;
  }
  
  public AnimatableFloatValue getOuterRoundedness()
  {
    return this.outerRoundedness;
  }
  
  public AnimatableFloatValue getPoints()
  {
    return this.points;
  }
  
  public AnimatableValue<PointF, PointF> getPosition()
  {
    return this.position;
  }
  
  public AnimatableFloatValue getRotation()
  {
    return this.rotation;
  }
  
  public PolystarShape.Type getType()
  {
    return this.type;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new PolystarContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.PolystarShape
 * JD-Core Version:    0.7.0.1
 */