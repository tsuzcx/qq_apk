package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class AutoGoneRelativeLayout
  extends RelativeLayout
{
  public AutoGoneRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoGoneRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoGoneRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo()
  {
    boolean bool2 = false;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() called");
    }
    StackTraceElement[] arrayOfStackTraceElement;
    int k;
    int i;
    int j;
    if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER))
    {
      arrayOfStackTraceElement = new Throwable().getStackTrace();
      k = arrayOfStackTraceElement.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < k)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (QLog.isColorLevel()) {
          QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() i = [" + j + "], " + localStackTraceElement.toString());
        }
        j += 1;
        if (localStackTraceElement.getClassName().contains("AccessibilityInteractionController")) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() isFromAccessibilityService = [" + bool1 + "], cost time = [" + (SystemClock.uptimeMillis() - l) + "]");
        }
        if (bool1) {
          ScreenShotHelper.a((Activity)getContext());
        }
        return super.createAccessibilityNodeInfo();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.AutoGoneRelativeLayout
 * JD-Core Version:    0.7.0.1
 */