package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

final class URLDrawableDecodeHandler$16
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if ((paramDownloadParams instanceof int[]))
    {
      paramDownloadParams = (int[])paramDownloadParams;
      if (paramDownloadParams.length == 2) {
        return ImageUtil.d(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.16
 * JD-Core Version:    0.7.0.1
 */