package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.IntegerKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

public class AnimatableIntegerValue
  extends BaseAnimatableValue<Integer, Integer>
{
  private AnimatableIntegerValue()
  {
    super(Integer.valueOf(100));
  }
  
  AnimatableIntegerValue(List<Keyframe<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public BaseKeyframeAnimation<Integer, Integer> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new IntegerKeyframeAnimation(this.keyframes);
  }
  
  public Integer getInitialValue()
  {
    return (Integer)this.initialValue;
  }
  
  public static final class Factory
  {
    static AnimatableIntegerValue newInstance()
    {
      return new AnimatableIntegerValue(null);
    }
    
    public static AnimatableIntegerValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
        paramLottieComposition.addWarning("Lottie doesn't support expressions.");
      }
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, 1.0F, paramLottieComposition, AnimatableIntegerValue.ValueFactory.access$100()).parseJson();
      paramLottieComposition = (Integer)paramJSONObject.initialValue;
      return new AnimatableIntegerValue(paramJSONObject.keyframes, paramLottieComposition);
    }
  }
  
  private static class ValueFactory
    implements AnimatableValue.Factory<Integer>
  {
    private static final ValueFactory INSTANCE = new ValueFactory();
    
    public Integer valueFromObject(Object paramObject, float paramFloat)
    {
      return Integer.valueOf(Math.round(JsonUtils.valueFromObject(paramObject) * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue
 * JD-Core Version:    0.7.0.1
 */