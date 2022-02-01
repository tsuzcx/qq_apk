package com.tencent.qqmini.sdk.report;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class InnerAppReportDc4239
{
  public static final String ACTION_TYPE = "inner_app";
  public static final String RESERVES2_DOWNLOADAPP = "downloadapp";
  public static final String RESERVES2_DOWNLOAD_FINISH = "downloadappfinish";
  public static final String RESERVES2_DOWNLOAD_PAUSE = "downloadapppause";
  public static final String RESERVES2_INSTALL_APP = "installapp";
  public static final String RESERVES2_OPENAPP = "openapp";
  public static final String RESERVES3_QQ_DOWNLOAD = "qqdownload";
  public static final String RESERVES3_YYB_DOWNLOAD = "yybdownload";
  public static final String RESERVES_ACTION_LAUNCH_APP = "launchapp";
  public static final String SUB_ACTION_TYPE = "from_api";
  private static final String TAG = "InnerAppReportDc4239";
  
  public static void innerAppReport(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new InnerAppReportDc4239.1(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.InnerAppReportDc4239
 * JD-Core Version:    0.7.0.1
 */