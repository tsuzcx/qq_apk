package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DesktopDataManager$15$1
  implements Runnable
{
  DesktopDataManager$15$1(DesktopDataManager.15 param15, List paramList, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (DesktopDataManager.access$1600(this.this$1.this$0).size() <= 0)
    {
      DesktopDataManager.access$1600(this.this$1.this$0).addAll(this.val$backupList);
      MiniAppUtils.updateMiniAppList(2);
      QLog.e("DesktopDataManager", 1, "useLocalDataIfRequestFailed, " + this.val$sb.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.15.1
 * JD-Core Version:    0.7.0.1
 */