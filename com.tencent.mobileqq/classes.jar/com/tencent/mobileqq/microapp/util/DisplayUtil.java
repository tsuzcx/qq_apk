package com.tencent.mobileqq.microapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public class DisplayUtil
{
  private static float density;
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int getBarHeight(Context paramContext)
  {
    try
    {
      int i = ((Integer)Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue();
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 38;
  }
  
  public static float getDensity(Context paramContext)
  {
    if (density != 0.0F) {
      return density;
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("");
    }
    density = paramContext.getResources().getDisplayMetrics().density;
    return density;
  }
  
  public static int parseColor(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.length() == 4)
      {
        str1 = paramString;
        if (paramString.substring(0, 1).equals("#"))
        {
          str1 = paramString.substring(1, 2);
          String str2 = paramString.substring(2, 3);
          paramString = paramString.substring(3, 4);
          str1 = "#" + str1 + str1 + str2 + str2 + paramString + paramString;
        }
      }
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */