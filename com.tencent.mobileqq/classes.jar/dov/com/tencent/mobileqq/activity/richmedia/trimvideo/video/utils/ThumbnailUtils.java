package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.maxvideo.trim.TrimNative;

public class ThumbnailUtils
{
  private static int a;
  private static int b;
  
  public static Bitmap a(long paramLong1, long paramLong2)
  {
    if ((a <= 0) || (b <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
      if (TrimNative.getThumbnail(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils
 * JD-Core Version:    0.7.0.1
 */