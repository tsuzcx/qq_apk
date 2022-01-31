package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ScaleKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.ScaleXY;
import com.tencent.mobileqq.dinifly.model.ScaleXY.Factory;
import java.util.List;
import org.json.JSONObject;

public class AnimatableScaleValue
  extends BaseAnimatableValue<ScaleXY, ScaleXY>
{
  private AnimatableScaleValue()
  {
    super(new ScaleXY());
  }
  
  AnimatableScaleValue(List<Keyframe<ScaleXY>> paramList, ScaleXY paramScaleXY)
  {
    super(paramList, paramScaleXY);
  }
  
  public BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new ScaleKeyframeAnimation(this.keyframes);
  }
  
  static final class Factory
  {
    static AnimatableScaleValue newInstance()
    {
      return new AnimatableScaleValue(null);
    }
    
    static AnimatableScaleValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, 1.0F, paramLottieComposition, ScaleXY.Factory.INSTANCE).parseJson();
      return new AnimatableScaleValue(paramJSONObject.keyframes, (ScaleXY)paramJSONObject.initialValue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue
 * JD-Core Version:    0.7.0.1
 */