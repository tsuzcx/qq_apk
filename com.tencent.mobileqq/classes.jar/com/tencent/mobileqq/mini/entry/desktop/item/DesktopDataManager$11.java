package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE.StOperationApp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.DesktopOperationAppEntryEntity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$11
  implements Runnable
{
  DesktopDataManager$11(DesktopDataManager paramDesktopDataManager, INTERFACE.StOperationApp paramStOperationApp) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch error, app is null.");
      return;
    }
    localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    if (localObject1 == null)
    {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch error, em is null.");
      return;
    }
    Object localObject2 = this.val$operationApp;
    boolean bool;
    if ((localObject2 != null) && (((INTERFACE.StOperationApp)localObject2).app.get() != null) && (!TextUtils.isEmpty(this.val$operationApp.name.get())))
    {
      localObject2 = new DesktopOperationAppEntryEntity(this.val$operationApp);
      ((DesktopOperationAppEntryEntity)localObject2).setStatus(1000);
      try
      {
        bool = DesktopDataManager.access$2200(this.this$0, (EntityManager)localObject1, (Entity)localObject2);
        if (!QLog.isColorLevel()) {
          break label346;
        }
        QLog.d("DesktopDataManager", 2, new Object[] { "[saveOperationAppEntryData] update entity ", ((DesktopOperationAppEntryEntity)localObject2).name, " result = ", Boolean.valueOf(bool), " via = ", this.val$operationApp.app.appInfo.basicInfo.via.get() });
        return;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("DesktopDataManager", 1, new Object[] { "[saveOperationAppEntryData] update entity ", ((DesktopOperationAppEntryEntity)localObject2).name, " error!", localThrowable1 });
        return;
      }
    }
    else
    {
      if ((DesktopDataManager.access$2100(this.this$0) == null) || (TextUtils.isEmpty(DesktopDataManager.access$2100(this.this$0).getName()))) {
        break label347;
      }
      localObject2 = new DesktopOperationAppEntryEntity(DesktopDataManager.access$2100(this.this$0).getName());
      try
      {
        bool = localThrowable1.remove((Entity)localObject2, "name=?", new String[] { ((DesktopOperationAppEntryEntity)localObject2).name });
        if (QLog.isColorLevel())
        {
          QLog.d("DesktopDataManager", 2, new Object[] { "[saveOperationAppEntryData] delete entity ", ((DesktopOperationAppEntryEntity)localObject2).name, " result = ", Boolean.valueOf(bool) });
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("DesktopDataManager", 1, new Object[] { "[saveOperationAppEntryData] delete entity ", ((DesktopOperationAppEntryEntity)localObject2).name, " error!", localThrowable2 });
      }
    }
    label346:
    return;
    label347:
    QLog.d("DesktopDataManager", 2, "[saveOperationAppEntryData] no need to delete entity.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.11
 * JD-Core Version:    0.7.0.1
 */