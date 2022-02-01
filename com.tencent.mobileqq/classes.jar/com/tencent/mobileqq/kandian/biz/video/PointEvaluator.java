package com.tencent.mobileqq.kandian.biz.video;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class PointEvaluator
  implements TypeEvaluator<Point>
{
  private Point a = new Point();
  
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    int i = (int)(paramPoint1.x + (paramPoint2.x - paramPoint1.x) * paramFloat);
    int j = (int)(paramPoint1.y + paramFloat * (paramPoint2.y - paramPoint1.y));
    this.a.set(i, j);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.PointEvaluator
 * JD-Core Version:    0.7.0.1
 */