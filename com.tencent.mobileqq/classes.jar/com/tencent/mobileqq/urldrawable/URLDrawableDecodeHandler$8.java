package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

final class URLDrawableDecodeHandler$8
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = paramDownloadParams.tag;
        localObject1 = paramBitmap;
      } while (!(localObject2 instanceof int[]));
      localObject1 = paramBitmap;
    } while (((int[])localObject2).length != 3);
    Object localObject1 = (int[])localObject2;
    int j = localObject1[0];
    int i = j;
    if (j == 0)
    {
      if (paramDownloadParams.reqWidth == 0) {
        i = paramBitmap.getWidth();
      }
    }
    else
    {
      int k = localObject1[1];
      j = k;
      if (k == 0) {
        if (paramDownloadParams.reqHeight != 0) {
          break label128;
        }
      }
    }
    label128:
    for (j = paramBitmap.getHeight();; j = paramDownloadParams.reqHeight)
    {
      return ImageUtil.d(paramBitmap, localObject1[2], i, j);
      i = paramDownloadParams.reqWidth;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.8
 * JD-Core Version:    0.7.0.1
 */