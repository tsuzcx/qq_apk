package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.StackBlur;

public class URLDrawableDecodeHandler$ReadInJoyVideoFeedsFastBlurDecoder
  implements DownloadParams.DecodeHandler
{
  private final int a = 10;
  private final int b = 20;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    try
    {
      paramDownloadParams = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 20, paramBitmap.getHeight() / 20, true);
      StackBlur.a(paramDownloadParams, 10);
      return paramDownloadParams;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      return paramBitmap;
    }
    catch (Exception paramDownloadParams) {}
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.ReadInJoyVideoFeedsFastBlurDecoder
 * JD-Core Version:    0.7.0.1
 */