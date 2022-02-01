package com.tencent.mobileqq.search.report;

import java.io.Serializable;

public abstract class ReportModel
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int report_count = 1;
  public String uin = "";
  public String version = "";
  
  public abstract String toReportString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.report.ReportModel
 * JD-Core Version:    0.7.0.1
 */