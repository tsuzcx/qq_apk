package com.tencent.mobileqq.msf.core.net.c;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static final String a = "MSF.C.DeepSleepDetector";
  private static final int b = 120000;
  private a.a c = new a.a(this);
  private Handler d;
  private final List e = new ArrayList();
  private boolean f = false;
  private final Hashtable g = new Hashtable();
  
  public a(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  private void a(boolean paramBoolean)
  {
    if (MsfCore.sCore != null)
    {
      j localj = MsfCore.sCore.getStatReporter();
      if (localj != null) {
        localj.d(paramBoolean);
      }
    }
  }
  
  private List c()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.e)
    {
      if (this.e.size() > 0) {
        localArrayList.addAll(this.e);
      }
      return localArrayList;
    }
  }
  
  private void d()
  {
    q.f().removeCallbacks(this.c);
    boolean bool = a.a.a(this.c, true);
    if (bool) {
      a(bool);
    }
    QLog.d("MSF.C.DeepSleepDetector", 1, new Object[] { "[onAppForeground] isDeepSleep: ", Boolean.valueOf(bool) });
    a.a.a(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.a(bool);
    }
    if (MsfService.core.sender != null) {
      MsfService.core.sender.h();
    }
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).a();
    }
  }
  
  private void e()
  {
    QLog.d("MSF.C.DeepSleepDetector", 1, "[onAppBackground]");
    a.a.a(this.c, SystemClock.elapsedRealtime());
    this.d.removeCallbacks(this.c);
    this.d.post(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.c();
    }
    if (MsfService.core.sender != null) {
      MsfService.core.sender.i();
    }
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).b();
    }
  }
  
  public void a()
  {
    boolean bool = a.a.a(this.c, false);
    if (bool) {
      a(bool);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScreenOn hasInDeepSleep ");
    localStringBuilder.append(bool);
    QLog.d("MSF.C.DeepSleepDetector", 1, localStringBuilder.toString());
  }
  
  public void a(a.b paramb)
  {
    List localList = this.e;
    if (paramb != null) {}
    try
    {
      if (!this.e.contains(paramb)) {
        this.e.add(paramb);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    boolean bool2 = this.f;
    Object localObject = this.g;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.g.put(paramString, Long.valueOf(paramLong));
        continue;
        this.g.remove(paramString);
        if (!this.g.isEmpty())
        {
          bool1 = true;
          this.f = bool1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onProcessViewableChanged process: ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", state: ");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(", at: ");
          ((StringBuilder)localObject).append(paramLong);
          QLog.d("MSF.C.DeepSleepDetector", 1, ((StringBuilder)localObject).toString());
          if ((this.f ^ bool2))
          {
            paramString = new StringBuilder();
            paramString.append("lead to app state changed from: ");
            paramString.append(bool2);
            paramString.append(", to: ");
            paramString.append(this.f);
            QLog.d("MSF.C.DeepSleepDetector", 1, paramString.toString());
            if (this.f)
            {
              d();
              return;
            }
            e();
          }
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public void b(a.b paramb)
  {
    synchronized (this.e)
    {
      this.e.remove(paramb);
      return;
    }
  }
  
  public boolean b()
  {
    return a.a.a(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a
 * JD-Core Version:    0.7.0.1
 */