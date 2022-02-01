package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class SquareRoundImageUtils$1
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    if ((paramDownloadParams != null) && (paramDownloadParams.reqWidth >= 0) && (paramDownloadParams.reqHeight >= 0)) {
      return SquareRoundImageUtils.a(paramBitmap, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
    }
    return SquareRoundImageUtils.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SquareRoundImageUtils.1
 * JD-Core Version:    0.7.0.1
 */