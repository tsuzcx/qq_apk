package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.FillContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class ShapeFill
  implements ContentModel
{
  @Nullable
  private final AnimatableColorValue color;
  private final boolean fillEnabled;
  private final Path.FillType fillType;
  private final boolean hidden;
  private final String name;
  @Nullable
  private final AnimatableIntegerValue opacity;
  
  public ShapeFill(String paramString, boolean paramBoolean1, Path.FillType paramFillType, @Nullable AnimatableColorValue paramAnimatableColorValue, @Nullable AnimatableIntegerValue paramAnimatableIntegerValue, boolean paramBoolean2)
  {
    this.name = paramString;
    this.fillEnabled = paramBoolean1;
    this.fillType = paramFillType;
    this.color = paramAnimatableColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.hidden = paramBoolean2;
  }
  
  @Nullable
  public AnimatableColorValue getColor()
  {
    return this.color;
  }
  
  public Path.FillType getFillType()
  {
    return this.fillType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  @Nullable
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new FillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeFill{color=, fillEnabled=");
    localStringBuilder.append(this.fillEnabled);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeFill
 * JD-Core Version:    0.7.0.1
 */