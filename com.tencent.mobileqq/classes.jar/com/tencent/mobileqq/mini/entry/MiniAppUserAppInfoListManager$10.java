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
    if (localObject == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "deleteMiniAppFromDB, app is null.");
    }
    MiniAppEntity localMiniAppEntity;
    do
    {
      return;
      localMiniAppEntity = new MiniAppEntity(this.val$entity);
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    try
    {
      localMiniAppEntity.setStatus(1001);
      if (((EntityManager)localObject).remove(localMiniAppEntity, "appId=?", new String[] { localMiniAppEntity.appId }))
      {
        QLog.d("MiniAppUserAppInfoListManager", 2, "deleteMiniAppFromDB, delete " + localMiniAppEntity.name + " success from db");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "deleteMiniAppFromDB, exception: " + Log.getStackTraceString(localThrowable));
      return;
    }
    QLog.d("MiniAppUserAppInfoListManager", 2, "deleteMiniAppFromDB, delete " + localThrowable.name + " fail from db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.10
 * JD-Core Version:    0.7.0.1
 */