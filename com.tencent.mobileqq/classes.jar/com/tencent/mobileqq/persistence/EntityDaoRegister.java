package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import java.util.HashMap;

public class EntityDaoRegister
{
  public static final String TAG = "EntityDaoRegister";
  private static HashMap<Class, Class> mDaoClassMap;
  private static HashMap<Class, OGAbstractDao> mDaoMap = new HashMap(10);
  
  static
  {
    mDaoClassMap = new HashMap(10);
    System.nanoTime();
    mDaoClassMap.put(HotChatInfo.class, HotChatInfoDao.class);
    mDaoClassMap.put(ResourcePluginInfo.class, ResourcePluginInfoDao.class);
    mDaoClassMap.put(ExpiredPushBanner.class, ExpiredPushBannerDao.class);
    mDaoClassMap.put(ShieldListInfo.class, ShieldListInfoDao.class);
    mDaoClassMap.put(NearbyPeopleCard.class, NearbyPeopleCardDao.class);
    mDaoClassMap.put(SearchHistory.class, SearchHistoryDao.class);
    mDaoClassMap.put(TroopAssistantData.class, TroopAssistantDataDao.class);
    mDaoClassMap.put(QZoneCover.class, QZoneCoverDao.class);
    mDaoClassMap.put(QQOperationViopTipTask.class, QQOperationViopTipTaskDao.class);
    mDaoClassMap.put(PublicAccountInfo.class, PublicAccountInfoDao.class);
  }
  
  public static OGAbstractDao getEntityDao(Class paramClass)
  {
    localObject1 = (OGAbstractDao)mDaoMap.get(paramClass);
    if (localObject1 != null) {
      return localObject1;
    }
    Class localClass = (Class)mDaoClassMap.get(paramClass);
    if (localClass != null) {
      synchronized (mDaoMap)
      {
        localObject1 = (OGAbstractDao)mDaoMap.get(paramClass);
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = (OGAbstractDao)localClass.newInstance();
      }
      catch (IllegalAccessException paramClass)
      {
        continue;
      }
      catch (InstantiationException paramClass)
      {
        continue;
      }
      try
      {
        mDaoMap.put(paramClass, localObject2);
        return localObject2;
      }
      catch (IllegalAccessException paramClass)
      {
        localObject1 = localObject2;
      }
      catch (InstantiationException paramClass)
      {
        localObject1 = localObject2;
      }
    }
    paramClass.printStackTrace();
    localObject2 = localObject1;
    break label94;
    paramClass.printStackTrace();
    localObject2 = localObject1;
    label94:
    return localObject2;
    paramClass = finally;
    throw paramClass;
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityDaoRegister
 * JD-Core Version:    0.7.0.1
 */