package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$14$1
  implements Runnable
{
  DesktopDataManager$14$1(DesktopDataManager.14 param14, List paramList) {}
  
  public void run()
  {
    if ((this.val$appInfoList.size() > 0) && ((DesktopDataManager.access$1600(this.this$1.this$0) == null) || (DesktopDataManager.access$1600(this.this$1.this$0).size() == 0)))
    {
      DesktopDataManager.access$1602(this.this$1.this$0, new ArrayList(this.val$appInfoList));
      MiniAppUtils.updateMiniAppList(2);
    }
    while ((DesktopDataManager.access$1600(this.this$1.this$0) != null) && (DesktopDataManager.access$1600(this.this$1.this$0).size() != 0)) {
      return;
    }
    DesktopDataManager.access$2700(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.14.1
 * JD-Core Version:    0.7.0.1
 */