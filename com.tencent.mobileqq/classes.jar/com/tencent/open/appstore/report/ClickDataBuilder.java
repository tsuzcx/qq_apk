package com.tencent.open.appstore.report;

public class ClickDataBuilder
  extends ReportDataBuilder
{
  private String o;
  
  public static ClickDataBuilder a()
  {
    return new ClickDataBuilder();
  }
  
  public ClickDataBuilder a(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("|");
    localStringBuilder.append(e());
    localStringBuilder.append("|");
    localStringBuilder.append(this.o);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.ClickDataBuilder
 * JD-Core Version:    0.7.0.1
 */