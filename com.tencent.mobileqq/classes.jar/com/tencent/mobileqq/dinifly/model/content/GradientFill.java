package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.GradientFillContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue.Factory;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONException;
import org.json.JSONObject;

public class GradientFill
  implements ContentModel
{
  private final AnimatablePointValue endPoint;
  private final Path.FillType fillType;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  @Nullable
  private final AnimatableFloatValue highlightAngle;
  @Nullable
  private final AnimatableFloatValue highlightLength;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  
  private GradientFill(String paramString, GradientType paramGradientType, Path.FillType paramFillType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.gradientType = paramGradientType;
    this.fillType = paramFillType;
    this.gradientColor = paramAnimatableGradientColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.startPoint = paramAnimatablePointValue1;
    this.endPoint = paramAnimatablePointValue2;
    this.name = paramString;
    this.highlightLength = paramAnimatableFloatValue1;
    this.highlightAngle = paramAnimatableFloatValue2;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return this.endPoint;
  }
  
  public Path.FillType getFillType()
  {
    return this.fillType;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return this.gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return this.gradientType;
  }
  
  @Nullable
  AnimatableFloatValue getHighlightAngle()
  {
    return this.highlightAngle;
  }
  
  @Nullable
  AnimatableFloatValue getHighlightLength()
  {
    return this.highlightLength;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  public AnimatablePointValue getStartPoint()
  {
    return this.startPoint;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientFillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  static class Factory
  {
    static GradientFill newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      String str = paramJSONObject.optString("nm");
      Object localObject1 = paramJSONObject.optJSONObject("g");
      Object localObject2 = localObject1;
      int i;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((JSONObject)localObject1).has("k"))
        {
          i = ((JSONObject)localObject1).optInt("p");
          localObject2 = ((JSONObject)localObject1).optJSONObject("k");
        }
      }
      try
      {
        ((JSONObject)localObject2).put("p", i);
        label58:
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = AnimatableGradientColorValue.Factory.newInstance((JSONObject)localObject2, paramLottieComposition);
        }
        Object localObject3 = paramJSONObject.optJSONObject("o");
        localObject2 = null;
        if (localObject3 != null) {
          localObject2 = AnimatableIntegerValue.Factory.newInstance((JSONObject)localObject3, paramLottieComposition);
        }
        if (paramJSONObject.optInt("r", 1) == 1)
        {
          localObject3 = Path.FillType.WINDING;
          if (paramJSONObject.optInt("t", 1) != 1) {
            break label205;
          }
        }
        label205:
        for (GradientType localGradientType = GradientType.Linear;; localGradientType = GradientType.Radial)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject("s");
          AnimatablePointValue localAnimatablePointValue = null;
          if (localJSONObject != null) {
            localAnimatablePointValue = AnimatablePointValue.Factory.newInstance(localJSONObject, paramLottieComposition);
          }
          localJSONObject = paramJSONObject.optJSONObject("e");
          paramJSONObject = null;
          if (localJSONObject != null) {
            paramJSONObject = AnimatablePointValue.Factory.newInstance(localJSONObject, paramLottieComposition);
          }
          return new GradientFill(str, localGradientType, (Path.FillType)localObject3, (AnimatableGradientColorValue)localObject1, (AnimatableIntegerValue)localObject2, localAnimatablePointValue, paramJSONObject, null, null, null);
          localObject3 = Path.FillType.EVEN_ODD;
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        break label58;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.GradientFill
 * JD-Core Version:    0.7.0.1
 */