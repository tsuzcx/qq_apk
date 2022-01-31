package com.tencent.mobileqq.mini.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class MiniProgramLpReportDC05116
{
  private static final String TAG = "MiniProgramLpReportDC05";
  
  public static void reportOneHttpOrDownloadRequest(MiniAppConfig paramMiniAppConfig, String paramString, long paramLong1, long paramLong2, int paramInt, DownloadResult paramDownloadResult)
  {
    String str1;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.appId != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramDownloadResult == null) {
        break label283;
      }
      str1 = "1";
    }
    for (;;)
    {
      long l = paramLong1;
      if (paramDownloadResult != null)
      {
        l = paramLong1;
        if (paramDownloadResult.getContent() != null) {
          l = paramDownloadResult.getContent().length;
        }
      }
      try
      {
        paramDownloadResult = new URL(paramString).getHost();
        if (paramString.indexOf('?') != -1)
        {
          str2 = paramString.substring(0, paramString.indexOf('?'));
          paramMiniAppConfig = paramMiniAppConfig.config.appId + '|' + paramString + '|' + str1 + '|' + String.valueOf(paramInt) + '|' + paramLong2 + '|' + l + '|' + paramDownloadResult + '|' + str2 + '|' + MiniProgramReportHelper.getNetworkType() + '|' + paramMiniAppConfig.config.getReportType() + '|' + "Android" + '|' + NetConnInfoCenter.getServerTimeMillis();
          paramString = new Bundle();
          paramString.putString("log_key", "dc05116");
          paramString.putStringArray("data", new String[] { paramMiniAppConfig });
          AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", paramString, null);
          return;
          label283:
          str1 = "0";
        }
      }
      catch (MalformedURLException paramDownloadResult)
      {
        for (;;)
        {
          QLog.e("MiniProgramLpReportDC05", 2, "reportOneHttpOrDownloadRequest", paramDownloadResult);
          paramDownloadResult = paramString;
          continue;
          String str2 = paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05116
 * JD-Core Version:    0.7.0.1
 */