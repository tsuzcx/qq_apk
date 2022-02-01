package com.tencent.mobileqq.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

final class BusinessUtils$1
  implements Runnable
{
  BusinessUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.mLoginTime = NetConnInfoCenter.getServerTime();
    RecentDataListManager.a().a(this.a, BaseApplicationImpl.sApplication, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.BusinessUtils.1
 * JD-Core Version:    0.7.0.1
 */