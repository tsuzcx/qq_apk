package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$21
  implements Runnable
{
  DesktopDataManager$21(DesktopDataManager paramDesktopDataManager, DesktopItemInfo paramDesktopItemInfo) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
      return;
    }
    EntityManager localEntityManager = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((this.val$data instanceof DesktopAppInfo))
        {
          localObject1 = new DeskTopAppEntity(((DesktopAppInfo)this.val$data).mMiniAppInfo);
        }
        else
        {
          if (!(this.val$data instanceof DesktopSearchInfo)) {
            break label182;
          }
          localObject1 = new DeskTopAppEntity(((DesktopSearchInfo)this.val$data).mAppInfo);
        }
        if (localObject1 != null)
        {
          ((DeskTopAppEntity)localObject1).setStatus(1000);
          DesktopDataManager.access$2200(this.this$0, localEntityManager, (Entity)localObject1);
          localStringBuilder.append(((DeskTopAppEntity)localObject1).name);
          localStringBuilder.append(", ");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DesktopDataManager", 2, new Object[] { "insertEntity : ", localStringBuilder.toString() });
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DesktopDataManager", 2, "insertEntity exception: ", localException);
        }
      }
      return;
      label182:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.21
 * JD-Core Version:    0.7.0.1
 */