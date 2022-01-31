package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.text.TextUtils;
import behq;
import bekr;
import belj;
import bepk;
import betc;
import beyx;
import beyy;
import beyz;
import bezi;
import bezl;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportPlugin
  extends BaseJsPlugin
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  public static final String KEY_ACTION_TYPE = "actiontype";
  public static final String KEY_RESERVES_ACTION = "reserves_action";
  public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
  public static final String KEY_TABLE_DATA = "args";
  public static final String KEY_TABLE_NAME = "tableName";
  private static final int REPORT_EVENT_Display = 15496;
  private static final int REPORT_EVENT_Speed = 13544;
  private static final int REPORT_EVENT_Speed_newPage2pageReady = 9;
  private static final int REPORT_EVENT_Speed_reRenderTime = 6;
  public static final String TABLE_DC04239 = "dc04239";
  public static final String TABLE_DC04682 = "dc04682";
  private final String TAG = "ReportPlugin";
  
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
          betc.d("ReportPlugin", "doReportBy898 key:  " + paramString + "  data: " + localStringBuilder.toString());
          bepk.a().a("cmd_dc_report_log_key_data", paramJSONArray, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        betc.d("ReportPlugin", "doReportBy898 failed, ", paramString);
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
  
  public void apiReport(bekr parambekr)
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
      beyz.a(str1, parambekr.b, str2, str3);
      return;
    }
    catch (Exception localException)
    {
      betc.d("ReportPlugin", parambekr.a + " error.", localException);
    }
  }
  
  public void reportDC(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      parambekr = ((JSONObject)localObject).getString("table");
      localObject = ((JSONObject)localObject).getJSONArray("reportArray");
      if ((!TextUtils.isEmpty(parambekr)) && (((JSONArray)localObject).length() > 0)) {
        doReportBy898(parambekr, (JSONArray)localObject);
      }
      return;
    }
    catch (Exception parambekr)
    {
      betc.d("ReportPlugin", " handleReportDC error.", parambekr);
    }
  }
  
  public void reportDataToDC(bekr parambekr)
  {
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambekr.b);
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
          bezl.a(this.mMiniAppInfo, "1", null, (String)localObject2, str, (String)localObject1, "");
          return;
        }
        if (!"dc04682".equals(str)) {
          return;
        }
        beyy.a(this.mMiniAppInfo, (JSONObject)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      betc.d("ReportPlugin", "ReportPlugin handleNativeRequest exception, [eventName=" + parambekr.a + "][jsonParams=" + parambekr.b + "]");
      return;
    }
    betc.d("ReportPlugin", "ReportPlugin report to table[" + str + "] fail, no args, [eventName=" + parambekr.a + "][jsonParams=" + parambekr.b + "]");
  }
  
  public void reportKeyValue(bekr parambekr)
  {
    int i = 0;
    for (;;)
    {
      long l;
      try
      {
        JSONArray localJSONArray = new JSONObject(parambekr.b).getJSONArray("dataArray");
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getJSONObject(i);
          int j = ((JSONObject)localObject).getInt("key");
          if (15496 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            if ((localObject.length > 8) && (!localObject[0].equals("2")))
            {
              j = Integer.parseInt(localObject[7]);
              if (j > 0)
              {
                betc.d("ReportPlugin", parambekr.a + " REPORT_EVENT_Display: " + j);
                bezi.a(this.mMiniAppInfo, 638, null, null, null, 0, "0", j, null);
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
                betc.d("ReportPlugin", parambekr.a + " REPORT_EVENT_Speed: " + l);
                if (9 == j) {
                  bezi.a(this.mMiniAppInfo, 636, null, null, null, 0, "0", l, null);
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        betc.d("ReportPlugin", parambekr.a + " error.", localException);
      }
      return;
      bezi.a(this.mMiniAppInfo, 637, null, null, null, 0, "0", l, null);
      i += 1;
    }
  }
  
  public String reportRealtimeAction(bekr parambekr)
  {
    if (this.mIsMiniGame) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambekr.b);
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
      if (localJSONObject2 != null)
      {
        Object localObject = localJSONObject2.optString("eventID", "");
        if (belj.a((String)localObject))
        {
          localObject = new JSONObject((String)localObject);
          if ((localObject != null) && (((JSONObject)localObject).has("finishShow")))
          {
            bezl.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
            if (((JSONObject)localObject).length() == 1)
            {
              parambekr.a();
              return "";
            }
          }
        }
        else if (((String)localObject).equals("finishShow"))
        {
          bezl.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
          parambekr.a();
          return "";
        }
        localJSONObject2.put("version", this.mMiniAppContext.a());
        localJSONObject1.put("actionData", localJSONObject2);
      }
      if (localMiniAppInfo != null)
      {
        beyx.a(localMiniAppInfo.appId, localJSONObject1.toString());
        parambekr.a();
      }
    }
    catch (Throwable parambekr)
    {
      for (;;)
      {
        betc.d("ReportPlugin", "", parambekr);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */