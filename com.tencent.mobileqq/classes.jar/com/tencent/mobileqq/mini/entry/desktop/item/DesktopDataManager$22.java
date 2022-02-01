package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$22
  implements Runnable
{
  DesktopDataManager$22(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
      return;
    }
    localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    if (localObject1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.val$moduleInfoList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (INTERFACE.StModuleInfo)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = new DesktopCardEntity((INTERFACE.StModuleInfo)localObject2);
          ((DesktopCardEntity)localObject2).setStatus(1000);
          DesktopDataManager.access$3100(this.this$0, (EntityManager)localObject1, (Entity)localObject2);
          localStringBuilder.append(((DesktopCardEntity)localObject2).moduleType);
          localStringBuilder.append(":");
          localStringBuilder.append(((DesktopCardEntity)localObject2).title);
          localStringBuilder.append(", ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DesktopDataManager", 2, new Object[] { "saveCardModuleData : ", localStringBuilder.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.22
 * JD-Core Version:    0.7.0.1
 */