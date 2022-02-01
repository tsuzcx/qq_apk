package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopBatchInfoHandlerProcessorConfig
{
  private static ArrayList<AbsTroopBatchInfoHandlerProcessor> a = new ArrayList();
  private static TroopBatchInfoHandlerProcessorConfig b;
  
  private TroopBatchInfoHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopBatchInfoHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopBatchInfoHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void b()
  {
    if (TroopCustomizedProcessorRegister.j != null)
    {
      Iterator localIterator = TroopCustomizedProcessorRegister.j.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopBatchInfoHandlerProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopBatchInfoHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopBatchInfoHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopBatchInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */