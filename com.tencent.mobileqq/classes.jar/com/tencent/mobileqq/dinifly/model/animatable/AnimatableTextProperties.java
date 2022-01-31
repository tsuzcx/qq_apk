package com.tencent.mobileqq.dinifly.model.animatable;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import org.json.JSONObject;

public class AnimatableTextProperties
{
  @Nullable
  public final AnimatableColorValue color;
  @Nullable
  public final AnimatableColorValue stroke;
  @Nullable
  public final AnimatableFloatValue strokeWidth;
  @Nullable
  public final AnimatableFloatValue tracking;
  
  AnimatableTextProperties(@Nullable AnimatableColorValue paramAnimatableColorValue1, @Nullable AnimatableColorValue paramAnimatableColorValue2, @Nullable AnimatableFloatValue paramAnimatableFloatValue1, @Nullable AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.color = paramAnimatableColorValue1;
    this.stroke = paramAnimatableColorValue2;
    this.strokeWidth = paramAnimatableFloatValue1;
    this.tracking = paramAnimatableFloatValue2;
  }
  
  public static final class Factory
  {
    public static AnimatableTextProperties newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      if ((paramJSONObject == null) || (!paramJSONObject.has("a"))) {
        return new AnimatableTextProperties(null, null, null, null);
      }
      Object localObject3 = paramJSONObject.optJSONObject("a");
      Object localObject1 = ((JSONObject)localObject3).optJSONObject("fc");
      paramJSONObject = null;
      if (localObject1 != null) {
        paramJSONObject = AnimatableColorValue.Factory.newInstance((JSONObject)localObject1, paramLottieComposition);
      }
      Object localObject2 = ((JSONObject)localObject3).optJSONObject("sc");
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = AnimatableColorValue.Factory.newInstance((JSONObject)localObject2, paramLottieComposition);
      }
      JSONObject localJSONObject = ((JSONObject)localObject3).optJSONObject("sw");
      localObject2 = null;
      if (localJSONObject != null) {
        localObject2 = AnimatableFloatValue.Factory.newInstance(localJSONObject, paramLottieComposition);
      }
      localJSONObject = ((JSONObject)localObject3).optJSONObject("t");
      localObject3 = null;
      if (localJSONObject != null) {
        localObject3 = AnimatableFloatValue.Factory.newInstance(localJSONObject, paramLottieComposition);
      }
      return new AnimatableTextProperties(paramJSONObject, (AnimatableColorValue)localObject1, (AnimatableFloatValue)localObject2, (AnimatableFloatValue)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties
 * JD-Core Version:    0.7.0.1
 */