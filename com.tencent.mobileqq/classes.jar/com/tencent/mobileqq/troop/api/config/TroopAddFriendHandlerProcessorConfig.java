package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopAddFriendHandlerProcessorConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<AbsTroopAddFriendHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private TroopAddFriendHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopAddFriendHandlerProcessorConfig a()
  {
    return TroopAddFriendHandlerProcessorConfig.SingletonHoler.a();
  }
  
  private static void a()
  {
    if (TroopCustomizedProcessorRegister.e != null)
    {
      Iterator localIterator = TroopCustomizedProcessorRegister.e.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopAddFriendHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopAddFriendHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAddFriendHandlerProcessor)localIterator.next()).a(paramAppInterface);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, HashMap<String, Integer> paramHashMap)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAddFriendHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramHashMap);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAddFriendHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramHashMap, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopAddFriendHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */