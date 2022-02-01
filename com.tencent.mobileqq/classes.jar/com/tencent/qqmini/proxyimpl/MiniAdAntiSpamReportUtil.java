package com.tencent.qqmini.proxyimpl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetLastClicksActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAdAntiSpamReportUtil
{
  private static long jdField_a_of_type_Long;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static long jdField_b_of_type_Long;
  private static HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static long c;
  
  private static long a()
  {
    return Math.max(jdField_b_of_type_Long, jdField_a_of_type_Long);
  }
  
  private static Bundle a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt2, String paramString5)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString1 = a(paramString1);
        localBundle.putString("viewid", paramString1);
        localBundle.putInt("lt", paramInt1);
        localBundle.putInt("ig", 1);
        localBundle.putString("refer", "");
        localBundle.putInt("at", 0);
        localBundle.putInt("fh", 0);
        localBundle.putString("wlv", paramString2);
        localBundle.putString("dl", "");
        localBundle.putInt("s", 0);
        localBundle.putString("lc", paramString3);
        localBundle.putString("s_p", paramString4);
        localBundle.putInt("sc_c", paramInt2);
        localBundle.putString("sc_sn", paramString5);
        if (paramInt1 == 0)
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          if (!TextUtils.isEmpty(paramString1))
          {
            jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(l2));
            l1 = l2;
          }
          localBundle.putLong("it", l1);
          localBundle.putLong("st", jdField_a_of_type_Long);
          localBundle.putLong("ent", a());
          localBundle.putLong("et", paramLong);
          localBundle.putLong("ud", b());
          return localBundle;
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = (Long)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if (paramString1 != null)
          {
            l1 = paramString1.longValue();
            continue;
          }
        }
        long l1 = 0L;
      }
      catch (Exception paramString1)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "createReportString error.", paramString1);
        return localBundle;
      }
    }
  }
  
  public static String a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if ((paramIMiniAppContext == null) || (TextUtils.isEmpty(paramString1))) {
      return new JSONObject().toString();
    }
    try
    {
      paramIMiniAppContext = a(paramIMiniAppContext.getAdReportData(), paramString1, paramString2);
      return paramIMiniAppContext;
    }
    catch (Throwable paramIMiniAppContext)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "getRewardedVideoAdExposeReportParamForSDK get an Exception:" + paramIMiniAppContext.toString());
    }
    return new JSONObject().toString();
  }
  
  private static String a(AdReportData paramAdReportData, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localJSONObject.put("ap_p", paramAdReportData.path);
        localJSONObject.put("at", 0);
        localJSONObject.put("cn_t", paramAdReportData.networkType);
        localJSONObject.put("dl", "");
        localJSONObject.put("ent", paramAdReportData.lastOnResumeTime);
        localJSONObject.put("et", l);
        localJSONObject.put("fh", 0);
        localJSONObject.put("ic", 0);
        localJSONObject.put("ig", paramAdReportData.isGame);
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
          localJSONObject.put("it", jdField_a_of_type_JavaUtilHashMap.get(paramString1));
        }
        localJSONObject.put("lc", paramAdReportData.lastClicks);
        localJSONObject.put("lt", 2);
        localJSONObject.put("refer", paramAdReportData.referPath);
        localJSONObject.put("s", 0);
        localJSONObject.put("s_p", paramString2);
        localJSONObject.put("sc_s", paramAdReportData.scene);
        if (!TextUtils.isEmpty(paramAdReportData.scene_sn)) {
          continue;
        }
        paramString2 = "";
        localJSONObject.put("sc_sn", paramString2);
        localJSONObject.put("st", paramAdReportData.startTime);
        localJSONObject.put("ud", paramAdReportData.stayTime);
        if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1)) {
          localJSONObject.put("viewid", a((String)jdField_b_of_type_JavaUtilHashMap.get(paramString1)));
        }
        localJSONObject.put("wlv", paramAdReportData.baseLibVersion);
        QLog.d("MiniAdAntiSpamReportUtil", 0, "spam data: " + localJSONObject.toString());
      }
      catch (Exception paramAdReportData)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "createRewardedVideoAdReportParams error.", paramAdReportData);
        continue;
      }
      return localJSONObject.toString();
      paramString2 = paramAdReportData.scene_sn;
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = Uri.parse(paramString).getQueryParameter("viewid");
      paramString = str;
    } while (str != null);
    return "";
  }
  
  private static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      Object localObject;
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = paramBundle.get(str);
          if ((localObject instanceof String)) {
            localJSONObject.put(str, paramBundle.getString(str));
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "paramsToJson error.", paramBundle);
      }
      if ((localObject instanceof Integer)) {
        localJSONObject.put(str, paramBundle.getInt(str));
      } else if ((localObject instanceof Long)) {
        localJSONObject.put(str, paramBundle.getLong(str));
      }
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, long paramLong, String paramString)
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    if (paramIMiniAppContext == null)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "miniAppContext == null");
      return localJSONObject;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    paramIMiniAppContext = str1;
    int i = j;
    if (localMiniAppInfo != null)
    {
      paramIMiniAppContext = str1;
      i = j;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        paramIMiniAppContext = str1;
        i = j;
        if (TextUtils.isEmpty(str1))
        {
          if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            break label286;
          }
          paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          if (paramIMiniAppContext == null) {
            break label291;
          }
          paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
          i = j;
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("at", 0);
        localJSONObject.put("ent", a());
        localJSONObject.put("ig", 1);
        localJSONObject.put("it", paramLong);
        localJSONObject.put("lc", str3);
        localJSONObject.put("s_p", paramString);
        localJSONObject.put("sc_s", i);
        if (paramIMiniAppContext != null) {
          continue;
        }
        paramIMiniAppContext = "";
        localJSONObject.put("sc_sn", paramIMiniAppContext);
        localJSONObject.put("st", jdField_a_of_type_Long);
        localJSONObject.put("ud", b());
        localJSONObject.put("wlv", str2);
      }
      catch (JSONException paramIMiniAppContext)
      {
        label286:
        label291:
        paramIMiniAppContext.printStackTrace();
        continue;
      }
      return localJSONObject;
      paramIMiniAppContext = null;
      break;
      paramIMiniAppContext = "";
      i = j;
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    int j = 0;
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i = j;
    paramIMiniAppContext = str1;
    if (localMiniAppInfo != null)
    {
      i = j;
      paramIMiniAppContext = str1;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        i = j;
        paramIMiniAppContext = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramIMiniAppContext = localObject;
          if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          }
          if (paramIMiniAppContext == null) {
            break label181;
          }
        }
      }
    }
    label181:
    for (paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");; paramIMiniAppContext = "")
    {
      i = j;
      return a(paramString1, 3, str2, str3, 0L, paramString2, i, paramIMiniAppContext);
    }
  }
  
  private static JSONObject a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt2, String paramString5)
  {
    return a(a(paramString1, paramInt1, paramString2, paramString3, paramLong, paramString4, paramInt2, paramString5));
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_Long = System.currentTimeMillis();
    c = 0L;
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    QLog.i("MiniAdAntiSpamReportUtil", 1, "reportParams=" + paramBundle.toString());
    ThreadManager.excute(new MiniAdAntiSpamReportUtil.1(paramBundle), 128, null, true);
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    int j = 0;
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i = j;
    paramIMiniAppContext = str1;
    if (localMiniAppInfo != null)
    {
      i = j;
      paramIMiniAppContext = str1;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        i = j;
        paramIMiniAppContext = str1;
        if (TextUtils.isEmpty(str1))
        {
          if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            break label184;
          }
          paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          if (paramIMiniAppContext == null) {
            break label189;
          }
        }
      }
    }
    label184:
    label189:
    for (paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");; paramIMiniAppContext = "")
    {
      i = j;
      a(a(paramString1, paramInt, str2, str3, paramLong, paramString2, i, paramIMiniAppContext));
      return;
      paramIMiniAppContext = null;
      break;
    }
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      int j = localMiniAppInfo.launchParam.scene;
      str1 = localMiniAppInfo.launchParam.fromMiniAppId;
      i = j;
      paramIMiniAppContext = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
          break label160;
        }
        paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
        if (paramIMiniAppContext == null) {
          break label165;
        }
        paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
        label142:
        i = j;
      }
    }
    for (;;)
    {
      a(paramString1, 0, str2, str3, 0L, paramString2, i, paramIMiniAppContext);
      return;
      label160:
      paramIMiniAppContext = null;
      break;
      label165:
      paramIMiniAppContext = "";
      break label142;
      i = 0;
      paramIMiniAppContext = str1;
    }
  }
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    }
  }
  
  private static long b()
  {
    return c + System.currentTimeMillis() - a();
  }
  
  public static void b()
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public static void c()
  {
    c += System.currentTimeMillis() - jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAdAntiSpamReportUtil
 * JD-Core Version:    0.7.0.1
 */