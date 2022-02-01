package com.tencent.mobileqq.statistics;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

class ScoreReportController$ReportData
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public String g;
  public String h = "8.8.17";
  public long i;
  public long j;
  public long k = 0L;
  public String l = Build.MODEL;
  public long m = 4L;
  public long n = a();
  public long o = Build.VERSION.SDK_INT;
  public String p;
  public String q = "";
  public long r;
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public String w;
  
  public int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i1 = 3;
    if (bool)
    {
      i1 = 2;
    }
    else
    {
      if (AppNetConnInfo.isMobileConn())
      {
        int i2 = AppNetConnInfo.getMobileInfo();
        if (i2 == 1) {
          break label55;
        }
        if (i2 != 2)
        {
          if (i2 == 3)
          {
            i1 = 5;
            break label55;
          }
        }
        else
        {
          i1 = 4;
          break label55;
        }
      }
      i1 = 0;
    }
    label55:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetType: ");
      localStringBuilder.append(i1);
      QLog.d("ScoreReportController", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.a);
    localStringBuilder.append('|');
    localStringBuilder.append(this.b);
    localStringBuilder.append('|');
    localStringBuilder.append(this.c);
    localStringBuilder.append('|');
    localStringBuilder.append(this.d);
    localStringBuilder.append('|');
    localStringBuilder.append(this.e);
    localStringBuilder.append('|');
    localStringBuilder.append(this.f);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    localStringBuilder.append(this.h);
    localStringBuilder.append('|');
    localStringBuilder.append(this.i);
    localStringBuilder.append('|');
    localStringBuilder.append(this.j);
    localStringBuilder.append('|');
    localStringBuilder.append(this.k);
    localStringBuilder.append('|');
    localStringBuilder.append(this.l);
    localStringBuilder.append('|');
    localStringBuilder.append(this.m);
    localStringBuilder.append('|');
    localStringBuilder.append(this.n);
    localStringBuilder.append('|');
    localStringBuilder.append(this.o);
    localStringBuilder.append('|');
    localStringBuilder.append(this.p);
    localStringBuilder.append('|');
    localStringBuilder.append(this.q);
    localStringBuilder.append('|');
    localStringBuilder.append(this.r);
    localStringBuilder.append('|');
    localStringBuilder.append(this.s);
    localStringBuilder.append('|');
    localStringBuilder.append(this.t);
    localStringBuilder.append('|');
    localStringBuilder.append(this.u);
    localStringBuilder.append('|');
    localStringBuilder.append(this.v);
    localStringBuilder.append('|');
    localStringBuilder.append(this.w);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController.ReportData
 * JD-Core Version:    0.7.0.1
 */