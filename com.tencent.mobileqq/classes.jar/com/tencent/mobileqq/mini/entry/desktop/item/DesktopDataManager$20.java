package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import auko;
import aukp;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$20
  implements Runnable
{
  DesktopDataManager$20(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
    }
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        return;
        localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      } while (localObject1 == null);
      localStringBuilder = new StringBuilder();
      Iterator localIterator = this.val$moduleInfoList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (INTERFACE.StModuleInfo)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = new DesktopCardEntity((INTERFACE.StModuleInfo)localObject2);
          ((DesktopCardEntity)localObject2).setStatus(1000);
          DesktopDataManager.access$3100(this.this$0, (aukp)localObject1, (auko)localObject2);
          localStringBuilder.append(((DesktopCardEntity)localObject2).moduleType).append(":").append(((DesktopCardEntity)localObject2).title).append(", ");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DesktopDataManager", 2, new Object[] { "saveCardModuleData : ", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.20
 * JD-Core Version:    0.7.0.1
 */