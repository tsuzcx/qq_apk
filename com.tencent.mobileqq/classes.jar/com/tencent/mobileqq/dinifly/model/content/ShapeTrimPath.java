package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.TrimPathContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class ShapeTrimPath
  implements ContentModel
{
  private final AnimatableFloatValue end;
  private final boolean hidden;
  private final String name;
  private final AnimatableFloatValue offset;
  private final AnimatableFloatValue start;
  private final ShapeTrimPath.Type type;
  
  public ShapeTrimPath(String paramString, ShapeTrimPath.Type paramType, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableFloatValue paramAnimatableFloatValue3, boolean paramBoolean)
  {
    this.name = paramString;
    this.type = paramType;
    this.start = paramAnimatableFloatValue1;
    this.end = paramAnimatableFloatValue2;
    this.offset = paramAnimatableFloatValue3;
    this.hidden = paramBoolean;
  }
  
  public AnimatableFloatValue getEnd()
  {
    return this.end;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableFloatValue getOffset()
  {
    return this.offset;
  }
  
  public AnimatableFloatValue getStart()
  {
    return this.start;
  }
  
  public ShapeTrimPath.Type getType()
  {
    return this.type;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new TrimPathContent(paramBaseLayer, this);
  }
  
  public String toString()
  {
    return "Trim Path: {start: " + this.start + ", end: " + this.end + ", offset: " + this.offset + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath
 * JD-Core Version:    0.7.0.1
 */