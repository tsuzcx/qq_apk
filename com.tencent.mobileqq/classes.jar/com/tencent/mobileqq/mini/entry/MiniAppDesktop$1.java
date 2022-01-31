package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;

class MiniAppDesktop$1
  implements Runnable
{
  MiniAppDesktop$1(MiniAppDesktop paramMiniAppDesktop) {}
  
  public void run()
  {
    MiniAppDesktop.access$000(this.this$0);
    DesktopDataManager localDesktopDataManager = (DesktopDataManager)MiniAppDesktop.access$100(this.this$0).getManager(336);
    if (localDesktopDataManager != null) {
      localDesktopDataManager.initLocalCacheData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.1
 * JD-Core Version:    0.7.0.1
 */