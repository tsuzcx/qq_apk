package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;

public class Program
{
  private static final String TAG = "Program";
  
  public static void checkEglError(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": EGL error: 0x");
      localStringBuilder2.append(Integer.toHexString(j));
      Log.e("Program", localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": EGL error: 0x");
      localStringBuilder2.append(Integer.toHexString(j));
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("EGL error encountered (see log): ");
      paramString.append(localStringBuilder1.toString());
      new RuntimeException(paramString.toString()).printStackTrace();
    }
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    try
    {
      int i = createProgram(paramString1, paramString2, null);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int createProgram(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    try
    {
      GLES20.glEnable(3042);
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(770, 771, 1, 771);
      int i = loadShader(35633, paramString1);
      if (i == 0) {
        return 0;
      }
      int k = loadShader(35632, paramString2);
      if (k == 0) {
        return 0;
      }
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2))
      {
        paramArrayOfInt[0] = i;
        paramArrayOfInt[1] = k;
      }
      int j = GLES20.glCreateProgram();
      checkEglError("glCreateProgram");
      if (j == 0) {
        Log.e("Program", "Could not create program");
      }
      GLES20.glAttachShader(j, i);
      checkEglError("glAttachShader");
      GLES20.glAttachShader(j, k);
      checkEglError("glAttachShader");
      GLES20.glLinkProgram(j);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(j, 35714, paramString1, 0);
      i = j;
      if (paramString1[0] != 1)
      {
        Log.e("Program", "Could not link program: ");
        Log.e("Program", GLES20.glGetProgramInfoLog(j));
        GLES20.glDeleteProgram(j);
        i = 0;
      }
      return i;
    }
    finally {}
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    try
    {
      int j = GLES20.glCreateShader(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("glCreateShader type=");
      localStringBuilder.append(paramInt);
      checkEglError(localStringBuilder.toString());
      GLES20.glShaderSource(j, paramString);
      GLES20.glCompileShader(j);
      paramString = new int[1];
      GLES20.glGetShaderiv(j, 35713, paramString, 0);
      int i = j;
      if (paramString[0] == 0)
      {
        paramString = new StringBuilder();
        paramString.append("Could not compile shader ");
        paramString.append(paramInt);
        paramString.append(":");
        Log.e("Program", paramString.toString());
        paramString = new StringBuilder();
        paramString.append(" ");
        paramString.append(GLES20.glGetShaderInfoLog(j));
        Log.e("Program", paramString.toString());
        GLES20.glDeleteShader(j);
        i = 0;
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.Program
 * JD-Core Version:    0.7.0.1
 */