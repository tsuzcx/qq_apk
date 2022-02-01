package com.tencent.qqmini.miniapp.util;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.MiniReportManager.MiniAppLaunchState;
import java.util.Map;
import org.json.JSONObject;

public class AdReportInfoUtil
{
  public static final String TAG = "AdReportInfoUtil";
  
  public static JSONObject getAdReportInfo(ApkgInfo paramApkgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramApkgInfo != null) && (paramApkgInfo.mMiniAppInfo != null)) {
      try
      {
        localJSONObject.put("fromAppid", paramApkgInfo.mMiniAppInfo.launchParam.fromMiniAppId);
        if (paramApkgInfo.mMiniAppInfo.launchParam.entryModel != null)
        {
          if (paramApkgInfo.mMiniAppInfo.launchParam.entryModel.type == 0) {
            localJSONObject.put("fromQQ", paramApkgInfo.mMiniAppInfo.launchParam.entryModel.uin);
          }
          if (paramApkgInfo.mMiniAppInfo.launchParam.entryModel.type == 1) {
            localJSONObject.put("fromGroupId", paramApkgInfo.mMiniAppInfo.launchParam.entryModel.uin);
          }
        }
        long l2 = System.currentTimeMillis();
        paramApkgInfo = MiniReportManager.getLaunchState(paramApkgInfo.appId);
        long l1 = l2;
        if (paramApkgInfo != null)
        {
          l1 = l2;
          if (paramApkgInfo.eventTime != null)
          {
            l1 = l2;
            if (paramApkgInfo.eventTime.size() > 0)
            {
              l1 = l2;
              if (paramApkgInfo.eventTime.containsKey(Integer.valueOf(1))) {
                l1 = ((Long)paramApkgInfo.eventTime.get(Integer.valueOf(1))).longValue();
              }
            }
          }
        }
        localJSONObject.put("appStartTime", l1);
      }
      catch (Throwable paramApkgInfo)
      {
        QMLog.e("AdReportInfoUtil", "adReportInfo error,", paramApkgInfo);
      }
    }
    paramApkgInfo = new StringBuilder();
    paramApkgInfo.append("getAdReportInfo : ");
    paramApkgInfo.append(localJSONObject.toString());
    QMLog.d("AdReportInfoUtil", paramApkgInfo.toString());
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.AdReportInfoUtil
 * JD-Core Version:    0.7.0.1
 */