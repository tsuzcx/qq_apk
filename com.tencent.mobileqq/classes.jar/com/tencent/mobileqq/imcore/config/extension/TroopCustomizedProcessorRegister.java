package com.tencent.mobileqq.imcore.config.extension;

import com.tencent.mobileqq.activity.troop.config.ApolloInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.ColorNickProcessor;
import com.tencent.mobileqq.activity.troop.config.HiddenChatTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.HiddenChatTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.RingUpdateTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.RingUpdateTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopExternalTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopFaceMemberListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopFaceTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopFaceTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopGameCardTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopHornorTroopListProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMaskTroopInfoProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopMemberInfoProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.troop.api.config.AbsTroopHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import java.util.ArrayList;

public class TroopCustomizedProcessorRegister
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=3)
  public static ArrayList<Class<? extends AbsTroopListHandlerProcessor>> a = new ArrayList();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=3)
  public static ArrayList<Class<? extends AbsTroopHandlerProcessor>> b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_TroopCustomizedConfig.yml", version=3)
  public static ArrayList<Class<? extends AbsTroopInfoHandlerProcessor>> c;
  
  static
  {
    a.add(TroopHornorTroopListProcessor.class);
    a.add(RingUpdateTroopListProcessor.class);
    a.add(TroopFaceTroopListProcessor.class);
    a.add(TroopGameCardTroopListProcessor.class);
    a.add(HiddenChatTroopListProcessor.class);
    a.add(TroopExternalTroopListProcessor.class);
    b = new ArrayList();
    b.add(TroopFaceMemberListProcessor.class);
    b.add(ApolloInfoProcessor.class);
    b.add(ColorNickProcessor.class);
    b.add(TroopMemberInfoProcessor.class);
    c = new ArrayList();
    c.add(HiddenChatTroopInfoProcessor.class);
    c.add(RingUpdateTroopInfoProcessor.class);
    c.add(TroopMaskTroopInfoProcessor.class);
    c.add(TroopFaceTroopInfoProcessor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister
 * JD-Core Version:    0.7.0.1
 */