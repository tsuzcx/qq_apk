package com.tencent.qqlive.module.videoreport.traversal;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.reflect.Method;
import java.util.HashSet;

public class ViewGroupDrawingCompat
{
  private static final String TAG = "ViewGroupDrawingCompat";
  private static final HashSet<String> sBlackList = new HashSet();
  
  static
  {
    sBlackList.add("android.view.ViewGroup");
    sBlackList.add("com.android.internal.policy.DecorView");
    sBlackList.add("android.widget.LinearLayout");
    sBlackList.add("android.widget.RelativeLayout");
    sBlackList.add("android.widget.FrameLayout");
    sBlackList.add("android.widget.GridLayout");
    sBlackList.add("android.widget.HorizontalScrollView");
    sBlackList.add("android.widget.TabHost");
    sBlackList.add("android.widget.GridView");
    sBlackList.add("android.widget.ListView");
    sBlackList.add("android.widget.ScrollView");
    sBlackList.add("android.support.constraint.ConstraintLayout");
  }
  
  private static void dumpDebugInfo(ViewGroup paramViewGroup, View[] paramArrayOfView)
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramViewGroup.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("Default Drawing order:\n");
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      localStringBuilder.append("index:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramViewGroup.getChildAt(i));
      localStringBuilder.append("\n");
      i -= 1;
    }
    localStringBuilder.append("reordered Drawing order:\n");
    i = paramArrayOfView.length - 1;
    while (i >= 0)
    {
      localStringBuilder.append("index:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramArrayOfView[i]);
      localStringBuilder.append("\n");
      i -= 1;
    }
    Log.v("ViewGroupDrawingCompat", localStringBuilder.toString());
  }
  
  private static View[] getChildByCustomOrder(ViewGroup paramViewGroup)
  {
    if (!initReflectionIfNeed(paramViewGroup)) {
      return getDefaultChildren();
    }
    int j = paramViewGroup.getChildCount();
    View[] arrayOfView = new View[paramViewGroup.getChildCount()];
    int i = 0;
    while (i < j)
    {
      arrayOfView[((java.lang.Integer)ViewGroupDrawingCompat.MethodHolder.access$200().invoke(paramViewGroup, new Object[] { java.lang.Integer.valueOf(j), java.lang.Integer.valueOf(i) })).intValue()] = paramViewGroup.getChildAt(i);
      i += 1;
    }
    dumpDebugInfo(paramViewGroup, arrayOfView);
    return arrayOfView;
  }
  
  static View[] getChildrenByDrawingOrder(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return null;
    }
    try
    {
      paramViewGroup = getChildByCustomOrder(paramViewGroup);
      return paramViewGroup;
    }
    catch (Throwable paramViewGroup)
    {
      label13:
      break label13;
    }
    return getDefaultChildren();
  }
  
  private static View[] getDefaultChildren()
  {
    return null;
  }
  
  private static boolean initReflection()
  {
    return (ViewGroupDrawingCompat.MethodHolder.access$100() != null) && (ViewGroupDrawingCompat.MethodHolder.access$200() != null);
  }
  
  private static boolean initReflectionIfNeed(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramViewGroup != null)
    {
      if (paramViewGroup.getChildCount() <= 1) {
        return false;
      }
      String str = paramViewGroup.getClass().getName();
      if (sBlackList.contains(str)) {
        return false;
      }
      bool1 = bool2;
      if (initReflection())
      {
        bool1 = bool2;
        if (((Boolean)ViewGroupDrawingCompat.MethodHolder.access$100().invoke(paramViewGroup, new Object[0])).booleanValue()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void preload()
  {
    ThreadUtils.execTask(new ViewGroupDrawingCompat.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat
 * JD-Core Version:    0.7.0.1
 */