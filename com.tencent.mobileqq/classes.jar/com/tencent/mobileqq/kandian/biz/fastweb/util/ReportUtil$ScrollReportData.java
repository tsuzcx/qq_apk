package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class ReportUtil$ScrollReportData
{
  public long a;
  public long b;
  public long c;
  public List<Pair<Long, Long>> d = new ArrayList();
  public List<Pair<Long, Long>> e = new ArrayList();
  public long f;
  public long g;
  private boolean h = false;
  
  public ReportUtil$ScrollReportData(long paramLong)
  {
    this.a = paramLong;
    if (this.a <= 0L) {
      this.a = NetConnInfoCenter.getServerTimeMillis();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.d.size() >= 30) {
      return;
    }
    this.f = NetConnInfoCenter.getServerTimeMillis();
    if (this.b == 0L) {
      this.b = this.f;
    }
    this.g = paramLong;
    this.h = paramBoolean;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
    if (this.d.size() >= 30) {
      return;
    }
    long l3 = this.c;
    long l2 = (l3 - this.f) / 100L;
    if (l2 == 0L) {
      return;
    }
    long l1 = paramLong - this.g;
    l3 = (l3 - this.a) / 100L;
    l2 = Utils.px2dp((float)(l1 / l2));
    this.d.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
    if ((this.h) || (paramBoolean)) {
      this.e.add(new Pair(Long.valueOf(this.c - this.f), Long.valueOf(l1)));
    }
    this.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.ScrollReportData
 * JD-Core Version:    0.7.0.1
 */