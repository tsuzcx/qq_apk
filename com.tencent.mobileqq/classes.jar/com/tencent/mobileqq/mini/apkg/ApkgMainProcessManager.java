package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApkgMainProcessManager
{
  private static final String CMD_MAIN_PROCESS_DOWNLOAD_PKG = "cmd_main_process_download_pkg";
  private static final String CMD_MAIN_PROCESS_LOAD_PKG = "cmd_main_process_load_pkg";
  private static final String CMD_QUEUE_MINI_PROCESS_LOAD_APKG = "cmd_queue_mini_process_load_apkg";
  private static final String CMD_REMOVE_MINI_PROCESS_LOAD_APKG = "cmd_remove_mini_process_load_apkg";
  public static final String EXTRA_PROGRESS = "PROGRESS";
  public static final String EXTRA_TOTAL_SIZE = "TOTAL_SIZE";
  public static final String KEY_MINI_APP_CONFIG = "key_mini_app_config";
  private static final String KEY_NEED_DOWNLOAD_IN_MAINPROCESS = "key_force_download_in_mainprocess";
  private static final String KEY_RUN_IN_MAINPROCSS = "key_run_in_mainprocess";
  private static final String TAG = "ApkgMainProcessManager";
  private static final ApkgMainProcessManager ourInstance = new ApkgMainProcessManager();
  private ConcurrentHashMap<String, List<CmdCallback>> cmdCallbackHashMap = new ConcurrentHashMap();
  private Set<String> subProcessLoadTaskSet = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public static void checkShouldDownloadInMainProcess(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (AppBrandProxy.isMainProcess())
    {
      AppBrandLaunchManager.g().sendCmd("cmd_main_process_download_pkg", paramBundle, new ApkgMainProcessManager.3(paramCmdCallback));
      return;
    }
    AppBrandProxy.g().sendCmd("cmd_main_process_download_pkg", paramBundle, new ApkgMainProcessManager.4(paramCmdCallback));
  }
  
  public static void checkShouldLoadPkgInMainProcess(MiniAppConfig paramMiniAppConfig, CmdCallback paramCmdCallback, boolean paramBoolean)
  {
    if (!paramMiniAppConfig.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      checkShouldLoadPkgInMainProcess(paramMiniAppConfig, paramCmdCallback, paramBoolean, bool);
      return;
    }
  }
  
  private static void checkShouldLoadPkgInMainProcess(MiniAppConfig paramMiniAppConfig, CmdCallback paramCmdCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppConfig);
    localBundle.putBoolean("key_run_in_mainprocess", paramBoolean1);
    if (AppBrandProxy.isMainProcess())
    {
      AppBrandLaunchManager.g().sendCmd("cmd_main_process_load_pkg", localBundle, new ApkgMainProcessManager.1(paramCmdCallback));
      return;
    }
    AppBrandProxy.g().sendCmd("cmd_main_process_load_pkg", localBundle, new ApkgMainProcessManager.2(paramCmdCallback, paramBoolean2));
  }
  
  private void checkShouldPerformMainProcessLoadPkg(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)paramBundle.getParcelable("key_mini_app_config");
    boolean bool = paramBundle.getBoolean("key_run_in_mainprocess", false);
    if ((localMiniAppConfig == null) || (localMiniAppConfig.config == null)) {
      return;
    }
    if (this.cmdCallbackHashMap.get(localMiniAppConfig.config.appId) != null)
    {
      ((List)this.cmdCallbackHashMap.get(localMiniAppConfig.config.appId)).add(paramCmdCallback);
      return;
    }
    if (!bool) {
      try
      {
        paramCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if (this.subProcessLoadTaskSet.contains(localMiniAppConfig.config.appId))
    {
      QLog.w("ApkgMainProcessManager", 2, "pkg already download in sub process! " + localMiniAppConfig);
      return;
    }
    this.cmdCallbackHashMap.put(localMiniAppConfig.config.appId, new CopyOnWriteArrayList(Collections.singletonList(paramCmdCallback)));
    QLog.d("ApkgMainProcessManager", 2, "load apkg in main process start " + localMiniAppConfig);
    if (localMiniAppConfig.isEngineTypeMiniGame())
    {
      loadGpkg(localMiniAppConfig);
      return;
    }
    loadApkg(localMiniAppConfig);
  }
  
  static ApkgMainProcessManager getInstance()
  {
    return ourInstance;
  }
  
  public static void handleMiniAppCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    try
    {
      paramBundle.setClassLoader(ApkgMainProcessManager.class.getClassLoader());
      localMiniAppConfig = (MiniAppConfig)paramBundle.getParcelable("key_mini_app_config");
      if (localMiniAppConfig != null)
      {
        if (localMiniAppConfig.config == null) {
          return;
        }
        if ("cmd_queue_mini_process_load_apkg".equals(paramString))
        {
          getInstance().queueSubProcessLoadTask(localMiniAppConfig.config.appId);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      MiniAppConfig localMiniAppConfig;
      QLog.d("ApkgMainProcessManager", 2, "handleMiniAppCmd ", paramString);
      if (paramCmdCallback != null)
      {
        try
        {
          paramCmdCallback.onCmdResult(true, new Bundle());
          return;
        }
        catch (RemoteException paramString)
        {
          QLog.d("ApkgMainProcessManager", 2, "handleMiniAppCmd ", paramString);
          return;
        }
        if ("cmd_remove_mini_process_load_apkg".equals(paramString))
        {
          getInstance().removeSubProcessLoadTask(localMiniAppConfig.config.appId);
          return;
        }
        if ("cmd_main_process_load_pkg".equals(paramString))
        {
          getInstance().checkShouldPerformMainProcessLoadPkg(paramBundle, paramCmdCallback);
          return;
        }
        if ("cmd_main_process_download_pkg".equals(paramString)) {
          GpkgManager.handleDownloadPkgInMainProcess(paramBundle, paramCmdCallback);
        }
      }
    }
  }
  
  private void loadApkg(MiniAppConfig paramMiniAppConfig)
  {
    ApkgManager.getInstance().getApkgInfoByConfig(paramMiniAppConfig, new ApkgMainProcessManager.7(this, paramMiniAppConfig));
    try
    {
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_enable_pkg_preload", 1) == 1) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.renderInfo != null) && (paramMiniAppConfig.config.renderInfo.renderMode == 1) && (paramMiniAppConfig.config.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null))
        {
          String str = (String)paramMiniAppConfig.config.renderInfo.renderMaterialMap.get(Integer.valueOf(1));
          if (!TextUtils.isEmpty(str)) {
            ApkgManager.getInstance().preloadFlutterPkg(paramMiniAppConfig, str);
          }
        }
        return;
      }
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      QLog.e("ApkgMainProcessManager", 1, "onInitApkgInfo exception!", paramMiniAppConfig);
    }
  }
  
  private void loadGpkg(MiniAppConfig paramMiniAppConfig)
  {
    GpkgManager.performGetGpkgInfoByConfig(paramMiniAppConfig, new ApkgMainProcessManager.8(this, paramMiniAppConfig), false);
  }
  
  private void loadSubGpkg(MiniAppConfig paramMiniAppConfig)
  {
    GpkgManager.performGetGpkgInfoByConfig(paramMiniAppConfig, new ApkgMainProcessManager.9(this, paramMiniAppConfig), false);
  }
  
  public static void queueSubProcessLoadTask(MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppConfig);
    AppBrandProxy.g().sendCmd("cmd_queue_mini_process_load_apkg", localBundle, new ApkgMainProcessManager.5(paramMiniAppConfig));
  }
  
  private void queueSubProcessLoadTask(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.subProcessLoadTaskSet.add(paramString);
    }
  }
  
  public static void removeSubProcessLoadTask(MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppConfig);
    AppBrandProxy.g().sendCmd("cmd_remove_mini_process_load_apkg", localBundle, new ApkgMainProcessManager.6(paramMiniAppConfig));
  }
  
  private void removeSubProcessLoadTask(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.subProcessLoadTaskSet.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager
 * JD-Core Version:    0.7.0.1
 */