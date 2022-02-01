package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$13
  implements Runnable
{
  MiniAppUserAppInfoListManager$13(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppRedDotEntity paramMiniAppRedDotEntity) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "updateRedDotData, app is null.");
    }
    do
    {
      return;
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    if (MiniAppUserAppInfoListManager.access$1300(this.this$0, (EntityManager)localObject, this.val$entity))
    {
      QLog.d("MiniAppUserAppInfoListManager", 1, "updateRedDotData, success to delete recommend appInfo: " + this.val$entity);
      return;
    }
    QLog.e("MiniAppUserAppInfoListManager", 1, "updateRedDotData, failed to delete recommend appInfo: " + this.val$entity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.13
 * JD-Core Version:    0.7.0.1
 */