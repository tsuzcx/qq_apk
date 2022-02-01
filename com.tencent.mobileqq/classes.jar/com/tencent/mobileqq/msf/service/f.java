package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private static final String a = "MSF.S.IPCTransportManager";
  private static final int[] b = { 716800, 655360, 409600, 204800, 102400 };
  private int c = b[0];
  private boolean d = false;
  
  public static f a()
  {
    return f.a.a();
  }
  
  private c d()
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
  
  int b()
  {
    c();
    return this.c;
  }
  
  void c()
  {
    if (this.d) {
      return;
    }
    c localc = d();
    if (localc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.IPCTransportManager", 2, "adjustTransPackageLenIfNeed, but appProcessInfo = null");
      }
      return;
    }
    FromServiceMsg localFromServiceMsg = new FromServiceMsg();
    localFromServiceMsg.setServiceCmd("test_ipc_package_length");
    localFromServiceMsg.setBusinessFail(-2);
    localFromServiceMsg.setRequestSsoSeq(-1);
    MsfMessagePair localMsfMessagePair = new MsfMessagePair(null, localFromServiceMsg);
    int i = 0;
    for (;;)
    {
      Object localObject = b;
      if (i >= localObject.length) {
        break;
      }
      int j = localObject[i];
      try
      {
        localFromServiceMsg.putWupBuffer(new byte[j]);
        e.d.a(localMsfMessagePair, localc.c());
        this.c = j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adjustTransPackageLenIfNeed suc, len = ");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("MSF.S.IPCTransportManager", 1, ((StringBuilder)localObject).toString());
      }
      catch (Throwable localThrowable)
      {
        if (i == b.length - 1)
        {
          this.c = j;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("adjustTransPackageLenIfNeed fail, last len = ");
          localStringBuilder.append(this.c);
          QLog.d("MSF.S.IPCTransportManager", 1, localStringBuilder.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.IPCTransportManager", 2, "adjustTransPackageLenIfNeed throw e: ", localThrowable);
        }
        i += 1;
      }
    }
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.f
 * JD-Core Version:    0.7.0.1
 */