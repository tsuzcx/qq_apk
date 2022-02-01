package com.tencent.open.business.cgireport;

import com.tencent.open.base.LogUtility;

public class reportItem
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  public reportItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("");
    this.a = localStringBuilder.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append("");
    this.b = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString3);
    paramString1.append("");
    this.c = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString4);
    paramString1.append("");
    this.d = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString5);
    paramString1.append("");
    this.e = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString6);
    paramString1.append("");
    this.f = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString7);
    paramString1.append("");
    this.g = paramString1.toString();
    this.h = paramString8;
    this.i = paramString9;
    paramString1 = new StringBuilder();
    paramString1.append(paramString10);
    paramString1.append("");
    this.j = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString11);
    paramString1.append("");
    this.k = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append("reportItem apn=");
    paramString1.append(this.a);
    paramString1.append(",frequency=");
    paramString1.append(this.b);
    paramString1.append(",commandid=");
    paramString1.append(this.c);
    paramString1.append(",resultcode=");
    paramString1.append(this.d);
    paramString1.append("timecost");
    paramString1.append(this.e);
    paramString1.append(",reqsize=");
    paramString1.append(this.f);
    paramString1.append(",rspsize=");
    paramString1.append(this.g);
    paramString1.append(",uin=");
    paramString1.append(this.h);
    paramString1.append(",deviceinfo=");
    paramString1.append(this.i);
    paramString1.append(",detail=");
    paramString1.append(this.j);
    paramString1.append(",appid=");
    paramString1.append(paramString11);
    LogUtility.b("report_debug", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.cgireport.reportItem
 * JD-Core Version:    0.7.0.1
 */