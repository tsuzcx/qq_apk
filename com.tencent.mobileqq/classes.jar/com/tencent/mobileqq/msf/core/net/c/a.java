package com.tencent.mobileqq.msf.core.net.c;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public final class a
{
  private static final String a = "DeepSleepDetector";
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
      k localk = MsfCore.sCore.getStatReporter();
      if (localk != null) {
        localk.d(paramBoolean);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepSleepDetector", 2, "onAppForeground");
    }
    u.f().removeCallbacks(this.c);
    boolean bool = a.a.a(this.c);
    if (bool) {
      a(bool);
    }
    a.a.b(this.c);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepSleepDetector", 2, "onAppBackground");
    }
    a.a.a(this.c, SystemClock.elapsedRealtime());
    this.d.removeCallbacks(this.c);
    this.d.post(this.c);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepSleepDetector", 2, "onScreenOn");
    }
    boolean bool = a.a.a(this.c);
    if (bool)
    {
      this.d.removeCallbacks(this.c);
      a(bool);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeepSleepDetector", 2, "onScreenOn hasInDeepSleep " + bool);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    boolean bool2 = this.e;
    Hashtable localHashtable = this.f;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.f.put(paramString, Long.valueOf(paramLong));
        if (this.f.isEmpty()) {
          break label192;
        }
        bool1 = true;
        this.e = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("DeepSleepDetector", 2, "onProcessViewableChanged process: " + paramString + ", state: " + paramBoolean + ", at: " + paramLong);
        }
        if ((this.e ^ bool2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DeepSleepDetector", 2, "lead to app state changed from: " + bool2 + ", to: " + this.e);
          }
          if (!this.e) {
            break;
          }
          b();
        }
        return;
      }
      finally {}
      this.f.remove(paramString);
      continue;
      label192:
      boolean bool1 = false;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a
 * JD-Core Version:    0.7.0.1
 */