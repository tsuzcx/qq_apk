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

class al$g
  implements Runnable
{
  public volatile AtomicBoolean a = new AtomicBoolean(false);
  public boolean b = false;
  
  private al$g(al paramal) {}
  
  public void run()
  {
    if (this.b) {
      return;
    }
    int i = MsfCore.sCore.quicksender.a().size();
    if ((MsfCore.sCore.quicksender.a() != null) && (i > 0) && (i < 100))
    {
      Object localObject = MsfCore.sCore.quicksender.a().values();
      boolean bool = false;
      long l2;
      if ((localObject != null) && (((Collection)localObject).size() > 0))
      {
        localObject = ((Collection)localObject).iterator();
        long l1 = 0L;
        ToServiceMsg localToServiceMsg;
        do
        {
          do
          {
            l2 = l1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localToServiceMsg = (ToServiceMsg)((Iterator)localObject).next();
          } while (localToServiceMsg == null);
          l1 = ((Long)localToServiceMsg.getAttribute("attr_quick_send_time", Long.valueOf(0L))).longValue();
          l2 = SystemClock.elapsedRealtime() - l1;
          l1 = l2;
        } while (l2 <= al.g().i);
        bool = true;
        i = localToServiceMsg.getRequestSsoSeq();
      }
      else
      {
        l2 = 0L;
        i = 0;
      }
      if (bool)
      {
        this.c.i.r = l2;
        al.a(this.c, 32);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("weaknet quickSendCheck reason=");
          ((StringBuilder)localObject).append(Integer.toHexString(al.a(this.c)));
          ((StringBuilder)localObject).append(" ssoSeq=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" timeout=");
          ((StringBuilder)localObject).append(bool);
          QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
        }
      }
      if ((!this.c.a(32)) && (MsfCore.sCore.quicksender.a().size() > 0) && (al.c(this.c) != null) && (al.c(this.c).get() != null)) {
        al.d(this.c).postDelayed((Runnable)al.c(this.c).get(), al.g().i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.al.g
 * JD-Core Version:    0.7.0.1
 */