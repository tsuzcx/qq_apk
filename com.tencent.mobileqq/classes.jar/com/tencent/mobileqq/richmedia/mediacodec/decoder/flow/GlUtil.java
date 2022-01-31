package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;

public class GlUtil
{
  public static int a(int paramInt)
  {
    return a(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt, Bitmap paramBitmap)
  {
    return a(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt1, @Nullable Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    a("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    a("glBindTexture " + arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    a("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public static void a(int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GLES20.glBindTexture(paramInt2, paramInt1);
    a("glBindTexture " + paramInt1);
    GLES20.glTexParameterf(paramInt2, 10241, paramInt3);
    GLES20.glTexParameterf(paramInt2, 10240, paramInt4);
    GLES20.glTexParameteri(paramInt2, 10242, paramInt5);
    GLES20.glTexParameteri(paramInt2, 10243, paramInt6);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    a("glTexParameter");
  }
  
  public static void a(int paramInt, @Nullable Bitmap paramBitmap)
  {
    a(paramInt, 3553, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      SLog.e("FlowEdit_GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    GLES20.glGenTextures(paramInt, arrayOfInt, 0);
    a("glGenTextures");
    return arrayOfInt;
  }
  
  public static void b(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    a("glDeleteTextures");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.GlUtil
 * JD-Core Version:    0.7.0.1
 */