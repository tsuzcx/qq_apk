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
    Bitmap localBitmap2 = this.a.run(paramDownloadParams, paramBitmap);
    if (localBitmap2 != null)
    {
      Bitmap localBitmap1 = this.b.run(paramDownloadParams, localBitmap2);
      paramDownloadParams = localBitmap1;
      if (localBitmap2 != localBitmap1)
      {
        paramDownloadParams = localBitmap1;
        if (localBitmap2 != paramBitmap)
        {
          localBitmap2.recycle();
          paramDownloadParams = localBitmap1;
        }
      }
    }
    else
    {
      paramDownloadParams = null;
    }
    if (paramDownloadParams != null) {
      return paramDownloadParams;
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SquareRoundImageUtils.CombineDecodeHandler
 * JD-Core Version:    0.7.0.1
 */