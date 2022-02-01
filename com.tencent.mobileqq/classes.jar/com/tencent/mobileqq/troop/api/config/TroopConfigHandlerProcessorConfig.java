package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopConfigHandlerProcessorConfig
{
  private static TroopConfigHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopConfigHandlerProcessorConfig;
  private static ArrayList<AbsTroopConfigHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopConfigHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopConfigHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopConfigHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopConfigHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopConfigHandlerProcessorConfig = new TroopConfigHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopConfigHandlerProcessorConfig;
  }
  
  void a()
  {
    if (BizTroopCustomizedProcessorRegister.h != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopConfigHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopConfigHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, oidb_0x496.AioKeyword paramAioKeyword)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopConfigHandlerProcessor)localIterator.next()).a(paramAppInterface, paramAioKeyword);
    }
  }
  
  public void a(AppInterface paramAppInterface, oidb_0x496.GroupMsgConfig paramGroupMsgConfig)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopConfigHandlerProcessor)localIterator.next()).a(paramAppInterface, paramGroupMsgConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopConfigHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */