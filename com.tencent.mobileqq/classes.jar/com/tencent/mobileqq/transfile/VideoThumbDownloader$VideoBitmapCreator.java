package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class VideoThumbDownloader$VideoBitmapCreator
  implements BitmapDecoder
{
  VideoThumbDownloader$VideoBitmapCreator(VideoThumbDownloader paramVideoThumbDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    String str = paramURL.getPath();
    try
    {
      Bitmap localBitmap = VideoThumbDownloader.access$000(this.this$0, str);
      paramURL = localBitmap;
      if (localBitmap == null) {
        paramURL = VideoThumbDownloader.access$100(this.this$0, str);
      }
      return paramURL;
    }
    catch (Throwable paramURL)
    {
      QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoThumbDownloader.VideoBitmapCreator
 * JD-Core Version:    0.7.0.1
 */