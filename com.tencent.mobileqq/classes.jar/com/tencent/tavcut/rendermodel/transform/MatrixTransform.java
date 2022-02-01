package com.tencent.tavcut.rendermodel.transform;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/transform/MatrixTransform;", "", "()V", "MIN_MATRIX_LENGTH", "", "transListMatrixToMatrix", "Landroid/graphics/Matrix;", "srcMatrix", "", "", "transMatrixToListMatrix", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MatrixTransform
{
  public static final MatrixTransform INSTANCE = new MatrixTransform();
  private static final int MIN_MATRIX_LENGTH = 9;
  
  @JvmStatic
  @NotNull
  public static final Matrix transListMatrixToMatrix(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "srcMatrix");
    Matrix localMatrix = new Matrix();
    if (paramList.size() < 9) {
      return localMatrix;
    }
    localMatrix.setValues(CollectionsKt.toFloatArray((Collection)paramList));
    return localMatrix;
  }
  
  @JvmStatic
  @NotNull
  public static final List<Float> transMatrixToListMatrix(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "srcMatrix");
    List localList = (List)new ArrayList();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localList.add(Float.valueOf(arrayOfFloat[i]));
      i += 1;
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.transform.MatrixTransform
 * JD-Core Version:    0.7.0.1
 */