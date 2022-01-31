package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.common.detector.MathUtils;

public class ResultPoint
{
  private final float x;
  private final float y;
  
  public ResultPoint(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  private static float crossProductZ(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    float f1 = paramResultPoint2.x;
    float f2 = paramResultPoint2.y;
    float f3 = paramResultPoint3.x;
    float f4 = paramResultPoint1.y;
    float f5 = paramResultPoint3.y;
    return (f3 - f1) * (f4 - f2) - (paramResultPoint1.x - f1) * (f5 - f2);
  }
  
  public static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.distance(paramResultPoint1.x, paramResultPoint1.y, paramResultPoint2.x, paramResultPoint2.y);
  }
  
  public static void orderBestPatterns(ResultPoint[] paramArrayOfResultPoint)
  {
    float f1 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = distance(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    ResultPoint localResultPoint;
    Object localObject2;
    Object localObject1;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localResultPoint = paramArrayOfResultPoint[0];
      localObject2 = paramArrayOfResultPoint[1];
      localObject1 = paramArrayOfResultPoint[2];
      if (crossProductZ((ResultPoint)localObject2, localResultPoint, (ResultPoint)localObject1) >= 0.0F) {
        break label135;
      }
    }
    for (;;)
    {
      paramArrayOfResultPoint[0] = localObject1;
      paramArrayOfResultPoint[1] = localResultPoint;
      paramArrayOfResultPoint[2] = localObject2;
      return;
      if ((f3 >= f2) && (f3 >= f1))
      {
        localResultPoint = paramArrayOfResultPoint[1];
        localObject2 = paramArrayOfResultPoint[0];
        localObject1 = paramArrayOfResultPoint[2];
        break;
      }
      localResultPoint = paramArrayOfResultPoint[2];
      localObject2 = paramArrayOfResultPoint[0];
      localObject1 = paramArrayOfResultPoint[1];
      break;
      label135:
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof ResultPoint))
    {
      paramObject = (ResultPoint)paramObject;
      bool1 = bool2;
      if (this.x == paramObject.x)
      {
        bool1 = bool2;
        if (this.y == paramObject.y) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final float getX()
  {
    return this.x;
  }
  
  public final float getY()
  {
    return this.y;
  }
  
  public final int hashCode()
  {
    return Float.floatToIntBits(this.x) * 31 + Float.floatToIntBits(this.y);
  }
  
  public final String toString()
  {
    return "(" + this.x + ',' + this.y + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.ResultPoint
 * JD-Core Version:    0.7.0.1
 */