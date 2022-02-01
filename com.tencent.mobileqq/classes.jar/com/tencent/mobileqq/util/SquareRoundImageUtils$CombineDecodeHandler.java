package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class SquareRoundImageUtils$CombineDecodeHandler
  implements DownloadParams.DecodeHandler
{
  private DownloadParams.DecodeHandler a;
  private DownloadParams.DecodeHandler b;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Bitmap localBitmap = this.a.run(paramDownloadParams, paramBitmap);
    DownloadParams localDownloadParams = null;
    if (localBitmap != null)
    {
      paramDownloadParams = this.b.run(paramDownloadParams, localBitmap);
      localDownloadParams = paramDownloadParams;
      if (localBitmap != paramDownloadParams)
      {
        localDownloadParams = paramDownloadParams;
        if (localBitmap != paramBitmap)
        {
          localBitmap.recycle();
          localDownloadParams = paramDownloadParams;
        }
      }
    }
    if (localDownloadParams != null) {
      paramBitmap = localDownloadParams;
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SquareRoundImageUtils.CombineDecodeHandler
 * JD-Core Version:    0.7.0.1
 */