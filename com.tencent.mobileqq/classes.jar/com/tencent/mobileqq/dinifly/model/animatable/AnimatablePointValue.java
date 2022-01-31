package com.tencent.mobileqq.dinifly.model.animatable;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.PointKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.StaticKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.PointFFactory;
import java.util.List;
import org.json.JSONObject;

public class AnimatablePointValue
  extends BaseAnimatableValue<PointF, PointF>
{
  private AnimatablePointValue(List<Keyframe<PointF>> paramList, PointF paramPointF)
  {
    super(paramList, paramPointF);
  }
  
  public BaseKeyframeAnimation<PointF, PointF> createAnimation()
  {
    if (!hasAnimation()) {
      return new StaticKeyframeAnimation(this.initialValue);
    }
    return new PointKeyframeAnimation(this.keyframes);
  }
  
  public static final class Factory
  {
    public static AnimatablePointValue newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, paramLottieComposition.getDpScale(), paramLottieComposition, PointFFactory.INSTANCE).parseJson();
      return new AnimatablePointValue(paramJSONObject.keyframes, (PointF)paramJSONObject.initialValue, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue
 * JD-Core Version:    0.7.0.1
 */