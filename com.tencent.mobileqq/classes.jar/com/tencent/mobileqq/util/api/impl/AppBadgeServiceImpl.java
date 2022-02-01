package com.tencent.mobileqq.util.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import mqq.app.AppRuntime;

public class AppBadgeServiceImpl
  implements IAppBadgeService
{
  private AppRuntime mAppRuntime;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void refreshAppBadge()
  {
    if ((this.mAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)this.mAppRuntime).refreshAppBadge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.api.impl.AppBadgeServiceImpl
 * JD-Core Version:    0.7.0.1
 */