package com.tencent.tavsticker.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ViewUtils
{
  public static int dip2px(float paramFloat)
  {
    return (int)(paramFloat * Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
  
  public static int px2dip(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */