package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.group.group_member_info.MemberInfo;

public final class TroopMemberInfoHandlerProcessorConfig
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<IGetMemberListObserver> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ArrayList<IGetTroopMemberInfoObserver> b = new ArrayList();
  private static ArrayList<IColorNickObserver> c = new ArrayList();
  private static ArrayList<IApolloInfoObserver> d = new ArrayList();
  private static ArrayList<IParseTroopMemberInfoObserver> e = new ArrayList();
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      i = ((IColorNickObserver)localIterator.next()).a(paramArrayOfByte);
    }
    return i;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    String str = null;
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      str = ((IColorNickObserver)localIterator.next()).a(paramByteStringMicro);
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    String str = null;
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      str = ((IColorNickObserver)localIterator.next()).a(paramString);
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = null;
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      str = ((IColorNickObserver)localIterator.next()).a(paramArrayOfByte);
    }
    return str;
  }
  
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
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject3 = (Class)localIterator.next();
            try
            {
              localObject3 = (AbsTroopHandlerProcessor)((Class)localObject3).newInstance();
              if ((localObject3 instanceof IGetMemberListObserver)) {
                jdField_a_of_type_JavaUtilArrayList.add((IGetMemberListObserver)localObject3);
              }
              if ((localObject3 instanceof IGetTroopMemberInfoObserver)) {
                b.add((IGetTroopMemberInfoObserver)localObject3);
              }
              if ((localObject3 instanceof IColorNickObserver)) {
                c.add((IColorNickObserver)localObject3);
              }
              if ((localObject3 instanceof IApolloInfoObserver)) {
                d.add((IApolloInfoObserver)localObject3);
              }
              if ((localObject3 instanceof IParseTroopMemberInfoObserver)) {
                e.add((IParseTroopMemberInfoObserver)localObject3);
              }
            }
            catch (Throwable localThrowable)
            {
              QLog.e("TroopMemberInfoHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
            }
          }
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IGetMemberListObserver)localIterator.next()).a(paramAppInterface, paramTroopInfo, paramArrayList);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IGetTroopMemberInfoObserver)localIterator.next()).a(paramAppInterface, paramString, paramLong);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, ArrayList<stTroopMemberInfo> paramArrayList)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      ((IApolloInfoObserver)localIterator.next()).a(paramAppInterface, paramArrayList);
    }
  }
  
  public static void a(TroopInfo paramTroopInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IParseTroopMemberInfoObserver)localIterator.next()).a(paramTroopInfo, paramstTroopMemberInfo);
    }
  }
  
  public static void a(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IParseTroopMemberInfoObserver)localIterator.next()).a(paramTroopMemberCard, paramMemberInfo);
    }
  }
  
  public static void a(TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IParseTroopMemberInfoObserver)localIterator.next()).a(paramTroopMemberInfo, paramstTroopMemberInfo);
    }
  }
  
  public static void a(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IGetTroopMemberInfoObserver)localIterator.next()).a(paramstTroopMemberInfo, paramTroopMemberInfo);
    }
  }
  
  public static Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    Object[] arrayOfObject = null;
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      arrayOfObject = ((IGetTroopMemberInfoObserver)localIterator.next()).a(paramAppInterface, paramString, paramArrayList);
    }
    return arrayOfObject;
  }
  
  public static void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IParseTroopMemberInfoObserver)localIterator.next()).b(paramTroopMemberInfo, paramstTroopMemberInfo);
    }
  }
  
  public static void b(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IGetTroopMemberInfoObserver)localIterator.next()).b(paramstTroopMemberInfo, paramTroopMemberInfo);
    }
  }
  
  public static void c(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IParseTroopMemberInfoObserver)localIterator.next()).c(paramTroopMemberInfo, paramstTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMemberInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */