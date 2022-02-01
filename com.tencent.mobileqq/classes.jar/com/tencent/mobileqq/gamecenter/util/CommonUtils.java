package com.tencent.mobileqq.gamecenter.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class CommonUtils
{
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.CommonUtils
 * JD-Core Version:    0.7.0.1
 */