package com.tencent.vbox.encode.hard;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final int NO_TEXTURE = -1;
  private static final String TAG = "GlUtil";
  
  @TargetApi(18)
  public static void checkEglError(String paramString)
  {
    for (;;)
    {
      int i = EGL14.eglGetError();
      if (i == 12288) {
        break;
      }
      Log.e("GlUtil", paramString + ": eglGetError: 0x" + Integer.toHexString(i));
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
      Log.e("GlUtil", paramString + ": glGetError: 0x" + Integer.toHexString(i));
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
    int j = loadShader(35632, paramString2);
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("GlUtil", "Could not link program:");
      Log.e("GlUtil", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
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
    int i = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("GlUtil", "Could not compile shader(TYPE=" + paramInt + "):");
      Log.e("GlUtil", GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  public static void saveYourTextureToRgbBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLSLRender.nativeToRGBData(paramArrayOfByte, paramInt2, paramInt3);
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.encode.hard.GlUtil
 * JD-Core Version:    0.7.0.1
 */