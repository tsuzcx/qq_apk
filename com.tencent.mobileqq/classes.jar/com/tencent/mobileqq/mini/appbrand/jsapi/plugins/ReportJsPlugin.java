package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04884;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportJsPlugin
  extends BaseJsPlugin
{
  public static final String API_API_REPORT = "api_report";
  public static final String API_API_REPORT_DC = "reportDC";
  private static final String API_REPORT_KEY_VALUE = "reportKeyValue";
  private static final int REPORT_EVENT_Display = 15496;
  private static final int REPORT_EVENT_Speed = 13544;
  private static final int REPORT_EVENT_Speed_newPage2pageReady = 9;
  private static final int REPORT_EVENT_Speed_reRenderTime = 6;
  private static final Set<String> S_EVENT_MAP = new ReportJsPlugin.1();
  private static final String TAG = "[mini] ReportJsPlugin";
  private Activity mActivity;
  
  private void doReportBy898(String paramString, JSONArray paramJSONArray)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          localStringBuilder.append(paramJSONArray.getString(i).replace("|", ""));
          if (i != paramJSONArray.length() - 1) {
            localStringBuilder.append('|');
          }
        }
        else
        {
          paramJSONArray = new Bundle();
          paramJSONArray.putString("log_key", paramString);
          paramJSONArray.putStringArray("data", new String[] { localStringBuilder.toString() });
          QLog.e("[mini] ReportJsPlugin", 2, "doReportBy898 key:  " + paramString + "  data: " + localStringBuilder.toString());
          AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", paramJSONArray, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[mini] ReportJsPlugin", 1, "doReportBy898 failed, ", paramString);
        return;
      }
      i += 1;
    }
  }
  
  private void handleApiReport(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig)
  {
    Object localObject2 = "";
    String str = "";
    Object localObject1 = localObject2;
    if (paramMiniAppConfig != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramMiniAppConfig.config != null) {
        localObject1 = paramMiniAppConfig.config.version;
      }
      localObject2 = str;
      if (paramMiniAppConfig != null)
      {
        localObject2 = str;
        if (paramMiniAppConfig.baseLibInfo != null) {
          localObject2 = paramMiniAppConfig.baseLibInfo.baseLibVersion;
        }
      }
      MiniProgramLpReportDC04884.reportApiReport(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId, paramString2, (String)localObject1, (String)localObject2);
      return;
    }
    catch (Exception paramString2)
    {
      QLog.e("[mini] ReportJsPlugin", 1, paramString1 + " error.", paramString2);
    }
  }
  
  private void handleReportDC(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      paramString1 = paramString2.getString("table");
      paramString2 = paramString2.getJSONArray("reportArray");
      if ((!TextUtils.isEmpty(paramString1)) && (paramString2.length() > 0)) {
        doReportBy898(paramString1, paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("[mini] ReportJsPlugin", 1, " handleReportDC error.", paramString1);
    }
  }
  
  private void handleReportKeyValue(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      long l;
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONArray("dataArray");
        i = 0;
        if (i < paramString2.length())
        {
          Object localObject = paramString2.getJSONObject(i);
          int j = ((JSONObject)localObject).getInt("key");
          if (15496 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            if ((localObject.length > 8) && (!localObject[0].equals("2")))
            {
              j = Integer.parseInt(localObject[7]);
              if (j > 0)
              {
                QLog.e("[mini] ReportJsPlugin", 1, paramString1 + " REPORT_EVENT_Display: " + j);
                MiniReportManager.reportEventType(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 638, null, null, null, 0, "0", j, null);
              }
            }
          }
          else if (13544 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            j = Integer.parseInt(localObject[0]);
            if ((9 == j) || (6 == j))
            {
              l = Long.parseLong(localObject[1]);
              l = Long.parseLong(localObject[4]) - l;
              if (l > 0L)
              {
                QLog.e("[mini] ReportJsPlugin", 1, paramString1 + " REPORT_EVENT_Speed: " + l);
                if (9 == j) {
                  MiniReportManager.reportEventType(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 636, null, null, null, 0, "0", l, null);
                }
              }
            }
          }
        }
      }
      catch (Exception paramString2)
      {
        QLog.e("[mini] ReportJsPlugin", 1, paramString1 + " error.", paramString2);
      }
      return;
      MiniReportManager.reportEventType(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 637, null, null, null, 0, "0", l, null);
      i += 1;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ("reportKeyValue".equals(paramString1)) {
      handleReportKeyValue(paramString1, paramString2);
    }
    for (;;)
    {
      return "";
      if ("api_report".equals(paramString1)) {
        handleApiReport(paramString1, paramString2, this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
      } else if ("reportDC".equals(paramString1)) {
        handleReportDC(paramString1, paramString2);
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.getActivityContext();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ReportJsPlugin
 * JD-Core Version:    0.7.0.1
 */