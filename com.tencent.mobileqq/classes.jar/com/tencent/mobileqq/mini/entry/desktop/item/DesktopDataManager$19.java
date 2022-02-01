package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$19
  implements Runnable
{
  DesktopDataManager$19(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if ((this.val$miniAppInfo != null) && (DesktopDataManager.access$1600(this.this$0) != null))
    {
      int i = this.val$miniAppInfo.topType;
      Object localObject;
      DesktopItemInfo localDesktopItemInfo;
      if (i != 0)
      {
        if (i == 1)
        {
          localObject = new DesktopAppInfo(3, this.val$miniAppInfo);
          i = 0;
          while (i < DesktopDataManager.access$1600(this.this$0).size())
          {
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
      else
      {
        localObject = DesktopDataManager.access$1600(this.this$0).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject).next();
          if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (localDesktopItemInfo.getModuleType() == 3) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.equals(this.val$miniAppInfo))) {
            ((Iterator)localObject).remove();
          }
        }
      }
      DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
      if (DesktopDataManager.access$1500(this.this$0) != null) {
        DesktopDataManager.access$1500(this.this$0).onDataChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.19
 * JD-Core Version:    0.7.0.1
 */