package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class WebViewUIUtils
{
  public static void a(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 28) && (paramActivity != null))
    {
      paramActivity = paramActivity.getWindow();
      WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      paramActivity.setAttributes(localLayoutParams);
    }
  }
  
  public static void a(Activity paramActivity, ClassCastException paramClassCastException)
  {
    QLog.e("WebViewUIUtils", 1, Log.getStackTraceString(paramClassCastException.getCause()));
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      a(paramActivity, "mStatusColorViewState");
      a(paramActivity, "mNavigationColorViewState");
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("WebViewUIUtils", 1, "dumpViewInError ", paramActivity);
    }
  }
  
  private static void a(View paramView, String paramString)
  {
    Object localObject = paramView.getClass().getDeclaredField(paramString);
    if (localObject == null)
    {
      QLog.e("WebViewUIUtils", 1, new Object[] { paramString, " field is null" });
      return;
    }
    ((Field)localObject).setAccessible(true);
    paramView = ((Field)localObject).get(paramView);
    if (paramView == null)
    {
      QLog.e("WebViewUIUtils", 1, new Object[] { paramString, " statusAttri is null" });
      return;
    }
    localObject = paramView.getClass().getDeclaredField("view");
    if (localObject == null)
    {
      QLog.e("WebViewUIUtils", 1, new Object[] { paramString, " viewField is null" });
      return;
    }
    ((Field)localObject).setAccessible(true);
    paramView = (View)((Field)localObject).get(paramView);
    if (paramView != null)
    {
      localObject = new StringBuilder(100);
      a(paramView, (StringBuilder)localObject);
      QLog.e("WebViewUIUtils", 1, new Object[] { paramString, ((StringBuilder)localObject).toString() });
      return;
    }
    QLog.d("WebViewUIUtils", 1, new Object[] { paramString, " viewFromState is null" });
  }
  
  private static void a(View paramView, StringBuilder paramStringBuilder)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        if ((localViewGroup.getChildAt(i) instanceof ViewGroup))
        {
          a(paramView, paramStringBuilder);
        }
        else
        {
          paramStringBuilder.append("view:");
          paramStringBuilder.append(paramView.getClass().getSimpleName());
          paramStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    paramStringBuilder.append("view:");
    paramStringBuilder.append(paramView.getClass().getSimpleName());
    paramStringBuilder.append("\n");
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public static void c(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewUIUtils
 * JD-Core Version:    0.7.0.1
 */