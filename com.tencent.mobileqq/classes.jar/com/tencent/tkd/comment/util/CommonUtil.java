package com.tencent.tkd.comment.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

public class CommonUtil
{
  private static long lastClickTime;
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      label39:
      break label39;
    }
    return 38;
  }
  
  public static boolean hideInputMethod(Context paramContext, View paramView)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if ((paramContext != null) && (paramContext.isActive()) && (paramView != null))
    {
      paramContext.hideSoftInputFromWindow(paramView.getWindowToken(), 2);
      return true;
    }
    return false;
  }
  
  public static void hideNavigationBar(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramWindow = paramWindow.getDecorView();
      int i;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 4610;
      } else {
        i = 515;
      }
      int j = i;
      if (Build.VERSION.SDK_INT < 21) {
        j = i | 0x100;
      }
      paramWindow.setSystemUiVisibility(j);
    }
  }
  
  public static boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = lastClickTime;
    lastClickTime = l1;
    return l1 - l2 < 500L;
  }
  
  public static void showInputMethod(Context paramContext, View paramView)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    paramView.requestFocus();
    paramContext.showSoftInput(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.util.CommonUtil
 * JD-Core Version:    0.7.0.1
 */