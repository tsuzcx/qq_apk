package com.tencent.mobileqq.gamecenter.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.BaseApplication;

public class ImageUtil
{
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    return a(paramBitmap, paramFloat, false, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        if (i > k)
        {
          paramInt1 = (i - k) / 2;
          j = paramInt2;
          i = k;
          break label257;
        }
        if (k <= i) {
          break label248;
        }
        k = (k - i) / 2;
        paramInt2 = i;
        m = paramInt2;
        j = 0;
        i = paramInt1;
        n = paramInt1;
        i1 = i;
      }
      catch (Throwable paramBitmap)
      {
        Bitmap localBitmap;
        Canvas localCanvas;
        Paint localPaint;
        Rect localRect1;
        Rect localRect2;
        RectF localRectF;
        paramBitmap.printStackTrace();
        return null;
      }
      localBitmap = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localRect1 = new Rect(j, k, paramInt2 + j, m + k);
      localRect2 = new Rect(0, 0, n, i1);
      localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      label248:
      int m = 0;
      int j = paramInt1;
      paramInt1 = m;
      label257:
      int i2 = 0;
      int i1 = paramInt2;
      int n = j;
      m = k;
      paramInt2 = i;
      int k = i2;
      j = paramInt1;
      if (!paramBoolean) {
        paramFloat = n;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f2 = f1;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt1;
      f2 = f1;
      if (f3 < f1 * f4) {
        f2 = f3 / f4;
      }
    }
    i = (paramInt1 + paramInt2) / 2;
    if (i < 35) {
      f1 = 2.0F;
    }
    for (;;)
    {
      i = (int)(f1 * f2);
      break;
      if (i < 50) {
        f1 = 3.0F;
      } else if (i < 64) {
        f1 = 5.0F;
      } else {
        f1 = 6.0F;
      }
    }
    paramInt1 = (int)(paramInt1 * f2);
    paramInt2 = (int)(paramInt2 * f2);
    return a(paramBitmap, i, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.ImageUtil
 * JD-Core Version:    0.7.0.1
 */