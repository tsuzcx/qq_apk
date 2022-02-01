package com.tencent.util;

import android.opengl.GLES20;

public class ShaderUtil
{
  public static int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    paramInt = i;
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      paramInt = i;
      if (paramString[0] == 0)
      {
        GLES20.glDeleteShader(i);
        paramInt = 0;
      }
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = a(35632, paramString2);
    if (j == 0) {
      return 0;
    }
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
    if (i == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(i);
    throw new RuntimeException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.ShaderUtil
 * JD-Core Version:    0.7.0.1
 */