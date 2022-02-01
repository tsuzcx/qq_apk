package com.tencent.mobileqq.persistence;

import azhd;
import azhe;
import azhf;
import azhg;
import azhi;
import azhj;
import azhk;
import azhl;
import azhm;
import azhn;
import azho;
import azhp;
import azhq;
import azhr;
import azht;
import azhv;
import azhw;
import azhx;
import azhy;
import azhz;
import azia;
import azib;
import azic;
import azid;
import azie;
import azif;
import azig;
import azih;
import azii;
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
    b.put(QZoneCover.class, azhy.class);
    b.put(EmoticonPackage.class, azhl.class);
    b.put(ExtensionInfo.class, azho.class);
    b.put(DiscussionInfo.class, azhi.class);
    b.put(Friends.class, azhp.class);
    b.put(Groups.class, azhq.class);
    b.put(RoamSetting.class, azib.class);
    b.put(TroopAssistantData.class, azih.class);
    b.put(ShieldListInfo.class, azie.class);
    b.put(Setting.class, azid.class);
    b.put(Emoticon.class, azhk.class);
    b.put(ExpiredPushBanner.class, azhn.class);
    b.put(NearbyPeopleCard.class, azht.class);
    b.put(EmoticonTab.class, azhm.class);
    b.put(TroopRemindSettingData.class, azii.class);
    b.put(SubAccountInfo.class, azig.class);
    b.put(CommonlyUsedTroop.class, azhe.class);
    b.put(Stranger.class, azif.class);
    b.put(HotChatInfo.class, azhr.class);
    b.put(ResourcePluginInfo.class, azia.class);
    b.put(PhoneContact.class, azhv.class);
    b.put(Card.class, azhd.class);
    b.put(DiscussionMemberInfo.class, azhj.class);
    b.put(ContactCard.class, azhf.class);
    b.put(SearchHistory.class, azic.class);
    b.put(ConversationInfo.class, azhg.class);
    b.put(QQOperationViopTipTask.class, azhx.class);
    b.put(Reporting.class, azhz.class);
    b.put(PublicAccountInfo.class, azhw.class);
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