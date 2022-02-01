package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class DesktopDataManager$14
  implements Runnable
{
  DesktopDataManager$14(MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)localAppRuntime.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
      if (localDesktopDataManager != null) {
        DesktopDataManager.access$2500(localDesktopDataManager, this.val$appInfo);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordMiniAppStart, appInfo = ");
      localStringBuilder.append(this.val$appInfo);
      localStringBuilder.append(", appRuntime = ");
      localStringBuilder.append(localAppRuntime);
      localStringBuilder.append("， manager = ");
      localStringBuilder.append(localDesktopDataManager);
      QLog.d("DesktopDataManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.14
 * JD-Core Version:    0.7.0.1
 */