package com.tencent.mobileqq.qwallet.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlymeOSStatusBarFontUtils
{
  private static int jdField_a_of_type_Int;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Method b;
  
  static
  {
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Integer.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      localNoSuchMethodException1.printStackTrace();
    }
    try
    {
      b = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      localNoSuchMethodException2.printStackTrace();
    }
    try
    {
      jdField_a_of_type_JavaLangReflectField = WindowManager.LayoutParams.class.getField("statusBarColor");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      localNoSuchFieldException1.printStackTrace();
    }
    try
    {
      jdField_a_of_type_Int = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      localNoSuchFieldException2.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    a(paramActivity, paramBoolean, true);
  }
  
  private static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    Method localMethod = b;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramActivity, new Object[] { Boolean.valueOf(paramBoolean1) });
        return;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    if (paramBoolean2) {
      a(paramActivity.getWindow(), paramBoolean1);
    }
  }
  
  private static void a(View paramView, boolean paramBoolean)
  {
    int j = paramView.getSystemUiVisibility();
    int i;
    if (paramBoolean) {
      i = jdField_a_of_type_Int | j;
    } else {
      i = (jdField_a_of_type_Int ^ 0xFFFFFFFF) & j;
    }
    if (i != j) {
      paramView.setSystemUiVisibility(i);
    }
  }
  
  private static void a(Window paramWindow, int paramInt)
  {
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    Field localField = jdField_a_of_type_JavaLangReflectField;
    if (localField != null) {
      try
      {
        if (localField.getInt(localLayoutParams) != paramInt)
        {
          jdField_a_of_type_JavaLangReflectField.set(localLayoutParams, Integer.valueOf(paramInt));
          paramWindow.setAttributes(localLayoutParams);
          return;
        }
      }
      catch (IllegalAccessException paramWindow)
      {
        paramWindow.printStackTrace();
      }
    }
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      a(paramWindow.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", paramBoolean);
      return;
    }
    View localView = paramWindow.getDecorView();
    if (localView != null)
    {
      a(localView, paramBoolean);
      a(paramWindow, 0);
    }
  }
  
  private static boolean a(WindowManager.LayoutParams paramLayoutParams, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      try
      {
        paramString = paramLayoutParams.getClass().getDeclaredField(paramString);
        paramString.setAccessible(true);
        i = paramString.getInt(paramLayoutParams);
        paramString = paramLayoutParams.getClass().getDeclaredField("meizuFlags");
        paramString.setAccessible(true);
        j = paramString.getInt(paramLayoutParams);
        if (!paramBoolean) {
          break label99;
        }
        i |= j;
        if (j != i)
        {
          paramString.setInt(paramLayoutParams, i);
          return true;
        }
      }
      catch (Throwable paramLayoutParams)
      {
        paramLayoutParams.printStackTrace();
      }
      catch (IllegalArgumentException paramLayoutParams)
      {
        paramLayoutParams.printStackTrace();
      }
      catch (IllegalAccessException paramLayoutParams)
      {
        paramLayoutParams.printStackTrace();
      }
      catch (NoSuchFieldException paramLayoutParams)
      {
        paramLayoutParams.printStackTrace();
      }
      return false;
      label99:
      int i = (i ^ 0xFFFFFFFF) & j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils
 * JD-Core Version:    0.7.0.1
 */