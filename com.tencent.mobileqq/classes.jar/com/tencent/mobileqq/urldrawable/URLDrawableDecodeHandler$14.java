package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;

final class URLDrawableDecodeHandler$14
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
      if (localObject.length == 2)
      {
        float f2 = DeviceInfoUtil.a();
        float f1 = f2;
        if (f2 < 0.01F) {
          f1 = 1.0F;
        }
        localObject[0] = ((int)(localObject[0] / f1));
        localObject[1] = ((int)(localObject[1] / f1));
        paramDownloadParams = ImageUtil.a(paramBitmap, localObject[0], localObject[1]);
      }
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.14
 * JD-Core Version:    0.7.0.1
 */