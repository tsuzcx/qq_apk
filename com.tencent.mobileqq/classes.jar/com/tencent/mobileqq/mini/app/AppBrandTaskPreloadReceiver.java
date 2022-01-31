package com.tencent.mobileqq.mini.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineInstanceManager;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager.PREPARE_FROM;
import com.tencent.mobileqq.minigame.manager.PreloadManager;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class AppBrandTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_BASELIB_UPDATED = "mini_baselib_updated";
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String ACTION_PRELOAD_INTERNAL_APP = "mini_preload_internal_app";
  public static final String ACTION_UPDATE_PERIODIC_CACHE = "mini_periodic_cache_update";
  public static final String INTENT_KEY_RETCODE = "key_retcode";
  public static final String LOG_TAG = "AppBrandReceiver";
  private static int killOtherGamesOnStartFlag = -1;
  
  private boolean needKillOtherGamesOnStart()
  {
    boolean bool = false;
    if (killOtherGamesOnStartFlag == -1) {
      killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);
    }
    if (killOtherGamesOnStartFlag == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    QLog.i("miniapp-start", 1, "AppBrandTaskPreloadReceiver onReceive action: " + str);
    if ("mini_process_kill".equals(str)) {
      if ((!needKillOtherGamesOnStart()) && (AppLoaderManager.sMiniAppInterface != null)) {
        AppLoaderManager.sMiniAppInterface.exitProcess();
      }
    }
    for (;;)
    {
      if (((this instanceof AppBrandTaskPreloadReceiver3)) || ((this instanceof AppBrandTaskPreloadReceiver4)) || ((this instanceof AppBrandTaskPreloadReceiver5))) {
        paramContext.getSharedPreferences("sdk_conf", 4).edit().putInt("usersdk", 0).apply();
      }
      return;
      if ("mini_baselib_updated".equals(str))
      {
        int i = paramIntent.getIntExtra("key_retcode", 0);
        AppLoaderFactory.getAppLoaderManager().onBaseLibUpdateResult(i);
        QLog.i("AppBrandReceiver", 1, "[MiniEng] mini_baselib_updated" + i + "," + BaseApplicationImpl.getApplication().getQQProcessName());
      }
      else if ("mini_preload_app".equals(str))
      {
        try
        {
          QLog.i("miniapp-start", 1, "预加载小程序");
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 605, null, null, null, 0);
          AppLoaderFactory.getAppLoaderManager().start(paramContext);
        }
        catch (Throwable paramIntent)
        {
          QLog.e("miniapp-start", 1, "mini_preload_app failed:", paramIntent);
        }
      }
      else if ("mini_preload_internal_app".equals(str))
      {
        try
        {
          paramIntent = (MiniAppConfig)paramIntent.getParcelableExtra("CONFIG");
          if (paramIntent == null) {
            continue;
          }
          AppLoaderFactory.getAppLoaderManager().start(paramContext);
          AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(paramIntent);
        }
        catch (Throwable paramIntent)
        {
          QLog.e("miniapp-start", 1, "", paramIntent);
        }
      }
      else if ("mini_preload_game".equals(str))
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 605, "1");
        QLog.i("AppBrandReceiver", 1, "[MiniEng]mini_preload_game " + BaseApplicationImpl.getApplication().getQQProcessName());
        if ((GameWnsUtils.gameEnable()) && (GameWnsUtils.enablePreloadGameBaseLib()))
        {
          MiniappDownloadUtil.preLoadDownloader();
          paramIntent = (EngineChannel)paramIntent.getParcelableExtra("engineChannel");
          EngineInstanceManager.g().setEngineChannelIfNeed(paramIntent);
          GameRuntimeLoaderManager.g().prepare(BaseApplicationImpl.getApplication(), GameRuntimeLoaderManager.PREPARE_FROM.MAIN_PROCESS);
        }
        GamePreConnectManager.preConnectDownloader();
        AppBrandProxy.g().setPreloadType("preload_game");
      }
      else if ("mini_preload__splash_game".equals(str))
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 605, "1");
        QLog.i("AppBrandReceiver", 1, "[MiniEng]mini_preload__splash_game " + BaseApplicationImpl.getApplication().getQQProcessName());
        AppBrandProxy.g().setPreloadType("preload_game");
        try
        {
          paramIntent = (SplashMiniGameData)paramIntent.getParcelableExtra("splashData");
          if (paramIntent == null) {
            continue;
          }
          PreloadManager.g().start(paramIntent);
        }
        catch (Throwable paramIntent)
        {
          for (;;)
          {
            paramIntent = null;
          }
        }
      }
      else if ("mini_periodic_cache_update".equals(str))
      {
        try
        {
          paramIntent = (MiniAppConfig)paramIntent.getParcelableExtra("CONFIG");
          if (paramIntent != null) {
            PreCacheManager.g().notifyPeriodicCacheUpdated(paramIntent);
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("miniapp-start", 1, "", paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */