package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.business.impl.LebaPluginSettingChange;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.List;

public class LebaSettingChangeProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaSettingChangeBiz>> a = new ArrayList();
  public List<ILebaSettingChangeBiz> b = new ArrayList();
  
  static
  {
    a.add(LebaPluginSettingChange.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaSettingChangeProxy
 * JD-Core Version:    0.7.0.1
 */