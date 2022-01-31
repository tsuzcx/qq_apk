package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

public class AnimatableFloatValue
  extends BaseAnimatableValue<Float, Float>
{
  private AnimatableFloatValue()
  {
    super(Float.valueOf(0.0F));
  }
  
  private AnimatableFloatValue(List<Keyframe<Float>> paramList, Float paramFloat)
  {
    super(paramList, paramFloat);
  }
  
  public BaseKeyframeAnimation<Float, Float> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new FloatKeyframeAnimation(this.keyframes);
  }
  
  public Float getInitialValue()
  {
    return (Float)this.initialValue;
  }
  
  public static final class Factory
  {
    static AnimatableFloatValue newInstance()
    {
      return new AnimatableFloatValue(null);
    }
    
    public static AnimatableFloatValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      return newInstance(paramJSONObject, paramLottieComposition, true);
    }
    
    public static AnimatableFloatValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (float f = paramLottieComposition.getDpScale();; f = 1.0F)
      {
        if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
          paramLottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, f, paramLottieComposition, AnimatableFloatValue.ValueFactory.INSTANCE).parseJson();
        return new AnimatableFloatValue(paramJSONObject.keyframes, (Float)paramJSONObject.initialValue, null);
      }
    }
  }
  
  private static class ValueFactory
    implements AnimatableValue.Factory<Float>
  {
    static final ValueFactory INSTANCE = new ValueFactory();
    
    public Float valueFromObject(Object paramObject, float paramFloat)
    {
      return Float.valueOf(JsonUtils.valueFromObject(paramObject) * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue
 * JD-Core Version:    0.7.0.1
 */