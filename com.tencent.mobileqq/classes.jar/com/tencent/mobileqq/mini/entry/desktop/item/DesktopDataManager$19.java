package com.tencent.mobileqq.mini.entry.desktop.item;

import auko;
import aukp;
import aukq;
import aukr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$19
  implements Runnable
{
  DesktopDataManager$19(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("DesktopDataManager", 1, "insertEntityWithBatch, app is null.");
    }
    aukp localaukp;
    do
    {
      return;
      localaukp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localaukp == null);
    aukr localaukr = localaukp.a();
    localaukr.a();
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        Iterator localIterator = this.val$appInfoList.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localObject1 = (DesktopItemInfo)localIterator.next();
        if (!(localObject1 instanceof DesktopAppInfo)) {
          continue;
        }
        localObject1 = new DeskTopAppEntity(((DesktopAppInfo)localObject1).mMiniAppInfo);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DesktopDataManager", 2, "insertEntityWithBatch exception: ", localException);
        return;
        if (!(localException instanceof DesktopSearchInfo)) {
          break label231;
        }
        DeskTopAppEntity localDeskTopAppEntity = new DeskTopAppEntity(((DesktopSearchInfo)localException).mAppInfo);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DesktopDataManager", 2, new Object[] { "insertEntityWithBatch : ", localStringBuilder.toString() });
        localaukr.c();
        return;
      }
      finally
      {
        localaukr.b();
      }
      if (localObject1 != null)
      {
        ((DeskTopAppEntity)localObject1).setStatus(1000);
        DesktopDataManager.access$3100(this.this$0, localaukp, (auko)localObject1);
        localStringBuilder.append(((DeskTopAppEntity)localObject1).name).append(", ");
        continue;
        label231:
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.19
 * JD-Core Version:    0.7.0.1
 */