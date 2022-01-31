package com.tencent.util;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;

@TargetApi(11)
public class AnimateUtils$BezierEvaluator
  implements TypeEvaluator
{
  private PointF a;
  
  private PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    PointF localPointF = new PointF();
    float f1 = 1.0F - paramFloat;
    localPointF.x = (f1 * f1 * paramPointF1.x + 2.0F * paramFloat * f1 * paramPointF2.x + paramFloat * paramFloat * paramPointF3.x);
    float f2 = paramPointF1.y;
    localPointF.y = (f1 * (2.0F * paramFloat) * paramPointF2.y + f1 * f1 * f2 + paramFloat * paramFloat * paramPointF3.y);
    return localPointF;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    return a(paramFloat, paramPointF1, this.a, paramPointF2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.util.AnimateUtils.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */