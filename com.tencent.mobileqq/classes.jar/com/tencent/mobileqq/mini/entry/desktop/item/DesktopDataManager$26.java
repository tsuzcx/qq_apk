package com.tencent.mobileqq.mini.entry.desktop.item;

import java.util.Iterator;
import java.util.List;

class DesktopDataManager$26
  implements Runnable
{
  DesktopDataManager$26(DesktopDataManager paramDesktopDataManager, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = DesktopDataManager.access$1600(this.this$0).iterator();
    while (localIterator.hasNext()) {
      if (((DesktopItemInfo)localIterator.next()).getModuleType() == this.val$type) {
        localIterator.remove();
      }
    }
    DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.26
 * JD-Core Version:    0.7.0.1
 */