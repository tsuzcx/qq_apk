package com.tencent.mobileqq.persistence;

import auka;
import aukb;
import aukc;
import aukd;
import auke;
import aukh;
import auki;
import aukj;
import aukk;
import aukl;
import aukq;
import aukr;
import auks;
import aukt;
import auku;
import aukw;
import auky;
import aulb;
import aulc;
import auld;
import aule;
import aulf;
import aulg;
import aulh;
import auli;
import aulj;
import aulk;
import aull;
import aulm;
import aulp;
import aulq;
import aulr;
import auls;
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
  private static HashMap<Class, auky> a = new HashMap(32);
  private static HashMap<Class, Class> b = new HashMap(32);
  
  static
  {
    System.nanoTime();
    b.put(TroopAssistantData.class, aulp.class);
    b.put(HotChatInfo.class, auku.class);
    b.put(SearchHistory.class, auli.class);
    b.put(NearbyPeopleCard.class, aukw.class);
    b.put(EmoticonTab.class, aukl.class);
    b.put(TroopRemindSettingData.class, auls.class);
    b.put(ExtensionInfo.class, aukr.class);
    b.put(DiscussionMemberInfo.class, auki.class);
    b.put(Card.class, aukb.class);
    b.put(CommonlyUsedTroop.class, aukc.class);
    b.put(TroopMemberInfo.class, aulr.class);
    b.put(DiscussionInfo.class, aukh.class);
    b.put(Emoticon.class, aukj.class);
    b.put(PhoneContact.class, aulb.class);
    b.put(ExpiredPushBanner.class, aukq.class);
    b.put(ResourcePluginInfo.class, aulg.class);
    b.put(QZoneCover.class, aule.class);
    b.put(Setting.class, aulj.class);
    b.put(Stranger.class, aull.class);
    b.put(ConversationInfo.class, auke.class);
    b.put(Ability.class, auka.class);
    b.put(SubAccountInfo.class, aulm.class);
    b.put(Friends.class, auks.class);
    b.put(TroopInfo.class, aulq.class);
    b.put(Groups.class, aukt.class);
    b.put(EmoticonPackage.class, aukk.class);
    b.put(ContactCard.class, aukd.class);
    b.put(RoamSetting.class, aulh.class);
    b.put(ShieldListInfo.class, aulk.class);
    b.put(QQOperationViopTipTask.class, auld.class);
    b.put(Reporting.class, aulf.class);
    b.put(PublicAccountInfo.class, aulc.class);
  }
  
  public static auky a(Class paramClass)
  {
    localObject1 = (auky)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (auky)a.get(paramClass);
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