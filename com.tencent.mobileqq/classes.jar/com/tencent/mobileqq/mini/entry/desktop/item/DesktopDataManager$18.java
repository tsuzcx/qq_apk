package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$18
  implements Runnable
{
  DesktopDataManager$18(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if ((this.val$miniAppInfo != null) && (DesktopDataManager.access$1600(this.this$0) != null)) {
      switch (this.val$miniAppInfo.topType)
      {
      }
    }
    label241:
    for (;;)
    {
      DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
      if (DesktopDataManager.access$1500(this.this$0) != null) {
        DesktopDataManager.access$1500(this.this$0).onDataChanged();
      }
      return;
      Object localObject = DesktopDataManager.access$1600(this.this$0).iterator();
      DesktopItemInfo localDesktopItemInfo;
      while (((Iterator)localObject).hasNext())
      {
        localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
        if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (localDesktopItemInfo.getModuleType() == 3) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.equals(this.val$miniAppInfo))) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = new DesktopAppInfo(3, this.val$miniAppInfo);
      int i = 0;
      for (;;)
      {
        if (i >= DesktopDataManager.access$1600(this.this$0).size()) {
          break label241;
        }
        localDesktopItemInfo = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
        if (((localDesktopItemInfo instanceof DesktopAppModuleInfo)) && (localDesktopItemInfo.getModuleType() == 3))
        {
          DesktopDataManager.access$1600(this.this$0).add(i + 1, localObject);
          break;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.18
 * JD-Core Version:    0.7.0.1
 */