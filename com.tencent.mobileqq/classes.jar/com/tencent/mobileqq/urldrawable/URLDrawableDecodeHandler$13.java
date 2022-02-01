package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.gdtad.util.GdtSmartBlur;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class URLDrawableDecodeHandler$13
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramDownloadParams = paramDownloadParams.tag;
      if ((GdtSmartBlur.a().a) && ((paramDownloadParams instanceof int[])))
      {
        paramDownloadParams = (int[])paramDownloadParams;
        if (paramDownloadParams.length == 1)
        {
          int i = paramDownloadParams[0];
          GdtSmartBlur.a().a(paramBitmap, i);
        }
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.13
 * JD-Core Version:    0.7.0.1
 */