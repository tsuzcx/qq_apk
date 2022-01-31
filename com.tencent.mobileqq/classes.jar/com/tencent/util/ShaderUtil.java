package com.tencent.util;

import android.opengl.GLES20;

public class ShaderUtil
{
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      paramString = new int[1];
      GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        GLES20.glDeleteShader(paramInt);
        return 0;
      }
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = a(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      a("glAttachShader");
      GLES20.glAttachShader(k, j);
      a("glAttachShader");
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        GLES20.glDeleteProgram(k);
        return 0;
      }
    }
    return k;
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.util.ShaderUtil
 * JD-Core Version:    0.7.0.1
 */