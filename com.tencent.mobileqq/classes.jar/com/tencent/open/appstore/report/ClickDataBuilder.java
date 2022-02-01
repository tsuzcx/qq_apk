package com.tencent.open.appstore.report;

public class ClickDataBuilder
  extends ReportDataBuilder
{
  private String n;
  
  public static ClickDataBuilder a()
  {
    return new ClickDataBuilder();
  }
  
  public ClickDataBuilder a(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("|");
    localStringBuilder.append(c());
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.report.ClickDataBuilder
 * JD-Core Version:    0.7.0.1
 */