package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.ttpic.util.VideoBitmapUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final float[] IDENTITY_MATRIX;
  public static final int NO_TEXTURE = -1;
  private static final int SIZEOF_FLOAT = 4;
  public static final String TAG = GlUtil.class.getSimpleName();
  
  static
  {
    IDENTITY_MATRIX = new float[16];
    Matrix.setIdentityM(IDENTITY_MATRIX, 0);
  }
  
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
    int i = GLES20.glGetError();
    if (i != 0)
    {
      paramString = paramString + ": glError 0x" + Integer.toHexString(i);
      Log.e(TAG, paramString);
    }
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createImageTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    checkGlError("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
    return i;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      int k = loadShader(35632, paramString2);
      if (k == 0) {
        return 0;
      }
      j = GLES20.glCreateProgram();
      checkGlError("glCreateProgram");
      if (j == 0) {
        Log.e(TAG, "Could not create program");
      }
      GLES20.glAttachShader(j, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(j, k);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(j);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(j, 35714, paramString1, 0);
      i = j;
    } while (paramString1[0] == 1);
    Log.e(TAG, "Could not link program: ");
    Log.e(TAG, GLES20.glGetProgramInfoLog(j));
    GLES20.glDeleteProgram(j);
    return 0;
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
  
  private static int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      Log.e(TAG, "Could not compile shader " + paramInt + ":");
      Log.e(TAG, " " + GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public static void loadTexture(int paramInt, Bitmap paramBitmap)
  {
    if (VideoBitmapUtil.isLegal(paramBitmap))
    {
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
  }
  
  public static void logVersionInfo()
  {
    Log.i(TAG, "vendor  : " + GLES20.glGetString(7936));
    Log.i(TAG, "renderer: " + GLES20.glGetString(7937));
    Log.i(TAG, "version : " + GLES20.glGetString(7938));
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt4);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, paramArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.GlUtil
 * JD-Core Version:    0.7.0.1
 */