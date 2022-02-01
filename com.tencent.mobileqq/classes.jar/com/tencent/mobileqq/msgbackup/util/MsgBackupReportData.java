package com.tencent.mobileqq.msgbackup.util;

import android.support.annotation.NonNull;
import java.util.ArrayList;

public class MsgBackupReportData
{
  public int a;
  public int b;
  public boolean c;
  public int d;
  public long e;
  public double f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public boolean u;
  public int v;
  public long w;
  public long x;
  public long y;
  public ArrayList<MsgBackupReportData.FileError> z = new ArrayList();
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = false;
    this.d = 0;
    this.e = 0L;
    this.f = 0.0D;
    this.g = 0L;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = false;
    this.v = 0;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z.clear();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[bizType = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n platForm = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n requestStatus = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n errorCode = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n totalCost = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n averageSpeed = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n totalSessionCount = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n finishedSessionCount = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n resSessionContains = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n resTotalSize = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n dbTotalSize = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n resRequestCount = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n resRequestFailedCount = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n resRequestCancelCount = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n resTrivialCount = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n resTrivialFailedCount = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n resTrivialCancelCount = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n dbRequestCount = ");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n dbRequestFailedCount = ");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n dbRequestCancelCount = ");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\n connectType = ");
    localStringBuilder.append(this.v);
    localStringBuilder.append("\n connectElipse = ");
    localStringBuilder.append(this.w);
    localStringBuilder.append("\n sessionReadyAllTimes = ");
    localStringBuilder.append(this.x);
    localStringBuilder.append("\n fileFailedCount = ");
    localStringBuilder.append(this.y);
    localStringBuilder.append("\n fileErrorList = ");
    localStringBuilder.append(this.z);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupReportData
 * JD-Core Version:    0.7.0.1
 */