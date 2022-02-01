package com.tencent.pts.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

public class PTSDeviceUtil
{
  private static final float SCREEN_RP = 750.0F;
  private static final String TAG = "PTSDeviceUtil";
  private static float density;
  private static int densityDpi;
  private static int screenHeightPx;
  private static int screenWidthPx;
  private static float textHeightOffsetPerLine = 0.0F;
  private static float textWidthOffsetPerLength = 0.0F;
  
  static
  {
    init();
  }
  
  public static float dp2px(float paramFloat)
  {
    return density * paramFloat;
  }
  
  public static int dp2pxInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return (int)(density * paramFloat + 0.5F);
    }
    if (paramFloat < 0.0F) {
      return (int)(density * paramFloat - 0.5F);
    }
    return 0;
  }
  
  public static float getRPXScaling()
  {
    return getScreenWidthDp() / 750.0F;
  }
  
  public static float getScreenHeightDp()
  {
    return px2dp(screenHeightPx);
  }
  
  public static float getScreenHeightPx()
  {
    return screenHeightPx;
  }
  
  public static float getScreenScale()
  {
    return densityDpi / 160.0F;
  }
  
  public static float getScreenWidthDp()
  {
    return px2dp(screenWidthPx);
  }
  
  public static float getScreenWidthPx()
  {
    return screenWidthPx;
  }
  
  public static float getTextHeightOffsetPerLine()
  {
    return textHeightOffsetPerLine;
  }
  
  public static float getTextWidthOffsetPerLength()
  {
    return textWidthOffsetPerLength;
  }
  
  private static void init()
  {
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    if (localDisplayMetrics != null)
    {
      density = localDisplayMetrics.density;
      densityDpi = localDisplayMetrics.densityDpi;
      screenWidthPx = localDisplayMetrics.widthPixels;
      screenHeightPx = localDisplayMetrics.heightPixels;
      PTSLog.i("PTSDeviceUtil", "[init] density = " + density + ", densityDpi = " + densityDpi + ", screenWidthPx = " + screenWidthPx + ", screenHeightPx = " + screenHeightPx);
      return;
    }
    PTSLog.i("PTSDeviceUtil", "[init] displayMetrics is null.");
  }
  
  public static void init(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null)) {
      init();
    }
    do
    {
      return;
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while (paramContext == null);
    density = paramContext.density;
    densityDpi = paramContext.densityDpi;
    screenWidthPx = paramContext.widthPixels;
    screenHeightPx = paramContext.heightPixels;
    PTSLog.i("PTSDeviceUtil", "[init] density = " + density + ", densityDpi = " + densityDpi + ", screenWidthPx = " + screenWidthPx + ", screenHeightPx = " + screenHeightPx);
  }
  
  public static boolean isVisibleOnScreen(View paramView)
  {
    if (paramView == null) {}
    while (!paramView.isShown()) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect.intersect(new Rect(0, 0, screenWidthPx, screenHeightPx));
  }
  
  public static float px2dp(float paramFloat)
  {
    float f = 0.0F;
    if (density != 0.0F) {
      f = paramFloat / density;
    }
    return f;
  }
  
  public static int px2dpInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return (int)(paramFloat / density + 0.5F);
    }
    if (paramFloat < 0.0F) {
      return (int)(paramFloat / density - 0.5F);
    }
    return 0;
  }
  
  public static int rp2pxInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return (int)(screenWidthPx / 750.0F * paramFloat + 0.5F);
    }
    if (paramFloat < 0.0F) {
      return (int)(screenWidthPx / 750.0F * paramFloat - 0.5F);
    }
    return 0;
  }
  
  public static void setTextHeightOffsetPerLine(float paramFloat)
  {
    textHeightOffsetPerLine = paramFloat;
  }
  
  public static void setTextWidthOffsetPerLength(float paramFloat)
  {
    textWidthOffsetPerLength = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSDeviceUtil
 * JD-Core Version:    0.7.0.1
 */