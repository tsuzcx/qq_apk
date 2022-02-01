package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public final class TroopRedDotHandlerProcessorConfig
{
  private static TroopRedDotHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopRedDotHandlerProcessorConfig;
  private static ArrayList<AbsTroopRedDotHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopRedDotHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopRedDotHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopRedDotHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopRedDotHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopRedDotHandlerProcessorConfig = new TroopRedDotHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopRedDotHandlerProcessorConfig;
  }
  
  private static void a()
  {
    if (BizTroopCustomizedProcessorRegister.b != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopRedDotHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopRedDotHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, long paramLong, @NonNull TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopRedDotHandlerProcessor)localIterator.next()).a(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopRedDotHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopRedDotHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */