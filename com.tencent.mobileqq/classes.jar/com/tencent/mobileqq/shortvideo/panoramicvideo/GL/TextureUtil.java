package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.opengl.GLES20;

public class TextureUtil
{
  public static final int NO_TEXTURE = 0;
  private static final String TAG = "TextureUtils";
  
  public static void bindTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0)
    {
      GLES20.glActiveTexture(paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil
 * JD-Core Version:    0.7.0.1
 */