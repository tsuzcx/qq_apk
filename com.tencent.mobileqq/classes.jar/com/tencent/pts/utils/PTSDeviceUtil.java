package com.tencent.pts.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PTSDeviceUtil
{
  private static final String TAG = "PTSDeviceUtil";
  private static float density;
  private static int densityDpi;
  private static int screenHeightPx;
  private static int screenWidthPx;
  
  public static float dp2px(float paramFloat)
  {
    return density * paramFloat + 0.5F;
  }
  
  public static float getRPXScaling()
  {
    return getScreenWidthDp() / 750.0F;
  }
  
  public static float getScreenHeightDp()
  {
    return px2dp(screenHeightPx);
  }
  
  public static float getScreenScale()
  {
    return densityDpi / 160.0F;
  }
  
  public static float getScreenWidthDp()
  {
    return px2dp(screenWidthPx);
  }
  
  public static void init(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null)) {}
    do
    {
      do
      {
        return;
      } while (density != 0.0F);
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while (paramContext == null);
    density = paramContext.density;
    densityDpi = paramContext.densityDpi;
    screenWidthPx = paramContext.widthPixels;
    screenHeightPx = paramContext.heightPixels;
  }
  
  public static float px2dp(float paramFloat)
  {
    return paramFloat / density + 0.5F;
  }
  
  public static void reset(Context paramContext)
  {
    density = 0.0F;
    init(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSDeviceUtil
 * JD-Core Version:    0.7.0.1
 */