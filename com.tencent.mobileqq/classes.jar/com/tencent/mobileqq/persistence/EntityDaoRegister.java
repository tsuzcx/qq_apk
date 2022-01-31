package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.statistics.Reporting;
import java.util.HashMap;

public class EntityDaoRegister
{
  private static HashMap a = new HashMap(33);
  private static HashMap b = new HashMap(33);
  
  static
  {
    System.nanoTime();
    b.put(NearbyPeopleCard.class, NearbyPeopleCardDao.class);
    b.put(TroopInfo.class, TroopInfoDao.class);
    b.put(TroopRemindSettingData.class, TroopRemindSettingDataDao.class);
    b.put(Emoticon.class, EmoticonDao.class);
    b.put(ResourcePluginInfo.class, ResourcePluginInfoDao.class);
    b.put(QZoneCover.class, QZoneCoverDao.class);
    b.put(Friends.class, FriendsDao.class);
    b.put(HotChatInfo.class, HotChatInfoDao.class);
    b.put(ExpiredPushBanner.class, ExpiredPushBannerDao.class);
    b.put(Ability.class, AbilityDao.class);
    b.put(TroopMemberInfo.class, TroopMemberInfoDao.class);
    b.put(PhoneContact.class, PhoneContactDao.class);
    b.put(EmoticonTab.class, EmoticonTabDao.class);
    b.put(TroopAssistantData.class, TroopAssistantDataDao.class);
    b.put(SearchHistory.class, SearchHistoryDao.class);
    b.put(CommonlyUsedTroop.class, CommonlyUsedTroopDao.class);
    b.put(Card.class, CardDao.class);
    b.put(Stranger.class, StrangerDao.class);
    b.put(Groups.class, GroupsDao.class);
    b.put(DiscussionInfo.class, DiscussionInfoDao.class);
    b.put(RoamSetting.class, RoamSettingDao.class);
    b.put(ConversationInfo.class, ConversationInfoDao.class);
    b.put(ShieldListInfo.class, ShieldListInfoDao.class);
    b.put(ContactCard.class, ContactCardDao.class);
    b.put(SubAccountInfo.class, SubAccountInfoDao.class);
    b.put(ExtensionInfo.class, ExtensionInfoDao.class);
    b.put(EmoticonPackage.class, EmoticonPackageDao.class);
    b.put(Setting.class, SettingDao.class);
    b.put(DiscussionMemberInfo.class, DiscussionMemberInfoDao.class);
    b.put(QQOperationViopTipTask.class, QQOperationViopTipTaskDao.class);
    b.put(RecentUser.class, RecentUserDao.class);
    b.put(Reporting.class, ReportingDao.class);
    b.put(PublicAccountInfo.class, PublicAccountInfoDao.class);
  }
  
  public static OGAbstractDao a(Class paramClass)
  {
    localObject1 = (OGAbstractDao)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (OGAbstractDao)a.get(paramClass);
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