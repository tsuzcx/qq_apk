package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;

public class Program
{
  private static final String TAG = "Program";
  
  public static void checkEglError(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Log.e("Program", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      localStringBuilder.append(paramString + ": EGL error: 0x" + Integer.toHexString(j));
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString()).printStackTrace();
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
    int j = 0;
    try
    {
      GLES20.glEnable(3042);
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(770, 771, 1, 771);
      int k = loadShader(35633, paramString1);
      int i;
      if (k == 0) {
        i = j;
      }
      for (;;)
      {
        return i;
        int m = loadShader(35632, paramString2);
        i = j;
        if (m != 0)
        {
          if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2))
          {
            paramArrayOfInt[0] = k;
            paramArrayOfInt[1] = m;
          }
          i = GLES20.glCreateProgram();
          checkEglError("glCreateProgram");
          if (i == 0) {
            Log.e("Program", "Could not create program");
          }
          GLES20.glAttachShader(i, k);
          checkEglError("glAttachShader");
          GLES20.glAttachShader(i, m);
          checkEglError("glAttachShader");
          GLES20.glLinkProgram(i);
          paramString1 = new int[1];
          GLES20.glGetProgramiv(i, 35714, paramString1, 0);
          if (paramString1[0] != 1)
          {
            Log.e("Program", "Could not link program: ");
            Log.e("Program", GLES20.glGetProgramInfoLog(i));
            GLES20.glDeleteProgram(i);
            i = j;
          }
        }
      }
    }
    finally {}
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        j = GLES20.glCreateShader(paramInt);
        checkEglError("glCreateShader type=" + paramInt);
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        if (paramString[0] == 0)
        {
          Log.e("Program", "Could not compile shader " + paramInt + ":");
          Log.e("Program", " " + GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          paramInt = i;
          return paramInt;
        }
      }
      finally {}
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.Program
 * JD-Core Version:    0.7.0.1
 */