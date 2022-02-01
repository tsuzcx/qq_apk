package com.tencent.qqlive.module.videoreport.utils;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

public class ViewCompatUtils
{
  private static final ViewCompatUtils.ViewCompatBaseImpl IMPL = new ViewCompatUtils.ViewCompatBaseImpl(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ViewCompatUtils.ViewCompatApi21Impl(null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ViewCompatUtils.ViewCompatApi19Impl(null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new ViewCompatUtils.ViewCompatApi18Impl(null);
      return;
    }
  }
  
  public static boolean getClipChildren(ViewGroup paramViewGroup)
  {
    return IMPL.getClipChildren(paramViewGroup);
  }
  
  public static boolean getClipToPadding(ViewGroup paramViewGroup)
  {
    return IMPL.getClipToPadding(paramViewGroup);
  }
  
  public static boolean isAttachedToWindow(View paramView)
  {
    return IMPL.isAttachedToWindow(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils
 * JD-Core Version:    0.7.0.1
 */