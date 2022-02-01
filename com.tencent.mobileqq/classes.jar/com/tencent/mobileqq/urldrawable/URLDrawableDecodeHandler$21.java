package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;

final class URLDrawableDecodeHandler$21
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    try
    {
      int i = paramBitmap.getHeight();
      int j = paramBitmap.getWidth();
      int k = paramDownloadParams.reqWidth;
      int m = paramDownloadParams.reqHeight;
      float f1 = k * 1.0F / j;
      paramDownloadParams = new Matrix();
      paramDownloadParams.setScale(f1, f1);
      float f2 = i;
      float f3 = m;
      if (f2 * f1 > f3) {
        paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, (int)(f3 / f1), paramDownloadParams, true);
      } else {
        paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, i, paramDownloadParams, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(URLDrawableDecodeHandler.a(), 2, String.format("ALIGN_TOP_DECODER srcHeight = %s, srcWidth = %s, reqWidth = %s, reqHeight = %s, scale = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1) }));
      }
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.21
 * JD-Core Version:    0.7.0.1
 */