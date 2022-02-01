package com.tencent.mobileqq.mini.entry;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class MiniAppEntryLayout$2
  implements DownloadParams.DecodeHandler
{
  MiniAppEntryLayout$2(MiniAppEntryLayout paramMiniAppEntryLayout) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Object localObject = null;
    Bitmap localBitmap = null;
    if (paramBitmap != null)
    {
      paramDownloadParams = localBitmap;
      try
      {
        Rect localRect = new Rect();
        paramDownloadParams = localBitmap;
        localRect.right = paramBitmap.getWidth();
        paramDownloadParams = localBitmap;
        int i = ViewUtils.a(240.0F);
        paramDownloadParams = localBitmap;
        localRect.bottom = Math.min(paramBitmap.getHeight(), i);
        paramDownloadParams = localBitmap;
        localBitmap = ImageUtil.a(paramBitmap, localRect, 2);
        paramDownloadParams = localBitmap;
        localObject = localBitmap;
        if (QLog.isColorLevel())
        {
          paramDownloadParams = localBitmap;
          localObject = new StringBuilder();
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append("updateHongBaoRes，setDecodeHandler：,originalHeight:");
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(paramBitmap.getHeight());
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(",maxHeight:");
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(i);
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append("，outWidth：");
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(localRect.right);
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(",outHeight：");
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(localRect.bottom);
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(",outBitmap:");
          paramDownloadParams = localBitmap;
          ((StringBuilder)localObject).append(localBitmap);
          paramDownloadParams = localBitmap;
          QLog.d("MicroAppEntryLayout", 2, ((StringBuilder)localObject).toString());
          return localBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("MicroAppEntryLayout", 1, paramBitmap, new Object[0]);
        localObject = paramDownloadParams;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.2
 * JD-Core Version:    0.7.0.1
 */