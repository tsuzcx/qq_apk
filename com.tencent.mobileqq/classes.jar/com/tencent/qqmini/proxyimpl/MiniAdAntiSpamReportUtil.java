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
      long l2 = 0L;
      long l1;
      if (paramInt1 == 0)
      {
        l2 = System.currentTimeMillis();
        l1 = l2;
        if (!TextUtils.isEmpty(paramString1))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(l2));
          l1 = l2;
        }
      }
      else
      {
        l1 = l2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = (Long)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          l1 = l2;
          if (paramString1 != null) {
            l1 = paramString1.longValue();
          }
        }
      }
      localBundle.putLong("it", l1);
      localBundle.putLong("st", jdField_a_of_type_Long);
      localBundle.putLong("ent", a());
      localBundle.putLong("et", paramLong);
      localBundle.putLong("ud", b());
      return localBundle;
    }
    catch (Exception paramString1)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "createReportString error.", paramString1);
    }
    return localBundle;
  }
  
  public static String a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if ((paramIMiniAppContext != null) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        paramIMiniAppContext = a(paramIMiniAppContext.getAdReportData(), paramString1, paramString2);
        return paramIMiniAppContext;
      }
      catch (Throwable paramIMiniAppContext)
      {
        paramString1 = new StringBuilder();
        paramString1.append("getRewardedVideoAdExposeReportParamForSDK get an Exception:");
        paramString1.append(paramIMiniAppContext.toString());
        QLog.e("MiniAdAntiSpamReportUtil", 1, paramString1.toString());
        return new JSONObject().toString();
      }
    }
    return new JSONObject().toString();
  }
  
  private static String a(AdReportData paramAdReportData, String paramString1, String paramString2)
  {
    String str = "";
    JSONObject localJSONObject = new JSONObject();
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
      if (TextUtils.isEmpty(paramAdReportData.scene_sn)) {
        paramString2 = str;
      } else {
        paramString2 = paramAdReportData.scene_sn;
      }
      localJSONObject.put("sc_sn", paramString2);
      localJSONObject.put("st", paramAdReportData.startTime);
      localJSONObject.put("ud", paramAdReportData.stayTime);
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1)) {
        localJSONObject.put("viewid", a((String)jdField_b_of_type_JavaUtilHashMap.get(paramString1)));
      }
      localJSONObject.put("wlv", paramAdReportData.baseLibVersion);
      paramAdReportData = new StringBuilder();
      paramAdReportData.append("spam data: ");
      paramAdReportData.append(localJSONObject.toString());
      QLog.d("MiniAdAntiSpamReportUtil", 0, paramAdReportData.toString());
    }
    catch (Exception paramAdReportData)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "createRewardedVideoAdReportParams error.", paramAdReportData);
    }
    return localJSONObject.toString();
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = Uri.parse(paramString).getQueryParameter("viewid");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  private static JSONObject a(Bundle paramBundle)
  {
    localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof String)) {
          localJSONObject.put(str, paramBundle.getString(str));
        } else if ((localObject instanceof Integer)) {
          localJSONObject.put(str, paramBundle.getInt(str));
        } else if ((localObject instanceof Long)) {
          localJSONObject.put(str, paramBundle.getLong(str));
        }
      }
      return localJSONObject;
    }
    catch (Exception paramBundle)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "paramsToJson error.", paramBundle);
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, long paramLong, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramIMiniAppContext == null)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "miniAppContext == null");
      return localJSONObject;
    }
    String str1 = paramIMiniAppContext.getBaseLibVersion();
    String str2 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      i = localMiniAppInfo.launchParam.scene;
      paramIMiniAppContext = localMiniAppInfo.launchParam.fromMiniAppId;
      if (TextUtils.isEmpty(paramIMiniAppContext))
      {
        if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
          paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
        } else {
          paramIMiniAppContext = null;
        }
        if (paramIMiniAppContext != null) {
          paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
        } else {
          paramIMiniAppContext = "";
        }
      }
    }
    else
    {
      paramIMiniAppContext = "";
      i = 0;
    }
    try
    {
      localJSONObject.put("at", 0);
      localJSONObject.put("ent", a());
      localJSONObject.put("ig", 1);
      localJSONObject.put("it", paramLong);
      localJSONObject.put("lc", str2);
      localJSONObject.put("s_p", paramString);
      localJSONObject.put("sc_s", i);
      paramString = paramIMiniAppContext;
      if (paramIMiniAppContext == null) {
        paramString = "";
      }
      localJSONObject.put("sc_sn", paramString);
      localJSONObject.put("st", jdField_a_of_type_Long);
      localJSONObject.put("ud", b());
      localJSONObject.put("wlv", str1);
      return localJSONObject;
    }
    catch (JSONException paramIMiniAppContext)
    {
      paramIMiniAppContext.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = null;
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.isMiniGame()))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      String str2 = paramIMiniAppContext.getBaseLibVersion();
      String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
      MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
      paramIMiniAppContext = "";
      int i;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
      {
        i = localMiniAppInfo.launchParam.scene;
        String str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        if (TextUtils.isEmpty(str1))
        {
          if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            localJSONObject = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          }
          if (localJSONObject != null) {
            paramIMiniAppContext = localJSONObject.optString("groupid", "");
          }
        }
        else
        {
          paramIMiniAppContext = str1;
        }
      }
      else
      {
        paramIMiniAppContext = "";
        i = 0;
      }
      return a(paramString1, 3, str2, str3, 0L, paramString2, i, paramIMiniAppContext);
    }
    return null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportParams=");
    localStringBuilder.append(paramBundle.toString());
    QLog.i("MiniAdAntiSpamReportUtil", 1, localStringBuilder.toString());
    ThreadManager.excute(new MiniAdAntiSpamReportUtil.1(paramBundle), 128, null, true);
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.isMiniGame()))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      String str1 = paramIMiniAppContext.getBaseLibVersion();
      String str2 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
      MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
      paramIMiniAppContext = "";
      int i;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
      {
        i = localMiniAppInfo.launchParam.scene;
        Object localObject = localMiniAppInfo.launchParam.fromMiniAppId;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            localObject = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          } else {
            localObject = null;
          }
          if (localObject != null) {
            paramIMiniAppContext = ((JSONObject)localObject).optString("groupid", "");
          }
        }
        else
        {
          paramIMiniAppContext = (IMiniAppContext)localObject;
        }
      }
      else
      {
        paramIMiniAppContext = "";
        i = 0;
      }
      a(a(paramString1, paramInt, str1, str2, paramLong, paramString2, i, paramIMiniAppContext));
    }
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.isMiniGame()))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      String str1 = paramIMiniAppContext.getBaseLibVersion();
      String str2 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
      MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
      paramIMiniAppContext = "";
      int i;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
      {
        i = localMiniAppInfo.launchParam.scene;
        Object localObject = localMiniAppInfo.launchParam.fromMiniAppId;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            localObject = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          } else {
            localObject = null;
          }
          if (localObject != null) {
            paramIMiniAppContext = ((JSONObject)localObject).optString("groupid", "");
          }
        }
        else
        {
          paramIMiniAppContext = (IMiniAppContext)localObject;
        }
      }
      else
      {
        paramIMiniAppContext = "";
        i = 0;
      }
      a(paramString1, 0, str1, str2, 0L, paramString2, i, paramIMiniAppContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAdAntiSpamReportUtil
 * JD-Core Version:    0.7.0.1
 */