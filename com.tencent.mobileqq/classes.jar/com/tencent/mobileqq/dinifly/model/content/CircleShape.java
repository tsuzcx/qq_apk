package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.EllipseContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONObject;

public class CircleShape
  implements ContentModel
{
  private final String name;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatablePointValue size;
  
  private CircleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue)
  {
    this.name = paramString;
    this.position = paramAnimatableValue;
    this.size = paramAnimatablePointValue;
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
    return new EllipseContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  static class Factory
  {
    static CircleShape newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      return new CircleShape(paramJSONObject.optString("nm"), AnimatablePathValue.createAnimatablePathOrSplitDimensionPath(paramJSONObject.optJSONObject("p"), paramLottieComposition), AnimatablePointValue.Factory.newInstance(paramJSONObject.optJSONObject("s"), paramLottieComposition), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.CircleShape
 * JD-Core Version:    0.7.0.1
 */