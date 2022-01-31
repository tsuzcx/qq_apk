package com.tencent.mobileqq.dinifly.utils;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import java.util.List;

public class MiscUtils
{
  public static PointF addPoints(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  private static int floorDiv(int paramInt1, int paramInt2)
  {
    int j = paramInt1 / paramInt2;
    int i = j;
    if ((paramInt1 ^ paramInt2) < 0)
    {
      i = j;
      if (j * paramInt2 != paramInt1) {
        i = j - 1;
      }
    }
    return i;
  }
  
  public static int floorMod(float paramFloat1, float paramFloat2)
  {
    return floorMod((int)paramFloat1, (int)paramFloat2);
  }
  
  public static int floorMod(int paramInt1, int paramInt2)
  {
    return paramInt1 - floorDiv(paramInt1, paramInt2) * paramInt2;
  }
  
  public static void getPathFromData(ShapeData paramShapeData, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramShapeData.getInitialPoint();
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    int i = 0;
    if (i < paramShapeData.getCurves().size())
    {
      Object localObject = (CubicCurveData)paramShapeData.getCurves().get(i);
      PointF localPointF2 = ((CubicCurveData)localObject).getControlPoint1();
      PointF localPointF3 = ((CubicCurveData)localObject).getControlPoint2();
      localObject = ((CubicCurveData)localObject).getVertex();
      if ((localPointF2.equals(localPointF1)) && (localPointF3.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      }
      for (;;)
      {
        localPointF1.set(((PointF)localObject).x, ((PointF)localObject).y);
        i += 1;
        break;
        paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y, ((PointF)localObject).x, ((PointF)localObject).y);
      }
    }
    if (paramShapeData.isClosed()) {
      paramPath.close();
    }
  }
  
  public static double lerp(double paramDouble1, double paramDouble2, @FloatRange(from=0.0D, to=1.0D) double paramDouble3)
  {
    return (paramDouble2 - paramDouble1) * paramDouble3 + paramDouble1;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public static int lerp(int paramInt1, int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.MiscUtils
 * JD-Core Version:    0.7.0.1
 */