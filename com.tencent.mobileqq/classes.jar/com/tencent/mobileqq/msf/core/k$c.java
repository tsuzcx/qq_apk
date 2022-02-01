package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.b.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class k$c
  implements Runnable
{
  public static final int a = 5000;
  private static final String b = "SocketReaderOldMonitor";
  
  public void run()
  {
    try
    {
      int i = MsfSdkUtils.getThreadCounts("MsfCoreSocketReaderOld");
      Object localObject;
      if ((i >= 5) && (k.e()))
      {
        k.a(false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SocketReader多线程异常 ");
        ((StringBuilder)localObject).append(i);
        QLog.d("SocketReaderOldMonitor", 1, ((StringBuilder)localObject).toString());
        localObject = new HashMap();
        ((Map)localObject).put("count", String.valueOf(i));
        ((Map)localObject).put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
          MsfCore.sCore.statReporter.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, (Map)localObject, false, false);
        }
        a.a(new com.tencent.mobileqq.msf.sdk.b.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader5多线程异常");
      }
      else if ((i >= 3) && (k.f()))
      {
        k.b(false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SocketReader多线程异常 ");
        ((StringBuilder)localObject).append(i);
        QLog.d("SocketReaderOldMonitor", 1, ((StringBuilder)localObject).toString());
        localObject = new HashMap();
        ((Map)localObject).put("count", String.valueOf(i));
        ((Map)localObject).put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
          MsfCore.sCore.statReporter.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, (Map)localObject, false, false);
        }
        a.a(new com.tencent.mobileqq.msf.sdk.b.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader3多线程异常");
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SocketReader current ");
        ((StringBuilder)localObject).append(i);
        QLog.d("SocketReaderOldMonitor", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      k.b(false);
      k.a(false);
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k.c
 * JD-Core Version:    0.7.0.1
 */