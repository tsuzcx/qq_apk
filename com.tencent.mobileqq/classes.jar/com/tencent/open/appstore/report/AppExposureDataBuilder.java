package com.tencent.open.appstore.report;

public class AppExposureDataBuilder
  extends ReportDataBuilder
{
  public static AppExposureDataBuilder a()
  {
    return new AppExposureDataBuilder();
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("|");
    localStringBuilder.append(e());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppExposureDataBuilder
 * JD-Core Version:    0.7.0.1
 */