package com.tencent.tkd.topicsdk.ucrop.util;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getMatrixValue", "", "matrix", "Landroid/graphics/Matrix;", "matrixIndex", "", "getMatrixScale", "topicsdk-ucrop_release"}, k=2, mv={1, 1, 16})
public final class MatrixExtKt
{
  public static final float a(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "$this$getMatrixScale");
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  private static final float a(Matrix paramMatrix, int paramInt)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    return arrayOfFloat[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.util.MatrixExtKt
 * JD-Core Version:    0.7.0.1
 */