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
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AutoGoneRelativeLayout", 2, "createAccessibilityNodeInfo() called");
    }
    if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER))
    {
      Object localObject1 = new Throwable().getStackTrace();
      int k = localObject1.length;
      boolean bool2 = false;
      int i = 0;
      int j = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= k) {
          break;
        }
        Object localObject2 = localObject1[i];
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createAccessibilityNodeInfo() i = [");
          localStringBuilder.append(j);
          localStringBuilder.append("], ");
          localStringBuilder.append(localObject2.toString());
          QLog.d("AutoGoneRelativeLayout", 2, localStringBuilder.toString());
        }
        j += 1;
        if (localObject2.getClassName().contains("AccessibilityInteractionController"))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createAccessibilityNodeInfo() isFromAccessibilityService = [");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append("], cost time = [");
        ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l);
        ((StringBuilder)localObject1).append("]");
        QLog.d("AutoGoneRelativeLayout", 2, ((StringBuilder)localObject1).toString());
      }
      if (bool1) {
        ScreenShotHelper.a((Activity)getContext());
      }
    }
    return super.createAccessibilityNodeInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.AutoGoneRelativeLayout
 * JD-Core Version:    0.7.0.1
 */