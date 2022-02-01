package com.tencent.mobileqq.msf.core.net.c;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public final class a
{
  private static final String a = "MSF.C.DeepSleepDetector";
  private static final int b = 120000;
  private a.a c = new a.a(this);
  private Handler d;
  private boolean e = false;
  private final Hashtable f = new Hashtable();
  
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
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onAppForeground");
    }
    q.f().removeCallbacks(this.c);
    boolean bool = a.a.a(this.c, true);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.DeepSleepDetector", 2, "find deep sleep.");
      }
      a(bool);
    }
    a.a.a(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.a(bool);
    }
    if (MsfService.core.sender != null) {
      MsfService.core.sender.h();
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onAppBackground");
    }
    a.a.a(this.c, SystemClock.elapsedRealtime());
    this.d.removeCallbacks(this.c);
    this.d.post(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.c();
    }
    if (MsfService.core.sender != null) {
      MsfService.core.sender.i();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onScreenOn");
    }
    boolean bool = a.a.a(this.c, true);
    if (bool)
    {
      this.d.removeCallbacks(this.c);
      a(bool);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScreenOn hasInDeepSleep ");
      localStringBuilder.append(bool);
      QLog.d("MSF.C.DeepSleepDetector", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    boolean bool2 = this.e;
    Object localObject = this.f;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.f.put(paramString, Long.valueOf(paramLong));
        continue;
        this.f.remove(paramString);
        if (!this.f.isEmpty())
        {
          bool1 = true;
          this.e = bool1;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onProcessViewableChanged process: ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", state: ");
            ((StringBuilder)localObject).append(paramBoolean);
            ((StringBuilder)localObject).append(", at: ");
            ((StringBuilder)localObject).append(paramLong);
            QLog.d("MSF.C.DeepSleepDetector", 2, ((StringBuilder)localObject).toString());
          }
          if ((this.e ^ bool2))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("lead to app state changed from: ");
              paramString.append(bool2);
              paramString.append(", to: ");
              paramString.append(this.e);
              QLog.d("MSF.C.DeepSleepDetector", 2, paramString.toString());
            }
            if (this.e)
            {
              c();
              return;
            }
            d();
          }
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public boolean b()
  {
    return a.a.a(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a
 * JD-Core Version:    0.7.0.1
 */