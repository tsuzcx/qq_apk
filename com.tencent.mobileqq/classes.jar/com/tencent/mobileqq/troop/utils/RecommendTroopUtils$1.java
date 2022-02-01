package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.recommend.data.NotificationRecommendTroopItem;

final class RecommendTroopUtils$1
  implements Runnable
{
  RecommendTroopUtils$1(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = (ITroopSysMsgDependApiService)this.a.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    Entity localEntity = null;
    if (localObject != null)
    {
      if (((ITroopSysMsgDependApiService)localObject).isBrowserAppInterface(this.a))
      {
        localObject = this.a.getEntityManagerFactory(null).createEntityManager();
        break label78;
      }
      if (((ITroopSysMsgDependApiService)localObject).isQQAppInterface(this.a))
      {
        localObject = this.a.getEntityManagerFactory().createEntityManager();
        break label78;
      }
    }
    localObject = null;
    label78:
    if (localObject == null) {
      return;
    }
    if (this.b == 2) {
      localEntity = ((EntityManager)localObject).find(NotificationRecommendTroopItem.class, this.c);
    }
    if (localEntity != null) {
      ((EntityManager)localObject).remove(localEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RecommendTroopUtils.1
 * JD-Core Version:    0.7.0.1
 */