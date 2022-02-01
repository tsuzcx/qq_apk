package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DesktopDataManager$16$1
  implements Runnable
{
  DesktopDataManager$16$1(DesktopDataManager.16 param16, List paramList, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (DesktopDataManager.access$1600(this.this$1.this$0).size() <= 0)
    {
      DesktopDataManager.access$1600(this.this$1.this$0).addAll(this.val$backupList);
      MiniAppUtils.updateMiniAppList(2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("useLocalDataIfRequestFailed, ");
      localStringBuilder.append(this.val$sb.toString());
      QLog.e("DesktopDataManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16.1
 * JD-Core Version:    0.7.0.1
 */