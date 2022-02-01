package com.tencent.mobileqq.onlinestatus.utils;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.BaseImageUtil;

final class URLDrawableHelper$1
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = paramDownloadParams.tag;
    Bitmap localBitmap = paramBitmap;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      localBitmap = paramBitmap;
      if (localObject.length == 3)
      {
        int j = localObject[0];
        int i = j;
        if (j == 0) {
          if (paramDownloadParams.reqWidth == 0) {
            i = paramBitmap.getWidth();
          } else {
            i = paramDownloadParams.reqWidth;
          }
        }
        int k = localObject[1];
        j = k;
        if (k == 0) {
          if (paramDownloadParams.reqHeight == 0) {
            j = paramBitmap.getHeight();
          } else {
            j = paramDownloadParams.reqHeight;
          }
        }
        localBitmap = BaseImageUtil.d(paramBitmap, localObject[2], i, j);
      }
    }
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.URLDrawableHelper.1
 * JD-Core Version:    0.7.0.1
 */