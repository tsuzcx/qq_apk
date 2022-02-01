package com.tencent.mobileqq.statistics;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class SubscribeReportController$ReportData
{
  public long a = System.currentTimeMillis();
  public long b = AppSetting.d();
  public String c = DeviceInfoUtil.b();
  public String d = "";
  public String e;
  public String f;
  public String g;
  public String h;
  public long i;
  public long j;
  public long k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p = "8.8.17.5770";
  public String q = "AND";
  
  public String a()
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.SubscribeReportController.ReportData
 * JD-Core Version:    0.7.0.1
 */