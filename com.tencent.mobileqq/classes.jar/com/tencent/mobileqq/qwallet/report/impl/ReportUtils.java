package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ReportUtils
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private static final String a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getAccount();
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static void a()
  {
    ThreadManagerV2.executeOnFileThread(new ReportUtils.1());
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    String str;
    if (SimpleUIUtil.e()) {
      str = "1";
    } else if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      str = "2";
    } else {
      str = "0";
    }
    a(paramBaseQQAppInterface, paramString, paramBaseSessionInfo, str);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, BaseSessionInfo paramBaseSessionInfo, String paramString2)
  {
    if (paramBaseSessionInfo != null) {}
    for (;;)
    {
      try
      {
        if (paramBaseSessionInfo.a == 3000)
        {
          paramBaseSessionInfo = "2";
        }
        else if (paramBaseSessionInfo.a == 1)
        {
          paramBaseSessionInfo = "1";
        }
        else
        {
          if (paramBaseSessionInfo.a != 10014) {
            break label162;
          }
          paramBaseSessionInfo = String.valueOf(11);
        }
      }
      catch (Exception paramBaseQQAppInterface)
      {
        Object localObject;
        QLog.e("ReportUtils", 1, paramBaseQQAppInterface, new Object[0]);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtils", 2, String.format("opName: %s__d1: %s__d2: %s__d3: %s", new Object[] { paramString1, paramBaseSessionInfo, localObject, paramString2 }));
      }
      ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramString1, 0, 0, paramBaseSessionInfo, (String)localObject, paramString2, "");
      return;
      for (;;)
      {
        break;
        label162:
        paramBaseSessionInfo = "0";
      }
      paramBaseSessionInfo = "";
    }
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if ((!paramMap.containsKey("A8")) && (MobileQQ.sMobileQQ != null)) {
        paramMap.put("A8", a(MobileQQ.sMobileQQ.peekAppRuntime()));
      }
      if (!paramMap.containsKey("plat")) {
        paramMap.put("plat", "android");
      }
      if (!paramMap.containsKey("version")) {
        paramMap.put("version", "8.8.17");
      }
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, true, true);
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    a(paramString1, paramString2, a(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.ReportUtils
 * JD-Core Version:    0.7.0.1
 */