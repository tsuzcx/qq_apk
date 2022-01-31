package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class SplitDimensionPathKeyframeAnimation
  extends BaseKeyframeAnimation<PointF, PointF>
{
  private final PointF point = new PointF();
  private final BaseKeyframeAnimation<Float, Float> xAnimation;
  private final BaseKeyframeAnimation<Float, Float> yAnimation;
  
  public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation1, BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation2)
  {
    super(Collections.emptyList());
    this.xAnimation = paramBaseKeyframeAnimation1;
    this.yAnimation = paramBaseKeyframeAnimation2;
    setProgress(getProgress());
  }
  
  public PointF getValue()
  {
    return getValue(null, 0.0F);
  }
  
  PointF getValue(Keyframe<PointF> paramKeyframe, float paramFloat)
  {
    return this.point;
  }
  
  public void setProgress(float paramFloat)
  {
    this.xAnimation.setProgress(paramFloat);
    this.yAnimation.setProgress(paramFloat);
    this.point.set(((Float)this.xAnimation.getValue()).floatValue(), ((Float)this.yAnimation.getValue()).floatValue());
    int i = 0;
    while (i < this.listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.SplitDimensionPathKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */