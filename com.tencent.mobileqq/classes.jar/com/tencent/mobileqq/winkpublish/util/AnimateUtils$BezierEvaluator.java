package com.tencent.mobileqq.winkpublish.util;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;

@TargetApi(11)
public class AnimateUtils$BezierEvaluator
  implements TypeEvaluator<PointF>
{
  private PointF a;
  
  private PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    PointF localPointF = new PointF();
    float f3 = 1.0F - paramFloat;
    float f1 = f3 * f3;
    float f2 = paramPointF1.x;
    f3 = 2.0F * paramFloat * f3;
    float f4 = paramPointF2.x;
    paramFloat *= paramFloat;
    localPointF.x = (f2 * f1 + f4 * f3 + paramPointF3.x * paramFloat);
    localPointF.y = (f1 * paramPointF1.y + f3 * paramPointF2.y + paramFloat * paramPointF3.y);
    return localPointF;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    return a(paramFloat, paramPointF1, this.a, paramPointF2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.AnimateUtils.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */