package com.tencent.mobileqq.mini.entry.desktop.item;

import java.util.List;

class DesktopDataManager$6
  implements Runnable
{
  DesktopDataManager$6(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    DesktopDataManager.access$1600(this.this$0, this.val$moduleInfos);
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.6
 * JD-Core Version:    0.7.0.1
 */