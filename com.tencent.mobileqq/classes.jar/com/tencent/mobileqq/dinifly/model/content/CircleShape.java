package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.EllipseContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class CircleShape
  implements ContentModel
{
  private final boolean hidden;
  private final boolean isReversed;
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatablePointValue size;
  
  public CircleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.name = paramString;
    this.position = paramAnimatableValue;
    this.size = paramAnimatablePointValue;
    this.isReversed = paramBoolean1;
    this.hidden = paramBoolean2;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableValue<PointF, PointF> getPosition()
  {
    return this.position;
  }
  
  public AnimatablePointValue getSize()
  {
    return this.size;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public boolean isReversed()
  {
    return this.isReversed;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new EllipseContent(paramLottieDrawable, paramBaseLayer, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.CircleShape
 * JD-Core Version:    0.7.0.1
 */