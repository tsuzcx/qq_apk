package com.tencent.wstt.SSCM;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public class SSCM
{
  public int a;
  protected float b;
  protected int c;
  protected double d;
  protected long e;
  protected long f;
  protected int g;
  protected int h;
  protected int i;
  protected boolean j = false;
  private boolean k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private int r;
  private int s;
  private int t;
  private int u;
  
  public SSCM()
  {
    a();
  }
  
  private long c()
  {
    return new Date().getTime();
  }
  
  private long d()
  {
    return new Date().getTime();
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.c = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (!this.j)
    {
      i1 = this.c;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            this.g = 4096;
          } else {
            this.g = 16384;
          }
        }
        else {
          this.g = 8192;
        }
      }
      else {
        this.g = 32768;
      }
    }
    if (paramLong < 102400L) {
      this.g *= 4;
    }
    int i1 = this.g;
    if (paramLong - i1 <= i1 / 2) {
      this.g = ((int)paramLong);
    }
    return this.g;
  }
  
  public int a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.e = c();
    if (paramLong1 < 102400L) {
      this.t = 1;
    } else {
      this.t = 2;
    }
    if (true == this.k)
    {
      a();
      this.h = a(paramContext, paramLong1);
      this.k = false;
      return this.h;
    }
    double d1 = this.h;
    double d2 = this.d;
    Double.isNaN(d1);
    this.m = ((float)(d1 / d2));
    float f1 = this.o;
    if (0.0F == f1)
    {
      this.o = this.m;
    }
    else
    {
      d1 = this.m;
      Double.isNaN(d1);
      d2 = f1;
      Double.isNaN(d2);
      this.o = ((float)(d1 * 0.8D + d2 * 0.2D));
    }
    if (this.a != 2)
    {
      this.u += 1;
      f1 = this.n;
      if (f1 == 0.0F)
      {
        this.b = 1.0F;
        if (this.u == this.t) {
          this.l = this.o;
        }
      }
      else if (this.u == this.t)
      {
        d1 = (this.o - f1) / this.l;
        d2 = this.h - this.i;
        double d3 = this.g;
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 /= (d3 + 0.0D);
        Double.isNaN(d1);
        this.b = ((float)(d1 / d2));
      }
    }
    int i1 = this.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          d1 = Math.abs(this.o - this.p);
          d2 = this.p;
          Double.isNaN(d2);
          if (d1 > d2 * 0.2D) {
            this.r += 1;
          } else {
            this.r = 0;
          }
          if (this.r < this.s)
          {
            this.a = 2;
          }
          else
          {
            this.r = 0;
            this.a = 0;
            this.h = this.g;
            this.n = 0.0F;
            this.i = 0;
            this.o = 0.0F;
            this.u = 0;
          }
        }
      }
      else if (this.u == this.t) {
        if (this.b < 0.09D)
        {
          this.a = 2;
          f1 = this.o;
          this.p = f1;
          this.n = 0.0F;
          this.i = 0;
          this.q = f1;
        }
        else
        {
          this.a = 1;
          this.i = this.h;
          d1 = this.i;
          Double.isNaN(d1);
          this.h = ((int)(d1 * 1.05D));
          f1 = this.o;
          this.n = f1;
          this.q = f1;
          this.o = 0.0F;
          this.u = 0;
        }
      }
    }
    else if (this.u == this.t)
    {
      if (this.b < 0.09D)
      {
        this.a = 1;
        d1 = this.i;
        Double.isNaN(d1);
        this.h = ((int)(d1 * 1.05D));
      }
      else
      {
        this.a = 0;
        this.i = this.h;
        this.h = (this.i * 2);
        this.n = this.o;
      }
      this.o = 0.0F;
      this.u = 0;
    }
    paramLong1 -= paramLong2;
    i1 = this.h;
    if (paramLong1 - i1 <= i1 / 2) {
      this.h = ((int)paramLong1);
    }
    if (this.u == 0) {
      f1 = this.n;
    } else {
      f1 = this.o;
    }
    if (paramInt > 0)
    {
      i1 = this.h;
      if ((i1 < 0) || (i1 > paramInt))
      {
        this.h = paramInt;
        break label793;
      }
    }
    if (this.h < 0)
    {
      this.r = 0;
      this.a = 0;
      this.h = this.g;
      this.n = 0.0F;
      this.i = 0;
      this.o = 0.0F;
      this.u = 0;
    }
    label793:
    return this.h;
  }
  
  public void a()
  {
    this.k = true;
    this.a = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
    this.d = 0.0D;
    this.e = 0L;
    this.f = 0L;
    this.b = 0.0F;
    this.q = 0.0F;
    this.r = 0;
    this.u = 0;
    this.s = 3;
    this.t = 2;
  }
  
  public void b()
  {
    this.f = d();
    double d1 = this.f - this.e;
    Double.isNaN(d1);
    this.d = (d1 / 1000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFilePakage time:");
    localStringBuilder.append(this.d);
    QLog.d("upload", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCM
 * JD-Core Version:    0.7.0.1
 */