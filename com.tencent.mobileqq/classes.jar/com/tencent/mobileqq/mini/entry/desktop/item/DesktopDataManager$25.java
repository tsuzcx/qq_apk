package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.List;

class DesktopDataManager$25
  implements Runnable
{
  DesktopDataManager$25(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    DesktopAppInfo localDesktopAppInfo = new DesktopAppInfo(3, this.val$appInfo);
    int i = DesktopDataManager.access$3200(this.this$0);
    if (i == -1) {
      DesktopDataManager.access$1500(this.this$0).add(localDesktopAppInfo);
    }
    for (;;)
    {
      DesktopDataManager.access$1800(DesktopDataManager.access$1500(this.this$0));
      if (DesktopDataManager.access$1400(this.this$0) != null) {
        DesktopDataManager.access$1400(this.this$0).onDataChanged();
      }
      return;
      DesktopDataManager.access$1500(this.this$0).add(i, localDesktopAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.25
 * JD-Core Version:    0.7.0.1
 */