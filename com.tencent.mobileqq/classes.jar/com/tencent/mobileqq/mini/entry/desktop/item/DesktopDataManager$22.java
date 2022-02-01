package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DesktopDataManager$22
  implements Runnable
{
  DesktopDataManager$22(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    QLog.d("DesktopDataManager-Recommend", 2, "clearRecommendExposureList");
    if (DesktopDataManager.access$1700(this.this$0) != null) {
      DesktopDataManager.access$1700(this.this$0).clear();
    }
    DesktopDataManager.access$1800(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.22
 * JD-Core Version:    0.7.0.1
 */