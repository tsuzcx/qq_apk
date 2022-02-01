package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class ReadinjoyReportUtils$ExposureReportItem
{
  public AbsBaseArticleInfo a;
  public long b;
  public final int c;
  
  public ReadinjoyReportUtils$ExposureReportItem(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_duration : ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.ExposureReportItem
 * JD-Core Version:    0.7.0.1
 */