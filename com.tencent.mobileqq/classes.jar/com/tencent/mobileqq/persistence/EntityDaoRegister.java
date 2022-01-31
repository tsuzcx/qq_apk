package com.tencent.mobileqq.persistence;

import aukc;
import aukd;
import auke;
import aukf;
import aukg;
import aukj;
import aukk;
import aukl;
import aukm;
import aukn;
import auks;
import aukt;
import auku;
import aukv;
import aukw;
import auky;
import aula;
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
import auln;
import aulo;
import aulr;
import auls;
import ault;
import aulu;
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
  private static HashMap<Class, aula> a = new HashMap(32);
  private static HashMap<Class, Class> b = new HashMap(32);
  
  static
  {
    System.nanoTime();
    b.put(TroopAssistantData.class, aulr.class);
    b.put(HotChatInfo.class, aukw.class);
    b.put(SearchHistory.class, aulk.class);
    b.put(NearbyPeopleCard.class, auky.class);
    b.put(EmoticonTab.class, aukn.class);
    b.put(TroopRemindSettingData.class, aulu.class);
    b.put(ExtensionInfo.class, aukt.class);
    b.put(DiscussionMemberInfo.class, aukk.class);
    b.put(Card.class, aukd.class);
    b.put(CommonlyUsedTroop.class, auke.class);
    b.put(TroopMemberInfo.class, ault.class);
    b.put(DiscussionInfo.class, aukj.class);
    b.put(Emoticon.class, aukl.class);
    b.put(PhoneContact.class, auld.class);
    b.put(ExpiredPushBanner.class, auks.class);
    b.put(ResourcePluginInfo.class, auli.class);
    b.put(QZoneCover.class, aulg.class);
    b.put(Setting.class, aull.class);
    b.put(Stranger.class, auln.class);
    b.put(ConversationInfo.class, aukg.class);
    b.put(Ability.class, aukc.class);
    b.put(SubAccountInfo.class, aulo.class);
    b.put(Friends.class, auku.class);
    b.put(TroopInfo.class, auls.class);
    b.put(Groups.class, aukv.class);
    b.put(EmoticonPackage.class, aukm.class);
    b.put(ContactCard.class, aukf.class);
    b.put(RoamSetting.class, aulj.class);
    b.put(ShieldListInfo.class, aulm.class);
    b.put(QQOperationViopTipTask.class, aulf.class);
    b.put(Reporting.class, aulh.class);
    b.put(PublicAccountInfo.class, aule.class);
  }
  
  public static aula a(Class paramClass)
  {
    localObject1 = (aula)a.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)b.get(paramClass);
    } while (localObject3 == null);
    synchronized (a)
    {
      localObject2 = (aula)a.get(paramClass);
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