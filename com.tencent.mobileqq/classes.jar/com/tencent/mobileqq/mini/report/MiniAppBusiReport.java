package com.tencent.mobileqq.mini.report;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class MiniAppBusiReport
{
  public static final String ACTION_SHOPPING_FOLDER = "shopping_folder";
  public static final String RESERVE_ACTION_MESSAGE = "message";
  public static final String RESERVE_ACTION_SEARCH = "search";
  public static final String SUB_ACTION_CLICK = "click";
  public static final String SUB_ACTION_EXPO = "expo";
  public static final String TAG = "MiniAppBusiReport";
  public static long lastEschopExpoReportTime;
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.d("MiniAppBusiReport", 2, "report actionType:" + paramString1 + "  subAction:" + paramString2 + " reserves:" + paramString3 + "  reserves2:" + paramString4);
    MiniProgramLpReportDC04239.reportAsync(paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void reportEshopExpo(String paramString1, String paramString2)
  {
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppEcShopExpoTimeLimit", 2000);
    long l1 = System.currentTimeMillis();
    long l2 = lastEschopExpoReportTime;
    if (l1 > i + l2)
    {
      report("shopping_folder", "expo", paramString1, paramString2);
      lastEschopExpoReportTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppBusiReport
 * JD-Core Version:    0.7.0.1
 */