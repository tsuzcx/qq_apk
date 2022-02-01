package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
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
    float f = paramFloat;
    if (i > 0)
    {
      f = paramFloat;
      if (i < 50 * paramFloat) {
        f = i / 50;
      }
    }
    i = (int)(50 * f);
    int j = (int)(50 * f);
    return ImageUtil.a(paramBitmap, i, i, j);
  }
  
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
    paramString = null;
    if (localBitmap != null)
    {
      if (paramInt != 1) {
        break label23;
      }
      paramString = a(localBitmap);
    }
    label23:
    do
    {
      return paramString;
      localBitmap = a(localBitmap, paramFloat);
      paramString = localBitmap;
    } while (!ThemeImageWrapper.isNightMode());
    paramString = new Paint();
    paramString.setAntiAlias(true);
    paramString.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, localCanvas.getWidth() / 2, paramString);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.DecodeUtils
 * JD-Core Version:    0.7.0.1
 */