package com.tencent.ttpic.gles;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.GLES30;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProgramTools
{
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateShader(35633);
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glShaderSource(j, paramString2);
    paramString1 = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, paramString1, 0);
    if (paramString1[0] == 0)
    {
      GLES20.glDeleteShader(i);
      throw new RuntimeException("vertext shader compile,failed:" + GLES20.glGetShaderInfoLog(i));
    }
    GLES20.glCompileShader(j);
    GLES20.glGetShaderiv(j, 35713, paramString1, 0);
    if (paramString1[0] == 0)
    {
      GLES20.glDeleteShader(j);
      throw new RuntimeException("fragment shader compile,failed:" + GLES20.glGetShaderInfoLog(j));
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] == 0)
    {
      GLES20.glDeleteProgram(k);
      throw new RuntimeException("link program,failed:" + GLES20.glGetProgramInfoLog(k));
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  public static void createTexture(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, null);
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES30.glCreateShader(paramInt);
    GLES30.glShaderSource(paramInt, paramString);
    GLES30.glCompileShader(paramInt);
    return paramInt;
  }
  
  public static void mallocTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
  }
  
  private static String readTextFile(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().openRawResource(paramInt);
    localBufferedReader = new BufferedReader(new InputStreamReader(paramContext));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      try
      {
        paramContext.close();
        localBufferedReader.close();
        throw localObject;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      for (;;)
      {
        try
        {
          paramContext.close();
          localBufferedReader.close();
          return null;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        try
        {
          paramContext.close();
          localBufferedReader.close();
          return localException.toString();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.ProgramTools
 * JD-Core Version:    0.7.0.1
 */