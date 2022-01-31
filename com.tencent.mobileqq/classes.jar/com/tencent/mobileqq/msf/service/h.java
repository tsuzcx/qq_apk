package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  private static final String a = "MSF.S.IPCTransportUtil";
  private static final int[] b = { 716800, 655360, 409600, 204800, 102400 };
  private static int c = b[0];
  private static boolean d = false;
  
  static int a()
  {
    b();
    return c;
  }
  
  static void b()
  {
    int i = 0;
    if (d) {}
    label180:
    for (;;)
    {
      return;
      c localc = c();
      if (localc == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.IPCTransportUtil", 2, "adjustTransPackageLenIfNeed, but appProcessInfo = null");
        }
      }
      else
      {
        d = true;
        FromServiceMsg localFromServiceMsg = new FromServiceMsg();
        localFromServiceMsg.setServiceCmd("test_ipc_package_length");
        localFromServiceMsg.setBusinessFail(-2);
        localFromServiceMsg.setRequestSsoSeq(-1);
        MsfMessagePair localMsfMessagePair = new MsfMessagePair(null, localFromServiceMsg);
        for (;;)
        {
          for (;;)
          {
            if (i >= b.length) {
              break label180;
            }
            int j = b[i];
            localFromServiceMsg.putWupBuffer(new byte[j]);
            try
            {
              b.a(localMsfMessagePair, 0, j, j, localc.c());
              c = j;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.S.IPCTransportUtil", 2, "adjustTransPackageLenIfNeed suc, len = " + c);
              return;
            }
            catch (Throwable localThrowable)
            {
              if (i == b.length - 1) {
                c = j;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.IPCTransportUtil", 2, "adjustTransPackageLenIfNeed throw e: ", localThrowable);
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private static c c()
  {
    Iterator localIterator = e.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (c)e.c.get(localObject);
      if ((localObject != null) && (((c)localObject).c() != null)) {
        return localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.h
 * JD-Core Version:    0.7.0.1
 */