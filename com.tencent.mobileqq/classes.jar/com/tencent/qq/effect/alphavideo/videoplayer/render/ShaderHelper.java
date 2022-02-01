package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.opengl.GLES20;
import com.tencent.qq.effect.utils.LogUtil;

public class ShaderHelper
{
  private static final String TAG = "VideoPlayer|ShaderHelper";
  
  public static int compileShader(int paramInt, String paramString)
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
        paramString = new StringBuilder();
        paramString.append("Error compiling shader: ");
        paramString.append(GLES20.glGetShaderInfoLog(i));
        LogUtil.e("VideoPlayer|ShaderHelper", paramString.toString());
        GLES20.glDeleteShader(i);
        paramInt = 0;
      }
    }
    if (paramInt == 0) {
      LogUtil.e("VideoPlayer|ShaderHelper", "Error creating shader.");
    }
    return paramInt;
  }
  
  public static int createAndLinkProgram(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    int j = GLES20.glCreateProgram();
    int i = j;
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
      i = j;
      if (paramArrayOfString[0] == 0)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Error compiling program: ");
        paramArrayOfString.append(GLES20.glGetProgramInfoLog(j));
        LogUtil.e("VideoPlayer|ShaderHelper", paramArrayOfString.toString());
        GLES20.glDeleteProgram(j);
        i = 0;
      }
    }
    if (i != 0) {
      return i;
    }
    paramArrayOfString = new RuntimeException("Error creating program.");
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.render.ShaderHelper
 * JD-Core Version:    0.7.0.1
 */