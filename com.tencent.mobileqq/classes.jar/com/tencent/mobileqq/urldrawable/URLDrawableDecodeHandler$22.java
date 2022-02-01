package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

final class URLDrawableDecodeHandler$22
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    int n;
    int i1;
    int i;
    int j;
    int k;
    int m;
    int i2;
    int i3;
    boolean bool;
    label128:
    label380:
    do
    {
      Object localObject;
      do
      {
        do
        {
          return paramDownloadParams;
          localObject = paramDownloadParams.tag;
          paramDownloadParams = paramBitmap;
        } while (!(localObject instanceof int[]));
        paramDownloadParams = paramBitmap;
      } while (((int[])localObject).length != 6);
      paramDownloadParams = (int[])localObject;
      n = paramDownloadParams[0];
      i1 = paramDownloadParams[1];
      i = paramDownloadParams[2];
      j = paramDownloadParams[3];
      k = paramDownloadParams[4];
      m = paramDownloadParams[5];
      i2 = paramBitmap.getHeight();
      i3 = paramBitmap.getWidth();
      float f1;
      if ((n >= 0) && (i1 >= 0) && (i > 0) && (j > 0) && (n < i3) && (i1 < i2))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER [%d,%d,%d,%d,%d,%d] valid=%b", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) }));
        }
        if ((bool) || (k <= 0) || (m <= 0)) {
          break label439;
        }
        f1 = k / m;
        float f2 = paramBitmap.getWidth() / paramBitmap.getHeight();
        localObject = new Rect();
        if (f1 <= f2) {
          break label380;
        }
        i = paramBitmap.getWidth();
        j = (int)(i / f1);
        n = (int)(0.5F * (paramBitmap.getHeight() - j));
        f1 = paramBitmap.getHeight() - j;
        ((Rect)localObject).set(0, n, i, (int)(j + 0.5F * f1));
      }
      for (;;)
      {
        paramBitmap = ImageUtil.a(paramBitmap, (Rect)localObject, TroopPhotoUtil.a(k, m, ((Rect)localObject).width(), ((Rect)localObject).height()));
        paramDownloadParams = paramBitmap;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER centerCrop %s", new Object[] { ((Rect)localObject).toShortString() }));
        return paramBitmap;
        bool = false;
        break label128;
        i = paramBitmap.getHeight();
        j = (int)(f1 * i);
        n = (int)(0.5F * (paramBitmap.getWidth() - j));
        f1 = paramBitmap.getWidth() - j;
        ((Rect)localObject).set(n, 0, (int)(j + 0.5F * f1), i);
      }
      paramDownloadParams = paramBitmap;
    } while (!bool);
    label439:
    if (n + i > i3) {
      i = i3 - n;
    }
    for (;;)
    {
      if (i1 + j > i2) {
        j = i2 - i1;
      }
      for (;;)
      {
        paramDownloadParams = new Rect(n, i1, i + n, j + i1);
        j = 1;
        i = j;
        if (k > 0)
        {
          i = j;
          if (m > 0) {
            i = TroopPhotoUtil.a(k, m, paramDownloadParams.width(), paramDownloadParams.height());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(URLDrawableDecodeHandler.a(), 2, String.format("CUSTOM_CLIP_DECODER [w,h]=[%d,%d] dstClip=%s sample=%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramDownloadParams, Integer.valueOf(i) }));
        }
        return ImageUtil.a(paramBitmap, paramDownloadParams, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.22
 * JD-Core Version:    0.7.0.1
 */