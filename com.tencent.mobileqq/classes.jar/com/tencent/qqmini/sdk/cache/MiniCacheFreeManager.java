package com.tencent.qqmini.sdk.cache;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager.RootPath;
import java.io.File;

@MiniKeep
public class MiniCacheFreeManager
  implements IMiniCacheFreeManager
{
  private static final String TAG = "MiniCacheFreeManager";
  
  private static void clearAllFileCaches()
  {
    MiniAppFileManager.getInstance().clearAllCache();
  }
  
  private static void clearAllPkgs()
  {
    FileUtils.delete(ApkgManager.RootPath.getGamePkgRoot(), false);
    FileUtils.delete(ApkgManager.RootPath.getAppPkgRoot(), false);
    FileUtils.delete(ApkgManager.RootPath.getTissuePkgRoot(), false);
  }
  
  private static void clearAllStorageCache()
  {
    try
    {
      FileUtils.delete(AppLoaderFactory.g().getContext().getCacheDir() + "/mini", false);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniCacheFreeManager", "clearAllStorageCache failed", localException);
    }
  }
  
  private static void clearAuthSp(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!AppLoaderFactory.g().getContext().getSharedPreferences(paramMiniAppInfo.appId + "_" + paramString, 4).edit().clear().commit()) {
      return;
    }
    QMLog.i("MiniCacheFreeManager", "clearAuthSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearDebugSp()
  {
    StorageUtil.getPreference().edit().clear().commit();
  }
  
  private static void clearDebugSp(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!StorageUtil.getPreference().edit().putBoolean(paramMiniAppInfo.appId + "_debug", false).commit()) {
      return;
    }
    QMLog.i("MiniCacheFreeManager", "clearDebugSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearFileCache(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {}
    MiniAppFileManager localMiniAppFileManager;
    do
    {
      return;
      localMiniAppFileManager = MiniAppFileManager.getMiniAppFileManager(paramMiniAppInfo.apkgInfo);
    } while (localMiniAppFileManager == null);
    localMiniAppFileManager.clearFileCache(paramMiniAppInfo.appId);
    QMLog.i("MiniCacheFreeManager", "clearFileCache finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearPkg(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    clearPkg(paramMiniAppInfo.appId, paramMiniAppInfo.isEngineTypeMiniGame());
  }
  
  private static void clearPkg(String paramString, boolean paramBoolean)
  {
    String str1 = ApkgManager.RootPath.getAppPkgRoot();
    if (paramBoolean) {
      str1 = ApkgManager.RootPath.getGamePkgRoot();
    }
    String str2 = MD5Utils.toMD5(paramString);
    Object localObject = new File(str1);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)))
        {
          QMLog.i("MiniCacheFreeManager", "clear Pkg finish. " + paramString + " dir:" + str1);
          FileUtils.delete(str1 + localCharSequence, false);
        }
        i += 1;
      }
    }
  }
  
  private static void clearStorageCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return;
      paramString = Storage.getCacheDir(AppLoaderFactory.g().getContext().getCacheDir().getAbsolutePath(), paramString, paramMiniAppInfo.appId);
    } while (!new File(paramString).exists());
    FileUtils.delete(paramString, false);
    QMLog.i("MiniCacheFreeManager", "clearStorageCache finish. " + paramMiniAppInfo.appId);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, Runnable paramRunnable)
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniCacheFreeManager.2(paramMiniAppInfo, paramString, paramBoolean, paramRunnable));
  }
  
  public static void freeCacheDialog(Activity paramActivity, String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2)
  {
    AppBrandTask.runTaskOnUiThread(new MiniCacheFreeManager.1(paramActivity, paramString2, paramString1, paramMiniAppInfo));
  }
  
  private static void killSelf(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(paramMiniAppInfo);
    QMLog.i("MiniCacheFreeManager", "kill process. " + paramMiniAppInfo.appId);
  }
  
  public void freeCache()
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniCacheFreeManager.3(this));
  }
  
  public void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    freeCache(paramString, paramMiniAppInfo, paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */