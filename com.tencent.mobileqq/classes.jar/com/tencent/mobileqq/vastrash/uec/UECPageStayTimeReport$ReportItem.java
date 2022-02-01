package com.tencent.mobileqq.vastrash.uec;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class UECPageStayTimeReport$ReportItem
{
  public String a;
  public String b;
  public long c;
  public long d;
  
  public void a()
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public long b()
  {
    long l1 = this.c;
    if (l1 != 0L)
    {
      long l2 = this.d;
      if ((l2 != 0L) && (l2 - l1 > 0L)) {
        return l2 - l1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStayTime error, ");
    localStringBuilder.append(toString());
    QLog.e("UECPageStayTimeReport", 1, localStringBuilder.toString());
    return 0L;
  }
  
  public void c()
  {
    this.d = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportItem{mPageKey='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExtraInfo='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mEnterTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mExitTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", Timelong=");
    localStringBuilder.append(this.d - this.c);
    localStringBuilder.append(", Process=");
    localStringBuilder.append(BaseApplicationImpl.processName);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport.ReportItem
 * JD-Core Version:    0.7.0.1
 */