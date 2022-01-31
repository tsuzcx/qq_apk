package com.tencent.mobileqq.lightReply;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class ImageExplodeLayout$BezierEvaluatorOne
  implements TypeEvaluator
{
  private PointF a;
  
  public ImageExplodeLayout$BezierEvaluatorOne(PointF paramPointF)
  {
    this.a = paramPointF;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = 1.0F - paramFloat;
    PointF localPointF = new PointF();
    localPointF.x = (f1 * f1 * paramPointF1.x + 2.0F * f1 * paramFloat * this.a.x + paramFloat * paramFloat * paramPointF2.x);
    float f2 = paramPointF1.y;
    localPointF.y = (f1 * 2.0F * paramFloat * this.a.y + f1 * f1 * f2 + paramFloat * paramFloat * paramPointF2.y);
    return localPointF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.ImageExplodeLayout.BezierEvaluatorOne
 * JD-Core Version:    0.7.0.1
 */