package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$9
  implements Runnable
{
  DesktopDataManager$9(DesktopDataManager paramDesktopDataManager, List paramList1, List paramList2) {}
  
  public void run()
  {
    DesktopDataManager.access$1600(this.this$0).clear();
    DesktopDataManager.access$1600(this.this$0).addAll(this.val$recommendExposureList);
    DesktopDataManager.access$1502(this.this$0, this.val$desktopItemInfos);
    if (DesktopDataManager.access$1400(this.this$0) != null)
    {
      DesktopDataManager.access$1400(this.this$0).onDataChanged();
      QLog.d("DesktopDataManager", 1, "updateData, convertData complete");
    }
    QLog.d("DesktopDataManager", 1, "convertData, size = " + DesktopDataManager.access$1500(this.this$0).size() + ", app List: " + DesktopDataManager.access$1500(this.this$0).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.9
 * JD-Core Version:    0.7.0.1
 */