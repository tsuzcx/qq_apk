package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.opengl.GLES20;
import com.tencent.qq.effect.utils.LogUtil;

public class ShaderHelper
{
  private static final String TAG = "VideoPlayer|ShaderHelper";
  
  public static int compileShader(int paramInt, String paramString)
  {
    int i = 0;
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      paramString = new int[1];
      GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        LogUtil.e("VideoPlayer|ShaderHelper", "Error compiling shader: " + GLES20.glGetShaderInfoLog(paramInt));
        GLES20.glDeleteShader(paramInt);
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        LogUtil.e("VideoPlayer|ShaderHelper", "Error creating shader.");
      }
      return paramInt;
    }
  }
  
  public static int createAndLinkProgram(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    int i = 0;
    int j = GLES20.glCreateProgram();
    if (j != 0)
    {
      GLES20.glAttachShader(j, paramInt1);
      GLES20.glAttachShader(j, paramInt2);
      if (paramArrayOfString != null)
      {
        paramInt2 = paramArrayOfString.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          GLES20.glBindAttribLocation(j, paramInt1, paramArrayOfString[paramInt1]);
          paramInt1 += 1;
        }
      }
      GLES20.glLinkProgram(j);
      paramArrayOfString = new int[1];
      GLES20.glGetProgramiv(j, 35714, paramArrayOfString, 0);
      if (paramArrayOfString[0] == 0)
      {
        LogUtil.e("VideoPlayer|ShaderHelper", "Error compiling program: " + GLES20.glGetProgramInfoLog(j));
        GLES20.glDeleteProgram(j);
      }
    }
    for (paramInt1 = i;; paramInt1 = j)
    {
      if (paramInt1 == 0) {
        throw new RuntimeException("Error creating program.");
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.render.ShaderHelper
 * JD-Core Version:    0.7.0.1
 */