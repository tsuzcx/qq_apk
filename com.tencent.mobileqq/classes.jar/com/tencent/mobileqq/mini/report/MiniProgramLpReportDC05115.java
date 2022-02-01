package com.tencent.mobileqq.mini.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MiniProgramLpReportDC05115
{
  private static final HashMap<String, MiniProgramLpReportDC05115.ReportModel> MINI_APP_ID_REPORT_MODEL_HASH_MAP = new HashMap();
  private static final String TAG = "MiniProgramLpReportDC05";
  
  private static void doReport(MiniProgramLpReportDC05115.ReportModel paramReportModel)
  {
    if (paramReportModel != null) {}
    try
    {
      String str = paramReportModel.toReportRecord();
      QLog.d("MiniProgramLpReportDC05", 2, new Object[] { "doReport ", str });
      QLog.d("MiniProgramLpReportDC05", 2, new Object[] { "doReport ", paramReportModel.toString() });
      Bundle localBundle = new Bundle();
      localBundle.putStringArray("data", new String[] { str });
      localBundle.putString("log_key", "dc05115");
      AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", localBundle, null);
      paramReportModel.reset();
      return;
    }
    catch (Exception paramReportModel)
    {
      QLog.e("MiniProgramLpReportDC05", 2, "doReport ", paramReportModel);
    }
  }
  
  public static void reDispatchReportEvent(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MiniProgramLpReportDC05115.ReportModel localReportModel;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (paramString1 != null))
    {
      localReportModel = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (localReportModel == null) {
        break label185;
      }
      if (!"app_download_result".equals(paramString1)) {
        break label68;
      }
      localReportModel.reportPKGDownloadResult(paramLong, paramString2);
    }
    label68:
    do
    {
      return;
      if (("launch_result".equals(paramString1)) && ("cold_start".equals(paramString3)))
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
      if (("minigamestaytime".equals(paramString1)) || ("miniappstaytime".equals(paramString1)))
      {
        localReportModel.setGameUseTime(paramLong);
        return;
      }
      if ("steplaunchgame".equals(paramString1))
      {
        localReportModel.setGamePrepareCost(paramLong);
        return;
      }
    } while (!"jsonerror".equals(paramString1));
    localReportModel.setJsErrorNum();
    return;
    label185:
    MINI_APP_ID_REPORT_MODEL_HASH_MAP.put(paramMiniAppConfig.config.appId, new MiniProgramLpReportDC05115.ReportModel(paramMiniAppConfig));
  }
  
  public static void reportCPUMemoryFPS(MiniAppConfig paramMiniAppConfig, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null)
      {
        MiniProgramLpReportDC05115.ReportModel.access$100(paramMiniAppConfig, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        doReport(paramMiniAppConfig);
      }
    }
  }
  
  public static void reportCrash(MiniAppConfig paramMiniAppConfig, Throwable paramThrowable)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null)
      {
        MiniProgramLpReportDC05115.ReportModel.access$202(paramMiniAppConfig, 1L);
        if (!(paramThrowable instanceof OutOfMemoryError)) {
          break label72;
        }
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      MiniProgramLpReportDC05115.ReportModel.access$302(paramMiniAppConfig, i);
      doReport(paramMiniAppConfig);
      return;
    }
  }
  
  public static void reportDownloadResult(MiniAppConfig paramMiniAppConfig, DownloadResult paramDownloadResult, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramDownloadResult != null)
        {
          l1 = l2;
          if (paramDownloadResult.getContent() != null) {
            l1 = paramDownloadResult.getContent().length;
          }
        }
        paramMiniAppConfig.reportDownloadRequestResult(paramLong, l1, paramBoolean);
      }
    }
  }
  
  public static void reportDownloadResultForSDK(MiniAppConfig paramMiniAppConfig, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null) {
        paramMiniAppConfig.reportDownloadRequestResult(paramLong2, paramLong1, paramBoolean);
      }
    }
  }
  
  public static void reportHttpRequestResult(MiniAppConfig paramMiniAppConfig, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null) {
        paramMiniAppConfig.reportHttpRequestResult(paramLong2, paramLong1, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115
 * JD-Core Version:    0.7.0.1
 */