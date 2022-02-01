package com.tencent.mobileqq.mini.entry.desktop.item;

class DesktopDataManager$36
  implements Runnable
{
  DesktopDataManager$36(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    DesktopDataManager localDesktopDataManager = this.this$0;
    DesktopDataManager.access$3700(localDesktopDataManager, DesktopDataManager.access$1600(localDesktopDataManager), DesktopDataManager.access$3600(this.this$0));
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.36
 * JD-Core Version:    0.7.0.1
 */