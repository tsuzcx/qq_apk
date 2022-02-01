package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import dov.com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import dov.com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;

public class GifProcessor
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  
  public static int a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    int i = 0;
    QLog.i("GifProcessor", 1, "generateGifFromVFile vfPath=" + paramString1 + " output=" + paramString3);
    a();
    GifCoder localGifCoder = new GifCoder();
    localGifCoder.setEncoderDither(true);
    localGifCoder.setEncoderGifSize(a);
    boolean bool;
    int k;
    int j;
    VideoSourceHelper localVideoSourceHelper;
    Bitmap localBitmap;
    if (b == 1)
    {
      bool = true;
      localGifCoder.setEncoderGifPicSizeForLongEdge(bool);
      k = CodecParam.mRecordFrames * 1000 / CodecParam.mRecordTime / c;
      j = k;
      if (k <= 0) {
        j = 1;
      }
      localVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
      localVideoSourceHelper.initHelperParam();
      paramString1 = localVideoSourceHelper.getSourceVideoParam();
      localBitmap = Bitmap.createBitmap(paramString1[0], paramString1[1], Bitmap.Config.RGB_565);
      k = 0;
    }
    for (;;)
    {
      if (k < CodecParam.mRecordFrames)
      {
        i = localVideoSourceHelper.getVideoFrameByIndex(localBitmap, k);
        if (QLog.isColorLevel()) {
          QLog.d("GifProcessor", 2, "getVideoFrameByIndex from vffile. index=" + k + " ret=" + i);
        }
        if (i == 0) {
          break label229;
        }
      }
      for (;;)
      {
        localGifCoder.closeEncoder();
        return i;
        bool = false;
        break;
        label229:
        paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
        paramString1 = paramString2;
        if (paramInt != 0)
        {
          paramString1 = paramString2;
          if (!CameraFilterGLView.a(paramInt)) {
            paramString1 = RecordThumbnailUtils.a(paramString2, paramInt);
          }
        }
        if (localGifCoder.encodeGif(paramString1, paramString3, d, true)) {
          break label280;
        }
        i = -1;
      }
      label280:
      k += j;
    }
  }
  
  private static void a()
  {
    a = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSize", 720);
    b = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSizeForLongEdge", 0);
    c = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFps", 5);
    d = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifTimePerFrame", 200);
    e = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifMaxFrame", 10);
    f = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFirstNSecond", 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor
 * JD-Core Version:    0.7.0.1
 */