package com.tencent.mobileqq.utils;

import android.graphics.PointF;

final class ValueAnimation$5
  implements ValueAnimation.TypeEvaluator<PointF>
{
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + paramFloat * (paramPointF2.y - f2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation.5
 * JD-Core Version:    0.7.0.1
 */