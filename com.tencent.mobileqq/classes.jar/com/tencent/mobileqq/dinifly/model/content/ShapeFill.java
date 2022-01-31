package com.tencent.mobileqq.dinifly.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.FillContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue.Factory;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONObject;

public class ShapeFill
  implements ContentModel
{
  @Nullable
  private final AnimatableColorValue color;
  private final boolean fillEnabled;
  private final Path.FillType fillType;
  private final String name;
  @Nullable
  private final AnimatableIntegerValue opacity;
  
  private ShapeFill(String paramString, boolean paramBoolean, Path.FillType paramFillType, @Nullable AnimatableColorValue paramAnimatableColorValue, @Nullable AnimatableIntegerValue paramAnimatableIntegerValue)
  {
    this.name = paramString;
    this.fillEnabled = paramBoolean;
    this.fillType = paramFillType;
    this.color = paramAnimatableColorValue;
    this.opacity = paramAnimatableIntegerValue;
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
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new FillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ShapeFill{color=");
    if (this.color == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", fillEnabled=").append(this.fillEnabled).append(", opacity=");
      if (this.opacity != null) {
        break label90;
      }
    }
    label90:
    for (Object localObject = "null";; localObject = this.opacity.getInitialValue())
    {
      return localObject + '}';
      localObject = Integer.toHexString(((Integer)this.color.getInitialValue()).intValue());
      break;
    }
  }
  
  static class Factory
  {
    static ShapeFill newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      AnimatableColorValue localAnimatableColorValue = null;
      AnimatableIntegerValue localAnimatableIntegerValue = null;
      String str = paramJSONObject.optString("nm");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("c");
      if (localJSONObject != null) {
        localAnimatableColorValue = AnimatableColorValue.Factory.newInstance(localJSONObject, paramLottieComposition);
      }
      localJSONObject = paramJSONObject.optJSONObject("o");
      if (localJSONObject != null) {
        localAnimatableIntegerValue = AnimatableIntegerValue.Factory.newInstance(localJSONObject, paramLottieComposition);
      }
      boolean bool = paramJSONObject.optBoolean("fillEnabled");
      if (paramJSONObject.optInt("r", 1) == 1) {}
      for (paramJSONObject = Path.FillType.WINDING;; paramJSONObject = Path.FillType.EVEN_ODD) {
        return new ShapeFill(str, bool, paramJSONObject, localAnimatableColorValue, localAnimatableIntegerValue, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.ShapeFill
 * JD-Core Version:    0.7.0.1
 */