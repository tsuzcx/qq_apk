package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.StackBlur;

public class URLDrawableDecodeHandler$FastBlurDecoder
  implements DownloadParams.DecodeHandler
{
  private int a;
  
  public URLDrawableDecodeHandler$FastBlurDecoder(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int k = paramDownloadParams.reqHeight;
    int m = j * k / i;
    if (k >= i)
    {
      k = i;
    }
    else
    {
      i = m;
      j = i;
    }
    try
    {
      paramDownloadParams = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_4444);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, null, new Rect(0, 0, j, k), new Paint(7));
      StackBlur.a(paramDownloadParams, this.a);
      return paramDownloadParams;
    }
    catch (Exception|OutOfMemoryError paramDownloadParams) {}
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.FastBlurDecoder
 * JD-Core Version:    0.7.0.1
 */