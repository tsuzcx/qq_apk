package com.tencent.mobileqq.kandian.repo.report;

public class ReportInfo$DynamicInsertReportData
  implements Cloneable
{
  public Long a;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DynamicInsertReportData{uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", seqNo='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", watchTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.ReportInfo.DynamicInsertReportData
 * JD-Core Version:    0.7.0.1
 */