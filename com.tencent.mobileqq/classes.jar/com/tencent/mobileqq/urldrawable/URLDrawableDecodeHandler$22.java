package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

final class URLDrawableDecodeHandler$22
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    if (paramBitmap == null) {
      return null;
    }
    Object localObject2 = paramDownloadParams.tag;
    paramDownloadParams = localObject1;
    if ((localObject2 instanceof int[]))
    {
      localObject2 = (int[])localObject2;
      paramDownloadParams = localObject1;
      if (localObject2.length == 1)
      {
        int i = localObject2[0];
        paramDownloadParams = ImageUtil.a(paramBitmap, i, i, i);
      }
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.22
 * JD-Core Version:    0.7.0.1
 */