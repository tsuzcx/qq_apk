package com.tencent.mobileqq.mini.report;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.qphone.base.util.QLog;

final class MiniAppReportManager$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPaused ");
      localStringBuilder.append(paramActivity.getClass().getSimpleName());
      QLog.i("MiniAppReportManager", 2, localStringBuilder.toString());
    }
    if ((paramActivity instanceof MiniChatActivity)) {
      MiniAppReportManager.access$000(true);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed ");
      localStringBuilder.append(paramActivity.getClass().getSimpleName());
      QLog.i("MiniAppReportManager", 2, localStringBuilder.toString());
    }
    if (((paramActivity instanceof MiniChatActivity)) || ((paramActivity instanceof PublicTransFragmentActivity))) {
      MiniAppReportManager.access$000(false);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStopped ");
      localStringBuilder.append(paramActivity.getClass().getSimpleName());
      QLog.i("MiniAppReportManager", 2, localStringBuilder.toString());
    }
    if ((paramActivity instanceof PublicTransFragmentActivity)) {
      MiniAppReportManager.access$000(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.1
 * JD-Core Version:    0.7.0.1
 */