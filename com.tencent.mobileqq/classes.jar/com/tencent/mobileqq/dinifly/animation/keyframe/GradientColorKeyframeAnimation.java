package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import java.util.List;

public class GradientColorKeyframeAnimation
  extends KeyframeAnimation<GradientColor>
{
  private final GradientColor gradientColor;
  
  public GradientColorKeyframeAnimation(List<? extends Keyframe<GradientColor>> paramList)
  {
    super(paramList);
    paramList = (GradientColor)((Keyframe)paramList.get(0)).startValue;
    if (paramList == null) {}
    for (;;)
    {
      this.gradientColor = new GradientColor(new float[i], new int[i]);
      return;
      i = paramList.getSize();
    }
  }
  
  GradientColor getValue(Keyframe<GradientColor> paramKeyframe, float paramFloat)
  {
    this.gradientColor.lerp((GradientColor)paramKeyframe.startValue, (GradientColor)paramKeyframe.endValue, paramFloat);
    return this.gradientColor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.GradientColorKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */