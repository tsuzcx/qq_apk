package com.tencent.mobileqq.wink.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/utils/RectUtils;", "", "()V", "getMapPoints", "Landroid/graphics/PointF;", "matrix", "Landroid/graphics/Matrix;", "x", "", "y", "isInRect", "", "rectF", "Landroid/graphics/RectF;", "roteAngle", "pointInRect", "curPoint", "pointLT", "pointRT", "pointLB", "pointRB", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RectUtils
{
  public static final RectUtils a = new RectUtils();
  
  private final boolean a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5)
  {
    PointF[] arrayOfPointF = new PointF[4];
    arrayOfPointF[0] = paramPointF2;
    arrayOfPointF[1] = paramPointF4;
    arrayOfPointF[2] = paramPointF5;
    arrayOfPointF[3] = paramPointF3;
    int m = arrayOfPointF.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      paramPointF2 = arrayOfPointF[i];
      int k = i + 1;
      paramPointF3 = arrayOfPointF[(k % m)];
      if (paramPointF2.y == paramPointF3.y)
      {
        i = k;
      }
      else
      {
        i = k;
        if (paramPointF1.y >= RangesKt.coerceAtMost(paramPointF2.y, paramPointF3.y)) {
          if (paramPointF1.y > RangesKt.coerceAtLeast(paramPointF2.y, paramPointF3.y))
          {
            i = k;
          }
          else
          {
            double d1 = paramPointF1.y - paramPointF2.y;
            double d2 = paramPointF3.x - paramPointF2.x;
            Double.isNaN(d1);
            Double.isNaN(d2);
            double d3 = paramPointF3.y - paramPointF2.y;
            Double.isNaN(d3);
            d1 = d1 * d2 / d3;
            d2 = paramPointF2.x;
            Double.isNaN(d2);
            i = k;
            if (d1 + d2 > paramPointF1.x)
            {
              j += 1;
              i = k;
            }
          }
        }
      }
    }
    return j % 2 == 1;
  }
  
  @NotNull
  public final PointF a(@NotNull Matrix paramMatrix, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    paramMatrix.mapPoints(arrayOfFloat);
    return new PointF(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, @Nullable RectF paramRectF, float paramFloat3)
  {
    if ((paramRectF != null) && (!paramRectF.isEmpty()))
    {
      if (paramFloat3 != 0.0F)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setRotate(paramFloat3, paramRectF.centerX(), paramRectF.centerY());
        return a(new PointF(paramFloat1, paramFloat2), a(localMatrix, paramRectF.left, paramRectF.top), a(localMatrix, paramRectF.right, paramRectF.top), a(localMatrix, paramRectF.left, paramRectF.bottom), a(localMatrix, paramRectF.right, paramRectF.bottom));
      }
      return paramRectF.contains(paramFloat1, paramFloat2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.RectUtils
 * JD-Core Version:    0.7.0.1
 */