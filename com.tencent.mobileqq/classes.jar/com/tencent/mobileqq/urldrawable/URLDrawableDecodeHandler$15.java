package com.tencent.mobileqq.urldrawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class URLDrawableDecodeHandler$15
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramDownloadParams == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "FLASH_PIC_MOSAIC_DECODE, bitmap is null");
      }
      return null;
    }
    float f1 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    int j = (int)(paramDownloadParams.reqWidth / f1 + 0.5F);
    int i = (int)(paramDownloadParams.reqHeight / f1 + 0.5F);
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    if ("chatthumb".equals(paramDownloadParams.url.getProtocol()))
    {
      j = 130;
      i = 102;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "downloadParams.reqWidth:" + paramDownloadParams.reqWidth + ",downloadParams.reqHeight:" + paramDownloadParams.reqHeight + ",reqWidth:" + j + ",reqHeight:" + i + ",isMutable:" + paramBitmap.isMutable());
    }
    f1 = j / k;
    float f2 = i / m;
    paramDownloadParams = new Matrix();
    paramDownloadParams.postScale(f1, f2);
    paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, paramDownloadParams, false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "scaleW:" + f1 + "scaleH:" + f2 + ",resizeBmp w:" + paramDownloadParams.getWidth() + ",h:" + paramDownloadParams.getHeight());
    }
    j = paramDownloadParams.getWidth() / 8;
    i = j;
    if (j == 0) {
      i = 16;
    }
    paramDownloadParams = URLDrawableDecodeHandler.a(paramDownloadParams, i);
    paramBitmap.recycle();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.15
 * JD-Core Version:    0.7.0.1
 */