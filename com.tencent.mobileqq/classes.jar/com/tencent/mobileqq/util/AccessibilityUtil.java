package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class AccessibilityUtil
{
  @TargetApi(14)
  public static void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
        bool1 = paramContext.isEnabled();
        boolean bool2 = paramContext.isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.d = bool1;
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("setTalkbackSwitch: ");
            paramContext.append(AppSetting.d);
            QLog.d("AccessibilityUtil", 2, paramContext.toString());
          }
          return;
        }
      }
      catch (Throwable paramContext)
      {
        return;
      }
      boolean bool1 = false;
    }
  }
  
  @TargetApi(14)
  public static void a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "requestFocus view can't be null");
      }
      return;
    }
    paramView.postDelayed(new AccessibilityUtil.3(paramView), 200L);
  }
  
  public static void a(View paramView, AccessibilityUtil.ViewOnClickListener paramViewOnClickListener)
  {
    paramView.setAccessibilityDelegate(new AccessibilityUtil.5(paramViewOnClickListener));
  }
  
  @TargetApi(14)
  public static void a(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new AccessibilityUtil.7(paramCharSequence, paramString));
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.d) {
      paramView.setContentDescription(paramString);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16))
    {
      if (paramBoolean)
      {
        ViewCompat.setImportantForAccessibility(paramView, 1);
        return;
      }
      ViewCompat.setImportantForAccessibility(paramView, 2);
    }
  }
  
  @TargetApi(14)
  public static void a(EditText paramEditText, String paramString)
  {
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 14))
    {
      paramEditText.setContentDescription(paramString);
      paramEditText.setAccessibilityDelegate(new AccessibilityUtil.1());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return ((AccessibilityManager)paramContext.getSystemService("accessibility")).isEnabled();
  }
  
  @TargetApi(16)
  public static void b(View paramView)
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    if ((localAccessibilityManager != null) && (Build.VERSION.SDK_INT >= 14) && (localAccessibilityManager.isEnabled()))
    {
      paramView.setFocusable(true);
      paramView.setAccessibilityDelegate(new AccessibilityUtil.4());
    }
  }
  
  public static void b(View paramView, String paramString)
  {
    a(paramView, null, paramString);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        b(localViewGroup.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    if (paramBoolean)
    {
      ViewCompat.setImportantForAccessibility(paramView, 1);
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  @TargetApi(16)
  public static void c(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "clearFocus view can't be null");
      }
      return;
    }
    if ((AppSetting.d) && (Build.VERSION.SDK_INT > 15))
    {
      Object localObject1 = paramView.getClass().getMethods();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.getName().equals("clearAccessibilityFocus"))
        {
          try
          {
            localObject2.invoke(paramView, new Object[0]);
            return;
          }
          catch (Exception paramView)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("clearFocus: ");
          ((StringBuilder)localObject1).append(paramView.toString());
          QLog.w("AccessibilityUtil", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */