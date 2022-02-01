package com.tencent.mobileqq.kandian.base.report;

public class AppReportData
{
  public String appCode;
  public String appUsedDate;
  public String appVersion;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appCode = ");
    localStringBuilder.append(this.appCode);
    localStringBuilder.append("\nappVersion = ");
    localStringBuilder.append(this.appVersion);
    localStringBuilder.append("\nappUsedDate = ");
    localStringBuilder.append(this.appUsedDate);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.AppReportData
 * JD-Core Version:    0.7.0.1
 */