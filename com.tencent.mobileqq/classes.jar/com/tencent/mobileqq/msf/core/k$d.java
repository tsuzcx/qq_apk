package com.tencent.mobileqq.msf.core;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.b.a;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

class k$d
  implements Runnable
{
  private static final String a = "WorkerThreadMonitor";
  private static final long d = 14400000L;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private boolean b = false;
  private final k.a c = new k.a(40);
  private long h = 0L;
  private long i = 0L;
  
  public void run()
  {
    int k = 0;
    Object localObject4 = "";
    for (;;)
    {
      try
      {
        boolean bool = this.c.a(MsfCore.sCore.sender.g.size());
        long l1 = MsfCore.sCore.sender.g.size();
        Object localObject1 = localObject4;
        j = k;
        if (bool)
        {
          localObject1 = localObject4;
          j = k;
          if (!this.b)
          {
            this.b = true;
            this.c.a();
            j = 1;
            QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by sender queue increasing ,queue size", Long.valueOf(l1) });
            localObject1 = "MsfCoreMsgSender";
          }
        }
        this.h = MsfCore.sCore.sender.a();
        long l2 = Math.abs(SystemClock.uptimeMillis() - this.h);
        long l3 = MsfCore.sCore.sender.b();
        localObject4 = localObject1;
        k = j;
        if (l2 >= 14400000L)
        {
          localObject4 = localObject1;
          k = j;
          if (!this.b)
          {
            localObject4 = localObject1;
            k = j;
            if (l3 >= 100L)
            {
              this.b = true;
              k = 2;
              QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by not send data for one hour,interval = ", Long.valueOf(l2) });
              localObject4 = "MsfCoreMsgSender";
              MsfCore.sCore.sender.c();
            }
          }
        }
        this.i = MsfCore.sCore.sender.b.l().f();
        long l4 = Math.abs(SystemClock.uptimeMillis() - this.i);
        if ((l4 < 14400000L) || (this.b)) {
          break label705;
        }
        this.b = true;
        k = 3;
        QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by not receive data for one hour,interval =", Long.valueOf(l4) });
        localObject1 = "MsfCoreSocketReaderNew";
        QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF check result[ senderSize:", Long.valueOf(l1), ",sendInterval:", Long.valueOf(l2), ",receiveInterval=", Long.valueOf(l4), ",addCmdCount=", Long.valueOf(l3) });
        if (this.b)
        {
          String str = MsfSdkUtils.getThreadStackString((String)localObject1);
          localObject4 = MsfCore.sCore.getAccountCenter().i();
          HashMap localHashMap = new HashMap();
          localHashMap.put("thread", localObject1);
          localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
          if (localObject4 == null) {
            continue;
          }
          localHashMap.put("uin", localObject4);
          if (str == null) {
            continue;
          }
          localObject4 = str;
          localHashMap.put("stack", localObject4);
          localHashMap.put("killReason", String.valueOf(k));
          localHashMap.put("senderSize", String.valueOf(l1));
          localHashMap.put("sendInterval", String.valueOf(l2));
          localHashMap.put("receiveInterval", String.valueOf(l4));
          localHashMap.put("addCmdCount", String.valueOf(l3));
          if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a("msf_core_EvtMsfThreadHeldKillMSF", true, 0L, 0L, localHashMap, false, false);
          }
          if (Math.random() > 0.001000000047497451D) {
            continue;
          }
          j = 1;
          if (j != 0) {
            a.a(new com.tencent.mobileqq.msf.sdk.b.b((String)localObject1 + " QueueHeld"), (String)localObject1 + "HeldCatchedException:" + str, str);
          }
          Thread.sleep(10000L);
          Process.killProcess(Process.myPid());
        }
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("WorkerThreadMonitor", 2, localException.getMessage(), localException);
        continue;
      }
      finally
      {
        k.c();
      }
      return;
      localObject4 = "0000";
      continue;
      localObject4 = "null";
      continue;
      j = 0;
      continue;
      label705:
      Object localObject3 = localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k.d
 * JD-Core Version:    0.7.0.1
 */