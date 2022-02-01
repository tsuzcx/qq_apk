package com.tencent.mobileqq.utils;

import android.graphics.Point;

final class ValueAnimation$4
  implements ValueAnimation.TypeEvaluator<Point>
{
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    float f1 = paramPoint1.x;
    float f2 = paramPoint1.y;
    return new Point((int)(f1 + (paramPoint2.x - f1) * paramFloat), (int)(f2 + paramFloat * (paramPoint2.y - f2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation.4
 * JD-Core Version:    0.7.0.1
 */