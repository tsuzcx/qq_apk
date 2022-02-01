package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopBatchInfoHandlerProcessorConfig
{
  private static TroopBatchInfoHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopBatchInfoHandlerProcessorConfig;
  private static ArrayList<AbsTroopBatchInfoHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopBatchInfoHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopBatchInfoHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopBatchInfoHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopBatchInfoHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopBatchInfoHandlerProcessorConfig = new TroopBatchInfoHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopBatchInfoHandlerProcessorConfig;
  }
  
  private static void a()
  {
    if (TroopCustomizedProcessorRegister.j != null)
    {
      Iterator localIterator = TroopCustomizedProcessorRegister.j.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopBatchInfoHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopBatchInfoHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopBatchInfoHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopBatchInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */