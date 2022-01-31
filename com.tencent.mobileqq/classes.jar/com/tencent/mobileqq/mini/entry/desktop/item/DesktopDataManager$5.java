package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StSearchModuleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DesktopDataManager$5
  implements Runnable
{
  DesktopDataManager$5(DesktopDataManager paramDesktopDataManager, List paramList1, List paramList2, INTERFACE.StSearchModuleInfo paramStSearchModuleInfo, boolean paramBoolean) {}
  
  public void run()
  {
    DesktopDataManager.access$1302(this.this$0, DesktopDataManager.access$1400(this.this$0, this.val$fixApps, this.val$moduleInfos, this.val$searchModuleInfo));
    if ((this.val$notify) && (DesktopDataManager.access$1500(this.this$0) != null))
    {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
      QLog.d("DesktopDataManager", 1, "updateData, convertData complete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.5
 * JD-Core Version:    0.7.0.1
 */