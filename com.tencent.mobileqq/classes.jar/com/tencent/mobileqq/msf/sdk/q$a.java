package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class q$a
  implements Runnable
{
  static final String a = "BindService";
  static final int b = 1;
  static final int c = 2;
  static final int d = 4;
  static final int e = 8;
  static final int f = 16;
  int g = 0;
  final AtomicBoolean h = new AtomicBoolean(false);
  boolean i = false;
  long j = 0L;
  long k = 0L;
  long l = 0L;
  long m = 0L;
  long n = 0L;
  short o = 0;
  short p = 0;
  short q = 0;
  short r = 0;
  short s = 0;
  boolean t = false;
  boolean u = false;
  boolean v = false;
  boolean w = false;
  
  public q$a(q paramq) {}
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("control=").append(Integer.toBinaryString(this.g)).append(" conned=").append(this.x.m()).append(" start=[").append(this.o).append(",").append(this.j).append("]").append(" bindSucc=[").append(this.p).append(",").append(this.k).append("]").append(" bindFail=[").append(this.q).append(",").append(this.l).append("]").append(" unbind=[").append(this.r).append(",").append(this.m).append("]").append(" stop=[").append(this.s).append(",").append(this.n).append("]");
    if (QLog.isColorLevel()) {
      QLog.i("BindService", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    int i1 = 1;
    int i2 = this.g;
    if (QLog.isColorLevel()) {
      QLog.d("BindService", 2, "execute cmd: " + Integer.toBinaryString(i2));
    }
    long l1;
    if ((i2 & 0x8) == 8)
    {
      l1 = System.currentTimeMillis();
      if (this.x.m()) {
        this.x.h();
      }
      this.u = this.x.c();
      this.s = ((short)(this.s + 1));
      this.n = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("BindService", 2, "stop service cost=" + (this.n - l1));
      }
    }
    if ((i2 & 0x4) == 4)
    {
      l1 = System.currentTimeMillis();
      if (this.x.m()) {
        this.x.h();
      }
      this.x.g();
      if (this.x.m()) {
        break label463;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.w = bool;
      if (!this.w) {
        QLog.i("BindService", 1, "unbind service failed");
      }
      this.r = ((short)(this.r + 1));
      this.m = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("BindService", 2, "unbind service cost=" + (this.m - l1));
      }
      if ((i2 & 0x1) == 1)
      {
        l1 = System.currentTimeMillis();
        this.x.a();
        this.o = ((short)(this.o + 1));
        this.j = System.currentTimeMillis();
        this.t = true;
        if (QLog.isColorLevel()) {
          QLog.d("BindService", 2, "start service cost=" + (System.currentTimeMillis() - l1));
        }
      }
      if (((i2 & 0x10) == 16) && (Build.VERSION.SDK_INT >= 21))
      {
        Intent localIntent = new Intent("com.tencent.mobileqq.msf.startmsf");
        localIntent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(localIntent);
      }
      if ((i2 & 0x2) != 2) {
        break label746;
      }
      long l2 = System.currentTimeMillis();
      if (this.x.m()) {
        break label681;
      }
      this.v = this.x.b();
      i2 = 50;
      for (;;)
      {
        if ((this.x.m()) || (Thread.interrupted()) || (i2 > 2000)) {
          break label469;
        }
        l1 = i2;
        label463:
        try
        {
          Thread.sleep(l1);
          i2 = i1 * 50 + i2;
          i1 += 1;
        }
        catch (Exception localException) {}
      }
    }
    label469:
    if (!this.x.m())
    {
      this.q = ((short)(this.q + 1));
      this.l = System.currentTimeMillis();
      i2 = 6;
      if (System.currentTimeMillis() - this.j > 10000L) {
        i2 = 23;
      }
      i1 = i2;
      if (System.currentTimeMillis() - this.n > 30000L) {
        i1 = i2 | 0x1D;
      }
      i2 = i1;
      if (QLog.isColorLevel())
      {
        if (!this.x.m()) {
          break label686;
        }
        l1 = this.k;
        QLog.d("BindService", 2, "bind service bindSucc=" + this.v + " conned=" + this.x.m() + " cost=" + (l1 - l2));
      }
    }
    label563:
    label746:
    for (i2 = i1;; i2 = 0)
    {
      if (this.x.m()) {
        this.h.set(false);
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          a();
          QLog.d("BindService", 2, "execute cmd finished");
        }
        return;
        this.p = ((short)(this.p + 1));
        this.q = 0;
        this.k = System.currentTimeMillis();
        i1 = 0;
        break;
        l1 = this.l;
        break label563;
        if (i2 > 0)
        {
          q.d(this.x).g = i2;
          q.b(this.x).post(q.d(this.x));
        }
        else
        {
          this.h.set(false);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q.a
 * JD-Core Version:    0.7.0.1
 */