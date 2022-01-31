package com.tencent.mobileqq.mini.entry.desktop.item;

import android.util.Log;
import awbw;
import awbx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$30
  implements Runnable
{
  DesktopDataManager$30(DesktopDataManager paramDesktopDataManager, String paramString) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "deleteMiniAppFromDB, app is null.");
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
      if (((awbw)localObject).a(localMiniAppRedDotEntity, "appId=?", new String[] { localMiniAppRedDotEntity.appId }))
      {
        QLog.d("DesktopDataManager", 2, "deleteRedDotDataFromDB, delete " + localMiniAppRedDotEntity.appId + " success from db");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DesktopDataManager", 1, "deleteRedDotDataFromDB, exception: " + Log.getStackTraceString(localThrowable));
      return;
    }
    QLog.d("DesktopDataManager", 2, "deleteRedDotDataFromDB, delete " + localThrowable.appId + " fail from db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.30
 * JD-Core Version:    0.7.0.1
 */