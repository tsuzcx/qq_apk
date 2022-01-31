package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class r
{
  static final String b = "MSF.C.NetConnTag";
  MsfCore a;
  private volatile Handler c;
  
  public r(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    r.a locala = new r.a(this, paramInt);
    this.c.postDelayed(locala, paramLong);
    return locala;
  }
  
  public Runnable a(n paramn, long paramLong)
  {
    if (paramn != null)
    {
      paramn = new r.e(this, paramn);
      this.c.postDelayed(paramn, paramLong);
      return paramn;
    }
    return null;
  }
  
  public Runnable a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    r.d locald = new r.d(this, paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(locald, paramLong);
    }
    return locald;
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
    r.c localc = new r.c(this, paramInt);
    this.c.postDelayed(localc, paramLong);
    return localc;
  }
  
  public Runnable b(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    r.b localb = new r.b(this, paramToServiceMsg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r
 * JD-Core Version:    0.7.0.1
 */