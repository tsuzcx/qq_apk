package com.tencent.mobileqq.minigame.report;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameLebaReporter;", "", "()V", "ACTION_TYPE_LEBA", "", "REFER_LEBA", "", "RESERVES_2_LEBA_RED_POINT", "RESERVES_ACTION_CLICK", "RESERVES_ACTION_EXPO", "SUB_ACTION_LEBA", "TAG", "VIA_LEBA", "createMiniAppConfigForLeba", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "targetAppId", "getReserves", "isClickReport", "", "reportFromLeba", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGameLebaReporter
{
  private static final String ACTION_TYPE_LEBA = "active_page";
  public static final MiniGameLebaReporter INSTANCE = new MiniGameLebaReporter();
  private static final int REFER_LEBA = 2050;
  private static final String RESERVES_2_LEBA_RED_POINT = "red_point";
  private static final String RESERVES_ACTION_CLICK = "click";
  private static final String RESERVES_ACTION_EXPO = "expo";
  private static final String SUB_ACTION_LEBA = "app_center";
  private static final String TAG = "MiniGameLebaReporter";
  private static final String VIA_LEBA = "2050";
  
  private final MiniAppConfig createMiniAppConfigForLeba(String paramString)
  {
    Object localObject = new MiniAppInfo();
    if (paramString == null) {
      paramString = "null";
    }
    ((MiniAppInfo)localObject).appId = paramString;
    ((MiniAppInfo)localObject).via = "2050";
    paramString = new MiniAppConfig((MiniAppInfo)localObject);
    localObject = new LaunchParam();
    ((LaunchParam)localObject).scene = 2050;
    paramString.launchParam = ((LaunchParam)localObject);
    return paramString;
  }
  
  private final String getReserves(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "click";
    }
    return "expo";
  }
  
  public final void reportFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (paramAppInfo == null)
    {
      MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba(null), "", "", "active_page", "app_center", getReserves(paramBoolean), null);
      return;
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo.buffer.get());
      localObject = paramAppInfo.optString("_show_mission");
      JSONObject localJSONObject = paramAppInfo.optJSONObject("msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localJSONObject != null))
      {
        localObject = localJSONObject.optJSONObject((String)localObject);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("content");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject).optString("appid");
            paramAppInfo = paramAppInfo.optString("ad_id");
            MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba((String)localObject), "", "", "active_page", "app_center", getReserves(paramBoolean), "red_point", paramAppInfo);
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramAppInfo = new StringBuilder();
          paramAppInfo.append("doReportForMiniGame warning, ");
          paramAppInfo.append((String)localObject);
          paramAppInfo.append(", ");
          paramAppInfo.append(localJSONObject);
          paramAppInfo.append(", ");
          paramAppInfo.append(paramBoolean);
          QLog.w("MiniGameLebaReporter", 2, paramAppInfo.toString());
        }
        MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba(null), "", "", "active_page", "app_center", getReserves(paramBoolean), null);
        return;
      }
    }
    catch (JSONException paramAppInfo)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReportForMiniGame, ex=");
        ((StringBuilder)localObject).append(paramAppInfo.getMessage());
        ((StringBuilder)localObject).append(",isClickReport=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.e("MiniGameLebaReporter", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.MiniGameLebaReporter
 * JD-Core Version:    0.7.0.1
 */