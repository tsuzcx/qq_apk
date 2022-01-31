package com.tencent.mobileqq.dinifly.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;

public class LottieInterpolatedPointValue
  extends LottieInterpolatedValue<PointF>
{
  private final PointF point = new PointF();
  
  public LottieInterpolatedPointValue(PointF paramPointF1, PointF paramPointF2)
  {
    super(paramPointF1, paramPointF2);
  }
  
  public LottieInterpolatedPointValue(PointF paramPointF1, PointF paramPointF2, Interpolator paramInterpolator)
  {
    super(paramPointF1, paramPointF2, paramInterpolator);
  }
  
  PointF interpolateValue(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    this.point.set(MiscUtils.lerp(paramPointF1.x, paramPointF2.x, paramFloat), MiscUtils.lerp(paramPointF1.y, paramPointF2.y, paramFloat));
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.value.LottieInterpolatedPointValue
 * JD-Core Version:    0.7.0.1
 */