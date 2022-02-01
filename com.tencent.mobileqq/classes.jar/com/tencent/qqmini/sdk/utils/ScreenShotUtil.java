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
    for (;;)
    {
      if ((j <= paramInt1) && (i <= paramInt2))
      {
        paramBitmap = ThumbnailUtils.extractThumbnail(paramBitmap, j, i);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 40, localByteArrayOutputStream);
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
      }
      j /= 2;
      i /= 2;
    }
  }
  
  public static Bitmap captureView(View paramView)
  {
    if ((paramView != null) && (runtime != null))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    return null;
  }
  
  public static boolean checkIfWhiteScreen(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (runtime == null) {
        return false;
      }
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      Object localObject = new NativeViewRequestEvent();
      ((NativeViewRequestEvent)localObject).dispatchTarget = 3;
      ((NativeViewRequestEvent)localObject).event = "getMenuButtonBoundingClientRect";
      int n = new JSONObject(getMenuButtonRect((NativeViewRequestEvent)localObject)).optInt("bottom") * (int)DisplayUtil.getDensity(runtime.getAttachedActivity()) + DisplayUtil.getStatusBarHeight(runtime.getAttachedActivity());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--- checkIfWhiteScreen:width:");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" height:");
      ((StringBuilder)localObject).append(m);
      QMLog.i("ScreenShotUtil", ((StringBuilder)localObject).toString());
      int i = getImageRowRgb(paramBitmap, k, n + 5);
      int j = getImageRowRgb(paramBitmap, k, m / 2);
      n = getImageRowRgb(paramBitmap, k, m - n - 5);
      k = getImageColRgb(paramBitmap, k / 2, m);
      if ((i != -1) && (i == j) && (j == n) && (n == k))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("--- checkIfWhiteScreen:rgb1:");
        paramBitmap.append(i);
        paramBitmap.append(" rgb2:");
        paramBitmap.append(j);
        paramBitmap.append(" rgb3:");
        paramBitmap.append(n);
        paramBitmap.append(" rgb4:");
        paramBitmap.append(k);
        QMLog.i("ScreenShotUtil", paramBitmap.toString());
        return true;
      }
      paramBitmap = new StringBuilder();
      paramBitmap.append("--- checkIfWhiteScreen:rgb1:");
      paramBitmap.append(i);
      paramBitmap.append(" rgb2:");
      paramBitmap.append(j);
      paramBitmap.append(" rgb3:");
      paramBitmap.append(n);
      paramBitmap.append(" rgb4:");
      paramBitmap.append(k);
      QMLog.i("ScreenShotUtil", paramBitmap.toString());
    }
    return false;
  }
  
  private static int getImageColRgb(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return -1;
    }
    int i = paramInt2 / 4;
    int m = paramBitmap.getPixel(paramInt1, i);
    int j = Color.red(m);
    int k = Color.green(m);
    m = Color.blue(m);
    int i2;
    int n;
    int i1;
    do
    {
      i += 1;
      if (i >= paramInt2 * 3 / 4) {
        break;
      }
      i2 = paramBitmap.getPixel(paramInt1, i);
      n = Color.red(i2);
      i1 = Color.green(i2);
      i2 = Color.blue(i2);
    } while ((n == j) && (i1 == k) && (i2 == m));
    return -1;
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
    while (i < paramInt1 - 10)
    {
      int i2 = paramBitmap.getPixel(i, paramInt2);
      int n = Color.red(i2);
      int i1 = Color.green(i2);
      i2 = Color.blue(i2);
      if ((n == j) && (i1 == k))
      {
        if (i2 != m) {
          return -1;
        }
        i += 1;
      }
      else
      {
        return -1;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ScreenShotUtil
 * JD-Core Version:    0.7.0.1
 */