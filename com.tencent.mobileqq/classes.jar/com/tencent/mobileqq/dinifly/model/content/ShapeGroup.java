package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.ContentGroup;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup
  implements ContentModel
{
  private final boolean hidden;
  private final List<ContentModel> items;
  private final String name;
  
  public ShapeGroup(String paramString, List<ContentModel> paramList, boolean paramBoolean)
  {
    this.name = paramString;
    this.items = paramList;
    this.hidden = paramBoolean;
  }
  
  public List<ContentModel> getItems()
  {
    return this.items;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new ContentGroup(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeGroup{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append("' Shapes: ");
    localStringBuilder.append(Arrays.toString(this.items.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeGroup
 * JD-Core Version:    0.7.0.1
 */