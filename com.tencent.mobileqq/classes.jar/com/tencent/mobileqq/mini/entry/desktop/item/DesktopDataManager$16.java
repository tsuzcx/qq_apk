package com.tencent.mobileqq.mini.entry.desktop.item;

import android.util.Log;
import aukn;
import auko;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$16
  implements Runnable
{
  DesktopDataManager$16(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "deleteEntity, app is null.");
    }
    DeskTopAppEntity localDeskTopAppEntity;
    do
    {
      return;
      localDeskTopAppEntity = new DeskTopAppEntity(this.val$entity);
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    try
    {
      localDeskTopAppEntity.setStatus(1001);
      if (((aukn)localObject).a(localDeskTopAppEntity, "uniqueId=?", new String[] { localDeskTopAppEntity.uniqueId }))
      {
        QLog.d("DesktopDataManager", 2, "deleteEntity, delete " + localDeskTopAppEntity.name + " success from db");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DesktopDataManager", 1, "deleteEntity, Exception: " + Log.getStackTraceString(localThrowable));
      return;
    }
    QLog.d("DesktopDataManager", 2, "deleteEntity, delete " + localThrowable.name + " fail from db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16
 * JD-Core Version:    0.7.0.1
 */