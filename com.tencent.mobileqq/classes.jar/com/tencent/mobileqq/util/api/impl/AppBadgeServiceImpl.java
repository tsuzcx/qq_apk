package com.tencent.mobileqq.util.api.impl;

import com.tencent.mobileqq.app.RefreshBadgeHelper;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import mqq.app.AppRuntime;

public class AppBadgeServiceImpl
  implements IAppBadgeService
{
  private static final String TAG = "AppBadgeServiceImpl";
  RefreshBadgeHelper badgeHelper;
  private AppRuntime mAppRuntime;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    this.badgeHelper = new RefreshBadgeHelper(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    RefreshBadgeHelper localRefreshBadgeHelper = this.badgeHelper;
    if (localRefreshBadgeHelper != null) {
      localRefreshBadgeHelper.a(true);
    }
  }
  
  public void refreshAppBadge()
  {
    if (((this.mAppRuntime.isBackgroundPause) || (this.mAppRuntime.isBackgroundStop)) && (BadgeUtils.a(this.mAppRuntime.getApplicationContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppBadgeServiceImpl", 2, "refreshAppBadge");
      }
      this.badgeHelper.a();
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAppBadge fail cause isBackground_Pause = ");
      localStringBuilder.append(this.mAppRuntime.isBackgroundPause);
      localStringBuilder.append(", isBackground_Stop = ");
      localStringBuilder.append(this.mAppRuntime.isBackgroundStop);
      localStringBuilder.append(", isSupportBadge + ");
      localStringBuilder.append(BadgeUtils.a(this.mAppRuntime.getApplicationContext()));
      QLog.d("AppBadgeServiceImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.api.impl.AppBadgeServiceImpl
 * JD-Core Version:    0.7.0.1
 */