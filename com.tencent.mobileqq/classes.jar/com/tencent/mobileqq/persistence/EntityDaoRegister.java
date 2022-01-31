package com.tencent.mobileqq.persistence;

import awbj;
import awbk;
import awbl;
import awbm;
import awbn;
import awbq;
import awbr;
import awbs;
import awbt;
import awbu;
import awbz;
import awca;
import awcb;
import awcc;
import awcd;
import awcf;
import awch;
import awck;
import awcl;
import awcm;
import awcn;
import awco;
import awcp;
import awcq;
import awcr;
import awcs;
import awct;
import awcu;
import awcv;
import awcy;
import awcz;
import awda;
import awdb;
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
  private static HashMap<Class, awch> a = new HashMap(32);
  private static HashMap<Class, Class> b = new HashMap(32);
  
  static
  {
    System.nanoTime();
    b.put(TroopAssistantData.class, awcy.class);
    b.put(HotChatInfo.class, awcd.class);
    b.put(SearchHistory.class, awcr.class);
    b.put(NearbyPeopleCard.class, awcf.class);
    b.put(EmoticonTab.class, awbu.class);
    b.put(TroopRemindSettingData.class, awdb.class);
    b.put(ExtensionInfo.class, awca.class);
    b.put(DiscussionMemberInfo.class, awbr.class);
    b.put(Card.class, awbk.class);
    b.put(CommonlyUsedTroop.class, awbl.class);
    b.put(TroopMemberInfo.class, awda.class);
    b.put(DiscussionInfo.class, awbq.class);
    b.put(Emoticon.class, awbs.class);
    b.put(PhoneContact.class, awck.class);
    b.put(ExpiredPushBanner.class, awbz.class);
    b.put(ResourcePluginInfo.class, awcp.class);
    b.put(QZoneCover.class, awcn.class);
    b.put(Setting.class, awcs.class);
    b.put(Stranger.class, awcu.class);
    b.put(ConversationInfo.class, awbn.class);
    b.put(Ability.class, awbj.class);
    b.put(SubAccountInfo.class, awcv.class);
    b.put(Friends.class, awcb.class);
    b.put(TroopInfo.class, awcz.class);
    b.put(Groups.class, awcc.class);
    b.put(EmoticonPackage.class, awbt.class);
    b.put(ContactCard.class, awbm.class);
    b.put(RoamSetting.class, awcq.class);
    b.put(ShieldListInfo.class, awct.class);
    b.put(QQOperationViopTipTask.class, awcm.class);
    b.put(Reporting.class, awco.class);
    b.put(PublicAccountInfo.class, awcl.class);
  }
  
  public static awch a(Class paramClass)
  {
    localObject1 = (awch)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (awch)a.get(paramClass);
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