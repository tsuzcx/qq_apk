package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DesktopDataManager$12
  implements Runnable
{
  DesktopDataManager$12(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    DesktopDataManager.access$1600(this.this$0).clear();
    QLog.e("DesktopDataManager", 1, "handleEmptyModuleInStudyMode, desktopItemInfos is null.");
    if (DesktopDataManager.access$1500(this.this$0) != null)
    {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
      QLog.d("DesktopDataManager", 1, "handleEmptyModuleInStudyMode, convertData complete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.12
 * JD-Core Version:    0.7.0.1
 */