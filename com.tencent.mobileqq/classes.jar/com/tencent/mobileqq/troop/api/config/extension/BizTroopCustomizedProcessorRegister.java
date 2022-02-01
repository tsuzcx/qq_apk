package com.tencent.mobileqq.troop.api.config.extension;

import com.tencent.mobileqq.activity.troop.config.GrayTipsTroopManagerBizProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopAnnouncementProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopConfigProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopGagProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopOnlinePushProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopRedDotHandlerProcessor;
import com.tencent.mobileqq.activity.troop.config.TroopSurveyHandlerProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.troop.api.config.AbsRoamSettingProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopAnnouncementProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopConfigHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopGagProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopManagerBizHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopOnlinePushHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopRedDotHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.AbsTroopSurveyHandlerProcessor;
import com.tencent.mobileqq.troop.roamsetting.TroopRoamSettingProcessor;
import com.tencent.mobileqq.utils.OtherRoamSettingProcessor;
import java.util.ArrayList;

public class BizTroopCustomizedProcessorRegister
{
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsRoamSettingProcessor>> a = new ArrayList();
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopRedDotHandlerProcessor>> b;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopSurveyHandlerProcessor>> c;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopGagProcessor>> d;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopAnnouncementProcessor>> e;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopOnlinePushHandlerProcessor>> f;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopManagerBizHandlerProcessor>> g;
  @ConfigInject(configPath="Business/qqtroop-impl/src/main/resources/Inject_TroopCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsTroopConfigHandlerProcessor>> h;
  
  static
  {
    a.add(TroopRoamSettingProcessor.class);
    a.add(OtherRoamSettingProcessor.class);
    b = new ArrayList();
    b.add(TroopRedDotHandlerProcessor.class);
    c = new ArrayList();
    c.add(TroopSurveyHandlerProcessor.class);
    d = new ArrayList();
    d.add(TroopGagProcessor.class);
    e = new ArrayList();
    e.add(TroopAnnouncementProcessor.class);
    f = new ArrayList();
    f.add(TroopOnlinePushProcessor.class);
    g = new ArrayList();
    g.add(GrayTipsTroopManagerBizProcessor.class);
    h = new ArrayList();
    h.add(TroopConfigProcessor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister
 * JD-Core Version:    0.7.0.1
 */