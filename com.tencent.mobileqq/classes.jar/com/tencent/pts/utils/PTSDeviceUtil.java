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
  private static float textHeightOffsetPerLine;
  private static float textWidthOffsetPerLength;
  
  static {}
  
  public static float dp2px(float paramFloat)
  {
    return paramFloat * density;
  }
  
  public static int dp2pxInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {}
    for (paramFloat = paramFloat * density + 0.5F;; paramFloat = paramFloat * density - 0.5F)
    {
      return (int)paramFloat;
      if (paramFloat >= 0.0F) {
        break;
      }
    }
    return 0;
  }
  
  public static float getRPXScaling()
  {
    return getScreenWidthDp() / 750.0F;
  }
  
  public static float getRPXScaling(float paramFloat)
  {
    return paramFloat / 750.0F;
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
    Object localObject = Resources.getSystem().getDisplayMetrics();
    if (localObject != null)
    {
      density = ((DisplayMetrics)localObject).density;
      densityDpi = ((DisplayMetrics)localObject).densityDpi;
      screenWidthPx = ((DisplayMetrics)localObject).widthPixels;
      screenHeightPx = ((DisplayMetrics)localObject).heightPixels;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[init] density = ");
      ((StringBuilder)localObject).append(density);
      ((StringBuilder)localObject).append(", densityDpi = ");
      ((StringBuilder)localObject).append(densityDpi);
      ((StringBuilder)localObject).append(", screenWidthPx = ");
      ((StringBuilder)localObject).append(screenWidthPx);
      ((StringBuilder)localObject).append(", screenHeightPx = ");
      ((StringBuilder)localObject).append(screenHeightPx);
      PTSLog.i("PTSDeviceUtil", ((StringBuilder)localObject).toString());
      return;
    }
    PTSLog.i("PTSDeviceUtil", "[init] displayMetrics is null.");
  }
  
  public static void init(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getResources() != null))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      if (paramContext != null)
      {
        density = paramContext.density;
        densityDpi = paramContext.densityDpi;
        screenWidthPx = paramContext.widthPixels;
        screenHeightPx = paramContext.heightPixels;
        paramContext = new StringBuilder();
        paramContext.append("[init] density = ");
        paramContext.append(density);
        paramContext.append(", densityDpi = ");
        paramContext.append(densityDpi);
        paramContext.append(", screenWidthPx = ");
        paramContext.append(screenWidthPx);
        paramContext.append(", screenHeightPx = ");
        paramContext.append(screenHeightPx);
        PTSLog.i("PTSDeviceUtil", paramContext.toString());
      }
      return;
    }
    init();
  }
  
  public static boolean isVisibleOnScreen(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!paramView.isShown()) {
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect.intersect(new Rect(0, 0, screenWidthPx, screenHeightPx));
  }
  
  public static float px2dp(float paramFloat)
  {
    float f = density;
    if (f != 0.0F) {
      return paramFloat / f;
    }
    return 0.0F;
  }
  
  public static int px2dpInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {}
    for (paramFloat = paramFloat / density + 0.5F;; paramFloat = paramFloat / density - 0.5F)
    {
      return (int)paramFloat;
      if (paramFloat >= 0.0F) {
        break;
      }
    }
    return 0;
  }
  
  public static int rp2pxInt(float paramFloat)
  {
    if (paramFloat > 0.0F) {}
    for (paramFloat = screenWidthPx / 750.0F * paramFloat + 0.5F;; paramFloat = screenWidthPx / 750.0F * paramFloat - 0.5F)
    {
      return (int)paramFloat;
      if (paramFloat >= 0.0F) {
        break;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSDeviceUtil
 * JD-Core Version:    0.7.0.1
 */