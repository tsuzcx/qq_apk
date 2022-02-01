package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class aq$g
  implements Runnable
{
  public volatile AtomicBoolean a = new AtomicBoolean(false);
  public boolean b = false;
  
  private aq$g(aq paramaq) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.b) {}
    int i;
    do
    {
      return;
      i = MsfCore.sCore.quicksender.a().size();
    } while ((MsfCore.sCore.quicksender.a() == null) || (i <= 0) || (i >= 100));
    Object localObject = MsfCore.sCore.quicksender.a().values();
    long l1;
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      l1 = 0L;
      label89:
      if (((Iterator)localObject).hasNext())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject).next();
        if (localToServiceMsg != null)
        {
          l1 = ((Long)localToServiceMsg.getAttribute("attr_quick_send_time", Long.valueOf(0L))).longValue();
          long l2 = SystemClock.elapsedRealtime() - l1;
          l1 = l2;
          if (l2 > aq.g().i)
          {
            bool = true;
            i = localToServiceMsg.getRequestSsoSeq();
            l1 = l2;
          }
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        this.c.i.r = l1;
        aq.a(this.c, 32);
        if (QLog.isColorLevel()) {
          QLog.d("WeaknetNew", 2, "weaknet quickSendCheck reason=" + Integer.toHexString(aq.a(this.c)) + " ssoSeq=" + i + " timeout=" + bool);
        }
      }
      if ((this.c.a(32)) || (MsfCore.sCore.quicksender.a().size() <= 0) || (aq.c(this.c) == null) || (aq.c(this.c).get() == null)) {
        break;
      }
      aq.d(this.c).postDelayed((Runnable)aq.c(this.c).get(), aq.g().i);
      return;
      break label89;
      i = 0;
      continue;
      i = 0;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aq.g
 * JD-Core Version:    0.7.0.1
 */