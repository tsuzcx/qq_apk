package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.ColorFactory;
import java.util.List;
import org.json.JSONObject;

public class AnimatableColorValue
  extends BaseAnimatableValue<Integer, Integer>
{
  private AnimatableColorValue(List<Keyframe<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public BaseKeyframeAnimation<Integer, Integer> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new ColorKeyframeAnimation(this.keyframes);
  }
  
  public String toString()
  {
    return "AnimatableColorValue{initialValue=" + this.initialValue + '}';
  }
  
  public static final class Factory
  {
    public static AnimatableColorValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, 1.0F, paramLottieComposition, ColorFactory.INSTANCE).parseJson();
      return new AnimatableColorValue(paramJSONObject.keyframes, (Integer)paramJSONObject.initialValue, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue
 * JD-Core Version:    0.7.0.1
 */