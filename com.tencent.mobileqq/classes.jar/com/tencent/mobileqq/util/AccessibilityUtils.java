package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class AccessibilityUtils
{
  @TargetApi(16)
  public static boolean a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16384);
      localAccessibilityEvent.setPackageName(paramView.getContext().getPackageName());
      localAccessibilityEvent.setClassName(paramView.getClass().getName());
      localAccessibilityEvent.setSource(paramView);
      localAccessibilityEvent.getText().add(paramString);
      paramView.getParent().requestSendAccessibilityEvent(paramView, localAccessibilityEvent);
    }
    else
    {
      QQTextToSpeechHelper.a(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.AccessibilityUtils
 * JD-Core Version:    0.7.0.1
 */