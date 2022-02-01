package com.tencent.mobileqq.litelivesdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class KeyboardUtil
{
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getCurrentFocus() != null) && (paramActivity.getWindow().getCurrentFocus().getWindowToken() != null)) {
      a(paramActivity, paramActivity.getWindow().getCurrentFocus().getWindowToken());
    }
  }
  
  public static void a(Context paramContext, IBinder paramIBinder)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 0);
  }
  
  public static void a(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInputFromWindow(paramEditText.getWindowToken(), 0, 0);
  }
  
  public static void b(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.KeyboardUtil
 * JD-Core Version:    0.7.0.1
 */