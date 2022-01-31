package com.tencent.mobileqq.dinifly.model.content;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.ShapeContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue.Factory;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONObject;

public class ShapePath
  implements ContentModel
{
  private final int index;
  private final String name;
  private final AnimatableShapeValue shapePath;
  
  private ShapePath(String paramString, int paramInt, AnimatableShapeValue paramAnimatableShapeValue)
  {
    this.name = paramString;
    this.index = paramInt;
    this.shapePath = paramAnimatableShapeValue;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableShapeValue getShapePath()
  {
    return this.shapePath;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new ShapeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    return "ShapePath{name=" + this.name + ", index=" + this.index + ", hasAnimation=" + this.shapePath.hasAnimation() + '}';
  }
  
  static class Factory
  {
    static ShapePath newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramLottieComposition = AnimatableShapeValue.Factory.newInstance(paramJSONObject.optJSONObject("ks"), paramLottieComposition);
      return new ShapePath(paramJSONObject.optString("nm"), paramJSONObject.optInt("ind"), paramLottieComposition, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapePath
 * JD-Core Version:    0.7.0.1
 */