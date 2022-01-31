package com.tencent.ttpic.util;

import android.opengl.Matrix;

public class MatrixUtil
{
  private static float[] mIdentityMatrix = new float[16];
  private static float[] mMVPMatrix;
  private static float[] mProjectionMatrix = new float[16];
  private static float[] mViewMatrix = new float[16];
  
  static
  {
    mMVPMatrix = new float[16];
  }
  
  public static float[] getDefaultMVPMatrix()
  {
    initProjectionMatrix(1.0F, 3.0F);
    initViewMatrix(2.0F);
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    return mMVPMatrix;
  }
  
  public static float[] getIdentityMatrix()
  {
    Matrix.setIdentityM(mIdentityMatrix, 0);
    return mIdentityMatrix;
  }
  
  public static float[] getMVPMatrix(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    initProjectionMatrix(paramFloat2, paramFloat3);
    initViewMatrix(paramFloat1);
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    return mMVPMatrix;
  }
  
  public static float[] initProjectionMatrix(float paramFloat1, float paramFloat2)
  {
    Matrix.frustumM(mProjectionMatrix, 0, -1.0F, 1.0F, -1.0F, 1.0F, paramFloat1, paramFloat2);
    return mProjectionMatrix;
  }
  
  public static float[] initViewMatrix(float paramFloat)
  {
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, paramFloat, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F);
    return mViewMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.MatrixUtil
 * JD-Core Version:    0.7.0.1
 */