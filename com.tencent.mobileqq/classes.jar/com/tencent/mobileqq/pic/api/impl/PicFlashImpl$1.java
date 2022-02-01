package com.tencent.mobileqq.pic.api.impl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class PicFlashImpl$1
  implements DownloadParams.DecodeHandler
{
  PicFlashImpl$1(PicFlashImpl paramPicFlashImpl) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramDownloadParams != null))
    {
      float f1 = this.a.getDensity();
      int j = (int)(paramDownloadParams.reqWidth / f1 + 0.5F);
      int i = (int)(paramDownloadParams.reqHeight / f1 + 0.5F);
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      if ("chatthumb".equals(paramDownloadParams.url.getProtocol()))
      {
        j = 130;
        i = 102;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadParams.reqWidth:");
        localStringBuilder.append(paramDownloadParams.reqWidth);
        localStringBuilder.append(",downloadParams.reqHeight:");
        localStringBuilder.append(paramDownloadParams.reqHeight);
        localStringBuilder.append(",reqWidth:");
        localStringBuilder.append(j);
        localStringBuilder.append(",reqHeight:");
        localStringBuilder.append(i);
        localStringBuilder.append(",isMutable:");
        localStringBuilder.append(paramBitmap.isMutable());
        QLog.d("Q.hotchat", 2, localStringBuilder.toString());
      }
      f1 = j / k;
      float f2 = i / m;
      paramDownloadParams = new Matrix();
      paramDownloadParams.postScale(f1, f2);
      paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, paramDownloadParams, false);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scaleW:");
        localStringBuilder.append(f1);
        localStringBuilder.append("scaleH:");
        localStringBuilder.append(f2);
        localStringBuilder.append(",resizeBmp w:");
        localStringBuilder.append(paramDownloadParams.getWidth());
        localStringBuilder.append(",h:");
        localStringBuilder.append(paramDownloadParams.getHeight());
        QLog.d("Q.hotchat", 2, localStringBuilder.toString());
      }
      j = paramDownloadParams.getWidth() / 8;
      i = j;
      if (j == 0) {
        i = 16;
      }
      paramDownloadParams = this.a.getMosaicBitmap(paramDownloadParams, i);
      paramBitmap.recycle();
      return paramDownloadParams;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "FLASH_PIC_MOSAIC_DECODE, bitmap is null");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicFlashImpl.1
 * JD-Core Version:    0.7.0.1
 */