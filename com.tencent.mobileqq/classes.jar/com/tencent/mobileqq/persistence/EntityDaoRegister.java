package com.tencent.mobileqq.persistence;

import ayuu;
import ayuv;
import ayuw;
import ayux;
import ayuz;
import ayva;
import ayvb;
import ayvc;
import ayvd;
import ayve;
import ayvf;
import ayvg;
import ayvh;
import ayvi;
import ayvk;
import ayvm;
import ayvn;
import ayvo;
import ayvp;
import ayvq;
import ayvr;
import ayvs;
import ayvt;
import ayvu;
import ayvv;
import ayvw;
import ayvx;
import ayvy;
import ayvz;
import aywa;
import aywb;
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
    b.put(ExtensionInfo.class, ayvf.class);
    b.put(ConversationInfo.class, ayux.class);
    b.put(SubAccountInfo.class, ayvx.class);
    b.put(NearbyPeopleCard.class, ayvk.class);
    b.put(EmoticonPackage.class, ayvc.class);
    b.put(Friends.class, ayvg.class);
    b.put(Stranger.class, ayvw.class);
    b.put(DiscussionInfo.class, ayuz.class);
    b.put(PhoneContact.class, ayvm.class);
    b.put(TroopRemindSettingData.class, aywb.class);
    b.put(QZoneCover.class, ayvp.class);
    b.put(ShieldListInfo.class, ayvv.class);
    b.put(TroopMemberInfo.class, aywa.class);
    b.put(TroopInfo.class, ayvz.class);
    b.put(HotChatInfo.class, ayvi.class);
    b.put(EmoticonTab.class, ayvd.class);
    b.put(RoamSetting.class, ayvs.class);
    b.put(SearchHistory.class, ayvt.class);
    b.put(Emoticon.class, ayvb.class);
    b.put(Card.class, ayuu.class);
    b.put(ResourcePluginInfo.class, ayvr.class);
    b.put(Setting.class, ayvu.class);
    b.put(CommonlyUsedTroop.class, ayuv.class);
    b.put(Groups.class, ayvh.class);
    b.put(ContactCard.class, ayuw.class);
    b.put(TroopAssistantData.class, ayvy.class);
    b.put(DiscussionMemberInfo.class, ayva.class);
    b.put(ExpiredPushBanner.class, ayve.class);
    b.put(QQOperationViopTipTask.class, ayvo.class);
    b.put(Reporting.class, ayvq.class);
    b.put(PublicAccountInfo.class, ayvn.class);
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