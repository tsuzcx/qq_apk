package com.tencent.mobileqq.tablequery;

import java.io.Serializable;

public class TReportData
  implements Serializable
{
  public String actionName;
  public String mainAction;
  public int opType;
  public String r2;
  public String r3;
  public String r4;
  public String r5;
  public int result;
  public String subAction;
  public String table;
  
  public TReportData() {}
  
  public TReportData(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.table = paramString1;
    this.mainAction = paramString2;
    this.subAction = paramString3;
    this.actionName = paramString4;
    this.opType = paramInt1;
    this.result = paramInt2;
    this.r2 = paramString5;
    this.r3 = paramString6;
    this.r4 = paramString7;
    this.r5 = paramString8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TReportData
 * JD-Core Version:    0.7.0.1
 */