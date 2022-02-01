package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import java.util.HashMap;

public class EntityDaoRegister
{
  public static final String TAG = "EntityDaoRegister";
  private static HashMap<Class, Class> mDaoClassMap;
  private static HashMap<Class, OGAbstractDao> mDaoMap = new HashMap(18);
  
  static
  {
    mDaoClassMap = new HashMap(18);
    System.nanoTime();
    mDaoClassMap.put(DiscussionMemberInfo.class, DiscussionMemberInfoDao.class);
    mDaoClassMap.put(SearchHistory.class, SearchHistoryDao.class);
    mDaoClassMap.put(SubAccountInfo.class, SubAccountInfoDao.class);
    mDaoClassMap.put(TroopRemindSettingData.class, TroopRemindSettingDataDao.class);
    mDaoClassMap.put(TroopAssistantData.class, TroopAssistantDataDao.class);
    mDaoClassMap.put(NearbyPeopleCard.class, NearbyPeopleCardDao.class);
    mDaoClassMap.put(ExpiredPushBanner.class, ExpiredPushBannerDao.class);
    mDaoClassMap.put(HotChatInfo.class, HotChatInfoDao.class);
    mDaoClassMap.put(ShieldListInfo.class, ShieldListInfoDao.class);
    mDaoClassMap.put(Stranger.class, StrangerDao.class);
    mDaoClassMap.put(EmoticonTab.class, EmoticonTabDao.class);
    mDaoClassMap.put(ResourcePluginInfo.class, ResourcePluginInfoDao.class);
    mDaoClassMap.put(DiscussionInfo.class, DiscussionInfoDao.class);
    mDaoClassMap.put(PhoneContact.class, PhoneContactDao.class);
    mDaoClassMap.put(RoamSetting.class, RoamSettingDao.class);
    mDaoClassMap.put(QZoneCover.class, QZoneCoverDao.class);
    mDaoClassMap.put(QQOperationViopTipTask.class, QQOperationViopTipTaskDao.class);
    mDaoClassMap.put(PublicAccountInfo.class, PublicAccountInfoDao.class);
  }
  
  public static OGAbstractDao getEntityDao(Class paramClass)
  {
    localObject1 = (OGAbstractDao)mDaoMap.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)mDaoClassMap.get(paramClass);
    } while (localObject3 == null);
    synchronized (mDaoMap)
    {
      localObject2 = (OGAbstractDao)mDaoMap.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityDaoRegister
 * JD-Core Version:    0.7.0.1
 */