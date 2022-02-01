package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

class ak$h
  implements Runnable
{
  static final short a = 10;
  final HashMap b = new HashMap(10);
  StringBuilder c = null;
  boolean d = false;
  
  private ak$h(ak paramak) {}
  
  public void run()
  {
    if (this.d) {
      return;
    }
    try
    {
      Object localObject4;
      int i;
      if (MsfCore.sCore.sender.d.size() >= ak.g().e)
      {
        this.b.clear();
        localObject4 = MsfCore.sCore.sender.d.values().iterator();
        i = 0;
      }
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        if (((Iterator)localObject4).hasNext())
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject4).next();
          if (!localToServiceMsg.isNeedCallback()) {
            continue;
          }
          localObject3 = localToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = localToServiceMsg.getAttribute("__timestamp_msf2net");
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject3 = localToServiceMsg.getAttribute("__timestamp_addSendQueue");
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject1 = localToServiceMsg.getAttribute("__timestamp_app2msf");
                if (localObject1 == null) {
                  continue;
                }
              }
            }
          }
          long l = ((Long)localObject1).longValue();
          if ((l <= 0L) || (System.currentTimeMillis() - l <= ak.g().g)) {
            break label736;
          }
          if (this.b.size() < 10)
          {
            i = (short)(i + 1);
            this.b.put(localToServiceMsg.getServiceCmd(), Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
            break label736;
          }
        }
        if ((i >= ak.g().e) && (ak.g().f >= 0))
        {
          this.e.i.j = i;
          this.e.i.k = ((short)this.b.size());
          ak.a(this.e, 4);
          if (QLog.isColorLevel())
          {
            this.c = new StringBuilder(512);
            this.c.append("wakenet ssoCheck current:" + Integer.toHexString(ak.a(this.e)) + " sendQueue:" + MsfCore.sCore.sender.d.size() + " detectQueue:" + MsfCore.sCore.sender.f.size() + " waitQueue:" + MsfCore.sCore.sender.g.size() + " delayWaitQueue:" + MsfCore.sCore.sender.h.size() + " bnbc: \n");
            localObject1 = this.b.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (String)((Iterator)localObject1).next();
              localObject4 = (Integer)this.b.get(localObject3);
              this.c.append(" ssoSeq:").append(localObject4).append(" serviceCmd:").append((String)localObject3).append("\n");
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeaknetNew", 1, localThrowable.getMessage(), localThrowable);
      }
      return;
      QLog.d("WeaknetNew", 2, this.c.toString());
      this.c = null;
      return;
    }
    finally
    {
      if ((ak.e(this.e) != null) && (ak.e(this.e).get() != null)) {
        ak.d(this.e).postDelayed((Runnable)ak.e(this.e).get(), ak.g().g);
      }
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ak.h
 * JD-Core Version:    0.7.0.1
 */