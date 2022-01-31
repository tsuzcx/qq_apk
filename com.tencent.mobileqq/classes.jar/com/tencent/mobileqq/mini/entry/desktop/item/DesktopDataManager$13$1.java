package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$13$1
  implements Runnable
{
  DesktopDataManager$13$1(DesktopDataManager.13 param13, List paramList) {}
  
  public void run()
  {
    if ((this.val$appInfoList.size() > 0) && ((DesktopDataManager.access$1500(this.this$1.this$0) == null) || (DesktopDataManager.access$1500(this.this$1.this$0).size() == 0)))
    {
      DesktopDataManager.access$1502(this.this$1.this$0, new ArrayList(this.val$appInfoList));
      MiniAppUtils.updateMiniAppList(2);
    }
    while ((DesktopDataManager.access$1500(this.this$1.this$0) != null) && (DesktopDataManager.access$1500(this.this$1.this$0).size() != 0)) {
      return;
    }
    DesktopDataManager.access$2600(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.13.1
 * JD-Core Version:    0.7.0.1
 */