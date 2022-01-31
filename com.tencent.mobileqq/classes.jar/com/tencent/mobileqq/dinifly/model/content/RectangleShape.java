package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.RectangleContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONObject;

public class RectangleShape
  implements ContentModel
{
  private final AnimatableFloatValue cornerRadius;
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatablePointValue size;
  
  private RectangleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, AnimatableFloatValue paramAnimatableFloatValue)
  {
    this.name = paramString;
    this.position = paramAnimatableValue;
    this.size = paramAnimatablePointValue;
    this.cornerRadius = paramAnimatableFloatValue;
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
  
  public AnimatablePointValue getSize()
  {
    return this.size;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RectangleContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    return "RectangleShape{cornerRadius=" + this.cornerRadius.getInitialValue() + ", position=" + this.position + ", size=" + this.size + '}';
  }
  
  static class Factory
  {
    static RectangleShape newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      return new RectangleShape(paramJSONObject.optString("nm"), AnimatablePathValue.createAnimatablePathOrSplitDimensionPath(paramJSONObject.optJSONObject("p"), paramLottieComposition), AnimatablePointValue.Factory.newInstance(paramJSONObject.optJSONObject("s"), paramLottieComposition), AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("r"), paramLottieComposition), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.RectangleShape
 * JD-Core Version:    0.7.0.1
 */