package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.group.group_member_info.MemberInfo;

public class TroopMemberCardHandlerProcessorConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<AbsTroopMemberCardHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.h != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.h.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopMemberCardHandlerProcessor)((Class)localObject3).newInstance();
            jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopMemberCardHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull TroopMemberCard paramTroopMemberCard, long paramLong, group_member_info.MemberInfo paramMemberInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberCardHandlerProcessor)localIterator.next()).a(paramTroopMemberCard, paramLong, paramMemberInfo);
    }
  }
  
  public static void a(@NonNull TroopMemberInfo paramTroopMemberInfo, TroopMemberCard paramTroopMemberCard)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberCardHandlerProcessor)localIterator.next()).a(paramTroopMemberInfo, paramTroopMemberCard);
    }
  }
  
  public static Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (Object[] arrayOfObject = null; localIterator.hasNext(); arrayOfObject = ((AbsTroopMemberCardHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramArrayList)) {}
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMemberCardHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */