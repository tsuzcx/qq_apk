package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class GalleryReportedUtils$ReportData
{
  public AbsBaseArticleInfo a;
  public String a;
  public String b;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public GalleryReportedUtils$ReportData(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof ReportData)) {
      return false;
    }
    paramObject = (ReportData)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData
 * JD-Core Version:    0.7.0.1
 */