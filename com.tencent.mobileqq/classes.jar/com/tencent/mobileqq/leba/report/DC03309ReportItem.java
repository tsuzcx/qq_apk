package com.tencent.mobileqq.leba.report;

public class DC03309ReportItem
  extends EXBaseReportItem
{
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    if (paramInt == 0)
    {
      localStringBuilder.append("${count_unknown}");
      localStringBuilder.append("|");
    }
    else
    {
      localStringBuilder.append(this.p);
      localStringBuilder.append("|");
    }
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.j);
    localStringBuffer.append("|");
    localStringBuffer.append(this.k);
    localStringBuffer.append("|");
    localStringBuffer.append(this.l);
    localStringBuffer.append("|");
    localStringBuffer.append(this.m);
    localStringBuffer.append("|");
    localStringBuffer.append(this.n);
    localStringBuffer.append("|");
    localStringBuffer.append(this.o);
    localStringBuffer.append("|");
    localStringBuffer.append(this.p);
    localStringBuffer.append("|");
    localStringBuffer.append(this.a);
    localStringBuffer.append("|");
    localStringBuffer.append(this.b);
    localStringBuffer.append("|");
    localStringBuffer.append(this.c);
    localStringBuffer.append("|");
    localStringBuffer.append(this.d);
    localStringBuffer.append("|");
    localStringBuffer.append(this.e);
    localStringBuffer.append("|");
    localStringBuffer.append(this.f);
    localStringBuffer.append("|");
    localStringBuffer.append(this.g);
    localStringBuffer.append("|");
    localStringBuffer.append(this.h);
    localStringBuffer.append("|");
    localStringBuffer.append(this.i);
    localStringBuffer.append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.DC03309ReportItem
 * JD-Core Version:    0.7.0.1
 */