package com.tencent.mobileqq.mini.entry;

import android.graphics.Bitmap;
import android.graphics.Rect;
import bheg;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class MiniAppEntryLayout$2
  implements DownloadParams.DecodeHandler
{
  MiniAppEntryLayout$2(MiniAppEntryLayout paramMiniAppEntryLayout) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    if (paramBitmap != null) {
      paramDownloadParams = localBitmap2;
    }
    try
    {
      Rect localRect = new Rect();
      paramDownloadParams = localBitmap2;
      localRect.right = paramBitmap.getWidth();
      paramDownloadParams = localBitmap2;
      int i = ViewUtils.dip2px(240.0F);
      paramDownloadParams = localBitmap2;
      localRect.bottom = Math.min(paramBitmap.getHeight(), i);
      paramDownloadParams = localBitmap2;
      localBitmap2 = bheg.a(paramBitmap, localRect, 2);
      localBitmap1 = localBitmap2;
      paramDownloadParams = localBitmap2;
      if (QLog.isColorLevel())
      {
        paramDownloadParams = localBitmap2;
        QLog.d("MicroAppEntryLayout", 2, "updateHongBaoRes，setDecodeHandler：,originalHeight:" + paramBitmap.getHeight() + ",maxHeight:" + i + "，outWidth：" + localRect.right + ",outHeight：" + localRect.bottom + ",outBitmap:" + localBitmap2);
        localBitmap1 = localBitmap2;
      }
      return localBitmap1;
    }
    catch (Throwable paramBitmap)
    {
      QLog.e("MicroAppEntryLayout", 1, paramBitmap, new Object[0]);
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.2
 * JD-Core Version:    0.7.0.1
 */