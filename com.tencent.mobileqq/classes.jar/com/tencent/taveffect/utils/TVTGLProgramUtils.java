package com.tencent.taveffect.utils;

import android.opengl.GLES20;
import android.util.Log;

public class TVTGLProgramUtils
{
  private static final String TAG = "TVTGLProgramUtils";
  
  public static int createProgram(String paramString1, String paramString2)
  {
    GLES20.glEnable(3042);
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(770, 771, 1, 771);
    int i = loadShader(35633, paramString1);
    if (i != 0)
    {
      int j = loadShader(35632, paramString2);
      if (j != 0)
      {
        int k = GLES20.glCreateProgram();
        TAVGLUtils.checkEglError("glCreateProgram");
        GLES20.glAttachShader(k, i);
        TAVGLUtils.checkEglError("glAttachShader");
        GLES20.glAttachShader(k, j);
        TAVGLUtils.checkEglError("glAttachShader");
        GLES20.glLinkProgram(k);
        paramString1 = new int[1];
        GLES20.glGetProgramiv(k, 35714, paramString1, 0);
        if (paramString1[0] != 0)
        {
          GLES20.glDeleteShader(i);
          GLES20.glDeleteShader(j);
          return k;
        }
        GLES20.glDeleteProgram(k);
        Log.e("TVTGLProgramUtils", GLES20.glGetProgramInfoLog(k));
      }
    }
    return 0;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    TAVGLUtils.checkEglError(localStringBuilder.toString());
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
      Log.e("TVTGLProgramUtils", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(j));
      Log.e("TVTGLProgramUtils", paramString.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.utils.TVTGLProgramUtils
 * JD-Core Version:    0.7.0.1
 */