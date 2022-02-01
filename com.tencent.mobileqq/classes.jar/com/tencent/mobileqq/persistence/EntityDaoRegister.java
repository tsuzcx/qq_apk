package com.tencent.mobileqq.persistence;

import ayar;
import ayas;
import ayat;
import ayau;
import ayaw;
import ayax;
import ayay;
import ayaz;
import ayba;
import aybb;
import aybc;
import aybd;
import aybe;
import aybf;
import aybh;
import aybj;
import aybk;
import aybl;
import aybm;
import aybn;
import aybo;
import aybp;
import aybq;
import aybr;
import aybs;
import aybt;
import aybu;
import aybv;
import aybw;
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
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.statistics.Reporting;
import java.util.HashMap;

public class EntityDaoRegister
{
  private static HashMap<Class, OGAbstractDao> a = new HashMap(29);
  private static HashMap<Class, Class> b = new HashMap(29);
  
  static
  {
    System.nanoTime();
    b.put(Setting.class, aybr.class);
    b.put(PhoneContact.class, aybj.class);
    b.put(TroopAssistantData.class, aybv.class);
    b.put(Emoticon.class, ayay.class);
    b.put(QZoneCover.class, aybm.class);
    b.put(DiscussionInfo.class, ayaw.class);
    b.put(CommonlyUsedTroop.class, ayas.class);
    b.put(ResourcePluginInfo.class, aybo.class);
    b.put(SubAccountInfo.class, aybu.class);
    b.put(Stranger.class, aybt.class);
    b.put(EmoticonPackage.class, ayaz.class);
    b.put(TroopRemindSettingData.class, aybw.class);
    b.put(ConversationInfo.class, ayau.class);
    b.put(Friends.class, aybd.class);
    b.put(Groups.class, aybe.class);
    b.put(RoamSetting.class, aybp.class);
    b.put(NearbyPeopleCard.class, aybh.class);
    b.put(HotChatInfo.class, aybf.class);
    b.put(Card.class, ayar.class);
    b.put(ExpiredPushBanner.class, aybb.class);
    b.put(ContactCard.class, ayat.class);
    b.put(EmoticonTab.class, ayba.class);
    b.put(ExtensionInfo.class, aybc.class);
    b.put(ShieldListInfo.class, aybs.class);
    b.put(SearchHistory.class, aybq.class);
    b.put(DiscussionMemberInfo.class, ayax.class);
    b.put(QQOperationViopTipTask.class, aybl.class);
    b.put(Reporting.class, aybn.class);
    b.put(PublicAccountInfo.class, aybk.class);
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