package com.tencent.mobileqq.imcore.config.extension;

import com.tencent.mobileqq.activity.troop.config.GAudioMsgTroopMngProcessor;
import com.tencent.mobileqq.activity.troop.config.GrayTipTroopPushProcessor;
import com.tencent.mobileqq.activity.troop.config.HiddenChatTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.HiddenChatTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.RingUpdateTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.RingUpdateTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopAddFriendProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopBaseRequestsProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopBatchInfoHandlerProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopBizTroopMngProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopBizTroopPushProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopColorNickMemberListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopExternalTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopFaceTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopFaceTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopGameCardTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopHornorMemberListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopHornorTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMaskTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberCardProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberColorNickProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberLevelProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberVipProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopTokenHandlerProcessor;
import com.tencent.mobileqq.apollo.config.ApolloInfoProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.troop.api.config.AbsTroopAddFriendHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopBaseHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopBatchInfoHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberCardHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberInfoHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopMngHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopPushHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopTokenHandlerProcessor;
import java.util.ArrayList;

public class TroopCustomizedProcessorRegister
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=5)
  public static ArrayList<Class<? extends AbsTroopListHandlerProcessor>> a = new ArrayList();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=4)
  public static ArrayList<Class<? extends AbsTroopInfoHandlerProcessor>> b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopPushHandlerProcessor>> c;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopMngHandlerProcessor>> d;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopAddFriendHandlerProcessor>> e;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopMemberInfoHandlerProcessor>> f;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends AbsTroopMemberListHandlerProcessor>> g;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopMemberCardHandlerProcessor>> h;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopBaseHandlerProcessor>> i;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopBatchInfoHandlerProcessor>> j;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopTokenHandlerProcessor>> k;
  
  static
  {
    a.add(TroopHornorTroopListProcessor.class);
    a.add(RingUpdateTroopListProcessor.class);
    a.add(TroopFaceTroopListProcessor.class);
    a.add(TroopGameCardTroopListProcessor.class);
    a.add(HiddenChatTroopListProcessor.class);
    a.add(TroopExternalTroopListProcessor.class);
    b = new ArrayList();
    b.add(HiddenChatTroopInfoProcessor.class);
    b.add(RingUpdateTroopInfoProcessor.class);
    b.add(TroopMaskTroopInfoProcessor.class);
    b.add(TroopFaceTroopInfoProcessor.class);
    c = new ArrayList();
    c.add(GrayTipTroopPushProcessor.class);
    c.add(TroopBizTroopPushProcessor.class);
    d = new ArrayList();
    d.add(TroopBizTroopMngProcessor.class);
    d.add(GAudioMsgTroopMngProcessor.class);
    e = new ArrayList();
    e.add(TroopAddFriendProcessor.class);
    f = new ArrayList();
    f.add(TroopMemberInfoProcessor.class);
    g = new ArrayList();
    g.add(ApolloInfoProcessor.class);
    g.add(TroopColorNickMemberListProcessor.class);
    g.add(TroopHornorMemberListProcessor.class);
    g.add(TroopMemberColorNickProcessor.class);
    g.add(TroopMemberLevelProcessor.class);
    g.add(TroopMemberListProcessor.class);
    g.add(TroopMemberVipProcessor.class);
    h = new ArrayList();
    h.add(TroopMemberCardProcessor.class);
    i = new ArrayList();
    i.add(TroopBaseRequestsProcessor.class);
    j = new ArrayList();
    j.add(TroopBatchInfoHandlerProcessor.class);
    k = new ArrayList();
    k.add(TroopTokenHandlerProcessor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister
 * JD-Core Version:    0.7.0.1
 */