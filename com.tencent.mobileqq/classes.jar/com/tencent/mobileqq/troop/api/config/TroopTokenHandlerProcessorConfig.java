package com.tencent.mobileqq.troop.api.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopTokenHandlerProcessorConfig
{
  private static ArrayList<AbsTroopTokenHandlerProcessor> a = new ArrayList();
  private static TroopTokenHandlerProcessorConfig b;
  
  private TroopTokenHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopTokenHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopTokenHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void b()
  {
    if (TroopCustomizedProcessorRegister.k != null)
    {
      Iterator localIterator = TroopCustomizedProcessorRegister.k.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopTokenHandlerProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopTokenHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString, @NonNull Object paramObject)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopTokenHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopTokenHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */