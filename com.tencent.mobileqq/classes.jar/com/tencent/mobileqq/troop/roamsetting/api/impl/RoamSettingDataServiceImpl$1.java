package com.tencent.mobileqq.troop.roamsetting.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

class RoamSettingDataServiceImpl$1
  implements Runnable
{
  RoamSettingDataServiceImpl$1(RoamSettingDataServiceImpl paramRoamSettingDataServiceImpl) {}
  
  public void run()
  {
    ArrayList localArrayList = (ArrayList)this.this$0.em.query(RoamSetting.class, false, null, null, null, null, null, null);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.this$0.lock.lock();
      int i = 0;
      try
      {
        while (i < localArrayList.size())
        {
          RoamSetting localRoamSetting = (RoamSetting)localArrayList.get(i);
          if (((RoamSettingServiceImpl)this.this$0.app.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(localRoamSetting.path) == 1) {
            this.this$0.mTroopSettingCache.put(localRoamSetting.path, localRoamSetting);
          } else {
            this.this$0.mSettingCache.put(localRoamSetting.path, localRoamSetting);
          }
          i += 1;
        }
      }
      finally
      {
        this.this$0.lock.unlock();
      }
    }
    this.this$0.mIsLoadDb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */