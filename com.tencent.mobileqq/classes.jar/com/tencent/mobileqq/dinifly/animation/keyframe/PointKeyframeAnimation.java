package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.List;

public class PointKeyframeAnimation
  extends KeyframeAnimation<PointF>
{
  private final PointF point = new PointF();
  
  public PointKeyframeAnimation(List<Keyframe<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(Keyframe<PointF> paramKeyframe, float paramFloat)
  {
    if ((paramKeyframe.startValue == null) || (paramKeyframe.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    PointF localPointF = (PointF)paramKeyframe.startValue;
    paramKeyframe = (PointF)paramKeyframe.endValue;
    this.point.set(localPointF.x + (paramKeyframe.x - localPointF.x) * paramFloat, localPointF.y + (paramKeyframe.y - localPointF.y) * paramFloat);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PointKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */