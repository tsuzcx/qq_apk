package com.tencent.util;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class UtilApi
{
  public static IUtilApi a;
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_Util.yml", version=2)
  public static ArrayList<Class<? extends IUtilApi>> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(UtilApiImpl.class);
    try
    {
      jdField_a_of_type_ComTencentUtilIUtilApi = (IUtilApi)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UtilApi", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.UtilApi
 * JD-Core Version:    0.7.0.1
 */