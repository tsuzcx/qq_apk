package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$15$1
  implements Runnable
{
  DesktopDataManager$15$1(DesktopDataManager.15 param15, List paramList) {}
  
  public void run()
  {
    if ((this.val$appInfoList.size() > 0) && ((DesktopDataManager.access$1600(this.this$1.this$0) == null) || (DesktopDataManager.access$1600(this.this$1.this$0).size() == 0)))
    {
      DesktopDataManager.access$1602(this.this$1.this$0, new ArrayList(this.val$appInfoList));
      MiniAppUtils.updateMiniAppList(2);
      return;
    }
    if ((DesktopDataManager.access$1600(this.this$1.this$0) == null) || (DesktopDataManager.access$1600(this.this$1.this$0).size() == 0)) {
      DesktopDataManager.access$2700(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.15.1
 * JD-Core Version:    0.7.0.1
 */