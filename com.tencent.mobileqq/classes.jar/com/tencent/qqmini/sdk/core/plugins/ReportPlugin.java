package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.text.TextUtils;
import bglv;
import bgok;
import bgpg;
import bgtu;
import bhbz;
import bhca;
import bhcb;
import bhck;
import bhcn;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
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
          QMLog.e("ReportPlugin", "doReportBy898 key:  " + paramString + "  data: " + localStringBuilder.toString());
          bgtu.a().a("cmd_dc_report_log_key_data", paramJSONArray, null);
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
  
  public void apiReport(bgok parambgok)
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
      bhcb.a(str1, parambgok.b, str2, str3);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("ReportPlugin", parambgok.a + " error.", localException);
    }
  }
  
  public void reportDC(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      parambgok = ((JSONObject)localObject).getString("table");
      localObject = ((JSONObject)localObject).getJSONArray("reportArray");
      if ((!TextUtils.isEmpty(parambgok)) && (((JSONArray)localObject).length() > 0)) {
        doReportBy898(parambgok, (JSONArray)localObject);
      }
      return;
    }
    catch (Exception parambgok)
    {
      QMLog.e("ReportPlugin", " handleReportDC error.", parambgok);
    }
  }
  
  public void reportDataToDC(bgok parambgok)
  {
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambgok.b);
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
          bhcn.a(this.mMiniAppInfo, "1", null, (String)localObject2, str, (String)localObject1, "");
          return;
        }
        if (!"dc04682".equals(str)) {
          return;
        }
        bhca.a(this.mMiniAppInfo, (JSONObject)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("ReportPlugin", "ReportPlugin handleNativeRequest exception, [eventName=" + parambgok.a + "][jsonParams=" + parambgok.b + "]");
      return;
    }
    QMLog.e("ReportPlugin", "ReportPlugin report to table[" + str + "] fail, no args, [eventName=" + parambgok.a + "][jsonParams=" + parambgok.b + "]");
  }
  
  public void reportKeyValue(bgok parambgok)
  {
    int i = 0;
    for (;;)
    {
      long l;
      try
      {
        JSONArray localJSONArray = new JSONObject(parambgok.b).getJSONArray("dataArray");
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
                QMLog.e("ReportPlugin", parambgok.a + " REPORT_EVENT_Display: " + j);
                bhck.a(this.mMiniAppInfo, 638, null, null, null, 0, "0", j, null);
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
                QMLog.e("ReportPlugin", parambgok.a + " REPORT_EVENT_Speed: " + l);
                if (9 == j) {
                  bhck.a(this.mMiniAppInfo, 636, null, null, null, 0, "0", l, null);
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.e("ReportPlugin", parambgok.a + " error.", localException);
      }
      return;
      bhck.a(this.mMiniAppInfo, 637, null, null, null, 0, "0", l, null);
      i += 1;
    }
  }
  
  public String reportRealtimeAction(bgok parambgok)
  {
    if (this.mIsMiniGame) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambgok.b);
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
      if (localJSONObject2 != null)
      {
        Object localObject = localJSONObject2.optString("eventID", "");
        if (bgpg.a((String)localObject))
        {
          localObject = new JSONObject((String)localObject);
          if ((localObject != null) && (((JSONObject)localObject).has("finishShow")))
          {
            bhcn.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
            if (((JSONObject)localObject).length() == 1)
            {
              parambgok.a();
              return "";
            }
          }
        }
        else if (((String)localObject).equals("finishShow"))
        {
          bhcn.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
          parambgok.a();
          return "";
        }
        localJSONObject2.put("version", this.mMiniAppContext.a());
        localJSONObject1.put("actionData", localJSONObject2);
      }
      if (localMiniAppInfo != null)
      {
        bhbz.a(localMiniAppInfo.appId, localJSONObject1.toString());
        parambgok.a();
      }
    }
    catch (Throwable parambgok)
    {
      for (;;)
      {
        QMLog.e("ReportPlugin", "", parambgok);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */