package com.tencent.qqmini.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

public class ScreenShotUtil
{
  public static final int EDGE_LEFT_RIGHT = 10;
  public static final String TAG = "ScreenShotUtil";
  private static BaseRuntime runtime;
  
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
    if ((paramView == null) || (runtime == null)) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  public static boolean checkIfWhiteScreen(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (runtime == null)) {
      return false;
    }
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    NativeViewRequestEvent localNativeViewRequestEvent = new NativeViewRequestEvent();
    localNativeViewRequestEvent.dispatchTarget = 3;
    localNativeViewRequestEvent.event = "getMenuButtonBoundingClientRect";
    int n = new JSONObject(getMenuButtonRect(localNativeViewRequestEvent)).optInt("bottom") * (int)DisplayUtil.getDensity(runtime.getAttachedActivity()) + DisplayUtil.getStatusBarHeight(runtime.getAttachedActivity());
    int i = getImageRowRgb(paramBitmap, k, n + 5);
    int j = getImageRowRgb(paramBitmap, k, m / 2);
    n = getImageRowRgb(paramBitmap, k, m - n - 5);
    k = getImageColRgb(paramBitmap, k / 2, m);
    if ((i != -1) && (i == j) && (j == n) && (n == k))
    {
      QMLog.i("ScreenShotUtil", "--- checkIfWhiteScreen:rgb1:" + i + " rgb2:" + j + " rgb3:" + n + " rgb4:" + k);
      return true;
    }
    QMLog.i("ScreenShotUtil", "--- checkIfWhiteScreen:rgb1:" + i + " rgb2:" + j + " rgb3:" + n + " rgb4:" + k);
    return false;
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
  
  private static String getMenuButtonRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    return runtime.getPage().dispatchEventToNativeView(paramNativeViewRequestEvent);
  }
  
  public static void setRuntime(BaseRuntime paramBaseRuntime)
  {
    runtime = paramBaseRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ScreenShotUtil
 * JD-Core Version:    0.7.0.1
 */