package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdgq;
import bdnw;
import bdsj;
import bdsk;
import bdsl;
import bdsu;
import bdsx;
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
  
  public void apiReport(bdfz parambdfz)
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
      bdsl.a(str1, parambdfz.b, str2, str3);
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("ReportPlugin", parambdfz.a + " error.", localException);
    }
  }
  
  public void reportDataToDC(bdfz parambdfz)
  {
    String str;
    try
    {
      Object localObject1 = new JSONObject(parambdfz.b);
      str = ((JSONObject)localObject1).optString("tableName");
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("args");
      if (localObject2 != null)
      {
        if ("dc04239".equals(str))
        {
          if (localObject1 == null) {
            return;
          }
          str = ((JSONObject)localObject1).optString("actiontype");
          localObject2 = ((JSONObject)localObject1).optString("sub_actiontype");
          localObject1 = ((JSONObject)localObject1).optString("reserves_action");
          bdsx.a(this.mMiniAppInfo, "1", null, str, (String)localObject2, (String)localObject1, "");
          return;
        }
        if (!"dc04682".equals(str)) {
          return;
        }
        bdsk.a(this.mMiniAppInfo, (JSONObject)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      bdnw.d("ReportPlugin", "ReportPlugin handleNativeRequest exception, [eventName=" + parambdfz.a + "][jsonParams=" + parambdfz.b + "]");
      return;
    }
    bdnw.d("ReportPlugin", "ReportPlugin report to table[" + str + "] fail, no args, [eventName=" + parambdfz.a + "][jsonParams=" + parambdfz.b + "]");
  }
  
  public void reportKeyValue(bdfz parambdfz)
  {
    int i = 0;
    for (;;)
    {
      long l;
      try
      {
        JSONArray localJSONArray = new JSONObject(parambdfz.b).getJSONArray("dataArray");
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
                bdnw.d("ReportPlugin", parambdfz.a + " REPORT_EVENT_Display: " + j);
                bdsu.a(this.mMiniAppInfo, 638, null, null, null, 0, "0", j, null);
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
                bdnw.d("ReportPlugin", parambdfz.a + " REPORT_EVENT_Speed: " + l);
                if (9 == j) {
                  bdsu.a(this.mMiniAppInfo, 636, null, null, null, 0, "0", l, null);
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        bdnw.d("ReportPlugin", parambdfz.a + " error.", localException);
      }
      return;
      bdsu.a(this.mMiniAppInfo, 637, null, null, null, 0, "0", l, null);
      i += 1;
    }
  }
  
  public String reportRealtimeAction(bdfz parambdfz)
  {
    if (this.mIsMiniGame) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambdfz.b);
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      JSONObject localJSONObject2 = new JSONObject(localJSONObject1.optString("actionData", ""));
      if (localJSONObject2 != null)
      {
        Object localObject = localJSONObject2.optString("eventID", "");
        if (bdgq.a((String)localObject))
        {
          localObject = new JSONObject((String)localObject);
          if ((localObject != null) && (((JSONObject)localObject).has("finishShow")))
          {
            bdsx.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
            if (((JSONObject)localObject).length() == 1)
            {
              parambdfz.a();
              return "";
            }
          }
        }
        else if (((String)localObject).equals("finishShow"))
        {
          bdsx.a(localMiniAppInfo, getAppType(localMiniAppInfo), null, "page_view", "finishShow", "", "");
          parambdfz.a();
          return "";
        }
        localJSONObject1.put("actionData", localJSONObject2);
      }
      if (localMiniAppInfo != null)
      {
        bdsj.a(localMiniAppInfo.appId, localJSONObject1.toString());
        parambdfz.a();
      }
    }
    catch (Throwable parambdfz)
    {
      for (;;)
      {
        bdnw.d("ReportPlugin", "", parambdfz);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */