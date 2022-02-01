package com.tencent.ttpic.openapi.util;

import android.opengl.Matrix;
import android.util.Log;
import java.util.Arrays;

public class MatrixUtil
{
  public static final float[] ROTATE_IDENTITY = { 0.0F, 0.0F, 0.0F };
  public static final float[] SCALE_IDENTITY;
  private static final String TAG = MatrixUtil.class.getSimpleName();
  public static final float[] TRANSLATE_IDENTITY;
  private static float[] mIdentityMatrix;
  private static float[] mMVPMatrix;
  private static float[] mProjectionMatrix = new float[16];
  private static float[] mViewMatrix = new float[16];
  
  static
  {
    mMVPMatrix = new float[16];
    mIdentityMatrix = new float[16];
    TRANSLATE_IDENTITY = new float[] { 0.0F, 0.0F, 0.0F };
    SCALE_IDENTITY = new float[] { 1.0F, 1.0F, 1.0F };
  }
  
  public static float[] compose(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    float[] arrayOfFloat1 = new float[16];
    float[] arrayOfFloat2 = new float[16];
    float[] arrayOfFloat3 = new float[16];
    float[] arrayOfFloat4 = new float[16];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.translateM(arrayOfFloat1, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], paramArrayOfFloat1[2]);
    Matrix.scaleM(arrayOfFloat1, 0, paramArrayOfFloat2[0], paramArrayOfFloat2[1], paramArrayOfFloat2[2]);
    paramArrayOfFloat1 = new float[3];
    int i = 0;
    while (i < paramArrayOfFloat1.length)
    {
      paramArrayOfFloat1[i] = ((float)(paramArrayOfFloat3[i] * 180.0F / 3.141592653589793D));
      i += 1;
    }
    Matrix.rotateM(arrayOfFloat4, 0, arrayOfFloat1, 0, paramArrayOfFloat1[2], 0.0F, 0.0F, 1.0F);
    Matrix.rotateM(arrayOfFloat3, 0, arrayOfFloat4, 0, paramArrayOfFloat1[1], 0.0F, 1.0F, 0.0F);
    Matrix.rotateM(arrayOfFloat2, 0, arrayOfFloat3, 0, paramArrayOfFloat1[0], 1.0F, 0.0F, 0.0F);
    return arrayOfFloat2;
  }
  
  public static void decompose(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length < 16)) {
      return;
    }
    paramArrayOfFloat2[0] = paramArrayOfFloat1[12];
    paramArrayOfFloat2[1] = paramArrayOfFloat1[13];
    paramArrayOfFloat2[2] = paramArrayOfFloat1[14];
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat1[1];
    float f3 = paramArrayOfFloat1[2];
    float f10 = paramArrayOfFloat1[4];
    float f11 = paramArrayOfFloat1[5];
    float f4 = paramArrayOfFloat1[6];
    float f8 = paramArrayOfFloat1[8];
    float f9 = paramArrayOfFloat1[9];
    float f5 = paramArrayOfFloat1[10];
    float f6 = (f11 * f5 - f4 * f9) * f1 + (f4 * f8 - f10 * f5) * f2 + f3 * (f10 * f9 - f11 * f8);
    float f7 = length(new float[] { f1, f2, f3 });
    f10 = length(new float[] { f10, f11, f4 });
    f8 = length(new float[] { f8, f9, f5 });
    paramArrayOfFloat3[0] = f7;
    paramArrayOfFloat3[1] = f10;
    paramArrayOfFloat3[2] = f8;
    int i;
    if (f6 < 0.0F)
    {
      i = 0;
      while (i < paramArrayOfFloat3.length)
      {
        paramArrayOfFloat3[i] = (-paramArrayOfFloat3[i]);
        i += 1;
      }
    }
    paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, paramArrayOfFloat1.length);
    if (Math.abs(f6) > 0.0F)
    {
      i = 0;
      while (i < 4)
      {
        int j = i + 0;
        paramArrayOfFloat1[j] /= paramArrayOfFloat3[0];
        j = i + 4;
        paramArrayOfFloat1[j] /= paramArrayOfFloat3[1];
        j = i + 8;
        paramArrayOfFloat1[j] /= paramArrayOfFloat3[2];
        i += 1;
      }
    }
    paramArrayOfFloat4[0] = ((float)Math.atan2(f4, f5));
    paramArrayOfFloat4[1] = ((float)Math.atan2(-f3, Math.sqrt(f4 * f4 + f5 * f5)));
    paramArrayOfFloat4[2] = ((float)Math.atan2(f2, f1));
  }
  
  public static float[] genLookAtMatrix(int paramInt1, int paramInt2)
  {
    float f = Math.max(paramInt1, paramInt2);
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, f, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    return mViewMatrix;
  }
  
  public static float[] genProjectionMatrix(int paramInt1, int paramInt2)
  {
    int i = Math.max(paramInt1, paramInt2);
    float f1 = i;
    float f2 = i;
    float f3 = -paramInt1;
    float f4 = paramInt1;
    float f5 = -paramInt2;
    float f6 = paramInt2;
    Matrix.frustumM(mProjectionMatrix, 0, f3 * 0.01F, f4 * 0.01F, f5 * 0.01F, 0.01F * f6, f1 * 0.02F, f2 * 2.0F);
    return mProjectionMatrix;
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
  
  public static float[] getMVPMatrix(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    genProjectionMatrix(paramInt1, paramInt2);
    genLookAtMatrix(paramInt1, paramInt2);
    Matrix.multiplyMM(paramArrayOfFloat, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    return paramArrayOfFloat;
  }
  
  public static float[] getRotate(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 1.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 1.0F;
    float[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 1.0F;
    tmp15_11;
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 16)) {
      return arrayOfFloat;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f10 = paramArrayOfFloat[4];
    float f11 = paramArrayOfFloat[5];
    float f4 = paramArrayOfFloat[6];
    float f8 = paramArrayOfFloat[8];
    float f9 = paramArrayOfFloat[9];
    float f5 = paramArrayOfFloat[10];
    float f6 = (f11 * f5 - f4 * f9) * f1 + (f4 * f8 - f10 * f5) * f2 + f3 * (f10 * f9 - f11 * f8);
    float f7 = length(new float[] { f1, f2, f3 });
    f10 = length(new float[] { f10, f11, f4 });
    f8 = length(new float[] { f8, f9, f5 });
    arrayOfFloat[0] = f7;
    arrayOfFloat[1] = f10;
    arrayOfFloat[2] = f8;
    int i;
    if (f6 < 0.0F)
    {
      i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = (-arrayOfFloat[i]);
        i += 1;
      }
    }
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    if (Math.abs(f6) > 0.0F)
    {
      i = 0;
      while (i < 4)
      {
        int j = i + 0;
        paramArrayOfFloat[j] /= arrayOfFloat[0];
        j = i + 4;
        paramArrayOfFloat[j] /= arrayOfFloat[1];
        j = i + 8;
        paramArrayOfFloat[j] /= arrayOfFloat[2];
        i += 1;
      }
    }
    return new float[] { (float)Math.atan2(f4, f5), (float)Math.atan2(-f3, Math.sqrt(f4 * f4 + f5 * f5)), (float)Math.atan2(f2, f1) };
  }
  
  public static float[] getScale(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 1.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 1.0F;
    float[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 1.0F;
    tmp15_11;
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 16)) {
      return arrayOfFloat;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[4];
    float f5 = paramArrayOfFloat[5];
    float f6 = paramArrayOfFloat[6];
    float f7 = paramArrayOfFloat[8];
    float f8 = paramArrayOfFloat[9];
    float f9 = paramArrayOfFloat[10];
    float f10 = length(new float[] { f1, f2, f3 });
    float f11 = length(new float[] { f4, f5, f6 });
    float f12 = length(new float[] { f7, f8, f9 });
    arrayOfFloat[0] = f10;
    arrayOfFloat[1] = f11;
    arrayOfFloat[2] = f12;
    if ((f5 * f9 - f6 * f8) * f1 + (f6 * f7 - f4 * f9) * f2 + f3 * (f4 * f8 - f5 * f7) < 0.0F)
    {
      int i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = (-arrayOfFloat[i]);
        i += 1;
      }
    }
    return arrayOfFloat;
  }
  
  public static float[] initProjectionMatrix(float paramFloat1, float paramFloat2)
  {
    Matrix.frustumM(mProjectionMatrix, 0, -1.0F, 1.0F, -1.0F, 1.0F, paramFloat1, paramFloat2);
    return mProjectionMatrix;
  }
  
  private static float[] initViewMatrix(float paramFloat)
  {
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, paramFloat, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F);
    return mViewMatrix;
  }
  
  public static float[] inverse(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return paramArrayOfFloat;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = (-paramArrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private static float length(float... paramVarArgs)
  {
    float f1 = 0.0F;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      float f2 = paramVarArgs[i];
      f1 += f2 * f2;
      i += 1;
    }
    return (float)Math.sqrt(f1);
  }
  
  public static void printMat(String paramString, float[] paramArrayOfFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append('\n');
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        localStringBuilder.append(paramArrayOfFloat[(i * 4 + j)] + ", ");
        j += 1;
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    Log.d(TAG, localStringBuilder.toString());
  }
  
  public static float[] rotate(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = ((float)(paramArrayOfFloat2[i] * 180.0F / 3.141592653589793D));
      i += 1;
    }
    paramArrayOfFloat2 = new float[16];
    setRotateEulerM(paramArrayOfFloat2, 0, arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat1, 0, paramArrayOfFloat2, 0);
    return arrayOfFloat;
  }
  
  public static void setRotateEulerM(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = paramFloat1 * 0.01745329F;
    float f1 = paramFloat2 * 0.01745329F;
    float f3 = 0.01745329F * paramFloat3;
    paramFloat1 = (float)Math.cos(f2);
    paramFloat2 = (float)Math.sin(f2);
    paramFloat3 = (float)Math.cos(f1);
    f1 = (float)Math.sin(f1);
    f2 = (float)Math.cos(f3);
    f3 = (float)Math.sin(f3);
    float f4 = paramFloat1 * f1;
    float f5 = paramFloat2 * f1;
    paramArrayOfFloat[(paramInt + 0)] = (paramFloat3 * f2);
    paramArrayOfFloat[(paramInt + 4)] = (-paramFloat3 * f3);
    paramArrayOfFloat[(paramInt + 8)] = f1;
    paramArrayOfFloat[(paramInt + 12)] = 0.0F;
    paramArrayOfFloat[(paramInt + 1)] = (f5 * f2 + paramFloat1 * f3);
    paramArrayOfFloat[(paramInt + 5)] = (-f5 * f3 + paramFloat1 * f2);
    paramArrayOfFloat[(paramInt + 9)] = (-paramFloat2 * paramFloat3);
    paramArrayOfFloat[(paramInt + 13)] = 0.0F;
    paramArrayOfFloat[(paramInt + 2)] = (-f4 * f2 + paramFloat2 * f3);
    paramArrayOfFloat[(paramInt + 6)] = (paramFloat2 * f2 + f3 * f4);
    paramArrayOfFloat[(paramInt + 10)] = (paramFloat1 * paramFloat3);
    paramArrayOfFloat[(paramInt + 14)] = 0.0F;
    paramArrayOfFloat[(paramInt + 3)] = 0.0F;
    paramArrayOfFloat[(paramInt + 7)] = 0.0F;
    paramArrayOfFloat[(paramInt + 11)] = 0.0F;
    paramArrayOfFloat[(paramInt + 15)] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.MatrixUtil
 * JD-Core Version:    0.7.0.1
 */