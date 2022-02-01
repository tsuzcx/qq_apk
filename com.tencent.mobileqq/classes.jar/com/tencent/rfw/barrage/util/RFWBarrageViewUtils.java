package com.tencent.rfw.barrage.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class RFWBarrageViewUtils
{
  private static float a()
  {
    Resources localResources = RFWQQUtils.a();
    if (localResources == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    if (localResources == null) {
      return 0.0F;
    }
    return localDisplayMetrics.density;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(paramFloat * a());
  }
  
  public static int b(float paramFloat)
  {
    float f = a();
    if (f <= 0.0F) {
      return 0;
    }
    return Math.round(paramFloat / f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageViewUtils
 * JD-Core Version:    0.7.0.1
 */