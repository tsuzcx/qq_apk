package com.tencent.util;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class UtilApi
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_Util.yml", version=2)
  public static ArrayList<Class<? extends IUtilApi>> a = new ArrayList();
  public static IUtilApi b;
  
  static
  {
    a.add(UtilApiImpl.class);
    try
    {
      b = (IUtilApi)((Class)a.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UtilApi", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.UtilApi
 * JD-Core Version:    0.7.0.1
 */