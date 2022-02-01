package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.graphics.Bitmap.CompressFormat;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class ThumbnailUtil
{
  public static String a(String paramString)
  {
    return paramString + ".thumb.png";
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, EncodeConfig paramEncodeConfig, ThumbnailUtil.ThumbnailCallback paramThumbnailCallback)
  {
    int[] arrayOfInt1 = new int[paramInt2 * paramInt3];
    int[] arrayOfInt2 = new int[paramInt2 * paramInt3];
    Object localObject1 = IntBuffer.wrap(arrayOfInt1);
    ((IntBuffer)localObject1).position(0);
    Object localObject2;
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
      localObject2 = paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecUtilsThumbnailUtil$ThumbConfig;
      if (localObject2 == null) {
        break label169;
      }
      paramEncodeConfig = ((ThumbnailUtil.ThumbConfig)localObject2).jdField_a_of_type_JavaLangString;
      localObject1 = ((ThumbnailUtil.ThumbConfig)localObject2).jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat;
    }
    for (paramInt1 = ((ThumbnailUtil.ThumbConfig)localObject2).jdField_a_of_type_Int;; paramInt1 = 100)
    {
      ThreadManager.executeOnFileThread(new ThumbnailUtil.1(paramInt3, paramInt2, arrayOfInt1, arrayOfInt2, paramEncodeConfig, (Bitmap.CompressFormat)localObject1, paramInt1, paramThumbnailCallback));
      return;
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
      break;
      label169:
      paramEncodeConfig = a(paramEncodeConfig.jdField_a_of_type_JavaLangString);
      localObject1 = Bitmap.CompressFormat.PNG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil
 * JD-Core Version:    0.7.0.1
 */