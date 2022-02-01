package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$11
  implements Runnable
{
  DesktopDataManager$11(DesktopDataManager paramDesktopDataManager, List paramList1, List paramList2) {}
  
  public void run()
  {
    DesktopDataManager.access$1700(this.this$0).clear();
    DesktopDataManager.access$1700(this.this$0).addAll(this.val$recommendExposureList);
    DesktopDataManager.access$1602(this.this$0, this.val$desktopItemInfos);
    if (DesktopDataManager.access$1500(this.this$0) != null)
    {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
      QLog.d("DesktopDataManager", 1, "updateData, convertData complete");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertData, size = ");
    localStringBuilder.append(DesktopDataManager.access$1600(this.this$0).size());
    localStringBuilder.append(", app List: ");
    localStringBuilder.append(DesktopDataManager.access$1600(this.this$0).toString());
    QLog.d("DesktopDataManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.11
 * JD-Core Version:    0.7.0.1
 */