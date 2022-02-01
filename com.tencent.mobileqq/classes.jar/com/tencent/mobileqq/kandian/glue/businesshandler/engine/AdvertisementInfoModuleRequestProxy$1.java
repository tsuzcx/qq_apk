package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class AdvertisementInfoModuleRequestProxy$1
  implements IFindRemovedEntity<AdvertisementInfo>
{
  AdvertisementInfoModuleRequestProxy$1(AdvertisementInfoModuleRequestProxy paramAdvertisementInfoModuleRequestProxy) {}
  
  public Entity a(EntityManager paramEntityManager, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramEntityManager.tabbleIsExist(AdvertisementInfo.class.getSimpleName())) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdTraceId))) {
      return paramEntityManager.find(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramAdvertisementInfo.mAdTraceId });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.AdvertisementInfoModuleRequestProxy.1
 * JD-Core Version:    0.7.0.1
 */