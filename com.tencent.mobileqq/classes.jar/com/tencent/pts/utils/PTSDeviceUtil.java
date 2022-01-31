package com.tencent.pts.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PTSDeviceUtil
{
  private static final String TAG = "PTSDeviceUtil";
  
  public static float getRPXScaling()
  {
    return getScreenWidthDp() / 750.0F;
  }
  
  public static float getScreenHeightDp()
  {
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    return localDisplayMetrics.heightPixels / (localDisplayMetrics.densityDpi / 160.0F) + 0.5F;
  }
  
  public static float getScreenScale()
  {
    return Resources.getSystem().getDisplayMetrics().densityDpi / 160.0F;
  }
  
  public static float getScreenWidthDp()
  {
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    return localDisplayMetrics.widthPixels / (localDisplayMetrics.densityDpi / 160.0F) + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.utils.PTSDeviceUtil
 * JD-Core Version:    0.7.0.1
 */