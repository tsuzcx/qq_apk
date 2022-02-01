package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PixelUtil
{
  static DisplayMetrics sMetrics = null;
  
  public static float dp2px(double paramDouble)
  {
    return dp2px((float)paramDouble);
  }
  
  public static float dp2px(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getMetrics());
  }
  
  private static DisplayMetrics getMetrics()
  {
    if (sMetrics == null) {
      sMetrics = ContextHolder.getAppContext().getResources().getDisplayMetrics();
    }
    return sMetrics;
  }
  
  public static float px2dp(float paramFloat)
  {
    return paramFloat / getMetrics().density + 0.5F;
  }
  
  public static float px2sp(float paramFloat)
  {
    return paramFloat / getMetrics().scaledDensity + 0.5F;
  }
  
  public static float sp2px(float paramFloat)
  {
    return TypedValue.applyDimension(2, paramFloat, getMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.PixelUtil
 * JD-Core Version:    0.7.0.1
 */