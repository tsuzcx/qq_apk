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
    if (paramReportModel != null) {
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
  }
  
  public static void reDispatchReportEvent(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (paramString1 != null))
    {
      MiniProgramLpReportDC05115.ReportModel localReportModel = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (localReportModel != null)
      {
        if ("app_download_result".equals(paramString1))
        {
          localReportModel.reportPKGDownloadResult(paramLong, paramString2);
          return;
        }
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
        if ((!"minigamestaytime".equals(paramString1)) && (!"miniappstaytime".equals(paramString1)))
        {
          if ("steplaunchgame".equals(paramString1))
          {
            localReportModel.setGamePrepareCost(paramLong);
            return;
          }
          if ("jsonerror".equals(paramString1)) {
            localReportModel.setJsErrorNum();
          }
        }
        else
        {
          localReportModel.setGameUseTime(paramLong);
        }
      }
      else
      {
        MINI_APP_ID_REPORT_MODEL_HASH_MAP.put(paramMiniAppConfig.config.appId, new MiniProgramLpReportDC05115.ReportModel(paramMiniAppConfig));
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
        MiniProgramLpReportDC05115.ReportModel.access$102(paramMiniAppConfig, 1L);
        int i;
        if ((paramThrowable instanceof OutOfMemoryError)) {
          i = 1;
        } else {
          i = 0;
        }
        MiniProgramLpReportDC05115.ReportModel.access$202(paramMiniAppConfig, i);
        doReport(paramMiniAppConfig);
      }
    }
  }
  
  public static void reportDownloadResult(MiniAppConfig paramMiniAppConfig, DownloadResult paramDownloadResult, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      paramMiniAppConfig = (MiniProgramLpReportDC05115.ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppConfig.config.appId);
      if (paramMiniAppConfig != null)
      {
        long l;
        if ((paramDownloadResult != null) && (paramDownloadResult.getContent() != null)) {
          l = paramDownloadResult.getContent().length;
        } else {
          l = 0L;
        }
        paramMiniAppConfig.reportDownloadRequestResult(paramLong, l, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115
 * JD-Core Version:    0.7.0.1
 */