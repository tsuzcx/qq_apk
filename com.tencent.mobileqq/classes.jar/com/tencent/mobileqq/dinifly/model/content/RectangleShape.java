package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.RectangleContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class RectangleShape
  implements ContentModel
{
  private final AnimatableFloatValue cornerRadius;
  private final boolean hidden;
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatableValue<PointF, PointF> size;
  
  public RectangleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue1, AnimatableValue<PointF, PointF> paramAnimatableValue2, AnimatableFloatValue paramAnimatableFloatValue, boolean paramBoolean)
  {
    this.name = paramString;
    this.position = paramAnimatableValue1;
    this.size = paramAnimatableValue2;
    this.cornerRadius = paramAnimatableFloatValue;
    this.hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getCornerRadius()
  {
    return this.cornerRadius;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableValue<PointF, PointF> getPosition()
  {
    return this.position;
  }
  
  public AnimatableValue<PointF, PointF> getSize()
  {
    return this.size;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RectangleContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RectangleShape{position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.RectangleShape
 * JD-Core Version:    0.7.0.1
 */