package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04363;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04682;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
public class ReportPlugin
  extends BaseJsPlugin
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  public static final String EVENT_REPORT_KEY_VALUE = "reportKeyValue";
  public static final String KEY_ACTION_TYPE = "actiontype";
  public static final String KEY_RESERVES_ACTION = "reserves_action";
  public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
  public static final String KEY_TABLE_DATA = "args";
  public static final String KEY_TABLE_NAME = "tableName";
  public static final int REPORT_EVENT_DISPLAY = 15496;
  public static final int REPORT_EVENT_JS_EXCEPTION = 13582;
  public static final int REPORT_EVENT_SPEED = 13544;
  public static final int REPORT_EVENT_SPEED_NEW_PAGE_2_PAGE_READY = 9;
  public static final int REPORT_EVENT_SPEED_RE_RENDER_TIME = 6;
  public static final String TABLE_DC04239 = "dc04239";
  public static final String TABLE_DC04682 = "dc04682";
  private static final String TAG = "ReportPlugin";
  
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
          QMLog.e("ReportPlugin", "doReportBy898 key:  " + paramString + "  data: " + localStringBuilder.toString());
          AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", paramJSONArray, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        QMLog.e("ReportPlugin", "doReportBy898 failed, ", paramString);
        return;
      }
      i += 1;
    }
  }
  
  public static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
  }
  
  @JsEvent({"api_report"})
  public void apiReport(RequestEvent paramRequestEvent)
  {
    String str2 = "";
    String str4 = "";
    String str1 = "";
    try
    {
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      if (localMiniAppInfo != null)
      {
        str2 = localMiniAppInfo.version;
        str1 = localMiniAppInfo.appId;
      }
      String str3 = str4;
      if (localMiniAppInfo != null)
      {
        str3 = str4;
        if (localMiniAppInfo.baseLibInfo != null) {
          str3 = localMiniAppInfo.baseLibInfo.baseLibVersion;
        }
      }
      MiniProgramLpReportDC04884.reportApiReport(str1, paramRequestEvent.jsonParams, str2, str3);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("ReportPlugin", paramRequestEvent.event + " error.", localException);
    }
  }
  
  @JsEvent({"realtimeLog"})
  public String realtimeLogAction(RequestEvent paramRequestEvent)
  {
    try
    {
      ((MiniAppRealTimeLogReporter)this.mMiniAppContext.getManager(MiniAppRealTimeLogReporter.class)).report(paramRequestEvent.jsonParams);
      QMLog.d("ReportPlugin", "EVENT_NAME_REAL_TIME_LOG " + paramRequestEvent.jsonParams);
      return "";
    }
    catch (Exception paramRequestEvent)
    {
      for (;;)
      {
        QMLog.e("ReportPlugin", "realtimeLog exception", paramRequestEvent);
      }
    }
  }
  
  @JsEvent({"reportDC"})
  public void reportDC(RequestEvent paramRequestEvent)
  {
    ThreadManager.getSubThreadHandler().post(new ReportPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"reportDataToDC"})
  public void reportDataToDC(RequestEvent paramRequestEvent)
  {
    String str;
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      str = ((JSONObject)localObject2).optString("tableName");
      Object localObject1 = ((JSONObject)localObject2).optJSONObject("args");
      if (localObject1 != null)
      {
        if ("dc04239".equals(str))
        {
          if (localObject2 == null) {
            return;
          }
          localObject2 = ((JSONObject)localObject1).optString("actiontype");
          str = ((JSONObject)localObject1).optString("sub_actiontype");
          localObject1 = ((JSONObject)localObject1).optString("reserves_action");
          SDKMiniProgramLpReportDC04239.reportForSDK(this.mMiniAppInfo, "1", null, (String)localObject2, str, (String)localObject1, "");
          return;
        }
        if (!"dc04682".equals(str)) {
          return;
        }
        MiniProgramLpReportDC04682.report(this.mMiniAppInfo, (JSONObject)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("ReportPlugin", "ReportPlugin handleNativeRequest exception, [eventName=" + paramRequestEvent.event + "][jsonParams=" + paramRequestEvent.jsonParams + "]");
      return;
    }
    QMLog.e("ReportPlugin", "ReportPlugin report to table[" + str + "] fail, no args, [eventName=" + paramRequestEvent.event + "][jsonParams=" + paramRequestEvent.jsonParams + "]");
  }
  
  @JsEvent({"reportKeyValue"})
  public void reportKeyValue(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 3));
  }
  
  @JsEvent({"reportRealtimeAction"})
  public String reportRealtimeAction(RequestEvent paramRequestEvent)
  {
    if (this.mIsMiniGame) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
      if (localJSONObject2 != null)
      {
        Object localObject = localJSONObject2.optString("eventID", "");
        if (JSONUtil.isJson((String)localObject))
        {
          localObject = new JSONObject((String)localObject);
          if ((localObject != null) && (((JSONObject)localObject).has("finishShow")))
          {
            SDKMiniProgramLpReportDC04239.reportForSDK(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
            if (((JSONObject)localObject).length() == 1)
            {
              paramRequestEvent.ok();
              return "";
            }
          }
        }
        else if (((String)localObject).equals("finishShow"))
        {
          SDKMiniProgramLpReportDC04239.reportForSDK(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
          paramRequestEvent.ok();
          return "";
        }
        localJSONObject2.put("version", this.mMiniAppContext.getBaseLibVersion());
        localJSONObject1.put("actionData", localJSONObject2);
      }
      if (localMiniAppInfo != null)
      {
        MiniProgramLpReportDC04363.handleReportRealTimeAction(localMiniAppInfo.appId, localJSONObject1.toString());
        paramRequestEvent.ok();
      }
    }
    catch (Throwable paramRequestEvent)
    {
      for (;;)
      {
        QMLog.e("ReportPlugin", "", paramRequestEvent);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */