package com.tencent.mobileqq.bubble;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class PathPoint$PathEvaluator
  implements TypeEvaluator<PathPoint>
{
  public PathPoint a(float paramFloat, PathPoint paramPathPoint1, PathPoint paramPathPoint2)
  {
    float f1;
    float f2;
    if (paramPathPoint2.i == 2)
    {
      float f3 = 1.0F - paramFloat;
      f1 = f3 * f3 * f3;
      f2 = paramPathPoint1.a;
      float f5 = 3.0F * f3;
      f3 = f3 * f5 * paramFloat;
      float f4 = paramPathPoint2.e;
      f5 = f5 * paramFloat * paramFloat;
      float f7 = paramPathPoint2.g;
      float f6 = paramFloat * paramFloat * paramFloat;
      f2 = f2 * f1 + f4 * f3 + f7 * f5 + paramPathPoint2.a * f6;
      f1 = f1 * paramPathPoint1.b + f3 * paramPathPoint2.f + f5 * paramPathPoint2.h + f6 * paramPathPoint2.b;
    }
    else if (paramPathPoint2.i == 1)
    {
      f2 = paramPathPoint1.a + (paramPathPoint2.a - paramPathPoint1.a) * paramFloat;
      f1 = paramPathPoint1.b;
      f1 = (paramPathPoint2.b - paramPathPoint1.b) * paramFloat + f1;
    }
    else
    {
      f2 = paramPathPoint2.a;
      f1 = paramPathPoint2.b;
    }
    PathPoint localPathPoint = PathPoint.b(f2, f1);
    paramPathPoint1.d += (paramPathPoint2.d - paramPathPoint1.d) * paramFloat;
    paramPathPoint1.c += paramFloat * (paramPathPoint2.c - paramPathPoint1.c);
    return localPathPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.PathPoint.PathEvaluator
 * JD-Core Version:    0.7.0.1
 */