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
    QLog.d("DtSdkInitStep", 1, "848QQDT [ignoreAppEvent] activity: " + paramActivity.toString());
    return paramActivity instanceof QQLSActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep.1
 * JD-Core Version:    0.7.0.1
 */