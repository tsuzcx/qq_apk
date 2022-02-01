package com.tencent.mobileqq.troop.api.config;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopMngHandlerProcessorConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<AbsTroopMngHandlerProcessor> c = new ArrayList();
  
  public static void a()
  {
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.d != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.d.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopMngHandlerProcessor)((Class)localObject3).newInstance();
            c.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopMngHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).b(paramAppInterface, paramString);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString1, String paramString2, TroopInfo paramTroopInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString1, paramString2, paramTroopInfo);
    }
  }
  
  public static void a(String paramString, int paramInt, Parcelable paramParcelable)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).a(paramString, paramInt, paramParcelable);
    }
  }
  
  public static void b(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).d(paramAppInterface, paramString);
    }
  }
  
  public static void c(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString);
    }
  }
  
  public static void d(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMngHandlerProcessor)localIterator.next()).c(paramAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMngHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */