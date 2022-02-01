package com.tencent.mobileqq.mini.entry.desktop.item;

import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$32
  implements Runnable
{
  DesktopDataManager$32(DesktopDataManager paramDesktopDataManager, String paramString) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("DesktopDataManager", 1, "deleteMiniAppFromDB, app is null.");
      return;
    }
    MiniAppRedDotEntity localMiniAppRedDotEntity = new MiniAppRedDotEntity(this.val$appId, 0, 0);
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null) {
      try
      {
        localMiniAppRedDotEntity.setStatus(1001);
        boolean bool = ((EntityManager)localObject).remove(localMiniAppRedDotEntity, "appId=?", new String[] { localMiniAppRedDotEntity.appId });
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteRedDotDataFromDB, delete ");
          ((StringBuilder)localObject).append(localMiniAppRedDotEntity.appId);
          ((StringBuilder)localObject).append(" success from db");
          QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteRedDotDataFromDB, delete ");
        ((StringBuilder)localObject).append(localMiniAppRedDotEntity.appId);
        ((StringBuilder)localObject).append(" fail from db");
        QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteRedDotDataFromDB, exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
        QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.32
 * JD-Core Version:    0.7.0.1
 */