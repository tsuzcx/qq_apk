package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
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
    PointF localPointF1 = (PointF)paramKeyframe.startValue;
    PointF localPointF2 = (PointF)paramKeyframe.endValue;
    if (this.valueCallback != null)
    {
      paramKeyframe = (PointF)this.valueCallback.getValueInternal(paramKeyframe.startFrame, paramKeyframe.endFrame.floatValue(), localPointF1, localPointF2, paramFloat, getLinearCurrentKeyframeProgress(), getProgress());
      if (paramKeyframe != null) {
        return paramKeyframe;
      }
    }
    this.point.set(localPointF1.x + (localPointF2.x - localPointF1.x) * paramFloat, localPointF1.y + (localPointF2.y - localPointF1.y) * paramFloat);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.PointKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */