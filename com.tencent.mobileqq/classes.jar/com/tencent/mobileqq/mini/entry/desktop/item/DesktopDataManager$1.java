package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$1
  implements Runnable
{
  DesktopDataManager$1(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    QLog.d("DesktopDataManager", 2, "registerObserver");
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.addObserver(DesktopDataManager.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.1
 * JD-Core Version:    0.7.0.1
 */