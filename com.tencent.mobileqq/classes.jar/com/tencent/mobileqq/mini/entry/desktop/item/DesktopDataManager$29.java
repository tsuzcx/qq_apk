package com.tencent.mobileqq.mini.entry.desktop.item;

import java.util.List;

class DesktopDataManager$29
  implements Runnable
{
  DesktopDataManager$29(DesktopDataManager paramDesktopDataManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = DesktopDataManager.access$3200(this.this$0);
    DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).remove(this.val$old_order + i);
    DesktopDataManager.access$1600(this.this$0).add(i + this.val$new_order, localDesktopItemInfo);
    DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.29
 * JD-Core Version:    0.7.0.1
 */