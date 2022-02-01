package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation
  extends KeyframeAnimation<ScaleXY>
{
  private final ScaleXY scaleXY = new ScaleXY();
  
  public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> paramList)
  {
    super(paramList);
  }
  
  public ScaleXY getValue(Keyframe<ScaleXY> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue != null) && (paramKeyframe.endValue != null))
    {
      ScaleXY localScaleXY1 = (ScaleXY)paramKeyframe.startValue;
      ScaleXY localScaleXY2 = (ScaleXY)paramKeyframe.endValue;
      if (this.valueCallback != null)
      {
        paramKeyframe = (ScaleXY)this.valueCallback.getValueInternal(paramKeyframe.startFrame, paramKeyframe.endFrame.floatValue(), localScaleXY1, localScaleXY2, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
        if (paramKeyframe != null) {
          return paramKeyframe;
        }
      }
      this.scaleXY.set(MiscUtils.lerp(localScaleXY1.getScaleX(), localScaleXY2.getScaleX(), paramFloat), MiscUtils.lerp(localScaleXY1.getScaleY(), localScaleXY2.getScaleY(), paramFloat));
      return this.scaleXY;
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.ScaleKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */