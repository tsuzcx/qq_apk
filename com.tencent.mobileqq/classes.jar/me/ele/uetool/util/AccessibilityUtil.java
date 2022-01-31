package me.ele.uetool.util;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityUtil
{
  public static AccessibilityNodeInfoCompat createNodeInfoFromView(View paramView)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    ViewCompat.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
    return localAccessibilityNodeInfoCompat;
  }
  
  public static String getFocusableReasons(View paramView)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    try
    {
      boolean bool1 = hasText(localAccessibilityNodeInfoCompat);
      boolean bool2 = localAccessibilityNodeInfoCompat.isCheckable();
      boolean bool3 = hasNonActionableSpeakingDescendants(localAccessibilityNodeInfoCompat, paramView);
      if (isActionableForAccessibility(localAccessibilityNodeInfoCompat))
      {
        if (localAccessibilityNodeInfoCompat.getChildCount() <= 0) {
          return "View is actionable and has no children.";
        }
        if (bool1) {
          return "View is actionable and has a description.";
        }
        if (bool2) {
          return "View is actionable and checkable.";
        }
        if (bool3) {
          return "View is actionable and has non-actionable descendants with descriptions.";
        }
      }
      if (isTopLevelScrollItem(localAccessibilityNodeInfoCompat, paramView))
      {
        if (bool1) {
          return "View is a direct child of a scrollable container and has a description.";
        }
        if (bool2) {
          return "View is a direct child of a scrollable container and is checkable.";
        }
        if (bool3) {
          return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
        }
      }
      if (bool1) {
        return "View has a description and is not actionable, but has no actionable ancestor.";
      }
      return null;
    }
    finally
    {
      localAccessibilityNodeInfoCompat.recycle();
    }
  }
  
  public static boolean getIgnored(View paramView)
  {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if ((i == 2) || (i == 4)) {
      return true;
    }
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((ViewParent)localObject).getParent()) {
      if (ViewCompat.getImportantForAccessibility((View)localObject) == 4) {
        return true;
      }
    }
    localObject = createNodeInfoFromView(paramView);
    try
    {
      boolean bool = ((AccessibilityNodeInfoCompat)localObject).isVisibleToUser();
      if (!bool) {
        return true;
      }
      if (isAccessibilityFocusable((AccessibilityNodeInfoCompat)localObject, paramView))
      {
        i = ((AccessibilityNodeInfoCompat)localObject).getChildCount();
        if (i <= 0) {
          return false;
        }
        bool = isSpeakingNode((AccessibilityNodeInfoCompat)localObject, paramView);
        return !bool;
      }
      if (!hasFocusableAncestor((AccessibilityNodeInfoCompat)localObject, paramView))
      {
        bool = hasText((AccessibilityNodeInfoCompat)localObject);
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally
    {
      ((AccessibilityNodeInfoCompat)localObject).recycle();
    }
  }
  
  public static String getIgnoredReasons(View paramView)
  {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if (i == 2) {
      return "View has importantForAccessibility set to 'NO'.";
    }
    if (i == 4) {
      return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
    }
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((ViewParent)localObject).getParent()) {
      if (ViewCompat.getImportantForAccessibility((View)localObject) == 4) {
        return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
      }
    }
    localObject = createNodeInfoFromView(paramView);
    try
    {
      if (!((AccessibilityNodeInfoCompat)localObject).isVisibleToUser()) {
        return "View is not visible.";
      }
      if (isAccessibilityFocusable((AccessibilityNodeInfoCompat)localObject, paramView)) {
        return "View is actionable, but has no description.";
      }
      if (hasText((AccessibilityNodeInfoCompat)localObject)) {
        return "View is not actionable, and an ancestor View has co-opted its description.";
      }
      return "View is not actionable and has no description.";
    }
    finally
    {
      ((AccessibilityNodeInfoCompat)localObject).recycle();
    }
  }
  
  public static boolean hasFocusableAncestor(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {
      return false;
    }
    paramView = ViewCompat.getParentForAccessibility(paramView);
    if (!(paramView instanceof View)) {
      return false;
    }
    paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    try
    {
      ViewCompat.onInitializeAccessibilityNodeInfo((View)paramView, paramAccessibilityNodeInfoCompat);
      if (paramAccessibilityNodeInfoCompat == null) {
        return false;
      }
      boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, (View)paramView);
      if (bool) {
        return true;
      }
      bool = hasFocusableAncestor(paramAccessibilityNodeInfoCompat, (View)paramView);
      return bool;
    }
    finally
    {
      paramAccessibilityNodeInfoCompat.recycle();
    }
  }
  
  public static boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null) || (!(paramView instanceof ViewGroup))) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    label29:
    View localView;
    if (i < j)
    {
      localView = paramView.getChildAt(i);
      if (localView != null) {
        break label53;
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label53:
      paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
      try
      {
        ViewCompat.onInitializeAccessibilityNodeInfo(localView, paramAccessibilityNodeInfoCompat);
        boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, localView);
        if (bool)
        {
          paramAccessibilityNodeInfoCompat.recycle();
          continue;
        }
        bool = isSpeakingNode(paramAccessibilityNodeInfoCompat, localView);
        if (bool) {
          return true;
        }
        paramAccessibilityNodeInfoCompat.recycle();
      }
      finally
      {
        paramAccessibilityNodeInfoCompat.recycle();
      }
    }
  }
  
  public static boolean hasText(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramAccessibilityNodeInfoCompat == null) {}
    while ((TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getText())) && (TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getContentDescription()))) {
      return false;
    }
    return true;
  }
  
  public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    boolean bool = true;
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {}
    while (!paramAccessibilityNodeInfoCompat.isVisibleToUser()) {
      return false;
    }
    if (isActionableForAccessibility(paramAccessibilityNodeInfoCompat)) {
      return true;
    }
    if ((isTopLevelScrollItem(paramAccessibilityNodeInfoCompat, paramView)) && (isSpeakingNode(paramAccessibilityNodeInfoCompat, paramView))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramAccessibilityNodeInfoCompat == null) {}
    ArrayList localArrayList;
    do
    {
      for (;;)
      {
        return false;
        if ((paramAccessibilityNodeInfoCompat.isClickable()) || (paramAccessibilityNodeInfoCompat.isLongClickable()) || (paramAccessibilityNodeInfoCompat.isFocusable())) {
          return true;
        }
        localArrayList = new ArrayList();
        try
        {
          paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getActionList();
          if ((paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(16))) || (paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(32))) || (paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(1)))) {
            return true;
          }
        }
        finally {}
      }
    } while ((!localArrayList.contains(Integer.valueOf(16))) && (!localArrayList.contains(Integer.valueOf(32))) && (!localArrayList.contains(Integer.valueOf(1))));
    return true;
  }
  
  public static boolean isSpeakingNode(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (!paramAccessibilityNodeInfoCompat.isVisibleToUser());
      i = ViewCompat.getImportantForAccessibility(paramView);
    } while ((i == 4) || ((i == 2) && (paramAccessibilityNodeInfoCompat.getChildCount() <= 0)) || ((!paramAccessibilityNodeInfoCompat.isCheckable()) && (!hasText(paramAccessibilityNodeInfoCompat)) && (!hasNonActionableSpeakingDescendants(paramAccessibilityNodeInfoCompat, paramView))));
    return true;
  }
  
  public static boolean isTopLevelScrollItem(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView)
  {
    if ((paramAccessibilityNodeInfoCompat == null) || (paramView == null)) {
      return false;
    }
    paramView = (View)ViewCompat.getParentForAccessibility(paramView);
    if (paramView == null) {
      return false;
    }
    if (paramAccessibilityNodeInfoCompat.isScrollable()) {
      return true;
    }
    try
    {
      paramAccessibilityNodeInfoCompat = paramAccessibilityNodeInfoCompat.getActionList();
      if ((!paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(4096))) && (!paramAccessibilityNodeInfoCompat.contains(Integer.valueOf(8192))))
      {
        if ((paramView instanceof Spinner)) {
          return false;
        }
        if ((!(paramView instanceof AdapterView)) && (!(paramView instanceof ScrollView)))
        {
          boolean bool = paramView instanceof HorizontalScrollView;
          if (!bool) {}
        }
      }
    }
    finally
    {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.util.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */