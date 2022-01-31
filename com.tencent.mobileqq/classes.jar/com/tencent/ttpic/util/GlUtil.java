package com.tencent.ttpic.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  private static final String TAG = GlUtil.class.getSimpleName();
  
  @TargetApi(18)
  public static void checkEglError(String paramString)
  {
    for (;;)
    {
      int i = EGL14.eglGetError();
      if (i == 12288) {
        break;
      }
      Log.e(TAG, paramString + ": eglGetError: 0x" + Integer.toHexString(i));
    }
  }
  
  public static void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      Log.e(TAG, paramString + ": glGetError: 0x" + Integer.toHexString(i));
    }
  }
  
  public static float[] createIdentityMtx()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    int k = loadShader(35632, paramString2);
    int j = GLES20.glCreateProgram();
    GLES20.glAttachShader(j, i);
    GLES20.glAttachShader(j, k);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    i = j;
    if (paramString1[0] != 1)
    {
      Log.e(TAG, "Could not link program:");
      Log.e(TAG, GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      i = 0;
    }
    return i;
  }
  
  public static FloatBuffer createSquareVtx()
  {
    float[] arrayOfFloat = new float[20];
    arrayOfFloat[0] = -1.0F;
    arrayOfFloat[1] = 1.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = -1.0F;
    arrayOfFloat[6] = -1.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 1.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 1.0F;
    arrayOfFloat[14] = 1.0F;
    arrayOfFloat[15] = 1.0F;
    arrayOfFloat[16] = -1.0F;
    arrayOfFloat[17] = 0.0F;
    arrayOfFloat[18] = 1.0F;
    arrayOfFloat[19] = 0.0F;
    arrayOfFloat;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      Log.e(TAG, "Could not compile shader(TYPE=" + paramInt + "):");
      Log.e(TAG, GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.GlUtil
 * JD-Core Version:    0.7.0.1
 */