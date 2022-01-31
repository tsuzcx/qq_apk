package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.ModifierContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.ScaleXY;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.Collections;
import org.json.JSONObject;

public class AnimatableTransform
  implements ModifierContent, ContentModel
{
  private final AnimatablePathValue anchorPoint;
  @Nullable
  private final AnimatableFloatValue endOpacity;
  private final AnimatableIntegerValue opacity;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatableFloatValue rotation;
  private final AnimatableScaleValue scale;
  @Nullable
  private final AnimatableFloatValue startOpacity;
  
  private AnimatableTransform(AnimatablePathValue paramAnimatablePathValue, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatableScaleValue paramAnimatableScaleValue, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableIntegerValue paramAnimatableIntegerValue, @Nullable AnimatableFloatValue paramAnimatableFloatValue2, @Nullable AnimatableFloatValue paramAnimatableFloatValue3)
  {
    this.anchorPoint = paramAnimatablePathValue;
    this.position = paramAnimatableValue;
    this.scale = paramAnimatableScaleValue;
    this.rotation = paramAnimatableFloatValue1;
    this.opacity = paramAnimatableIntegerValue;
    this.startOpacity = paramAnimatableFloatValue2;
    this.endOpacity = paramAnimatableFloatValue3;
  }
  
  public TransformKeyframeAnimation createAnimation()
  {
    return new TransformKeyframeAnimation(this);
  }
  
  public AnimatablePathValue getAnchorPoint()
  {
    return this.anchorPoint;
  }
  
  @Nullable
  public AnimatableFloatValue getEndOpacity()
  {
    return this.endOpacity;
  }
  
  public AnimatableIntegerValue getOpacity()
  {
    return this.opacity;
  }
  
  public AnimatableValue<PointF, PointF> getPosition()
  {
    return this.position;
  }
  
  public AnimatableFloatValue getRotation()
  {
    return this.rotation;
  }
  
  public AnimatableScaleValue getScale()
  {
    return this.scale;
  }
  
  @Nullable
  public AnimatableFloatValue getStartOpacity()
  {
    return this.startOpacity;
  }
  
  @Nullable
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return null;
  }
  
  public static class Factory
  {
    public static AnimatableTransform newInstance()
    {
      return new AnimatableTransform(new AnimatablePathValue(), new AnimatablePathValue(), AnimatableScaleValue.Factory.newInstance(), AnimatableFloatValue.Factory.newInstance(), AnimatableIntegerValue.Factory.newInstance(), AnimatableFloatValue.Factory.newInstance(), AnimatableFloatValue.Factory.newInstance(), null);
    }
    
    public static AnimatableTransform newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      AnimatableValue localAnimatableValue = null;
      Object localObject4 = null;
      AnimatableFloatValue localAnimatableFloatValue = null;
      Object localObject5 = null;
      Object localObject1 = paramJSONObject.optJSONObject("a");
      Object localObject2;
      label57:
      label78:
      JSONObject localJSONObject;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = new AnimatablePathValue(((JSONObject)localObject1).opt("k"), paramLottieComposition);
        localObject2 = paramJSONObject.optJSONObject("p");
        if (localObject2 == null) {
          break label223;
        }
        localAnimatableValue = AnimatablePathValue.createAnimatablePathOrSplitDimensionPath((JSONObject)localObject2, paramLottieComposition);
        localObject2 = paramJSONObject.optJSONObject("s");
        if (localObject2 == null) {
          break label231;
        }
        localObject2 = AnimatableScaleValue.Factory.newInstance((JSONObject)localObject2, paramLottieComposition);
        localJSONObject = paramJSONObject.optJSONObject("r");
        localObject3 = localJSONObject;
        if (localJSONObject == null) {
          localObject3 = paramJSONObject.optJSONObject("rz");
        }
        if (localObject3 == null) {
          break label253;
        }
        localObject3 = AnimatableFloatValue.Factory.newInstance((JSONObject)localObject3, paramLottieComposition, false);
        label117:
        localObject4 = paramJSONObject.optJSONObject("o");
        if (localObject4 == null) {
          break label265;
        }
      }
      label265:
      for (localObject4 = AnimatableIntegerValue.Factory.newInstance((JSONObject)localObject4, paramLottieComposition);; localObject4 = new AnimatableIntegerValue(Collections.emptyList(), Integer.valueOf(100)))
      {
        localJSONObject = paramJSONObject.optJSONObject("so");
        if (localJSONObject != null) {
          localAnimatableFloatValue = AnimatableFloatValue.Factory.newInstance(localJSONObject, paramLottieComposition, false);
        }
        localJSONObject = paramJSONObject.optJSONObject("eo");
        paramJSONObject = localObject5;
        if (localJSONObject != null) {
          paramJSONObject = AnimatableFloatValue.Factory.newInstance(localJSONObject, paramLottieComposition, false);
        }
        return new AnimatableTransform((AnimatablePathValue)localObject1, localAnimatableValue, (AnimatableScaleValue)localObject2, (AnimatableFloatValue)localObject3, (AnimatableIntegerValue)localObject4, localAnimatableFloatValue, paramJSONObject, null);
        Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
        localObject1 = new AnimatablePathValue();
        break;
        label223:
        throwMissingTransform("position");
        break label57;
        label231:
        localObject2 = new AnimatableScaleValue(Collections.emptyList(), new ScaleXY());
        break label78;
        label253:
        throwMissingTransform("rotation");
        localObject3 = localObject4;
        break label117;
      }
    }
    
    private static void throwMissingTransform(String paramString)
    {
      throw new IllegalArgumentException("Missing transform for " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform
 * JD-Core Version:    0.7.0.1
 */