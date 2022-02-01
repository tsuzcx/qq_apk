package com.tencent.mobileqq.qqexpand.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class BackgroundUtil
{
  public static Bitmap a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = paramInt1 * 2;
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setAlpha((int)(paramFloat * 255.0F));
    localPaint.setColor(paramInt2);
    localPaint.setStyle(Paint.Style.FILL);
    paramFloat = paramInt1;
    localCanvas.drawCircle(paramFloat, paramFloat, paramFloat, localPaint);
    localCanvas.save();
    localCanvas.restore();
    return localBitmap;
  }
  
  public static Bitmap a(Resources paramResources, Bitmap paramBitmap, int paramInt, float paramFloat, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      if (!paramBoolean)
      {
        paramBitmap = new RectF(0.0F, 0.0F, i, j);
        Paint localPaint = new Paint(1);
        localPaint.setColor(paramInt);
        localPaint.setAlpha((int)(paramFloat * 255.0F));
        paramFloat = AIOUtils.b(2.0F, paramResources);
        localCanvas.drawRoundRect(paramBitmap, paramFloat, paramFloat, localPaint);
      }
      else
      {
        paramResources = new Paint(1);
        paramResources.setAlpha((int)(paramFloat * 255.0F));
        paramResources.setColor(paramInt);
        paramResources.setStyle(Paint.Style.FILL);
        paramFloat = i / 2;
        localCanvas.drawCircle(paramFloat, paramFloat, paramFloat, paramResources);
      }
      localCanvas.save();
      localCanvas.restore();
      return localBitmap;
    }
    catch (OutOfMemoryError paramResources)
    {
      label170:
      break label170;
    }
    QLog.e("BackgroundUtil", 1, "get OOM when create ret, return target");
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.BackgroundUtil
 * JD-Core Version:    0.7.0.1
 */