package com.tencent.open.agent.util;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AuthReporter
{
  private static IAuthBeaconReporter a;
  
  public static String a()
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null) {
      return "";
    }
    if (localNetworkInfo.getType() == 1) {
      return "wifi";
    }
    if (localNetworkInfo.getType() != 0) {
      return "";
    }
    int i = localNetworkInfo.getSubtype();
    if ((i != 3) && (i != 8) && (i != 5) && (i != 6)) {
      return "2G";
    }
    return "3G";
  }
  
  public static void a(int paramInt, AccountInfo paramAccountInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramInt));
    a("KEY_LOGIN_STAGE_3_TOTAL", paramAccountInfo);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a("KEY_AUTHORITY_TOTAL", paramAccountInfo, localHashMap, bool);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    SSOLog.a("AuthReporter", new Object[] { "reportLoginResult, errorCode=", Integer.valueOf(paramInt), ", appId=", paramString1, ", uin=*", AuthorityUtil.a(paramString2) });
    String str;
    if (paramInt == 0) {
      str = "0";
    }
    for (;;)
    {
      try
      {
        ReportCenter.a().a(paramString2, "", paramString1, "1", "3", str, true, true);
        return;
      }
      catch (Exception paramString1)
      {
        SSOLog.c("AuthReporter", "reportLoginResult, error: ", paramString1);
        return;
      }
      str = "1";
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    try
    {
      OpenSdkStatic.a().a(paramInt1, paramString1, paramString2, paramString3, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt2, 1, paramString4);
      return;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("AuthReporter", "Exception", paramString1);
    }
  }
  
  public static void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    a(AuthorityUtil.a(new Object[] { "report_type", Integer.valueOf(103), "act_type", Integer.valueOf(10), "stringext_1", "GetTicketNoPassword", "intext_2", Integer.valueOf(paramInt), "intext_5", Long.valueOf(paramLong) }), paramString1, paramString2);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramInt, paramString1, paramString2, paramString3, new HashMap());
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errordetail", paramString4);
    a(paramContext, paramInt, paramString1, paramString2, paramString3, localHashMap);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("appid", paramString3);
    ((HashMap)localObject).put("errorcode", String.valueOf(paramInt));
    ((HashMap)localObject).put("errormsg", paramString1);
    paramString1 = a();
    if (!TextUtils.isEmpty(paramString1)) {
      ((HashMap)localObject).put("network", paramString1);
    }
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString2, "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramBoolean1) {
      str1 = "notlogged";
    } else {
      str1 = "logged";
    }
    String str2;
    if (paramBoolean2) {
      str2 = "auth";
    } else {
      str2 = "uauth";
    }
    try
    {
      paramString1 = AuthorityUtil.a(new String[] { "appid", paramString1, "p1", str1, "p2", str2, "autologin", "0" });
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString2, "connect_sso_lognback", true, paramLong, 0L, paramString1, "");
      return;
    }
    catch (Exception paramContext)
    {
      SSOLog.c("AuthReporter", "Exception", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = AuthorityUtil.a(new String[] { "appid", paramString1, "p1", paramString4, "p2", paramString5, "autologin", "0" });
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString2, paramString3, false, paramLong, 0L, paramString1, "");
      return;
    }
    catch (Exception paramContext)
    {
      SSOLog.c("AuthReporter", "Exception", paramContext);
    }
  }
  
  public static void a(Bundle paramBundle, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBundle.getBoolean("isShort", false)) {
      paramBundle = "2";
    } else {
      paramBundle = "1";
    }
    a(AuthorityUtil.a(new Object[] { "report_type", Integer.valueOf(103), "act_type", Integer.valueOf(paramInt2), "intext_3", paramBundle, "stringext_1", paramString1, "intext_2", Integer.valueOf(paramInt1), "intext_5", Long.valueOf(paramLong) }), paramString2, paramString3);
  }
  
  private static void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    try
    {
      ReportCenter.a().a(paramBundle, paramString1, paramString2, false, true);
      return;
    }
    catch (Exception paramBundle)
    {
      SSOLog.c("AuthReporter", "Exception", paramBundle);
    }
  }
  
  public static void a(IAuthBeaconReporter paramIAuthBeaconReporter)
  {
    a = paramIAuthBeaconReporter;
  }
  
  public static void a(String paramString)
  {
    a.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    a.a(paramString, paramLong);
  }
  
  public static void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    try
    {
      ReportManager.a().a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, Long.parseLong(paramString2), "1000069", paramString3, true);
      return;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("AuthReporter", "Exception", paramString1);
    }
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo)
  {
    a.a(paramString, paramAccountInfo);
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a.a(paramString, paramAccountInfo, paramHashMap, paramBoolean);
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo, boolean paramBoolean)
  {
    a.a(paramString, paramAccountInfo, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(SharedPrefs.c()))) {
      ReportController.b(null, "dc00898", "", paramString1, paramString2, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a.a(paramString1, paramString2, paramLong, paramHashMap, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    paramString3 = paramString4;
    if (paramString4 == null) {
      paramString3 = "";
    }
    paramString4 = new Bundle();
    paramString4.putString("uin", paramString1);
    paramString4.putString("openid", "");
    paramString4.putString("report_type", "1");
    paramString4.putString("act_type", "7");
    paramString4.putString("via", "2");
    paramString4.putString("app_id", paramString2);
    paramString4.putString("packagename", str);
    paramString4.putString("stringext_1", paramString3);
    paramString4.putString("result", "0");
    a(paramString4, paramString2, paramString1);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    try
    {
      ReportCenter.a().a(paramString1, "", paramString2, "1", paramString3, paramString4, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("AuthReporter", "Exception", paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a.a(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(paramAppRuntime, paramString1, paramString2);
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      a(AuthorityUtil.a(new Object[] { "report_type", Integer.valueOf(103), "act_type", Integer.valueOf(paramInt), "intext_5", Long.valueOf(paramLong) }), paramString1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      SSOLog.c("AuthReporter", "Exception", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthReporter
 * JD-Core Version:    0.7.0.1
 */