package com.tencent.plato.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.plato.core.utils.Ev;

public class DeviceInfo
{
  public static final boolean DOM_LOG_DEBUG_ENABLE = false;
  public static final int FIT_DEVICE_WIDTH = 750;
  public static final boolean IMAGE_DEBUG_ENABLE = false;
  public static final boolean TIME_LOG_DEBUG_ENABLE = true;
  public static int height;
  public static float mDensity;
  public static DisplayMetrics metrics;
  public static float perRemPx;
  public static int width;
  
  public static float dpToPixel(float paramFloat)
  {
    return paramFloat * (metrics.densityDpi / 160.0F);
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static void init()
  {
    metrics = Ev.appContext().getResources().getDisplayMetrics();
    width = metrics.widthPixels;
    height = metrics.heightPixels - getStatusBarHeight(Ev.appContext());
    mDensity = metrics.density;
    perRemPx = width * 1.0F / 750.0F;
  }
  
  public static void setHeight(int paramInt)
  {
    height = paramInt;
  }
  
  public static void setWidth(int paramInt)
  {
    width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */