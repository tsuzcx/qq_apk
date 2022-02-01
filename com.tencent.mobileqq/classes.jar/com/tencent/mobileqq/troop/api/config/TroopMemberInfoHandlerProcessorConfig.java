package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;

public final class TroopMemberInfoHandlerProcessorConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<AbsTroopMemberInfoHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.f != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.f.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopMemberInfoHandlerProcessor)((Class)localObject3).newInstance();
            jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopMemberInfoHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull ToServiceMsg paramToServiceMsg, @NonNull Map<String, String> paramMap, List<oidb_0x787.MemberLevelInfo> paramList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberInfoHandlerProcessor)localIterator.next()).a(paramAppInterface, paramToServiceMsg, paramMap, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMemberInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */