package com.tencent.mobileqq.persistence;

import atmc;
import atmd;
import atme;
import atmf;
import atmg;
import atmj;
import atmk;
import atml;
import atmm;
import atmn;
import atms;
import atmt;
import atmu;
import atmv;
import atmw;
import atmy;
import atna;
import atnd;
import atne;
import atnf;
import atng;
import atnh;
import atni;
import atnj;
import atnk;
import atnl;
import atnm;
import atnn;
import atno;
import atnr;
import atns;
import atnt;
import atnu;
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
  private static HashMap<Class, atna> a = new HashMap(32);
  private static HashMap<Class, Class> b = new HashMap(32);
  
  static
  {
    System.nanoTime();
    b.put(ExtensionInfo.class, atmt.class);
    b.put(Groups.class, atmv.class);
    b.put(TroopMemberInfo.class, atnt.class);
    b.put(ShieldListInfo.class, atnm.class);
    b.put(EmoticonTab.class, atmn.class);
    b.put(DiscussionMemberInfo.class, atmk.class);
    b.put(PhoneContact.class, atnd.class);
    b.put(TroopRemindSettingData.class, atnu.class);
    b.put(Stranger.class, atnn.class);
    b.put(Emoticon.class, atml.class);
    b.put(TroopInfo.class, atns.class);
    b.put(ConversationInfo.class, atmg.class);
    b.put(SearchHistory.class, atnk.class);
    b.put(Ability.class, atmc.class);
    b.put(Card.class, atmd.class);
    b.put(ContactCard.class, atmf.class);
    b.put(ResourcePluginInfo.class, atni.class);
    b.put(SubAccountInfo.class, atno.class);
    b.put(HotChatInfo.class, atmw.class);
    b.put(EmoticonPackage.class, atmm.class);
    b.put(QZoneCover.class, atng.class);
    b.put(RoamSetting.class, atnj.class);
    b.put(TroopAssistantData.class, atnr.class);
    b.put(Friends.class, atmu.class);
    b.put(CommonlyUsedTroop.class, atme.class);
    b.put(NearbyPeopleCard.class, atmy.class);
    b.put(ExpiredPushBanner.class, atms.class);
    b.put(DiscussionInfo.class, atmj.class);
    b.put(Setting.class, atnl.class);
    b.put(QQOperationViopTipTask.class, atnf.class);
    b.put(Reporting.class, atnh.class);
    b.put(PublicAccountInfo.class, atne.class);
  }
  
  public static atna a(Class paramClass)
  {
    localObject1 = (atna)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (atna)a.get(paramClass);
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