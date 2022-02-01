package com.tencent.tkd.comment.adapt;

import android.app.Application;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

class Util
{
  private static final DisplayMetrics sDisplayMetrics = new DisplayMetrics();
  
  public static int dp2px(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, sDisplayMetrics);
  }
  
  public static int getScreenHeight()
  {
    return sDisplayMetrics.heightPixels;
  }
  
  public static void init(Application paramApplication)
  {
    ((WindowManager)paramApplication.getSystemService("window")).getDefaultDisplay().getMetrics(sDisplayMetrics);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.Util
 * JD-Core Version:    0.7.0.1
 */