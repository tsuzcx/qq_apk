package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class DesktopDataManager$31
  implements Runnable
{
  DesktopDataManager$31(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, app is null.");
    }
    for (;;)
    {
      return;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager().a(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MiniAppRedDotEntity localMiniAppRedDotEntity = (MiniAppRedDotEntity)((Iterator)localObject).next();
          if ((localMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(localMiniAppRedDotEntity.appId))) {
            DesktopDataManager.access$2900(this.this$0).put(localMiniAppRedDotEntity.appId, Integer.valueOf(localMiniAppRedDotEntity.wnsPushRedDotNum));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.31
 * JD-Core Version:    0.7.0.1
 */