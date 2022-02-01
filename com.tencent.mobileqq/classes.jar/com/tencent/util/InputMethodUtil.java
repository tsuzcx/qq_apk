package com.tencent.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qphone.base.util.QLog;

public class InputMethodUtil
{
  public static void a(Activity paramActivity)
  {
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager.isActive())
      {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      if (QLog.isDevelopLevel()) {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static void a(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "default_input_method");
      return (paramContext != null) && ((paramContext.contains("com.sohu.inputmethod.sogou")) || (paramContext.contains("com.tencent.qqpinyin")) || (paramContext.contains("com.sogou.zhuyininput")));
    }
    catch (NullPointerException paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSogouInputDefault(), e = ");
        localStringBuilder.append(paramContext.getStackTrace());
        QLog.d("InputMethodUtil", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.InputMethodUtil
 * JD-Core Version:    0.7.0.1
 */