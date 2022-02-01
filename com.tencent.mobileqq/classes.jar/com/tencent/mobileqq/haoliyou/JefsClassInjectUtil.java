package com.tencent.mobileqq.haoliyou;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class JefsClassInjectUtil
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_JefsClassConfig.yml", version=1)
  public static ArrayList<Class<? extends IJefsClassInjectInterface>> a = new ArrayList();
  
  static
  {
    a.add(JefsClassInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClassInjectUtil
 * JD-Core Version:    0.7.0.1
 */