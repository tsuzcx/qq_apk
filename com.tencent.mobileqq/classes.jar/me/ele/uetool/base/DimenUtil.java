package me.ele.uetool.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DimenUtil
{
  private static final Context CONTEXT = ;
  
  public static int dip2px(float paramFloat)
  {
    return (int)(CONTEXT.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int getScreenHeight()
  {
    return CONTEXT.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth()
  {
    return CONTEXT.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight()
  {
    Resources localResources = CONTEXT.getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return localResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static String px2dip(float paramFloat)
  {
    return px2dip(paramFloat, false);
  }
  
  public static String px2dip(float paramFloat, boolean paramBoolean)
  {
    float f = CONTEXT.getResources().getDisplayMetrics().density;
    StringBuilder localStringBuilder = new StringBuilder().append((int)(paramFloat / f + 0.5F));
    if (paramBoolean) {}
    for (String str = "dp";; str = "") {
      return str;
    }
  }
  
  public static String px2sp(float paramFloat)
  {
    return String.valueOf(paramFloat / CONTEXT.getResources().getDisplayMetrics().scaledDensity);
  }
  
  public static int sp2px(float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, CONTEXT.getResources().getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.base.DimenUtil
 * JD-Core Version:    0.7.0.1
 */