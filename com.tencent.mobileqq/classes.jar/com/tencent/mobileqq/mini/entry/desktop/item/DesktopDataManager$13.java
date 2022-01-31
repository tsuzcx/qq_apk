package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class DesktopDataManager$13
  implements Runnable
{
  DesktopDataManager$13(MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)localAppRuntime.getManager(336);
      if (localDesktopDataManager != null) {
        DesktopDataManager.access$2500(localDesktopDataManager, this.val$appInfo);
      }
      QLog.d("DesktopDataManager", 1, "recordMiniAppStart, appInfo = " + this.val$appInfo + ", appRuntime = " + localAppRuntime + "， manager = " + localDesktopDataManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.13
 * JD-Core Version:    0.7.0.1
 */