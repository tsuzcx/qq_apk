package com.tencent.mobileqq.videocodec.mediacodec.util;

import android.graphics.Bitmap.CompressFormat;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class ThumbnailUtil
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".thumb.png");
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, EncodeConfig paramEncodeConfig, ThumbnailUtil.ThumbnailCallback paramThumbnailCallback)
  {
    int i = paramInt2 * paramInt3;
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    Object localObject1 = IntBuffer.wrap(arrayOfInt1);
    ((IntBuffer)localObject1).position(0);
    if (paramInt1 != 0)
    {
      localObject2 = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject2, 0);
      GLES20.glBindFramebuffer(36160, localObject2[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject2, 0);
      localObject2[0] = 0;
    }
    else
    {
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
    }
    Object localObject2 = paramEncodeConfig.v;
    if (localObject2 != null)
    {
      paramEncodeConfig = ((ThumbnailUtil.ThumbConfig)localObject2).c;
      localObject1 = ((ThumbnailUtil.ThumbConfig)localObject2).a;
      paramInt1 = ((ThumbnailUtil.ThumbConfig)localObject2).b;
    }
    else
    {
      paramEncodeConfig = a(paramEncodeConfig.b);
      localObject1 = Bitmap.CompressFormat.PNG;
      paramInt1 = 100;
    }
    ThreadManager.executeOnFileThread(new ThumbnailUtil.1(paramInt3, paramInt2, arrayOfInt1, arrayOfInt2, paramEncodeConfig, (Bitmap.CompressFormat)localObject1, paramInt1, paramThumbnailCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil
 * JD-Core Version:    0.7.0.1
 */