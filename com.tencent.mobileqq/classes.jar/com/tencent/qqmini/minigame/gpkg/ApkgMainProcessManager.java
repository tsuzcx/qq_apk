package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.manager.EnginePackageManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApkgMainProcessManager
{
  public static final String EXTRA_PROGRESS = "PROGRESS";
  public static final String EXTRA_TOTAL_SIZE = "TOTAL_SIZE";
  public static final String KEY_MINI_APP_CONFIG = "key_mini_app_config";
  private static final String KEY_NEED_DOWNLOAD_IN_MAINPROCESS = "key_force_download_in_mainprocess";
  private static final String KEY_RUN_IN_MAINPROCSS = "key_run_in_mainprocess";
  private static final String TAG = "ApkgMainProcessManager";
  private static final ApkgMainProcessManager ourInstance = new ApkgMainProcessManager();
  private ConcurrentHashMap<String, List<MiniCmdCallback>> cmdCallbackHashMap = new ConcurrentHashMap();
  private Set<String> subProcessLoadTaskSet = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public static void checkShouldDownloadInMainProcess(Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    AppBrandCmdProxy.g().sendCmd("cmd_main_process_download_pkg", paramBundle, new ApkgMainProcessManager.2(paramMiniCmdCallback));
  }
  
  public static void checkShouldLoadPkgInMainProcess(MiniAppInfo paramMiniAppInfo, MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean)
  {
    if (!paramMiniAppInfo.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      checkShouldLoadPkgInMainProcess(paramMiniAppInfo, paramMiniCmdCallback, paramBoolean, bool);
      return;
    }
  }
  
  private static void checkShouldLoadPkgInMainProcess(MiniAppInfo paramMiniAppInfo, MiniCmdCallback paramMiniCmdCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    localBundle.putBoolean("key_run_in_mainprocess", paramBoolean1);
    AppBrandCmdProxy.g().sendCmd("cmd_main_process_load_pkg", localBundle, new ApkgMainProcessManager.1(paramMiniCmdCallback, paramBoolean2));
  }
  
  private void checkShouldPerformMainProcessLoadPkg(Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("key_mini_app_config");
    boolean bool = paramBundle.getBoolean("key_run_in_mainprocess", false);
    if (localMiniAppInfo == null) {
      return;
    }
    if (this.cmdCallbackHashMap.get(localMiniAppInfo.appId) != null)
    {
      ((List)this.cmdCallbackHashMap.get(localMiniAppInfo.appId)).add(paramMiniCmdCallback);
      return;
    }
    if (!bool) {
      try
      {
        paramMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if (this.subProcessLoadTaskSet.contains(localMiniAppInfo.appId))
    {
      QMLog.w("ApkgMainProcessManager", "pkg already download in sub process! " + localMiniAppInfo);
      return;
    }
    this.cmdCallbackHashMap.put(localMiniAppInfo.appId, new CopyOnWriteArrayList(Collections.singletonList(paramMiniCmdCallback)));
    QMLog.d("ApkgMainProcessManager", "load apkg in main process start " + localMiniAppInfo);
    if (localMiniAppInfo.isEngineTypeMiniGame())
    {
      loadGpkg(localMiniAppInfo);
      return;
    }
    loadApkg(localMiniAppInfo);
  }
  
  static ApkgMainProcessManager getInstance()
  {
    return ourInstance;
  }
  
  public static void handleMiniAppCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    try
    {
      paramBundle.setClassLoader(ApkgMainProcessManager.class.getClassLoader());
      localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("key_mini_app_config");
      if (localMiniAppInfo == null) {
        return;
      }
      if ("cmd_queue_mini_process_load_apkg".equals(paramString))
      {
        getInstance().queueSubProcessLoadTask(localMiniAppInfo.appId);
        return;
      }
    }
    catch (Throwable paramString)
    {
      MiniAppInfo localMiniAppInfo;
      QMLog.d("ApkgMainProcessManager", "handleMiniAppCmd ", paramString);
      if (paramMiniCmdCallback != null)
      {
        try
        {
          paramMiniCmdCallback.onCmdResult(true, new Bundle());
          return;
        }
        catch (RemoteException paramString)
        {
          QMLog.d("ApkgMainProcessManager", "handleMiniAppCmd ", paramString);
          return;
        }
        if ("cmd_remove_mini_process_load_apkg".equals(paramString))
        {
          getInstance().removeSubProcessLoadTask(localMiniAppInfo.appId);
          return;
        }
        if ("cmd_main_process_load_pkg".equals(paramString))
        {
          getInstance().checkShouldPerformMainProcessLoadPkg(paramBundle, paramMiniCmdCallback);
          return;
        }
        if ((!"cmd_main_process_download_pkg".equals(paramString)) && ("cmd_update_triton_engine".equals(paramString))) {
          EnginePackageManager.checkTritonUpdate();
        }
      }
    }
  }
  
  private void loadApkg(MiniAppInfo paramMiniAppInfo)
  {
    ApkgManager.getInstance().getApkgInfoByConfig(paramMiniAppInfo, new ApkgMainProcessManager.5(this, paramMiniAppInfo));
  }
  
  private void loadGpkg(MiniAppInfo paramMiniAppInfo)
  {
    GpkgManager.performGetGpkgInfoByConfig(paramMiniAppInfo, new ApkgMainProcessManager.6(this, paramMiniAppInfo));
  }
  
  private void loadSubGpkg(MiniAppInfo paramMiniAppInfo)
  {
    GpkgManager.performGetGpkgInfoByConfig(paramMiniAppInfo, new ApkgMainProcessManager.7(this, paramMiniAppInfo));
  }
  
  public static void queueSubProcessLoadTask(MiniAppInfo paramMiniAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    AppBrandCmdProxy.g().sendCmd("cmd_queue_mini_process_load_apkg", localBundle, new ApkgMainProcessManager.3(paramMiniAppInfo));
  }
  
  private void queueSubProcessLoadTask(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.subProcessLoadTaskSet.add(paramString);
    }
  }
  
  public static void removeSubProcessLoadTask(MiniAppInfo paramMiniAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    AppBrandCmdProxy.g().sendCmd("cmd_remove_mini_process_load_apkg", localBundle, new ApkgMainProcessManager.4(paramMiniAppInfo));
  }
  
  private void removeSubProcessLoadTask(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.subProcessLoadTaskSet.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager
 * JD-Core Version:    0.7.0.1
 */