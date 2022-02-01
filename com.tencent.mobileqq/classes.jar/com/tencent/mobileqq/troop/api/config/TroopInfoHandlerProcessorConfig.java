package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public final class TroopInfoHandlerProcessorConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<AbsTroopInfoHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.b != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.b.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopInfoHandlerProcessor)((Class)localObject3).newInstance();
            jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopInfoHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
          }
        }
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopInfoHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo, paramGroupInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */