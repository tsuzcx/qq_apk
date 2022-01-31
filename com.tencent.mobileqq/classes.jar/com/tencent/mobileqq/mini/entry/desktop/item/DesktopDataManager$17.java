package com.tencent.mobileqq.mini.entry.desktop.item;

import atmo;
import atmp;
import atmq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$17
  implements Runnable
{
  DesktopDataManager$17(DesktopDataManager paramDesktopDataManager, DesktopItemInfo paramDesktopItemInfo) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
    }
    atmp localatmp;
    do
    {
      return;
      localatmp = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localatmp == null);
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = null;
        if (!(this.val$data instanceof DesktopAppInfo)) {
          break label148;
        }
        localObject = new DeskTopAppEntity(((DesktopAppInfo)this.val$data).mMiniAppInfo);
        if (localObject != null)
        {
          ((DeskTopAppEntity)localObject).setStatus(1000);
          DesktopDataManager.access$3200(this.this$0, localatmp, (atmo)localObject);
          localStringBuilder.append(((DeskTopAppEntity)localObject).name).append(", ");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DesktopDataManager", 2, new Object[] { "insertEntity : ", localStringBuilder.toString() });
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DesktopDataManager", 2, "insertEntity exception: ", localException);
      return;
      label148:
      if ((this.val$data instanceof DesktopSearchInfo)) {
        DeskTopAppEntity localDeskTopAppEntity = new DeskTopAppEntity(((DesktopSearchInfo)this.val$data).mAppInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.17
 * JD-Core Version:    0.7.0.1
 */