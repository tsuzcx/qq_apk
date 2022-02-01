package com.tencent.mobileqq.dinifly.utils;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.dinifly.animation.content.KeyPathElementContent;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import java.util.List;

public class MiscUtils
{
  private static PointF pathFromDataCurrentPoint = new PointF();
  
  public static PointF addPoints(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt3, paramInt1));
  }
  
  public static boolean contains(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= paramFloat2) && (paramFloat1 <= paramFloat3);
  }
  
  private static int floorDiv(int paramInt1, int paramInt2)
  {
    int j = paramInt1 / paramInt2;
    if ((paramInt1 ^ paramInt2) >= 0) {}
    for (int i = 1; (i == 0) && (paramInt1 % paramInt2 != 0); i = 0) {
      return j - 1;
    }
    return j;
  }
  
  static int floorMod(float paramFloat1, float paramFloat2)
  {
    return floorMod((int)paramFloat1, (int)paramFloat2);
  }
  
  private static int floorMod(int paramInt1, int paramInt2)
  {
    return paramInt1 - floorDiv(paramInt1, paramInt2) * paramInt2;
  }
  
  public static void getPathFromData(ShapeData paramShapeData, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = paramShapeData.getInitialPoint();
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    pathFromDataCurrentPoint.set(localPointF1.x, localPointF1.y);
    int i = 0;
    if (i < paramShapeData.getCurves().size())
    {
      Object localObject = (CubicCurveData)paramShapeData.getCurves().get(i);
      localPointF1 = ((CubicCurveData)localObject).getControlPoint1();
      PointF localPointF2 = ((CubicCurveData)localObject).getControlPoint2();
      localObject = ((CubicCurveData)localObject).getVertex();
      if ((localPointF1.equals(pathFromDataCurrentPoint)) && (localPointF2.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      }
      for (;;)
      {
        pathFromDataCurrentPoint.set(((PointF)localObject).x, ((PointF)localObject).y);
        i += 1;
        break;
        paramPath.cubicTo(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y, ((PointF)localObject).x, ((PointF)localObject).y);
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
  
  public static void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2, KeyPathElementContent paramKeyPathElementContent)
  {
    if (paramKeyPath1.fullyResolvesTo(paramKeyPathElementContent.getName(), paramInt)) {
      paramList.add(paramKeyPath2.addKey(paramKeyPathElementContent.getName()).resolve(paramKeyPathElementContent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.MiscUtils
 * JD-Core Version:    0.7.0.1
 */