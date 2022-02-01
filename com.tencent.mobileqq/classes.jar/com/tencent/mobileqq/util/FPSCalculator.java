package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class FPSCalculator
{
  private static volatile FPSCalculator i;
  private long a = 0L;
  private int b = 0;
  private Choreographer c;
  private Choreographer.FrameCallback d;
  private boolean e = false;
  private Handler f;
  private Vector<FPSCalculator.GetFPSListener> g = new Vector();
  private Object h = new Object();
  private Runnable j = new FPSCalculator.2(this);
  private Runnable k = new FPSCalculator.3(this);
  
  private static long a(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public static FPSCalculator a()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new FPSCalculator();
        }
      }
      finally {}
    }
    return i;
  }
  
  private void b()
  {
    if (this.e)
    {
      QLog.d("FPSCalculator", 2, "FPSCalculator is enable");
      return;
    }
    this.e = true;
    QLog.d("FPSCalculator", 2, "FPSCalculator set enable = true");
    if (this.f == null) {
      this.f = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.d == null) {
        this.d = new FPSCalculator.1(this);
      }
      this.f.post(this.j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FPSCalculator", 2, "build version is not support ");
    }
    this.f.postDelayed(this.k, 500L);
  }
  
  private void b(long paramLong)
  {
    paramLong = a(paramLong);
    long l = this.a;
    if (l <= 0L)
    {
      this.a = paramLong;
    }
    else
    {
      l = paramLong - l;
      this.b += 1;
      if (l > 500L)
      {
        double d1 = this.b * 1000;
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        this.a = paramLong;
        int m = 0;
        this.b = 0;
        synchronized (this.h)
        {
          while (m < this.g.size())
          {
            ((FPSCalculator.GetFPSListener)this.g.get(m)).onInfo(this.a, d1);
            m += 1;
          }
        }
      }
    }
    this.c.postFrameCallback(this.d);
  }
  
  private void c()
  {
    if (this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Choreographer localChoreographer = this.c;
        if (localChoreographer != null)
        {
          localChoreographer.removeFrameCallback(this.d);
          if (QLog.isColorLevel()) {
            QLog.d("FPSCalculator", 2, "removeFrameCallback ");
          }
        }
        this.f.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      else
      {
        this.f.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      this.a = 0L;
      this.b = 0;
      this.e = false;
      QLog.d("FPSCalculator", 2, "FPSCalculator set enable = false");
    }
  }
  
  public void a(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.h)
    {
      if (!this.g.contains(paramGetFPSListener)) {
        this.g.add(paramGetFPSListener);
      }
      if (this.g.size() > 0) {
        b();
      }
      return;
    }
  }
  
  public void b(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.h)
    {
      if (this.g.contains(paramGetFPSListener)) {
        this.g.remove(paramGetFPSListener);
      }
      if (this.g.size() <= 0) {
        c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator
 * JD-Core Version:    0.7.0.1
 */