package com.tencent.mobileqq.qqgamepub.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class UIUtils
{
  public static final float a(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.UIUtils
 * JD-Core Version:    0.7.0.1
 */