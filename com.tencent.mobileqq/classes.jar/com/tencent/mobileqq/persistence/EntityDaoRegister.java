package com.tencent.mobileqq.persistence;

import awfs;
import awft;
import awfu;
import awfv;
import awfw;
import awfz;
import awga;
import awgb;
import awgc;
import awgd;
import awgi;
import awgj;
import awgk;
import awgl;
import awgm;
import awgo;
import awgq;
import awgt;
import awgu;
import awgv;
import awgw;
import awgx;
import awgy;
import awgz;
import awha;
import awhb;
import awhc;
import awhd;
import awhe;
import awhh;
import awhi;
import awhj;
import awhk;
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
  private static HashMap<Class, awgq> a = new HashMap(32);
  private static HashMap<Class, Class> b = new HashMap(32);
  
  static
  {
    System.nanoTime();
    b.put(TroopAssistantData.class, awhh.class);
    b.put(HotChatInfo.class, awgm.class);
    b.put(SearchHistory.class, awha.class);
    b.put(NearbyPeopleCard.class, awgo.class);
    b.put(EmoticonTab.class, awgd.class);
    b.put(TroopRemindSettingData.class, awhk.class);
    b.put(ExtensionInfo.class, awgj.class);
    b.put(DiscussionMemberInfo.class, awga.class);
    b.put(Card.class, awft.class);
    b.put(CommonlyUsedTroop.class, awfu.class);
    b.put(TroopMemberInfo.class, awhj.class);
    b.put(DiscussionInfo.class, awfz.class);
    b.put(Emoticon.class, awgb.class);
    b.put(PhoneContact.class, awgt.class);
    b.put(ExpiredPushBanner.class, awgi.class);
    b.put(ResourcePluginInfo.class, awgy.class);
    b.put(QZoneCover.class, awgw.class);
    b.put(Setting.class, awhb.class);
    b.put(Stranger.class, awhd.class);
    b.put(ConversationInfo.class, awfw.class);
    b.put(Ability.class, awfs.class);
    b.put(SubAccountInfo.class, awhe.class);
    b.put(Friends.class, awgk.class);
    b.put(TroopInfo.class, awhi.class);
    b.put(Groups.class, awgl.class);
    b.put(EmoticonPackage.class, awgc.class);
    b.put(ContactCard.class, awfv.class);
    b.put(RoamSetting.class, awgz.class);
    b.put(ShieldListInfo.class, awhc.class);
    b.put(QQOperationViopTipTask.class, awgv.class);
    b.put(Reporting.class, awgx.class);
    b.put(PublicAccountInfo.class, awgu.class);
  }
  
  public static awgq a(Class paramClass)
  {
    localObject1 = (awgq)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (awgq)a.get(paramClass);
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