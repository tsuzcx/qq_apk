package com.tencent.richmediabrowser.animation;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;

@TargetApi(11)
public class AnimateUtils$BezierEvaluator
  implements TypeEvaluator<PointF>
{
  private PointF mPointF;
  
  public AnimateUtils$BezierEvaluator(PointF paramPointF)
  {
    this.mPointF = paramPointF;
  }
  
  private PointF calculateBezierPointForQuadratic(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    PointF localPointF = new PointF();
    float f1 = 1.0F - paramFloat;
    localPointF.x = (f1 * f1 * paramPointF1.x + 2.0F * paramFloat * f1 * paramPointF2.x + paramFloat * paramFloat * paramPointF3.x);
    float f2 = paramPointF1.y;
    localPointF.y = (f1 * (2.0F * paramFloat) * paramPointF2.y + f1 * f1 * f2 + paramFloat * paramFloat * paramPointF3.y);
    return localPointF;
  }
  
  public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    return calculateBezierPointForQuadratic(paramFloat, paramPointF1, this.mPointF, paramPointF2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimateUtils.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */