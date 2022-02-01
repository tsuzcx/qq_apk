package com.tencent.qqmini.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.ByteArrayOutputStream;

public class ScreenShotUtil
{
  public static final int EDGE_LEFT_RIGHT = 10;
  public static final String TAG = "ScreenShotUtil";
  
  public static boolean CheckIfWhiteScreen(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return false;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    int i = getImageRowRgb(paramBitmap, m, n / 4);
    int j = getImageRowRgb(paramBitmap, m, n / 2);
    int k = getImageRowRgb(paramBitmap, m, n * 3 / 4);
    m = getImageColRgb(paramBitmap, m / 2, n);
    if ((i != -1) && (i == j) && (j == k) && (k == m))
    {
      QMLog.i("ScreenShotUtil", "--- CheckIfWhiteScreen:rgb1:" + i + " rgb2:" + j + " rgb3:" + k + " rgb4:" + m);
      return true;
    }
    QMLog.i("ScreenShotUtil", "--- CheckIfWhiteScreen:rgb1:" + i + " rgb2:" + j + " rgb3:" + k + " rgb4:" + m);
    return false;
  }
  
  public static String bitmapTobase64(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    while ((j > paramInt1) || (i > paramInt2))
    {
      j /= 2;
      i /= 2;
    }
    paramBitmap = ThumbnailUtils.extractThumbnail(paramBitmap, j, i);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 40, localByteArrayOutputStream);
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
  
  public static Bitmap captureView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  private static int getImageColRgb(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return -1;
    }
    int i = paramBitmap.getPixel(paramInt1, paramInt2 / 4);
    int j = Color.red(i);
    int k = Color.green(i);
    int m = Color.blue(i);
    i = paramInt2 / 4 + 1;
    while (i < paramInt2 * 3 / 4)
    {
      int i2 = paramBitmap.getPixel(paramInt1, i);
      int n = Color.red(i2);
      int i1 = Color.green(i2);
      i2 = Color.blue(i2);
      if ((n != j) || (i1 != k) || (i2 != m)) {
        return -1;
      }
      i += 1;
    }
    return j * k * m;
  }
  
  private static int getImageRowRgb(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return -1;
    }
    int i = paramBitmap.getPixel(10, paramInt2);
    int j = Color.red(i);
    int k = Color.green(i);
    int m = Color.blue(i);
    i = 11;
    for (;;)
    {
      if (i >= paramInt1 - 10) {
        break label100;
      }
      int i2 = paramBitmap.getPixel(i, paramInt2);
      int n = Color.red(i2);
      int i1 = Color.green(i2);
      i2 = Color.blue(i2);
      if ((n != j) || (i1 != k) || (i2 != m)) {
        break;
      }
      i += 1;
    }
    label100:
    return j * k * m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ScreenShotUtil
 * JD-Core Version:    0.7.0.1
 */