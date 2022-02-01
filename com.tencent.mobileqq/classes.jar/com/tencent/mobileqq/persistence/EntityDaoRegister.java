package com.tencent.mobileqq.persistence;

import aznh;
import azni;
import aznj;
import aznk;
import aznm;
import aznn;
import azno;
import aznp;
import aznq;
import aznr;
import azns;
import aznt;
import aznu;
import aznv;
import aznx;
import aznz;
import azoa;
import azob;
import azoc;
import azod;
import azoe;
import azof;
import azog;
import azoh;
import azoi;
import azoj;
import azok;
import azol;
import azom;
import azon;
import azoo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
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
  private static HashMap<Class, OGAbstractDao> a = new HashMap(31);
  private static HashMap<Class, Class> b = new HashMap(31);
  
  static
  {
    System.nanoTime();
    b.put(ShieldListInfo.class, azoi.class);
    b.put(ContactCard.class, aznj.class);
    b.put(TroopMemberInfo.class, azon.class);
    b.put(ConversationInfo.class, aznk.class);
    b.put(HotChatInfo.class, aznv.class);
    b.put(SearchHistory.class, azog.class);
    b.put(SubAccountInfo.class, azok.class);
    b.put(EmoticonTab.class, aznq.class);
    b.put(ResourcePluginInfo.class, azoe.class);
    b.put(Friends.class, aznt.class);
    b.put(Card.class, aznh.class);
    b.put(Stranger.class, azoj.class);
    b.put(NearbyPeopleCard.class, aznx.class);
    b.put(TroopInfo.class, azom.class);
    b.put(EmoticonPackage.class, aznp.class);
    b.put(DiscussionInfo.class, aznm.class);
    b.put(RoamSetting.class, azof.class);
    b.put(DiscussionMemberInfo.class, aznn.class);
    b.put(Emoticon.class, azno.class);
    b.put(Setting.class, azoh.class);
    b.put(Groups.class, aznu.class);
    b.put(ExtensionInfo.class, azns.class);
    b.put(QZoneCover.class, azoc.class);
    b.put(TroopAssistantData.class, azol.class);
    b.put(CommonlyUsedTroop.class, azni.class);
    b.put(ExpiredPushBanner.class, aznr.class);
    b.put(PhoneContact.class, aznz.class);
    b.put(TroopRemindSettingData.class, azoo.class);
    b.put(QQOperationViopTipTask.class, azob.class);
    b.put(Reporting.class, azod.class);
    b.put(PublicAccountInfo.class, azoa.class);
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