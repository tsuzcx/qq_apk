package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class DesktopDataManager$31
  implements Runnable
{
  DesktopDataManager$31(DesktopDataManager paramDesktopDataManager, MiniAppRedDotEntity paramMiniAppRedDotEntity) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("DesktopDataManager", 1, "updateRedDotData, app is null.");
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null)
    {
      if (DesktopDataManager.access$3300(this.this$0, (EntityManager)localObject, this.val$entity))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRedDotData, success to delete recommend appInfo: ");
        ((StringBuilder)localObject).append(this.val$entity);
        QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRedDotData, failed to delete recommend appInfo: ");
      ((StringBuilder)localObject).append(this.val$entity);
      QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.31
 * JD-Core Version:    0.7.0.1
 */