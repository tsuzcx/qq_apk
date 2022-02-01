package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public final class TroopRedDotHandlerProcessorConfig
{
  private static ArrayList<AbsTroopRedDotHandlerProcessor> a = new ArrayList();
  private static TroopRedDotHandlerProcessorConfig b;
  
  private TroopRedDotHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopRedDotHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopRedDotHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void b()
  {
    if (BizTroopCustomizedProcessorRegister.b != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopRedDotHandlerProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopRedDotHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, long paramLong, @NonNull TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopRedDotHandlerProcessor)localIterator.next()).a(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopRedDotHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopRedDotHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */