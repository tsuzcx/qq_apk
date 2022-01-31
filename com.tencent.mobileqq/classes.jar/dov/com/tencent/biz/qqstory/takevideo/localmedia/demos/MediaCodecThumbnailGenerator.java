package dov.com.tencent.biz.qqstory.takevideo.localmedia.demos;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;

public class MediaCodecThumbnailGenerator
{
  public Handler a;
  public HandlerThread a;
  public MediaCodecThumbnailGenerator.CodecHandler a;
  
  public MediaCodecThumbnailGenerator()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MediaCodecThumbnailGenerator");
  }
  
  public static float a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getHeight() / 16;
    int i2 = paramBitmap.getWidth() / 9;
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      if (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        if (((n >> 16 & 0xFF) < 10) && ((n >> 8 & 0xFF) < 10) && ((n & 0xFF) < 10))
        {
          n = j + 1;
          j = i;
        }
        for (i = n;; i = n)
        {
          n = m + i2;
          m = i;
          i = j;
          j = m;
          m = n;
          break;
          n = j;
          j = i + 1;
        }
      }
      k += i1;
    }
    float f = j / (i + j);
    SLog.c("MediaCodecThumbnailGen", "whitePixelCount = " + i + " blackPixelCount = " + j);
    return f;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$CodecHandler = new MediaCodecThumbnailGenerator.CodecHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localLooper);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, Callbacks.Callback paramCallback1, Callbacks.Callback paramCallback2)
  {
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = new MediaCodecThumbnailGenerator.ThumbnailArgs();
    localThumbnailArgs.jdField_a_of_type_JavaLangString = paramString1;
    localThumbnailArgs.jdField_b_of_type_JavaLangString = paramString2;
    localThumbnailArgs.jdField_a_of_type_Boolean = paramBoolean1;
    localThumbnailArgs.jdField_a_of_type_Int = paramInt1;
    localThumbnailArgs.jdField_b_of_type_Int = paramInt2;
    localThumbnailArgs.c = paramInt3;
    localThumbnailArgs.d = paramInt4;
    localThumbnailArgs.jdField_b_of_type_Boolean = paramBoolean2;
    localThumbnailArgs.jdField_b_of_type_DovComTencentBizQqstoryTakevideoLocalmediaBaoutilsCommonCallbacks$Callback = paramCallback1;
    localThumbnailArgs.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaBaoutilsCommonCallbacks$Callback = paramCallback2;
    Message.obtain(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$CodecHandler, 1, localThumbnailArgs).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator
 * JD-Core Version:    0.7.0.1
 */