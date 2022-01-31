package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.model.ScaleXY;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.List;

public class ScaleKeyframeAnimation
  extends KeyframeAnimation<ScaleXY>
{
  public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> paramList)
  {
    super(paramList);
  }
  
  public ScaleXY getValue(Keyframe<ScaleXY> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    ScaleXY localScaleXY = (ScaleXY)paramKeyframe.startValue;
    paramKeyframe = (ScaleXY)paramKeyframe.endValue;
    return new ScaleXY(MiscUtils.lerp(localScaleXY.getScaleX(), paramKeyframe.getScaleX(), paramFloat), MiscUtils.lerp(localScaleXY.getScaleY(), paramKeyframe.getScaleY(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ScaleKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */