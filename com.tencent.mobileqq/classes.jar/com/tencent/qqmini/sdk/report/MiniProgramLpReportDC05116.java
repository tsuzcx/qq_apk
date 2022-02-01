package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class MiniProgramLpReportDC05116
{
  private static final String TAG = "MiniProgramLpReportDC05";
  
  public static void reportOneHttpOrDownloadRequest(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramLong1 != 0L) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      String str4 = QUAUtil.getQUA();
      String str5 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      String str6 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      String str7 = QUAUtil.getLoginType();
      String str2;
      try
      {
        String str1 = new URL(paramString).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QMLog.e("MiniProgramLpReportDC05", "reportOneHttpOrDownloadRequest", localMalformedURLException);
        str2 = paramString;
      }
      String str3;
      if (paramString.indexOf('?') != -1) {
        str3 = paramString.substring(0, paramString.indexOf('?'));
      } else {
        str3 = paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString);
      localStringBuilder.append('|');
      localStringBuilder.append((String)localObject);
      localStringBuilder.append('|');
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong1);
      localStringBuilder.append('|');
      localStringBuilder.append(str2);
      localStringBuilder.append('|');
      localStringBuilder.append(str3);
      localStringBuilder.append('|');
      localStringBuilder.append(MiniProgramReportHelper.getNetworkType());
      localStringBuilder.append('|');
      localStringBuilder.append(paramMiniAppInfo.getReportType());
      localStringBuilder.append('|');
      localStringBuilder.append("android");
      localStringBuilder.append('|');
      localStringBuilder.append(System.currentTimeMillis());
      paramString = localStringBuilder.toString();
      paramMiniAppInfo = paramString;
      if (!QUAUtil.isQQApp())
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append(paramString);
        paramMiniAppInfo.append('|');
        paramMiniAppInfo.append(str4);
        paramMiniAppInfo.append('|');
        paramMiniAppInfo.append(str5);
        paramMiniAppInfo.append('|');
        paramMiniAppInfo.append(str6);
        paramMiniAppInfo.append('|');
        paramMiniAppInfo.append(str7);
        paramMiniAppInfo = paramMiniAppInfo.toString();
      }
      Object localObject = new Bundle();
      if (QUAUtil.isQQApp()) {
        paramString = "dc05116";
      } else {
        paramString = "dc05388";
      }
      ((Bundle)localObject).putString("log_key", paramString);
      ((Bundle)localObject).putStringArray("data", new String[] { paramMiniAppInfo });
      AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116
 * JD-Core Version:    0.7.0.1
 */