package com.tencent.mobileqq.mini.entry.desktop.item;

class DesktopDataManager$35
  implements Runnable
{
  DesktopDataManager$35(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    DesktopDataManager localDesktopDataManager = this.this$0;
    DesktopDataManager.access$3500(localDesktopDataManager, DesktopDataManager.access$1600(localDesktopDataManager), DesktopDataManager.access$3400(this.this$0));
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.35
 * JD-Core Version:    0.7.0.1
 */