package com.tencent.mobileqq.search.report;

public class ReportModelDC02528
  extends ReportModel
{
  public String action = " ";
  public int app_version = 0;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ts);
    localStringBuilder.append("|");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|");
    localStringBuilder.append(this.opername);
    localStringBuilder.append("|");
    localStringBuilder.append(this.module);
    localStringBuilder.append("|");
    localStringBuilder.append(this.action);
    localStringBuilder.append("|");
    localStringBuilder.append("Android");
    localStringBuilder.append("|");
    localStringBuilder.append(this.version);
    localStringBuilder.append("|");
    localStringBuilder.append(this.obj1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.obj2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.obj3);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver3);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver4);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver5);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver6);
    localStringBuilder.append("|");
    localStringBuilder.append(this.ver7);
    localStringBuilder.append("|");
    localStringBuilder.append(this.app_version);
    localStringBuilder.append("|");
    localStringBuilder.append(this.session_id);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportModelDC02528{report_count=");
    localStringBuilder.append(this.report_count);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ts=");
    localStringBuilder.append(this.ts);
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", platform='");
    localStringBuilder.append("Android");
    localStringBuilder.append('\'');
    localStringBuilder.append(", opername='");
    localStringBuilder.append(this.opername);
    localStringBuilder.append('\'');
    localStringBuilder.append(", module='");
    localStringBuilder.append(this.module);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action='");
    localStringBuilder.append(this.action);
    localStringBuilder.append('\'');
    localStringBuilder.append(", obj1='");
    localStringBuilder.append(this.obj1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", obj2='");
    localStringBuilder.append(this.obj2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", obj3='");
    localStringBuilder.append(this.obj3);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver1='");
    localStringBuilder.append(this.ver1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver2='");
    localStringBuilder.append(this.ver2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver3='");
    localStringBuilder.append(this.ver3);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver4='");
    localStringBuilder.append(this.ver4);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver5='");
    localStringBuilder.append(this.ver5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver6='");
    localStringBuilder.append(this.ver6);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ver7='");
    localStringBuilder.append(this.ver7);
    localStringBuilder.append('\'');
    localStringBuilder.append(", app_version=");
    localStringBuilder.append(this.app_version);
    localStringBuilder.append(", session_id='");
    localStringBuilder.append(this.session_id);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.report.ReportModelDC02528
 * JD-Core Version:    0.7.0.1
 */