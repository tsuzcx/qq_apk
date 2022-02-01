package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.j;
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
      HashMap localHashMap;
      if ((i >= 5) && (k.e()))
      {
        k.a(false);
        QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
        localHashMap = new HashMap();
        localHashMap.put("count", String.valueOf(i));
        localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
          MsfCore.sCore.statReporter.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, localHashMap, false, false);
        }
        a.a(new com.tencent.mobileqq.msf.sdk.b.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader5多线程异常");
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SocketReaderOldMonitor", 1, "SocketReader current " + i);
        return;
        if ((i >= 3) && (k.f()))
        {
          k.b(false);
          QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
          localHashMap = new HashMap();
          localHashMap.put("count", String.valueOf(i));
          localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
            MsfCore.sCore.statReporter.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, localHashMap, false, false);
          }
          a.a(new com.tencent.mobileqq.msf.sdk.b.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader3多线程异常");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      k.b(false);
      k.a(false);
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k.c
 * JD-Core Version:    0.7.0.1
 */