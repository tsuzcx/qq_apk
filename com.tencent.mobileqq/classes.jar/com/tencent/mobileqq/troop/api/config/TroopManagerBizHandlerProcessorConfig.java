package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopManagerBizHandlerProcessorConfig
{
  private static TroopManagerBizHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopManagerBizHandlerProcessorConfig;
  private static ArrayList<AbsTroopManagerBizHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopManagerBizHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopManagerBizHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopManagerBizHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopManagerBizHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopManagerBizHandlerProcessorConfig = new TroopManagerBizHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopManagerBizHandlerProcessorConfig;
  }
  
  void a()
  {
    if (BizTroopCustomizedProcessorRegister.g != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.g.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopManagerBizHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopGagProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, TroopInfo paramTroopInfo, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopManagerBizHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo, paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2, paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopManagerBizHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */