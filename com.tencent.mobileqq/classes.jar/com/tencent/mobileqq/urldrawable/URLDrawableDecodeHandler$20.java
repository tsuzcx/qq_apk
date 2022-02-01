package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

final class URLDrawableDecodeHandler$20
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (localBitmap == null) {
      return null;
    }
    Object localObject = paramDownloadParams.tag;
    paramDownloadParams = localBitmap;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      paramDownloadParams = localBitmap;
      if (localObject.length == 6)
      {
        int i1 = localObject[0];
        int i2 = localObject[1];
        int j = localObject[2];
        int k = localObject[3];
        int m = localObject[4];
        int n = localObject[5];
        int i3 = paramBitmap.getHeight();
        int i4 = paramBitmap.getWidth();
        boolean bool;
        if ((i1 >= 0) && (i2 >= 0) && (j > 0) && (k > 0) && (i1 < i4) && (i2 < i3)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel()) {
          QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER [%d,%d,%d,%d,%d,%d] valid=%b", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(bool) }));
        }
        int i;
        if ((!bool) && (m > 0) && (n > 0))
        {
          float f1 = m / n;
          float f2 = paramBitmap.getWidth() / paramBitmap.getHeight();
          localObject = new Rect();
          if (f1 > f2)
          {
            i = paramBitmap.getWidth();
            j = (int)(i / f1);
            ((Rect)localObject).set(0, (int)((paramBitmap.getHeight() - j) * 0.5F), i, (int)((paramBitmap.getHeight() - j) * 0.5F + j));
          }
          else
          {
            i = paramBitmap.getHeight();
            j = (int)(i * f1);
            ((Rect)localObject).set((int)((paramBitmap.getWidth() - j) * 0.5F), 0, (int)((paramBitmap.getWidth() - j) * 0.5F + j), i);
          }
          paramBitmap = ImageUtil.a(localBitmap, (Rect)localObject, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getInSampleSize(m, n, ((Rect)localObject).width(), ((Rect)localObject).height()));
          paramDownloadParams = paramBitmap;
          if (QLog.isColorLevel())
          {
            QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER centerCrop %s", new Object[] { ((Rect)localObject).toShortString() }));
            return paramBitmap;
          }
        }
        else
        {
          paramDownloadParams = localBitmap;
          if (bool)
          {
            i = j;
            if (i1 + j > i4) {
              i = i4 - i1;
            }
            j = k;
            if (i2 + k > i3) {
              j = i3 - i2;
            }
            paramDownloadParams = new Rect(i1, i2, i + i1, j + i2);
            if ((m > 0) && (n > 0)) {
              i = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getInSampleSize(m, n, paramDownloadParams.width(), paramDownloadParams.height());
            } else {
              i = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER [w,h]=[%d,%d] dstClip=%s sample=%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramDownloadParams, Integer.valueOf(i) }));
            }
            paramDownloadParams = ImageUtil.a(localBitmap, paramDownloadParams, i);
          }
        }
      }
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.20
 * JD-Core Version:    0.7.0.1
 */