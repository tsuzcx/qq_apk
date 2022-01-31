package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe.Factory;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnimatablePathValue
  implements AnimatableValue<PointF, PointF>
{
  private PointF initialPoint;
  private final List<PathKeyframe> keyframes = new ArrayList();
  
  AnimatablePathValue()
  {
    this.initialPoint = new PointF(0.0F, 0.0F);
  }
  
  AnimatablePathValue(Object paramObject, LottieComposition paramLottieComposition)
  {
    if (hasKeyframes(paramObject))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        PathKeyframe localPathKeyframe = PathKeyframe.Factory.newInstance(paramObject.optJSONObject(i), paramLottieComposition, ValueFactory.INSTANCE);
        this.keyframes.add(localPathKeyframe);
        i += 1;
      }
      Keyframe.setEndFrames(this.keyframes);
      return;
    }
    this.initialPoint = JsonUtils.pointFromJsonArray((JSONArray)paramObject, paramLottieComposition.getDpScale());
  }
  
  public static AnimatableValue<PointF, PointF> createAnimatablePathOrSplitDimensionPath(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
  {
    if (paramJSONObject.has("k")) {
      return new AnimatablePathValue(paramJSONObject.opt("k"), paramLottieComposition);
    }
    return new AnimatableSplitDimensionPathValue(AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("x"), paramLottieComposition), AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("y"), paramLottieComposition));
  }
  
  private boolean hasKeyframes(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {}
    do
    {
      return false;
      paramObject = ((JSONArray)paramObject).opt(0);
    } while ((!(paramObject instanceof JSONObject)) || (!((JSONObject)paramObject).has("t")));
    return true;
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialPoint);
    }
    return new PathKeyframeAnimation(this.keyframes);
  }
  
  public boolean hasAnimation()
  {
    return !this.keyframes.isEmpty();
  }
  
  public String toString()
  {
    return "initialPoint=" + this.initialPoint;
  }
  
  private static class ValueFactory
    implements AnimatableValue.Factory<PointF>
  {
    private static final AnimatableValue.Factory<PointF> INSTANCE = new ValueFactory();
    
    public PointF valueFromObject(Object paramObject, float paramFloat)
    {
      return JsonUtils.pointFromJsonArray((JSONArray)paramObject, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue
 * JD-Core Version:    0.7.0.1
 */