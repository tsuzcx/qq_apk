package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;

public class MiniProgramLpReportDC05115
{
  private static final HashMap<String, MiniProgramLpReportDC05115.ReportModel> MINI_APP_ID_REPORT_MODEL_HASH_MAP = new HashMap();
  private static final String TAG = "MiniProgramLpReportDC05";
  
  private static void doReport(MiniProgramLpReportDC05115.ReportModel paramReportModel)
  {
    if (paramReportModel != null) {}
    for (;;)
    {
      try
      {
        str = paramReportModel.toReportRecord();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReport ");
        ((StringBuilder)localObject).append(str);
        QMLog.d("MiniProgramLpReportDC05", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReport ");
        ((StringBuilder)localObject).append(paramReportModel.toString());
        QMLog.d("MiniProgramLpReportDC05", ((StringBuilder)localObject).toString());
        localObject = new Bundle();
        ((Bundle)localObject).putStringArray("data", new String[] { str });
        if (!QUAUtil.isQQApp()) {
          break label138;
        }
        str = "dc05115";
        ((Bundle)localObject).putString("log_key", str);
        AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject, null);
        paramReportModel.reset();
        return;
      }
      catch (Exception paramReportModel)
      {
        QMLog.e("MiniProgramLpReportDC05", "doReport ", paramReportModel);
      }
      return;
      label138:
      String str = "dc05387";
    }
  }
  
  public static void reDispatchReportEvent(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, long paramLong)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (paramString1 != null))
    {
      MiniProgramLpReportDC05115.ReportModel localReportModel = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (localReportModel != null)
      {
        if ("app_download_result".equals(paramString1))
        {
          localReportModel.reportPKGDownloadResult(paramLong, paramString2);
          return;
        }
        if ("launch_result".equals(paramString1))
        {
          localReportModel.reportLaunchResult(paramLong, paramString2);
          return;
        }
        if ("game_first_launch_result".equals(paramString1))
        {
          MiniProgramLpReportDC05115.ReportModel.access$002(localReportModel, true);
          return;
        }
        if ("game_twice_launch_result".equals(paramString1))
        {
          localReportModel.reportReLaunchResult(paramLong, paramString2);
          return;
        }
        if (("minigamestaytime".equals(paramString1)) || ("miniappstaytime".equals(paramString1))) {
          localReportModel.setGameUseTime(paramLong);
        }
      }
      else
      {
        MINI_APP_ID_REPORT_MODEL_HASH_MAP.put(paramMiniAppInfo.appId, new MiniProgramLpReportDC05115.ReportModel(paramMiniAppInfo));
      }
    }
  }
  
  public static void reportCPUMemoryFPS(MiniAppInfo paramMiniAppInfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        MiniProgramLpReportDC05115.ReportModel.access$100(paramMiniAppInfo, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        doReport(paramMiniAppInfo);
      }
    }
  }
  
  public static void reportCrash(MiniAppInfo paramMiniAppInfo, Throwable paramThrowable)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        MiniProgramLpReportDC05115.ReportModel.access$202(paramMiniAppInfo, 1L);
        int i;
        if ((paramThrowable instanceof OutOfMemoryError)) {
          i = 1;
        } else {
          i = 0;
        }
        MiniProgramLpReportDC05115.ReportModel.access$302(paramMiniAppInfo, i);
        doReport(paramMiniAppInfo);
      }
    }
  }
  
  public static void reportDownloadResult(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportDownloadRequestResult(paramLong, paramInt, paramBoolean);
      }
    }
  }
  
  public static void reportDownloadResultForSDK(MiniAppInfo paramMiniAppInfo, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportDownloadRequestResult(paramLong2, paramLong1, paramBoolean);
      }
    }
  }
  
  public static void reportHttpRequestResult(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportHttpRequestResult(paramLong2, paramLong1, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115
 * JD-Core Version:    0.7.0.1
 */