package com.tencent.mobileqq.richmedia.mediacodec.utils;

import ahas;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.ThreadManager;
import java.nio.IntBuffer;

public class ThumbnailUtil
{
  public static String a(String paramString)
  {
    return paramString + ".thumb.png";
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ThumbnailUtil.ThumbnailCallback paramThumbnailCallback)
  {
    int[] arrayOfInt1 = new int[paramInt2 * paramInt3];
    int[] arrayOfInt2 = new int[paramInt2 * paramInt3];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    if (paramInt1 != 0)
    {
      int[] arrayOfInt3 = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt3, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt3[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localIntBuffer);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt3, 0);
      arrayOfInt3[0] = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new ahas(paramInt3, paramInt2, arrayOfInt1, arrayOfInt2, paramString, paramThumbnailCallback));
      return;
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localIntBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil
 * JD-Core Version:    0.7.0.1
 */