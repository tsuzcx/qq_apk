package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class AccessibilityUtil
{
  @TargetApi(14)
  public static void changeAccessibilityForView(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new AccessibilityUtil.1(paramCharSequence, paramString));
    }
  }
  
  public static void changeAccessibilityForView(View paramView, String paramString)
  {
    changeAccessibilityForView(paramView, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */