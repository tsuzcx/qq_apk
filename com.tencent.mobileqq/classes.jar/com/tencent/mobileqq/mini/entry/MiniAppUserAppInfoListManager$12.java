package com.tencent.mobileqq.mini.entry;

import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$12
  implements Runnable
{
  MiniAppUserAppInfoListManager$12(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if (this.val$appInfo == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, appInfo is null.");
    }
    Object localObject;
    RecommendMiniAppEntity localRecommendMiniAppEntity;
    do
    {
      return;
      localObject = MiniAppUtils.getAppInterface();
      if (localObject == null)
      {
        QLog.e("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, app is null.");
        return;
      }
      localRecommendMiniAppEntity = new RecommendMiniAppEntity(this.val$appInfo.appId, this.val$appInfo.name, this.val$appInfo.recommend);
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localObject == null);
    if (MiniAppUserAppInfoListManager.access$1100(this.this$0, (awgf)localObject, localRecommendMiniAppEntity))
    {
      QLog.d("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, success to delete recommend appInfo: " + localRecommendMiniAppEntity);
      return;
    }
    QLog.e("MiniAppUserAppInfoListManager", 1, "insertRecommendMiniAppToDB, failed to delete recommend appInfo: " + localRecommendMiniAppEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.12
 * JD-Core Version:    0.7.0.1
 */