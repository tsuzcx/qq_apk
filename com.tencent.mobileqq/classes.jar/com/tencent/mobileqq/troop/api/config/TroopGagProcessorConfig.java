package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopGagProcessorConfig
{
  private static TroopGagProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopGagProcessorConfig;
  private static ArrayList<AbsTroopGagProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopGagProcessorConfig()
  {
    a();
  }
  
  public static TroopGagProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopGagProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopGagProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopGagProcessorConfig = new TroopGagProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopGagProcessorConfig;
  }
  
  void a()
  {
    if (BizTroopCustomizedProcessorRegister.d != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.d.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopGagProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopGagProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopGagProcessor)localIterator.next()).a(paramAppInterface, paramLong);
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopGagProcessor)localIterator.next()).a(paramAppInterface, paramLong, paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopGagProcessorConfig
 * JD-Core Version:    0.7.0.1
 */