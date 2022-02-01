package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

final class URLDrawableDecodeHandler$6
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = paramDownloadParams.tag;
    paramDownloadParams = paramBitmap;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      paramDownloadParams = paramBitmap;
      if (localObject.length == 3)
      {
        if (localObject[0] == 0) {
          localObject[0] = paramBitmap.getWidth();
        }
        if (localObject[1] == 0) {
          localObject[1] = paramBitmap.getHeight();
        }
        paramDownloadParams = ImageUtil.d(paramBitmap, localObject[2], localObject[0], localObject[1]);
      }
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.6
 * JD-Core Version:    0.7.0.1
 */