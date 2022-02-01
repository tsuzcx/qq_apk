package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetTroopListRespV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TroopListHandlerProcessorConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<AbsTroopListHandlerProcessor> c = new ArrayList();
  
  public static void a()
  {
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.a != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.a.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopListHandlerProcessor)((Class)localObject3).newInstance();
            c.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopListHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull AppInterface paramAppInterface)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopListHandlerProcessor)localIterator.next()).a(paramAppInterface);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramGetTroopListRespV2);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, Map<String, Boolean> paramMap)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopListHandlerProcessor)localIterator.next()).a(paramAppInterface, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopListHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */