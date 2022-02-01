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
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          localStringBuilder1.append(paramJSONArray.getString(i).replace("|", ""));
          if (i != paramJSONArray.length() - 1) {
            localStringBuilder1.append('|');
          }
        }
        else
        {
          paramJSONArray = new Bundle();
          paramJSONArray.putString("log_key", paramString);
          paramJSONArray.putStringArray("data", new String[] { localStringBuilder1.toString() });
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("doReportBy898 key:  ");
          localStringBuilder2.append(paramString);
          localStringBuilder2.append("  data: ");
          localStringBuilder2.append(localStringBuilder1.toString());
          QMLog.e("ReportPlugin", localStringBuilder2.toString());
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
    String str2 = "0";
    String str1 = str2;
    if (paramMiniAppInfo != null)
    {
      str1 = str2;
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        str1 = "1";
      }
    }
    return str1;
  }
  
  @JsEvent({"api_report"})
  public void apiReport(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
        String str4 = "";
        if (localMiniAppInfo != null)
        {
          String str1 = localMiniAppInfo.version;
          localObject = localMiniAppInfo.appId;
          String str3 = str4;
          if (localMiniAppInfo != null)
          {
            str3 = str4;
            if (localMiniAppInfo.baseLibInfo != null) {
              str3 = localMiniAppInfo.baseLibInfo.baseLibVersion;
            }
          }
          MiniProgramLpReportDC04884.reportApiReport((String)localObject, paramRequestEvent.jsonParams, str1, str3);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramRequestEvent.event);
        ((StringBuilder)localObject).append(" error.");
        QMLog.e("ReportPlugin", ((StringBuilder)localObject).toString(), localException);
        return;
      }
      String str2 = "";
      Object localObject = str2;
    }
  }
  
  @JsEvent({"realtimeLog"})
  public String realtimeLogAction(RequestEvent paramRequestEvent)
  {
    try
    {
      ((MiniAppRealTimeLogReporter)this.mMiniAppContext.getManager(MiniAppRealTimeLogReporter.class)).report(paramRequestEvent.jsonParams);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EVENT_NAME_REAL_TIME_LOG ");
      localStringBuilder.append(paramRequestEvent.jsonParams);
      QMLog.d("ReportPlugin", localStringBuilder.toString());
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("ReportPlugin", "realtimeLog exception", paramRequestEvent);
    }
    return "";
  }
  
  @JsEvent({"reportDC"})
  public void reportDC(RequestEvent paramRequestEvent)
  {
    ThreadManager.getSubThreadHandler().post(new ReportPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"reportDataToDC"})
  public void reportDataToDC(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      localObject1 = ((JSONObject)localObject2).optString("tableName");
      localObject2 = ((JSONObject)localObject2).optJSONObject("args");
      if (localObject2 != null)
      {
        if ("dc04239".equals(localObject1))
        {
          localObject1 = ((JSONObject)localObject2).optString("actiontype");
          String str = ((JSONObject)localObject2).optString("sub_actiontype");
          localObject2 = ((JSONObject)localObject2).optString("reserves_action");
          SDKMiniProgramLpReportDC04239.reportForSDK(this.mMiniAppInfo, "1", null, (String)localObject1, str, (String)localObject2, "");
          return;
        }
        if (!"dc04682".equals(localObject1)) {
          break label229;
        }
        MiniProgramLpReportDC04682.report(this.mMiniAppInfo, (JSONObject)localObject2);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ReportPlugin report to table[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] fail, no args, [eventName=");
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append("][jsonParams=");
      ((StringBuilder)localObject2).append(paramRequestEvent.jsonParams);
      ((StringBuilder)localObject2).append("]");
      QMLog.e("ReportPlugin", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label170:
      label229:
      break label170;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ReportPlugin handleNativeRequest exception, [eventName=");
    ((StringBuilder)localObject1).append(paramRequestEvent.event);
    ((StringBuilder)localObject1).append("][jsonParams=");
    ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
    ((StringBuilder)localObject1).append("]");
    QMLog.e("ReportPlugin", ((StringBuilder)localObject1).toString());
  }
  
  @JsEvent({"reportKeyValue"})
  public void reportKeyValue(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 3));
  }
  
  @JsEvent({"reportRealtimeAction"})
  public String reportRealtimeAction(RequestEvent paramRequestEvent)
  {
    if (this.mIsMiniGame) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
        MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
        JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
        Object localObject = localJSONObject2.optString("eventID", "");
        boolean bool = JSONUtil.isJson((String)localObject);
        if (bool)
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("finishShow"))
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
        if (localMiniAppInfo != null)
        {
          MiniProgramLpReportDC04363.handleReportRealTimeAction(localMiniAppInfo.appId, localJSONObject1.toString());
          paramRequestEvent.ok();
          return "";
        }
      }
      catch (Throwable paramRequestEvent)
      {
        QMLog.e("ReportPlugin", "", paramRequestEvent);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */