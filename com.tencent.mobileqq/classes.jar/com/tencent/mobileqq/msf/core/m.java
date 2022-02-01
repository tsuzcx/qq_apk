package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class m
{
  static final String b = "MSF.C.NetConnTag";
  MsfCore a;
  private volatile Handler c;
  
  public m(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    m.a locala = new m.a(this, paramInt);
    this.c.postDelayed(locala, paramLong);
    return locala;
  }
  
  public Runnable a(n paramn, long paramLong)
  {
    if (paramn != null)
    {
      paramn = new m.f(this, paramn);
      this.c.postDelayed(paramn, paramLong);
      return paramn;
    }
    return null;
  }
  
  public Runnable a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    m.e locale = new m.e(this, paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(locale, paramLong);
    }
    return locale;
  }
  
  public Runnable a(ToServiceMsg paramToServiceMsg, long paramLong, m.d paramd)
  {
    paramd = new m.e(this, paramToServiceMsg, paramd);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(paramd, paramLong);
    }
    return paramd;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("MsfCoreTimeoutChecker", 5);
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    this.c.removeCallbacks(paramRunnable);
  }
  
  public Handler b()
  {
    return this.c;
  }
  
  public Runnable b(int paramInt, long paramLong)
  {
    m.c localc = new m.c(this, paramInt);
    this.c.postDelayed(localc, paramLong);
    return localc;
  }
  
  public Runnable b(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    m.b localb = new m.b(this, paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(localb, paramLong);
    }
    return localb;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.c.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m
 * JD-Core Version:    0.7.0.1
 */