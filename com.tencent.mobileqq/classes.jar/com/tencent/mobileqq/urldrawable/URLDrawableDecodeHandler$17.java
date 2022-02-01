package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class URLDrawableDecodeHandler$17
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
      if (paramDownloadParams.length > 0)
      {
        i = paramDownloadParams[0];
        break label40;
      }
    }
    int i = 0;
    label40:
    if (i != 0)
    {
      paramDownloadParams = new Matrix();
      paramDownloadParams.postRotate(i);
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      boolean bool;
      if (i % 90 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, paramDownloadParams, bool);
    }
    else
    {
      paramDownloadParams = paramBitmap;
    }
    if (paramDownloadParams != paramBitmap) {
      paramBitmap.recycle();
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.17
 * JD-Core Version:    0.7.0.1
 */