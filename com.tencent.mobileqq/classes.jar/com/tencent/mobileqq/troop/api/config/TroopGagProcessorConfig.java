package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopGagProcessorConfig
{
  private static ArrayList<AbsTroopGagProcessor> a = new ArrayList();
  private static TroopGagProcessorConfig b;
  
  private TroopGagProcessorConfig()
  {
    b();
  }
  
  public static TroopGagProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopGagProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(AppInterface paramAppInterface, long paramLong)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopGagProcessor)localIterator.next()).a(paramAppInterface, paramLong);
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopGagProcessor)localIterator.next()).a(paramAppInterface, paramLong, paramBoolean1, paramBoolean2);
    }
  }
  
  void b()
  {
    if (BizTroopCustomizedProcessorRegister.d != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.d.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopGagProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopGagProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopGagProcessorConfig
 * JD-Core Version:    0.7.0.1
 */