package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$9
  implements Runnable
{
  DesktopDataManager$9(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    QLog.d("DesktopDataManager", 1, "updateCardModuleInfo");
    if ((this.val$moduleInfos == null) || (this.val$moduleInfos.size() <= 0)) {
      QLog.e("DesktopDataManager", 1, "updateCardModuleInfo, moduleInfos is null.");
    }
    label381:
    do
    {
      do
      {
        return;
      } while (DesktopDataManager.access$1600(this.this$0).size() <= 0);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.val$moduleInfos.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (INTERFACE.StModuleInfo)((Iterator)localObject2).next();
        if (localObject3 != null) {
          if (((INTERFACE.StModuleInfo)localObject3).moduleType.get() == 6)
          {
            localObject4 = new DesktopPopularModuleInfo(6);
            ((DesktopPopularModuleInfo)localObject4).mergePbData((INTERFACE.StModuleInfo)localObject3);
            ((List)localObject1).add(localObject4);
          }
          else if (((INTERFACE.StModuleInfo)localObject3).moduleType.get() == 4)
          {
            ((List)localObject1).add(new DesktopRecommendModuleInfo(4, (INTERFACE.StModuleInfo)localObject3));
          }
          else if (((INTERFACE.StModuleInfo)localObject3).moduleType.get() == 7)
          {
            localObject4 = new DesktopDittoInfo(7);
            ((DesktopDittoInfo)localObject4).mergePbData((INTERFACE.StModuleInfo)localObject3);
            ((List)localObject1).add(localObject4);
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
        int i;
        if (((DesktopItemInfo)localObject2).getModuleType() == 7)
        {
          localObject3 = (DesktopDittoInfo)localObject2;
          i = DesktopDataManager.access$1600(this.this$0).size() - 1;
          for (;;)
          {
            if (i < 0) {
              break label381;
            }
            localObject4 = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
            if ((((DesktopItemInfo)localObject4).getModuleType() == 7) && (((DesktopDittoInfo)localObject4).subType == ((DesktopDittoInfo)localObject3).subType))
            {
              DesktopDataManager.access$1600(this.this$0).remove(i);
              DesktopDataManager.access$1600(this.this$0).add(i, localObject3);
              QLog.d("DesktopDataManager", 1, "updateCardModuleInfo, update ditto " + localObject2.toString());
              break;
            }
            i -= 1;
          }
        }
        else
        {
          i = DesktopDataManager.access$1600(this.this$0).size() - 1;
          for (;;)
          {
            if (i < 0) {
              break label464;
            }
            if (((DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i)).getModuleType() == ((DesktopItemInfo)localObject2).getModuleType())
            {
              DesktopDataManager.access$1600(this.this$0).remove(i);
              DesktopDataManager.access$1600(this.this$0).add(i, localObject2);
              break;
            }
            i -= 1;
          }
        }
      }
    } while (DesktopDataManager.access$1500(this.this$0) == null);
    label464:
    DesktopDataManager.access$1500(this.this$0).onDataChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.9
 * JD-Core Version:    0.7.0.1
 */