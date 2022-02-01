package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import d;

public class UIUtils
{
  private static final Rect TEMP_RECT = new Rect();
  
  public static String getActivityInfo(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "null";
    }
    return paramActivity.getClass().getSimpleName();
  }
  
  public static View getDecorView(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    return getDecorView(paramActivity.getWindow());
  }
  
  public static View getDecorView(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return null;
    }
    return getDecorView(paramDialog.getWindow());
  }
  
  public static View getDecorView(android.app.Fragment paramFragment)
  {
    return getDecorView(paramFragment.getActivity());
  }
  
  public static View getDecorView(android.support.v4.app.Fragment paramFragment)
  {
    return getDecorView(paramFragment.getActivity());
  }
  
  public static View getDecorView(View paramView)
  {
    if (ViewCompatUtils.isAttachedToWindow(paramView)) {
      return paramView.getRootView();
    }
    return null;
  }
  
  public static View getDecorView(Window paramWindow)
  {
    if (paramWindow == null) {
      return null;
    }
    return paramWindow.getDecorView();
  }
  
  public static View getDecorView(d paramd)
  {
    return getDecorView(paramd.getActivity());
  }
  
  public static AreaInfo getExposureAreaInfo(View paramView)
  {
    double d = 0.0D;
    if (paramView == null) {
      return null;
    }
    long l2 = paramView.getWidth() * paramView.getHeight();
    long l1;
    if ((paramView.isShown()) && (paramView.getGlobalVisibleRect(TEMP_RECT)))
    {
      l1 = TEMP_RECT.width() * TEMP_RECT.height();
      if (l2 != 0L) {}
    }
    for (;;)
    {
      return new AreaInfo(l2, l1, d);
      d = l1 * 1.0D / l2;
      continue;
      l1 = 0L;
      d = 0.0D;
    }
  }
  
  public static Object getListScrollListener(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return null;
    }
    return ReflectUtils.getField(AbsListView.class, "mOnScrollListener", paramAbsListView);
  }
  
  public static double getViewExposureRate(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return 0.0D;
      if ((paramView.isShown()) && (paramView.getGlobalVisibleRect(TEMP_RECT))) {}
      for (int i = 1; i != 0; i = 0)
      {
        long l1 = TEMP_RECT.width();
        long l2 = TEMP_RECT.height();
        long l3 = paramView.getWidth();
        long l4 = paramView.getHeight();
        return l1 * l2 * 1.0D / (l3 * l4);
      }
    }
  }
  
  public static String getViewInfo(View paramView)
  {
    if (paramView == null) {
      return "null";
    }
    str3 = "0";
    int i = paramView.getId();
    String str1 = str3;
    if (i != -1) {}
    try
    {
      Context localContext = ReportUtils.getContext();
      str1 = str3;
      if (localContext != null) {
        str1 = localContext.getResources().getResourceName(i);
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        String str2 = str3;
      }
    }
    return paramView.getClass().getSimpleName() + ":" + str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.UIUtils
 * JD-Core Version:    0.7.0.1
 */