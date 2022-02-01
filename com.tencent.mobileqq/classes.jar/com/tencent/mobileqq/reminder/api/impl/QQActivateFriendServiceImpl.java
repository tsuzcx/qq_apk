package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQActivateFriendServiceImpl
  implements IQQActivateFriendService
{
  public static final String TAG = "QQActivateFriendServiceImpl";
  private AppRuntime mApp;
  
  public boolean getSwitchValue(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((ActivateFriendsManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQActivateFriendServiceImpl", 2, "getSwitchValue app not QQAppInterface");
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void setSwtichValue(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((ActivateFriendsManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQActivateFriendServiceImpl
 * JD-Core Version:    0.7.0.1
 */