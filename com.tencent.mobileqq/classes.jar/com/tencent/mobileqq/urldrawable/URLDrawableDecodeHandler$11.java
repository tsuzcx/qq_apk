package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class URLDrawableDecodeHandler$11
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    int i;
    int j;
    int k;
    int m;
    if (paramBitmap != null)
    {
      if (paramDownloadParams == null) {
        return paramBitmap;
      }
      paramDownloadParams = paramDownloadParams.tag;
      if ((paramDownloadParams instanceof int[]))
      {
        paramDownloadParams = (int[])paramDownloadParams;
        if (paramDownloadParams.length == 4)
        {
          i = paramDownloadParams[0];
          j = paramDownloadParams[1];
          k = paramDownloadParams[2];
          m = paramDownloadParams[3];
          if (k > 0)
          {
            if (m <= 0) {
              return paramBitmap;
            }
            if ((k == paramBitmap.getWidth()) && (m == paramBitmap.getHeight())) {
              return paramBitmap;
            }
          }
        }
      }
    }
    try
    {
      paramDownloadParams = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramDownloadParams);
      Matrix localMatrix = new Matrix();
      URLDrawableDecodeHandler.a(localMatrix, paramBitmap.getWidth(), paramBitmap.getHeight(), k, m, i, j);
      localCanvas.drawBitmap(paramBitmap, localMatrix, new Paint(6));
      return paramDownloadParams;
    }
    catch (OutOfMemoryError paramDownloadParams) {}
    return paramBitmap;
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.11
 * JD-Core Version:    0.7.0.1
 */