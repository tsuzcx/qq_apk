package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ThemeImageWrapper;

public class DecodeUtils
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap = QQAppInterface.getShapeRoundFaceBitmap(paramBitmap, ImageUtil.a(paramBitmap.getWidth()), 50, 50);
    if (ThemeImageWrapper.isNightMode())
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), 10.0F, 10.0F, localPaint);
    }
    return paramBitmap;
  }
  
  private static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    int i = paramBitmap.getWidth();
    float f1 = paramFloat;
    if (i > 0)
    {
      float f2 = i;
      float f3 = 50;
      f1 = paramFloat;
      if (f2 < paramFloat * f3) {
        f1 = f2 / f3;
      }
    }
    i = (int)(50 * f1);
    return ImageUtil.a(paramBitmap, i, i, i);
  }
  
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      if (paramInt == 1) {
        return a(paramString);
      }
      Bitmap localBitmap = a(paramString, paramFloat);
      paramString = localBitmap;
      if (ThemeImageWrapper.isNightMode())
      {
        paramString = new Paint();
        paramString.setAntiAlias(true);
        paramString.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, localCanvas.getWidth() / 2, paramString);
        return localBitmap;
      }
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.DecodeUtils
 * JD-Core Version:    0.7.0.1
 */