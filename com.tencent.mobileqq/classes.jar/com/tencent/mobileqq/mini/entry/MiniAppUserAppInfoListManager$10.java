package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$10
  implements Runnable
{
  MiniAppUserAppInfoListManager$10(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "deleteMiniAppFromDB, app is null.");
      return;
    }
    MiniAppEntity localMiniAppEntity = new MiniAppEntity(this.val$entity);
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null) {
      try
      {
        localMiniAppEntity.setStatus(1001);
        boolean bool = ((EntityManager)localObject).remove(localMiniAppEntity, "appId=?", new String[] { localMiniAppEntity.appId });
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteMiniAppFromDB, delete ");
          ((StringBuilder)localObject).append(localMiniAppEntity.name);
          ((StringBuilder)localObject).append(" success from db");
          QLog.d("MiniAppUserAppInfoListManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteMiniAppFromDB, delete ");
        ((StringBuilder)localObject).append(localMiniAppEntity.name);
        ((StringBuilder)localObject).append(" fail from db");
        QLog.d("MiniAppUserAppInfoListManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteMiniAppFromDB, exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
        QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.10
 * JD-Core Version:    0.7.0.1
 */