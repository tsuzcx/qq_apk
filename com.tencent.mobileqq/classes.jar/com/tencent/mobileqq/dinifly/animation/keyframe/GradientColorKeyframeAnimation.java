package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.model.content.GradientColor;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation
  extends KeyframeAnimation<GradientColor>
{
  private final GradientColor gradientColor;
  
  public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> paramList)
  {
    super(paramList);
    int i = 0;
    paramList = (GradientColor)((Keyframe)paramList.get(0)).startValue;
    if (paramList != null) {
      i = paramList.getSize();
    }
    this.gradientColor = new GradientColor(new float[i], new int[i]);
  }
  
  GradientColor getValue(Keyframe<GradientColor> paramKeyframe, float paramFloat)
  {
    this.gradientColor.lerp((GradientColor)paramKeyframe.startValue, (GradientColor)paramKeyframe.endValue, paramFloat);
    return this.gradientColor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.GradientColorKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */