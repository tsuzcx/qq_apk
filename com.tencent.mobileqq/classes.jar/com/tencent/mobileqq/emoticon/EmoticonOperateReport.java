package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EmoticonOperateReport
{
  public static final String REPORT_TAG_0X800AE20 = "0X800AE20";
  public static final String REPORT_TAG_0X800AE21 = "0X800AE21";
  public static final String REPORT_TAG_0X800AE22 = "0X800AE22";
  public static final String REPORT_TAG_0X800AE23 = "0X800AE23";
  public static final String REPORT_TAG_0X800AE24 = "0X800AE24";
  public static final String REPORT_TAG_0X800AE25 = "0X800AE25";
  public static final String REPORT_TAG_0X800AE27 = "0X800AE27";
  public static final String REPORT_TAG_0X800AE28 = "0X800AE28";
  public static final String REPORT_TAG_0X800AE29 = "0X800AE29";
  public static final String REPORT_TAG_0X800AE2A = "0X800AE2A";
  public static final String REPORT_TAG_0X800AE2B = "0X800AE2B";
  public static final String REPORT_TAG_0X800AE2C = "0X800AE2C";
  public static final String REPORT_TAG_0X800AE2E = "0X800AE2E";
  public static final String REPORT_TAG_0X800AE2F = "0X800AE2F";
  public static final String REPORT_TAG_0X800AE30 = "0X800AE30";
  public static final String REPORT_TAG_0X800AE31 = "0X800AE31";
  public static final String REPORT_TAG_0X800AE32 = "0X800AE32";
  public static final String REPORT_TAG_0X800AE33 = "0X800AE33";
  
  public static void reportAIOEmoticonMonitor(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool = "0".equals(paramString1);
      if (bool) {
        localHashMap.put("receiveSuccess", paramString1);
      } else {
        localHashMap.put("receiveError", paramString1);
      }
    }
    else if (!TextUtils.isEmpty(paramString2))
    {
      bool = "0".equals(paramString2);
      if (bool) {
        localHashMap.put("sendSuccess", paramString2);
      } else {
        localHashMap.put("sendError", paramString2);
      }
    }
    else
    {
      bool = false;
    }
    localHashMap.put("type", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "AIOEmoticonMonitor", bool, 0L, 0L, localHashMap, null);
  }
  
  public static void reportAIOEmoticonMonitorReceiveStatus(String paramString, int paramInt)
  {
    reportAIOEmoticonMonitor(paramString, null, paramInt);
  }
  
  public static void reportAIOEmoticonMonitorSendStatus(String paramString, int paramInt)
  {
    reportAIOEmoticonMonitor(null, paramString, paramInt);
  }
  
  public static void reportEmoticonOperateMonitor(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool = "0".equals(paramString1);
      if (bool) {
        localHashMap.put("addScucess", paramString1);
      } else {
        localHashMap.put("addError", paramString1);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        bool = "0".equals(paramString2);
        if (bool) {
          localHashMap.put("deleteSuccess", paramString2);
        } else {
          localHashMap.put("deleteError", paramString2);
        }
      }
      for (;;)
      {
        break;
        if (!TextUtils.isEmpty(paramString3))
        {
          bool = "0".equals(paramString3);
          if (bool) {
            localHashMap.put("getScucess", paramString3);
          } else {
            localHashMap.put("getError", paramString3);
          }
        }
        else
        {
          bool = false;
        }
      }
    }
    localHashMap.put("type", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "EmoticonOperateMonitor", bool, 0L, 0L, localHashMap, null);
  }
  
  public static void reportEmoticonOperateMonitorAddStatus(String paramString, int paramInt)
  {
    reportEmoticonOperateMonitor(paramString, null, null, paramInt);
  }
  
  public static void reportEmoticonOperateMonitorDeleteStatus(String paramString, int paramInt)
  {
    reportEmoticonOperateMonitor(null, paramString, null, paramInt);
  }
  
  public static void reportEmoticonOperateMonitorGetStatus(String paramString, int paramInt)
  {
    reportEmoticonOperateMonitor(null, null, paramString, paramInt);
  }
  
  public static void reportFavAddEmotionEvent(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800AEE5", "0X800AEE5", paramInt, 0, "", "", paramString1, paramString2);
  }
  
  public static void reportNewSoundEvent(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (paramInt != -1)
    {
      paramInt = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(paramInt)).intValue();
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = -1;
            } else {
              paramInt = 2;
            }
          }
          else {
            paramInt = 4;
          }
        }
        else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt != -1)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "";
      }
      ReportController.b(paramAppInterface, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonOperateReport
 * JD-Core Version:    0.7.0.1
 */