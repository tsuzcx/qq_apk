package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;

final class DtSdkInitStep$1
  implements IDetectionInterceptor
{
  public boolean ignoreAppEvent(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("848QQDT [ignoreAppEvent] activity: ");
    localStringBuilder.append(paramActivity.toString());
    QLog.d("DtSdkInitStep", 1, localStringBuilder.toString());
    return paramActivity instanceof QQLSActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep.1
 * JD-Core Version:    0.7.0.1
 */