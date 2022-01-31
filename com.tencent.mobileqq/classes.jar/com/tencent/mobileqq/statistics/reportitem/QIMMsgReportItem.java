package com.tencent.mobileqq.statistics.reportitem;

public class QIMMsgReportItem
  extends QIMBaseReportItem
{
  public double a;
  public int a;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  
  public QIMMsgReportItem()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.c = "";
    this.e = "0";
    this.d = "";
    this.f = "";
    this.g = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Double = 0.0D;
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = "";
    this.v = "";
    this.w = "";
    this.x = "";
  }
  
  public QIMMsgReportItem(QIMMsgReportItem paramQIMMsgReportItem)
  {
    this.jdField_a_of_type_JavaLangString = paramQIMMsgReportItem.jdField_a_of_type_JavaLangString;
    this.b = paramQIMMsgReportItem.b;
    this.c = paramQIMMsgReportItem.c;
    this.e = paramQIMMsgReportItem.e;
    this.d = paramQIMMsgReportItem.d;
    this.f = paramQIMMsgReportItem.f;
    this.g = paramQIMMsgReportItem.g;
    this.jdField_a_of_type_Int = paramQIMMsgReportItem.jdField_a_of_type_Int;
    this.jdField_a_of_type_Double = paramQIMMsgReportItem.jdField_a_of_type_Double;
    this.h = paramQIMMsgReportItem.h;
    this.i = paramQIMMsgReportItem.i;
    this.j = paramQIMMsgReportItem.j;
    this.k = paramQIMMsgReportItem.k;
    this.l = paramQIMMsgReportItem.l;
    this.m = paramQIMMsgReportItem.m;
    this.n = paramQIMMsgReportItem.n;
    this.o = paramQIMMsgReportItem.o;
    this.p = paramQIMMsgReportItem.p;
    this.q = paramQIMMsgReportItem.q;
    this.r = paramQIMMsgReportItem.r;
    this.s = paramQIMMsgReportItem.s;
    this.t = paramQIMMsgReportItem.t;
    this.u = paramQIMMsgReportItem.u;
    this.v = paramQIMMsgReportItem.v;
    this.w = paramQIMMsgReportItem.w;
    this.x = paramQIMMsgReportItem.x;
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.b).append("|");
    localStringBuilder.append(this.c).append("|");
    localStringBuilder.append(this.e).append("|");
    localStringBuilder.append(this.d).append("|");
    localStringBuilder.append(this.f).append("|");
    localStringBuilder.append(this.g).append("|");
    if (paramInt == 0) {
      localStringBuilder.append("${count_unknown}").append("|");
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_a_of_type_Double).append("|");
      localStringBuilder.append(this.h).append("|");
      localStringBuilder.append(this.i).append("|");
      localStringBuilder.append(this.j).append("|");
      localStringBuilder.append(this.k).append("|");
      localStringBuilder.append(this.l).append("|");
      localStringBuilder.append(this.m).append("|");
      localStringBuilder.append(this.n).append("|");
      localStringBuilder.append(this.o).append("|");
      localStringBuilder.append(this.p).append("|");
      localStringBuilder.append(this.q).append("|");
      localStringBuilder.append(this.r).append("|");
      localStringBuilder.append(this.s).append("|");
      localStringBuilder.append(this.t).append("|");
      localStringBuilder.append(this.u).append("|");
      localStringBuilder.append(this.v).append("|");
      localStringBuilder.append(this.w).append("|");
      localStringBuilder.append(this.x).append("|");
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_Int).append("|");
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuffer.append(this.b).append("|");
    localStringBuffer.append(this.c).append("|");
    localStringBuffer.append(this.e).append("|");
    localStringBuffer.append(this.d).append("|");
    localStringBuffer.append(this.f).append("|");
    localStringBuffer.append(this.g).append("|");
    localStringBuffer.append(this.jdField_a_of_type_Int).append("|");
    localStringBuffer.append(this.jdField_a_of_type_Double).append("|");
    localStringBuffer.append(this.h).append("|");
    localStringBuffer.append(this.i).append("|");
    localStringBuffer.append(this.j).append("|");
    localStringBuffer.append(this.k).append("|");
    localStringBuffer.append(this.l).append("|");
    localStringBuffer.append(this.m).append("|");
    localStringBuffer.append(this.n).append("|");
    localStringBuffer.append(this.o).append("|");
    localStringBuffer.append(this.p).append("|");
    localStringBuffer.append(this.q).append("|");
    localStringBuffer.append(this.r).append("|");
    localStringBuffer.append(this.s).append("|");
    localStringBuffer.append(this.t).append("|");
    localStringBuffer.append(this.u).append("|");
    localStringBuffer.append(this.v).append("|");
    localStringBuffer.append(this.w).append("|");
    localStringBuffer.append(this.x).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.reportitem.QIMMsgReportItem
 * JD-Core Version:    0.7.0.1
 */