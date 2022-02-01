package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04363;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04682;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class ReportPlugin
  extends BaseJsPlugin
{
  public static final String API_REPORT_ANALYTICS = "reportRealtimeAction";
  public static final String EVENT_NAME_REPORT_DATA_TO_DC = "reportDataToDC";
  public static final String KEY_TABLE_DATA = "args";
  public static final String KEY_TABLE_NAME = "tableName";
  private static final Set<String> S_EVENT_MAP = new ReportPlugin.1();
  public static final String TABLE_DC04239 = "dc04239";
  public static final String TABLE_DC04682 = "dc04682";
  private static final String TAG = "[minigame] ReportPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] ReportPlugin", 1, "ReportPlugin handleNativeRequest [eventName=" + paramString1 + "][jsonParams=" + paramString2 + "]");
    if ((getGameBrandRuntime() == null) || (getGameBrandRuntime().getApkgInfo() == null)) {
      QLog.e("[minigame] ReportPlugin", 1, "ReportPlugin handleNativeRequest fail, runtime error, [eventName=" + paramString1 + "][jsonParams=" + paramString2 + "]");
    }
    for (;;)
    {
      return "{}";
      Object localObject;
      if ("reportDataToDC".equals(paramString1))
      {
        try
        {
          localObject = new JSONObject(paramString2);
          paramJsRuntime = ((JSONObject)localObject).optString("tableName");
          localObject = ((JSONObject)localObject).optJSONObject("args");
          if (localObject == null) {
            break label236;
          }
          if ("dc04239".equals(paramJsRuntime))
          {
            MiniProgramLpReportDC04239.gameInnerReport(getGameBrandRuntime().getApkgInfo().appConfig, (JSONObject)localObject);
            return "{}";
          }
        }
        catch (Exception paramJsRuntime)
        {
          QLog.e("[minigame] ReportPlugin", 1, "ReportPlugin handleNativeRequest exception, [eventName=" + paramString1 + "][jsonParams=" + paramString2 + "]");
          return "{}";
        }
        if ("dc04682".equals(paramJsRuntime))
        {
          MiniProgramLpReportDC04682.report(getGameBrandRuntime().getApkgInfo().appConfig, (JSONObject)localObject);
          return "{}";
          label236:
          QLog.e("[minigame] ReportPlugin", 1, "ReportPlugin report to table[" + paramJsRuntime + "] fail, no args, [eventName=" + paramString1 + "][jsonParams=" + paramString2 + "]");
          return "{}";
        }
      }
      else if (("reportRealtimeAction".equals(paramString1)) && (isMiniGameRuntime()))
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject(paramString2);
          GameRuntimeLoader localGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
          localObject = localGameRuntimeLoader.getGameInfoManager().getMiniAppConfig();
          JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
          if (localJSONObject2 != null)
          {
            paramString2 = localJSONObject2.optString("eventID", "");
            if (JSONUtil.isJson(paramString2))
            {
              paramString2 = new JSONObject(paramString2);
              if ((paramString2 != null) && (paramString2.has("finishShow")))
              {
                MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, MiniProgramLpReportDC04239.getAppType((MiniAppConfig)localObject), null, "finishshow", null);
                if (paramString2.length() == 1)
                {
                  this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
                  return "";
                }
              }
            }
            else if (paramString2.equals("finishShow"))
            {
              QLog.i("[minigame][start] ", 1, "game[" + ((MiniAppConfig)localObject).config.appId + "][" + ((MiniAppConfig)localObject).config.name + "] 游戏加载完成(游戏上报finishShow)");
              MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, MiniProgramLpReportDC04239.getAppType((MiniAppConfig)localObject), null, "finishshow", null);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              return "";
            }
            localJSONObject2.put("version", localGameRuntimeLoader.getJsVersion());
            localJSONObject1.put("actionData", localJSONObject2);
            paramString2 = localJSONObject1.toString();
          }
          if ((localObject != null) && (((MiniAppConfig)localObject).config != null))
          {
            MiniProgramLpReportDC04363.handleReportRealTimeAction(((MiniAppConfig)localObject).config.appId, paramString2);
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            return "{}";
          }
        }
        catch (Throwable paramString2)
        {
          QLog.e("[minigame] ReportPlugin", 1, paramString2, new Object[0]);
          paramString2 = ApiUtil.wrapCallbackFail(paramString1, null);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, paramString2, paramInt);
        }
      }
    }
    return paramString2.toString();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */