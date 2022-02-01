package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$14
  implements Runnable
{
  MiniAppUserAppInfoListManager$14(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, String paramString) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "deleteMiniAppFromDB, app is null.");
    }
    MiniAppRedDotEntity localMiniAppRedDotEntity;
    do
    {
      return;
      localMiniAppRedDotEntity = new MiniAppRedDotEntity(this.val$appId, 0, 0);
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    try
    {
      localMiniAppRedDotEntity.setStatus(1001);
      if (((EntityManager)localObject).remove(localMiniAppRedDotEntity, "appId=?", new String[] { localMiniAppRedDotEntity.appId }))
      {
        QLog.d("MiniAppUserAppInfoListManager", 2, "deleteRedDotDataFromDB, delete " + localMiniAppRedDotEntity.appId + " success from db");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "deleteRedDotDataFromDB, exception: " + Log.getStackTraceString(localThrowable));
      return;
    }
    QLog.d("MiniAppUserAppInfoListManager", 2, "deleteRedDotDataFromDB, delete " + localThrowable.appId + " fail from db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.14
 * JD-Core Version:    0.7.0.1
 */