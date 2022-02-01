package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopManagerBizHandlerProcessorConfig
{
  private static ArrayList<AbsTroopManagerBizHandlerProcessor> a = new ArrayList();
  private static TroopManagerBizHandlerProcessorConfig b;
  
  private TroopManagerBizHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopManagerBizHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopManagerBizHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(AppInterface paramAppInterface, TroopInfo paramTroopInfo, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopManagerBizHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopInfo, paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2, paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAppInterface;
    }
  }
  
  void b()
  {
    if (BizTroopCustomizedProcessorRegister.g != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.g.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopManagerBizHandlerProcessor)((Class)localObject).newInstance();
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
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopManagerBizHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */