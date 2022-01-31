package com.tencent.qqmini.sdk.minigame.plugins;

import android.os.Environment;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.io.File;

public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String CHANNEL = "10036618";
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  public static final String FOLDER = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/app_download/";
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */