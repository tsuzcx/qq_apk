package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopPushHandlerProcessorConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<AbsTroopPushHandlerProcessor> c = new ArrayList();
  
  public static void a()
  {
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.c != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.c.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopPushHandlerProcessor)((Class)localObject3).newInstance();
            c.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopPushHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopPushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramInt1, paramInt2);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong, int paramInt)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopPushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopPushHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */