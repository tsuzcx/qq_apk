package com.tencent.tavsticker.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public class ScreenUtil
{
  private static final String TAG = ScreenUtil.class.getSimpleName();
  
  public static int getScreenHeight()
  {
    return Resources.getSystem().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth()
  {
    return Resources.getSystem().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight()
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = Resources.getSystem().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.utils.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */