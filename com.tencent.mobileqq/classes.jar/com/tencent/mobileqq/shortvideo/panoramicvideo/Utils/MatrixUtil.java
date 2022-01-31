package com.tencent.mobileqq.shortvideo.panoramicvideo.Utils;

import android.opengl.Matrix;

public class MatrixUtil
{
  public static final int ADJUSTING_MODE_CROP = 2;
  public static final int ADJUSTING_MODE_FIT_TO_SCREEN = 3;
  public static final int ADJUSTING_MODE_STRETCH = 1;
  public static float[] IDENTITY_MATRIX = new float[16];
  
  static
  {
    Matrix.setIdentityM(IDENTITY_MATRIX, 0);
  }
  
  public static void updateProjection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOfFloat)
  {
    switch (paramInt5)
    {
    default: 
      throw new RuntimeException("Adjusting Mode not found!");
    case 1: 
      updateProjectionFill(paramArrayOfFloat);
      return;
    case 3: 
      updateProjectionFit(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
      return;
    }
    updateProjectionCrop(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
  }
  
  public static void updateProjectionCrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f2 < f1)
    {
      Matrix.orthoM(paramArrayOfFloat, 0, -1.0F, 1.0F, -f2 / f1, f2 / f1, -1.0F, 1.0F);
      return;
    }
    Matrix.orthoM(paramArrayOfFloat, 0, -f1 / f2, f1 / f2, -1.0F, 1.0F, -1.0F, 1.0F);
  }
  
  public static void updateProjectionFill(float[] paramArrayOfFloat)
  {
    Matrix.setIdentityM(paramArrayOfFloat, 0);
  }
  
  public static void updateProjectionFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f2 > f1)
    {
      Matrix.orthoM(paramArrayOfFloat, 0, -1.0F, 1.0F, -f2 / f1, f2 / f1, -1.0F, 1.0F);
      return;
    }
    Matrix.orthoM(paramArrayOfFloat, 0, -f1 / f2, f1 / f2, -1.0F, 1.0F, -1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.MatrixUtil
 * JD-Core Version:    0.7.0.1
 */