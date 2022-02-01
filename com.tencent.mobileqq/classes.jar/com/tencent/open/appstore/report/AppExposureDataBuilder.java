package com.tencent.open.appstore.report;

public class AppExposureDataBuilder
  extends ReportDataBuilder
{
  public static AppExposureDataBuilder a()
  {
    return new AppExposureDataBuilder();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("|");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppExposureDataBuilder
 * JD-Core Version:    0.7.0.1
 */