package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import java.util.HashSet;
import java.util.Set;

public class UIUtils
{
  private static final String TAG = "UIUtils";
  private static final Rect TEMP_RECT = new Rect();
  
  public static Activity findAttachedActivity(View paramView)
  {
    if (!ViewCompatUtils.isAttachedToWindow(paramView)) {
      return null;
    }
    paramView = paramView.getRootView();
    paramView = ViewContainerBinder.getInstance().getBoundContainer(paramView);
    if ((paramView instanceof Activity)) {
      return (Activity)paramView;
    }
    if ((paramView instanceof Dialog)) {
      return DialogListUtil.getDialogActivity((Dialog)paramView);
    }
    return null;
  }
  
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
  
  public static AreaInfo getExposureAreaInfo(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    long l2 = paramView.getWidth() * paramView.getHeight();
    boolean bool = paramView.isShown();
    double d1 = 0.0D;
    long l1;
    if ((bool) && (paramView.getGlobalVisibleRect(TEMP_RECT)))
    {
      l1 = TEMP_RECT.width() * TEMP_RECT.height();
      if (l2 != 0L)
      {
        d1 = l1;
        Double.isNaN(d1);
        double d2 = l2;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
      }
    }
    else
    {
      l1 = 0L;
      d1 = 0.0D;
    }
    return new AreaInfo(l2, l1, d1);
  }
  
  public static Object getListOnHierarchyChangeListener(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return null;
    }
    return ReflectUtils.getField(ViewGroup.class, "mOnHierarchyChangeListener", paramAbsListView);
  }
  
  public static Object getListScrollListener(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return null;
    }
    return ReflectUtils.getField(AbsListView.class, "mOnScrollListener", paramAbsListView);
  }
  
  public static Set<View> getParentViews(View paramView)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = paramView;
    if (paramView == null) {
      return localHashSet;
    }
    while ((((View)localObject).getParent() instanceof ViewGroup))
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      localHashSet.add(localObject);
    }
    return localHashSet;
  }
  
  public static double getViewExposureRate(View paramView)
  {
    if (paramView == null) {
      return 0.0D;
    }
    int i;
    if ((paramView.isShown()) && (paramView.getGlobalVisibleRect(TEMP_RECT))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0.0D;
    }
    long l1 = TEMP_RECT.width();
    long l2 = TEMP_RECT.height();
    long l3 = paramView.getWidth();
    long l4 = paramView.getHeight();
    double d1 = l1 * l2;
    Double.isNaN(d1);
    double d2 = l3 * l4;
    Double.isNaN(d2);
    return d1 * 1.0D / d2;
  }
  
  public static String getViewInfo(View paramView)
  {
    if (paramView == null) {
      return "null";
    }
    Object localObject3 = "0";
    int i = paramView.getId();
    Object localObject1 = localObject3;
    Object localObject2;
    if (i != -1) {
      try
      {
        localObject4 = ReportUtils.getContext();
        localObject1 = localObject3;
        if (localObject4 != null) {
          localObject1 = ((Context)localObject4).getResources().getResourceName(i);
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("NotFoundException ");
        ((StringBuilder)localObject4).append(localNotFoundException);
        Log.e("UIUtils", ((StringBuilder)localObject4).toString());
        localObject2 = localObject3;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramView.getClass().getSimpleName());
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(localObject2);
    return ((StringBuilder)localObject3).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.UIUtils
 * JD-Core Version:    0.7.0.1
 */