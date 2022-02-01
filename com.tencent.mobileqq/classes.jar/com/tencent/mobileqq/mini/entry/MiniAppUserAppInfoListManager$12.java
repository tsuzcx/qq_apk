package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$12
  implements Runnable
{
  MiniAppUserAppInfoListManager$12(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if (this.val$appInfo == null)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, appInfo is null.");
      return;
    }
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, app is null.");
      return;
    }
    RecommendMiniAppEntity localRecommendMiniAppEntity = new RecommendMiniAppEntity(this.val$appInfo.appId, this.val$appInfo.name, this.val$appInfo.recommend);
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject != null)
    {
      if (MiniAppUserAppInfoListManager.access$1100(this.this$0, (EntityManager)localObject, localRecommendMiniAppEntity))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertRecommendMiniAppToDB, success to delete recommend appInfo: ");
        ((StringBuilder)localObject).append(localRecommendMiniAppEntity);
        QLog.d("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertRecommendMiniAppToDB, failed to delete recommend appInfo: ");
      ((StringBuilder)localObject).append(localRecommendMiniAppEntity);
      QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.12
 * JD-Core Version:    0.7.0.1
 */