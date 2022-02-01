package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopMemberListHandlerProcessorConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<AbsTroopMemberListHandlerProcessor> c = new ArrayList();
  
  public static void a()
  {
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.g != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.g.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopMemberListHandlerProcessor)((Class)localObject3).newInstance();
            c.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.i("TroopMemberListHandlerProcessorConfig", 1, "Init Fail", localThrowable);
          }
        }
      }
      a.set(true);
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramLong, paramList);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo, paramArrayList);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramLong);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopMemberInfo> paramArrayList)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramArrayList);
    }
  }
  
  public static void a(@NonNull TroopMemberCard paramTroopMemberCard, oidb_0x787.MemberLevelInfo paramMemberLevelInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramTroopMemberCard, paramMemberLevelInfo);
    }
  }
  
  public static void a(@NonNull TroopMemberCardInfo paramTroopMemberCardInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramTroopMemberCardInfo, paramstTroopMemberInfo);
    }
  }
  
  public static void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).a(paramTroopMemberInfo, paramstTroopMemberInfo);
    }
  }
  
  public static void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberListHandlerProcessor)localIterator.next()).b(paramTroopMemberInfo, paramstTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMemberListHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */