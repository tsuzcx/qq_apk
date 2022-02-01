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
    localStringBuilder.append("control=");
    localStringBuilder.append(Integer.toBinaryString(this.g));
    localStringBuilder.append(" conned=");
    localStringBuilder.append(this.x.m());
    localStringBuilder.append(" start=[");
    localStringBuilder.append(this.o);
    localStringBuilder.append(",");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    localStringBuilder.append(" bindSucc=[");
    localStringBuilder.append(this.p);
    localStringBuilder.append(",");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    localStringBuilder.append(" bindFail=[");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",");
    localStringBuilder.append(this.l);
    localStringBuilder.append("]");
    localStringBuilder.append(" unbind=[");
    localStringBuilder.append(this.r);
    localStringBuilder.append(",");
    localStringBuilder.append(this.m);
    localStringBuilder.append("]");
    localStringBuilder.append(" stop=[");
    localStringBuilder.append(this.s);
    localStringBuilder.append(",");
    localStringBuilder.append(this.n);
    localStringBuilder.append("]");
    if (QLog.isColorLevel()) {
      QLog.i("BindService", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    int i1 = this.g;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("execute cmd: ");
      ((StringBuilder)localObject).append(Integer.toBinaryString(i1));
      QLog.d("BindService", 2, ((StringBuilder)localObject).toString());
    }
    long l1;
    if ((i1 & 0x8) == 8)
    {
      l1 = System.currentTimeMillis();
      if (this.x.m()) {
        this.x.h();
      }
      this.u = this.x.c();
      this.s = ((short)(this.s + 1));
      this.n = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stop service cost=");
        ((StringBuilder)localObject).append(this.n - l1);
        QLog.d("BindService", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((i1 & 0x4) == 4)
    {
      l1 = System.currentTimeMillis();
      if (this.x.m()) {
        this.x.h();
      }
      this.x.g();
      this.w = (this.x.m() ^ true);
      if (!this.w) {
        QLog.i("BindService", 1, "unbind service failed");
      }
      this.r = ((short)(this.r + 1));
      this.m = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unbind service cost=");
        ((StringBuilder)localObject).append(this.m - l1);
        QLog.d("BindService", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((i1 & 0x1) == 1)
    {
      l1 = System.currentTimeMillis();
      this.x.a();
      this.o = ((short)(this.o + 1));
      this.j = System.currentTimeMillis();
      this.t = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start service cost=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        QLog.d("BindService", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (((i1 & 0x10) == 16) && (Build.VERSION.SDK_INT >= 21))
    {
      localObject = new Intent("com.tencent.mobileqq.msf.startmsf");
      ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
    }
    int i2;
    if ((i1 & 0x2) == 2)
    {
      long l2 = System.currentTimeMillis();
      if (!this.x.m())
      {
        this.v = this.x.b();
        i2 = 50;
        i1 = 1;
        while ((!this.x.m()) && (!Thread.interrupted()) && (i2 <= 2000))
        {
          l1 = i2;
          try
          {
            Thread.sleep(l1);
            i2 += i1 * 50;
            i1 += 1;
          }
          catch (Exception localException)
          {
            label497:
            break label497;
          }
        }
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
        }
        else
        {
          this.p = ((short)(this.p + 1));
          this.q = 0;
          this.k = System.currentTimeMillis();
        }
      }
      else
      {
        i1 = 0;
      }
      i2 = i1;
      if (QLog.isColorLevel())
      {
        if (this.x.m()) {
          l1 = this.k;
        } else {
          l1 = this.l;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bind service bindSucc=");
        ((StringBuilder)localObject).append(this.v);
        ((StringBuilder)localObject).append(" conned=");
        ((StringBuilder)localObject).append(this.x.m());
        ((StringBuilder)localObject).append(" cost=");
        ((StringBuilder)localObject).append(l1 - l2);
        QLog.d("BindService", 2, ((StringBuilder)localObject).toString());
        i2 = i1;
      }
    }
    else
    {
      i2 = 0;
    }
    if (this.x.m())
    {
      this.h.set(false);
    }
    else if (i2 > 0)
    {
      q.d(this.x).g = i2;
      q.b(this.x).post(q.d(this.x));
    }
    else
    {
      this.h.set(false);
    }
    if (QLog.isColorLevel())
    {
      a();
      QLog.d("BindService", 2, "execute cmd finished");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q.a
 * JD-Core Version:    0.7.0.1
 */