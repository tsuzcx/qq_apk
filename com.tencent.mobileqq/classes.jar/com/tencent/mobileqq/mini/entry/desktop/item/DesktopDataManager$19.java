package com.tencent.mobileqq.mini.entry.desktop.item;

import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$19
  implements Runnable
{
  DesktopDataManager$19(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("DesktopDataManager", 1, "deleteEntity, app is null.");
      return;
    }
    DeskTopAppEntity localDeskTopAppEntity = new DeskTopAppEntity(this.val$entity);
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null) {
      try
      {
        localDeskTopAppEntity.setStatus(1001);
        boolean bool = ((EntityManager)localObject).remove(localDeskTopAppEntity, "uniqueId=?", new String[] { localDeskTopAppEntity.uniqueId });
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteEntity, delete ");
          ((StringBuilder)localObject).append(localDeskTopAppEntity.name);
          ((StringBuilder)localObject).append(" success from db");
          QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteEntity, delete ");
        ((StringBuilder)localObject).append(localDeskTopAppEntity.name);
        ((StringBuilder)localObject).append(" fail from db");
        QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteEntity, Exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
        QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.19
 * JD-Core Version:    0.7.0.1
 */