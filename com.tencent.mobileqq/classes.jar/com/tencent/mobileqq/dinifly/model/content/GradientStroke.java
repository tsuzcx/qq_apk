package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.GradientStrokeContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue.Factory;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GradientStroke
  implements ContentModel
{
  private final ShapeStroke.LineCapType capType;
  @Nullable
  private final AnimatableFloatValue dashOffset;
  private final AnimatablePointValue endPoint;
  private final AnimatableGradientColorValue gradientColor;
  private final GradientType gradientType;
  private final ShapeStroke.LineJoinType joinType;
  private final List<AnimatableFloatValue> lineDashPattern;
  private final String name;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  private final AnimatableFloatValue width;
  
  private GradientStroke(String paramString, GradientType paramGradientType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, List<AnimatableFloatValue> paramList, @Nullable AnimatableFloatValue paramAnimatableFloatValue2)
  {
    this.name = paramString;
    this.gradientType = paramGradientType;
    this.gradientColor = paramAnimatableGradientColorValue;
    this.opacity = paramAnimatableIntegerValue;
    this.startPoint = paramAnimatablePointValue1;
    this.endPoint = paramAnimatablePointValue2;
    this.width = paramAnimatableFloatValue1;
    this.capType = paramLineCapType;
    this.joinType = paramLineJoinType;
    this.lineDashPattern = paramList;
    this.dashOffset = paramAnimatableFloatValue2;
  }
  
  public ShapeStroke.LineCapType getCapType()
  {
    return this.capType;
  }
  
  @Nullable
  public AnimatableFloatValue getDashOffset()
  {
    return this.dashOffset;
  }
  
  public AnimatablePointValue getEndPoint()
  {
    return this.endPoint;
  }
  
  public AnimatableGradientColorValue getGradientColor()
  {
    return this.gradientColor;
  }
  
  public GradientType getGradientType()
  {
    return this.gradientType;
  }
  
  public ShapeStroke.LineJoinType getJoinType()
  {
    return this.joinType;
  }
  
  public List<AnimatableFloatValue> getLineDashPattern()
  {
    return this.lineDashPattern;
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
  
  public AnimatableFloatValue getWidth()
  {
    return this.width;
  }
  
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new GradientStrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  static class Factory
  {
    static GradientStroke newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      String str1 = paramJSONObject.optString("nm");
      Object localObject1 = paramJSONObject.optJSONObject("g");
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((JSONObject)localObject1).has("k")) {
          localObject2 = ((JSONObject)localObject1).optJSONObject("k");
        }
      }
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = AnimatableGradientColorValue.Factory.newInstance((JSONObject)localObject2, paramLottieComposition);
      }
      Object localObject3 = paramJSONObject.optJSONObject("o");
      localObject2 = null;
      if (localObject3 != null) {
        localObject2 = AnimatableIntegerValue.Factory.newInstance((JSONObject)localObject3, paramLottieComposition);
      }
      Object localObject4;
      AnimatablePointValue localAnimatablePointValue;
      AnimatableFloatValue localAnimatableFloatValue;
      ShapeStroke.LineCapType localLineCapType;
      ShapeStroke.LineJoinType localLineJoinType;
      JSONObject localJSONObject;
      ArrayList localArrayList;
      int i;
      label221:
      String str2;
      if (paramJSONObject.optInt("t", 1) == 1)
      {
        localObject3 = GradientType.Linear;
        localObject4 = paramJSONObject.optJSONObject("s");
        localAnimatablePointValue = null;
        if (localObject4 != null) {
          localAnimatablePointValue = AnimatablePointValue.Factory.newInstance((JSONObject)localObject4, paramLottieComposition);
        }
        localObject5 = paramJSONObject.optJSONObject("e");
        localObject4 = null;
        if (localObject5 != null) {
          localObject4 = AnimatablePointValue.Factory.newInstance((JSONObject)localObject5, paramLottieComposition);
        }
        localAnimatableFloatValue = AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("w"), paramLottieComposition);
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJSONObject.optInt("lc") - 1)];
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJSONObject.optInt("lj") - 1)];
        localObject5 = null;
        localJSONObject = null;
        localArrayList = new ArrayList();
        if (!paramJSONObject.has("d")) {
          break label369;
        }
        JSONArray localJSONArray = paramJSONObject.optJSONArray("d");
        i = 0;
        paramJSONObject = localJSONObject;
        if (i >= localJSONArray.length()) {
          break label336;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        str2 = localJSONObject.optString("n");
        if (!str2.equals("o")) {
          break label288;
        }
        localObject5 = AnimatableFloatValue.Factory.newInstance(localJSONObject.optJSONObject("v"), paramLottieComposition);
      }
      for (;;)
      {
        i += 1;
        paramJSONObject = (JSONObject)localObject5;
        break label221;
        localObject3 = GradientType.Radial;
        break;
        label288:
        if (!str2.equals("d"))
        {
          localObject5 = paramJSONObject;
          if (!str2.equals("g")) {}
        }
        else
        {
          localArrayList.add(AnimatableFloatValue.Factory.newInstance(localJSONObject.optJSONObject("v"), paramLottieComposition));
          localObject5 = paramJSONObject;
        }
      }
      label336:
      Object localObject5 = paramJSONObject;
      if (localArrayList.size() == 1)
      {
        localArrayList.add(localArrayList.get(0));
        localObject5 = paramJSONObject;
      }
      label369:
      return new GradientStroke(str1, (GradientType)localObject3, (AnimatableGradientColorValue)localObject1, (AnimatableIntegerValue)localObject2, localAnimatablePointValue, (AnimatablePointValue)localObject4, localAnimatableFloatValue, localLineCapType, localLineJoinType, localArrayList, (AnimatableFloatValue)localObject5, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.GradientStroke
 * JD-Core Version:    0.7.0.1
 */