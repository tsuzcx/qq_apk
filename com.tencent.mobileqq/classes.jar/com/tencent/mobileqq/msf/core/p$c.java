package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.report.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

public class p$c
  implements Runnable
{
  public static final int a = 5000;
  private static final String b = "SocketReaderOldMonitor";
  
  public void run()
  {
    try
    {
      int i = MsfSdkUtils.getThreadCounts("MsfCoreSocketReaderOld");
      Properties localProperties;
      if ((i >= 5) && (p.e()))
      {
        p.a(false);
        QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
        localProperties = new Properties();
        localProperties.setProperty("count", String.valueOf(i));
        localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.SocketReaderMultiThreadException", localProperties);
        a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader5多线程异常");
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SocketReaderOldMonitor", 1, "SocketReader current " + i);
        return;
        if ((i >= 3) && (p.f()))
        {
          p.b(false);
          QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
          localProperties = new Properties();
          localProperties.setProperty("count", String.valueOf(i));
          localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.SocketReaderMultiThreadException", localProperties);
          a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader3多线程异常");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      p.b(false);
      p.a(false);
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.p.c
 * JD-Core Version:    0.7.0.1
 */