package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;

public class LebaReportUtils
{
  public static int a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((!paramBoolean) || (paramRedTypeInfo == null)) {
      return 0;
    }
    if (paramRedTypeInfo.red_type.get() == 0) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 2;
    }
    return 3;
  }
  
  public static DC03309ReportItem a(String paramString)
  {
    DC03309ReportItem localDC03309ReportItem = new DC03309ReportItem();
    localDC03309ReportItem.i = "trends_tab";
    localDC03309ReportItem.j = "trends_plugin";
    localDC03309ReportItem.k = paramString;
    return localDC03309ReportItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.LebaReportUtils
 * JD-Core Version:    0.7.0.1
 */