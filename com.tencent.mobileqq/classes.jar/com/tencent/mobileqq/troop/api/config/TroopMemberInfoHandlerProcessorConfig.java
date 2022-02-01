package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imcore.config.extension.TroopCustomizedProcessorRegister;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;

public final class TroopMemberInfoHandlerProcessorConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<AbsTroopMemberInfoHandlerProcessor> c = new ArrayList();
  
  public static void a()
  {
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      if (TroopCustomizedProcessorRegister.f != null)
      {
        Iterator localIterator = TroopCustomizedProcessorRegister.f.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (Class)localIterator.next();
          try
          {
            localObject3 = (AbsTroopMemberInfoHandlerProcessor)((Class)localObject3).newInstance();
            c.add(localObject3);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("TroopMemberInfoHandlerProcessorConfig", 1, "Init Fail,", localThrowable);
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
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull ToServiceMsg paramToServiceMsg, @NonNull Map<String, String> paramMap, List<oidb_0x787.MemberLevelInfo> paramList)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopMemberInfoHandlerProcessor)localIterator.next()).a(paramAppInterface, paramToServiceMsg, paramMap, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopMemberInfoHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */