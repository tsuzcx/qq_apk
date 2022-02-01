package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;

public class GlUtils
{
  public static int a(int paramInt, Bitmap paramBitmap)
  {
    return a(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt1, @Nullable Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GlUtil.a("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glBindTexture ");
    localStringBuilder.append(arrayOfInt[0]);
    GlUtil.a(localStringBuilder.toString());
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    GlUtil.a("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static void a(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    GlUtil.a("glDeleteTextures");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.GlUtils
 * JD-Core Version:    0.7.0.1
 */