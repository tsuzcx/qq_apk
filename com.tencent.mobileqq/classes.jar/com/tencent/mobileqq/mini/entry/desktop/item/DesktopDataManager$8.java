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
    Object localObject1 = this.val$moduleInfos;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.val$moduleInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        INTERFACE.StModuleInfo localStModuleInfo = (INTERFACE.StModuleInfo)((Iterator)localObject1).next();
        if ((localStModuleInfo != null) && (localStModuleInfo.moduleType.get() == 1) && (localStModuleInfo.userAppList.get() != null) && (localStModuleInfo.userAppList.get().size() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          int i = DesktopDataManager.access$1600(this.this$0).size() - 1;
          Object localObject2;
          int k;
          for (int j = -1; i >= 0; j = k)
          {
            localObject2 = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
            if ((((DesktopItemInfo)localObject2).mModuleType == 1) && ((localObject2 instanceof DesktopAppInfo))) {
              localArrayList.add(0, (DesktopAppInfo)localObject2);
            }
            k = j;
            if (((DesktopItemInfo)localObject2).mModuleType == 1)
            {
              k = j;
              if (j < 0) {
                k = i;
              }
            }
            i -= 1;
          }
          if (j >= 0)
          {
            localObject2 = new ArrayList();
            Iterator localIterator1 = localStModuleInfo.userAppList.get().iterator();
            while (localIterator1.hasNext())
            {
              Object localObject3 = (INTERFACE.StUserAppInfo)localIterator1.next();
              localObject3 = new DesktopAppInfo(localStModuleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject3));
              Iterator localIterator2 = localArrayList.iterator();
              while (localIterator2.hasNext())
              {
                DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)localIterator2.next();
                if ((localDesktopAppInfo.mMiniAppInfo != null) && (((DesktopAppInfo)localObject3).mMiniAppInfo != null) && (localDesktopAppInfo.mMiniAppInfo.equals(((DesktopAppInfo)localObject3).mMiniAppInfo)))
                {
                  i = 1;
                  break label352;
                }
              }
              i = 0;
              label352:
              if (i == 0) {
                ((List)localObject2).add(localObject3);
              }
            }
            DesktopDataManager.access$1600(this.this$0).addAll(j + 1, (Collection)localObject2);
          }
        }
      }
    }
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.8
 * JD-Core Version:    0.7.0.1
 */