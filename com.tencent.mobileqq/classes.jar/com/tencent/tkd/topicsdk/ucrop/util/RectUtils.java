package com.tencent.tkd.topicsdk.ucrop.util;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/util/RectUtils;", "", "()V", "getCenterFromRect", "", "r", "Landroid/graphics/RectF;", "getCornersFromRect", "getRectSidesFromCorners", "corners", "trapToRect", "array", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class RectUtils
{
  public static final RectUtils a = new RectUtils();
  
  @JvmStatic
  @NotNull
  public static final RectF a(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "array");
    RectF localRectF = new RectF(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      float f2 = paramArrayOfFloat[(i - 1)];
      float f1 = 10;
      f2 = (float)MathKt.roundToLong(f2 * f1) / 10.0F;
      f1 = (float)MathKt.roundToLong(paramArrayOfFloat[i] * f1) / 10.0F;
      float f3;
      if (f2 < localRectF.left) {
        f3 = f2;
      } else {
        f3 = localRectF.left;
      }
      localRectF.left = f3;
      if (f1 < localRectF.top) {
        f3 = f1;
      } else {
        f3 = localRectF.top;
      }
      localRectF.top = f3;
      if (f2 <= localRectF.right) {
        f2 = localRectF.right;
      }
      localRectF.right = f2;
      if (f1 <= localRectF.bottom) {
        f1 = localRectF.bottom;
      }
      localRectF.bottom = f1;
      i += 2;
    }
    localRectF.sort();
    return localRectF;
  }
  
  @JvmStatic
  @NotNull
  public static final float[] a(@NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "r");
    return new float[] { paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.top, paramRectF.right, paramRectF.bottom, paramRectF.left, paramRectF.bottom };
  }
  
  @JvmStatic
  @NotNull
  public static final float[] a(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "corners");
    double d1 = paramArrayOfFloat[0];
    double d2 = paramArrayOfFloat[2];
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.pow(d1 - d2, 2.0D);
    d2 = paramArrayOfFloat[1];
    double d3 = paramArrayOfFloat[3];
    Double.isNaN(d2);
    Double.isNaN(d3);
    float f = (float)Math.sqrt(d1 + Math.pow(d2 - d3, 2.0D));
    d1 = paramArrayOfFloat[2];
    d2 = paramArrayOfFloat[4];
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.pow(d1 - d2, 2.0D);
    d2 = paramArrayOfFloat[3];
    d3 = paramArrayOfFloat[5];
    Double.isNaN(d2);
    Double.isNaN(d3);
    return new float[] { f, (float)Math.sqrt(d1 + Math.pow(d2 - d3, 2.0D)) };
  }
  
  @JvmStatic
  @NotNull
  public static final float[] b(@NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "r");
    return new float[] { paramRectF.centerX(), paramRectF.centerY() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.RectUtils
 * JD-Core Version:    0.7.0.1
 */