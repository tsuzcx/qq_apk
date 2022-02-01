package com.tencent.mobileqq.qqsec.api;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.security.SecControllerInjectImpl;
import java.util.ArrayList;

public class QQSecBlockInjectUtil
{
  @ConfigInject(configPath="Business/qqsafeblock-api/src/main/resources/Inject_SecurityBlockConfig.yml", version=1)
  public static ArrayList<Class<? extends ISecControllerInterface>> a = new ArrayList();
  
  static
  {
    a.add(SecControllerInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqsec.api.QQSecBlockInjectUtil
 * JD-Core Version:    0.7.0.1
 */