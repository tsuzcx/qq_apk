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
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
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
    float f = density;
    if (f != 0.0F) {
      return f;
    }
    if (paramContext != null)
    {
      density = paramContext.getResources().getDisplayMetrics().density;
      return density;
    }
    throw new IllegalArgumentException("");
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("#");
          localStringBuilder.append(str1);
          localStringBuilder.append(str1);
          localStringBuilder.append(str2);
          localStringBuilder.append(str2);
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramString);
          str1 = localStringBuilder.toString();
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
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */