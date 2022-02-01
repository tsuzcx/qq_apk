package com.tencent.mobileqq.troop.api.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopTokenHandlerProcessorConfig
{
  private static TroopTokenHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopTokenHandlerProcessorConfig;
  private static ArrayList<AbsTroopTokenHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopTokenHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopTokenHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopTokenHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopTokenHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopTokenHandlerProcessorConfig = new TroopTokenHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopTokenHandlerProcessorConfig;
  }
  
  private static void a()
  {
    if (TroopCustomizedProcessorRegister.k != null)
    {
      Iterator localIterator = TroopCustomizedProcessorRegister.k.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopTokenHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopTokenHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString, @NonNull Object paramObject)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopTokenHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopTokenHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */