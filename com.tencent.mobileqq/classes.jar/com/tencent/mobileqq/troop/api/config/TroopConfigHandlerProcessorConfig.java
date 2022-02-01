package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopConfigHandlerProcessorConfig
{
  private static ArrayList<AbsTroopConfigHandlerProcessor> a = new ArrayList();
  private static TroopConfigHandlerProcessorConfig b;
  
  private TroopConfigHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopConfigHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopConfigHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(AppInterface paramAppInterface, oidb_0x496.AioKeyword paramAioKeyword)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopConfigHandlerProcessor)localIterator.next()).a(paramAppInterface, paramAioKeyword);
    }
  }
  
  public void a(AppInterface paramAppInterface, oidb_0x496.GroupMsgConfig paramGroupMsgConfig)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopConfigHandlerProcessor)localIterator.next()).a(paramAppInterface, paramGroupMsgConfig);
    }
  }
  
  void b()
  {
    if (BizTroopCustomizedProcessorRegister.h != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.h.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopConfigHandlerProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopConfigHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopConfigHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */