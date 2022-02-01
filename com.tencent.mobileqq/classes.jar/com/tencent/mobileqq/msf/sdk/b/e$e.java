package com.tencent.mobileqq.msf.sdk.b;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.qphone.base.util.QLog;

public class e$e
  extends e.a
{
  private static final String b = "pullServiceFail";
  private boolean c = false;
  private long d = 0L;
  private short e = 0;
  private long f = 0L;
  
  public static e b()
  {
    return e.e.a.a();
  }
  
  private void f()
  {
    if (!MsfServiceSdk.isUseNewProxy) {
      return;
    }
    l.a(e.b, false);
  }
  
  private void g()
  {
    if (!MsfServiceSdk.isUseNewProxy) {}
  }
  
  private void h()
  {
    this.f = 0L;
    this.d = 0L;
    this.e = 0;
    this.c = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = ((short)(this.e + 1));
    if ((this.e > 10) && (this.f == 0L) && (this.d > 0L) && (SystemClock.elapsedRealtime() > this.d + 60000L) && (!this.c))
    {
      this.f = SystemClock.elapsedRealtime();
      this.c = true;
      f();
      QLog.d("pullServiceFail", 1, "cannot pull msf service.");
    }
  }
  
  public void c()
  {
    if (this.d == 0L) {
      this.d = SystemClock.elapsedRealtime();
    }
  }
  
  public void d()
  {
    g();
    h();
  }
  
  public void e()
  {
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.e
 * JD-Core Version:    0.7.0.1
 */