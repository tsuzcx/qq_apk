package com.tencent.mobileqq.search.report;

public class ReportModelDC02528
  extends ReportModel
{
  public String action = " ";
  public int app_version;
  public String module = " ";
  public String obj1 = " ";
  public String obj2 = " ";
  public String obj3 = " ";
  public String opername = " ";
  protected final String platform = "Android";
  public String session_id = " ";
  protected long ts;
  public String ver1 = " ";
  public String ver2 = " ";
  public String ver3 = " ";
  public String ver4 = " ";
  public String ver5 = " ";
  public String ver6 = " ";
  public String ver7 = " ";
  
  public ReportModelDC02528()
  {
    opername("Grp_all_search");
  }
  
  public ReportModelDC02528 action(String paramString)
  {
    this.action = paramString;
    return this;
  }
  
  public ReportModelDC02528 app_version(int paramInt)
  {
    this.app_version = paramInt;
    return this;
  }
  
  public ReportModelDC02528 module(String paramString)
  {
    this.module = paramString;
    return this;
  }
  
  public ReportModelDC02528 obj1(String paramString)
  {
    this.obj1 = paramString;
    return this;
  }
  
  public ReportModelDC02528 obj2(String paramString)
  {
    this.obj2 = paramString;
    return this;
  }
  
  public ReportModelDC02528 obj3(String paramString)
  {
    this.obj3 = paramString;
    return this;
  }
  
  public ReportModelDC02528 opername(String paramString)
  {
    this.opername = paramString;
    return this;
  }
  
  public ReportModelDC02528 session_id(String paramString)
  {
    this.session_id = paramString;
    return this;
  }
  
  public String toReportString()
  {
    this.ts = System.currentTimeMillis();
    return this.ts + "|" + this.uin + "|" + this.opername + "|" + this.module + "|" + this.action + "|" + "Android" + "|" + this.version + "|" + this.obj1 + "|" + this.obj2 + "|" + this.obj3 + "|" + this.ver1 + "|" + this.ver2 + "|" + this.ver3 + "|" + this.ver4 + "|" + this.ver5 + "|" + this.ver6 + "|" + this.ver7 + "|" + this.app_version + "|" + this.session_id;
  }
  
  public String toString()
  {
    return "ReportModelDC02528{report_count=" + this.report_count + ", uin='" + this.uin + '\'' + ", ts=" + this.ts + ", version='" + this.version + '\'' + ", platform='" + "Android" + '\'' + ", opername='" + this.opername + '\'' + ", module='" + this.module + '\'' + ", action='" + this.action + '\'' + ", obj1='" + this.obj1 + '\'' + ", obj2='" + this.obj2 + '\'' + ", obj3='" + this.obj3 + '\'' + ", ver1='" + this.ver1 + '\'' + ", ver2='" + this.ver2 + '\'' + ", ver3='" + this.ver3 + '\'' + ", ver4='" + this.ver4 + '\'' + ", ver5='" + this.ver5 + '\'' + ", ver6='" + this.ver6 + '\'' + ", ver7='" + this.ver7 + '\'' + ", app_version=" + this.app_version + ", session_id='" + this.session_id + '\'' + '}';
  }
  
  public ReportModelDC02528 ver1(String paramString)
  {
    this.ver1 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver2(String paramString)
  {
    this.ver2 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver3(String paramString)
  {
    this.ver3 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver4(String paramString)
  {
    this.ver4 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver5(String paramString)
  {
    this.ver5 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver6(String paramString)
  {
    this.ver6 = paramString;
    return this;
  }
  
  public ReportModelDC02528 ver7(String paramString)
  {
    this.ver7 = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.report.ReportModelDC02528
 * JD-Core Version:    0.7.0.1
 */