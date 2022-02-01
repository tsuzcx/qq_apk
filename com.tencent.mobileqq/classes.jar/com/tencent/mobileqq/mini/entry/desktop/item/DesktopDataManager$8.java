package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$8
  implements Runnable
{
  DesktopDataManager$8(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    INTERFACE.StModuleInfo localStModuleInfo;
    ArrayList localArrayList;
    int j;
    int i;
    label119:
    Object localObject1;
    if ((this.val$moduleInfos != null) && (this.val$moduleInfos.size() > 0))
    {
      Iterator localIterator1 = this.val$moduleInfos.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localStModuleInfo = (INTERFACE.StModuleInfo)localIterator1.next();
          if ((localStModuleInfo != null) && (localStModuleInfo.moduleType.get() == 1) && (localStModuleInfo.userAppList.get() != null) && (localStModuleInfo.userAppList.get().size() > 0))
          {
            localArrayList = new ArrayList();
            j = -1;
            i = DesktopDataManager.access$1600(this.this$0).size() - 1;
            if (i >= 0)
            {
              localObject1 = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
              if ((((DesktopItemInfo)localObject1).mModuleType == 1) && ((localObject1 instanceof DesktopAppInfo))) {
                localArrayList.add(0, (DesktopAppInfo)localObject1);
              }
              if ((((DesktopItemInfo)localObject1).mModuleType != 1) || (j >= 0)) {
                break label396;
              }
              j = i;
            }
          }
        }
      }
    }
    label394:
    label396:
    for (;;)
    {
      i -= 1;
      break label119;
      if (j < 0) {
        break;
      }
      localObject1 = new ArrayList();
      Iterator localIterator2 = localStModuleInfo.userAppList.get().iterator();
      for (;;)
      {
        label221:
        Object localObject2;
        if (localIterator2.hasNext())
        {
          localObject2 = (INTERFACE.StUserAppInfo)localIterator2.next();
          localObject2 = new DesktopAppInfo(localStModuleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject2));
          Iterator localIterator3 = localArrayList.iterator();
          DesktopAppInfo localDesktopAppInfo;
          do
          {
            if (!localIterator3.hasNext()) {
              break;
            }
            localDesktopAppInfo = (DesktopAppInfo)localIterator3.next();
          } while ((localDesktopAppInfo.mMiniAppInfo == null) || (((DesktopAppInfo)localObject2).mMiniAppInfo == null) || (!localDesktopAppInfo.mMiniAppInfo.equals(((DesktopAppInfo)localObject2).mMiniAppInfo)));
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label394;
          }
          ((List)localObject1).add(localObject2);
          break label221;
          DesktopDataManager.access$1600(this.this$0).addAll(j + 1, (Collection)localObject1);
          break;
          if (DesktopDataManager.access$1500(this.this$0) != null) {
            DesktopDataManager.access$1500(this.this$0).onDataChanged();
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.8
 * JD-Core Version:    0.7.0.1
 */