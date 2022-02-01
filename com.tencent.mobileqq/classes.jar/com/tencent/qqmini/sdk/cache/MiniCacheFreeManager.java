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
import com.tencent.qqmini.sdk.manager.ApkgManager;
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
  
  private static void clearAuthSp(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (AppLoaderFactory.g().getContext().getSharedPreferences(paramString2 + "_" + paramString1, 4).edit().clear().commit())) {
      QMLog.i("MiniCacheFreeManager", "clearAuthSp finish. " + paramString2);
    }
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
  
  private static void clearDebugSp(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (StorageUtil.getPreference().edit().putBoolean(paramString + "_debug", false).commit())) {
      QMLog.i("MiniCacheFreeManager", "clearDebugSp finish. " + paramString);
    }
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
  
  private static void clearFileCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MiniAppFileManager localMiniAppFileManager = MiniAppFileManager.getMiniAppFileManager(paramString);
      if (localMiniAppFileManager != null)
      {
        localMiniAppFileManager.clearFileCache(paramString);
        QMLog.i("MiniCacheFreeManager", "clearFileCache finish. " + paramString);
      }
    }
  }
  
  private static void clearPkg(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    String str;
    do
    {
      return;
      str = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    } while (!new File(str).exists());
    FileUtils.delete(str, false);
    QMLog.i("MiniCacheFreeManager", "clearPkg finish: " + paramMiniAppInfo.appId);
  }
  
  private static void clearPkg(String paramString)
  {
    String str1 = ApkgManager.RootPath.getGamePkgRoot();
    String str2 = MD5Utils.toMD5(paramString);
    Object localObject = new File(str1);
    int j;
    int i;
    CharSequence localCharSequence;
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list();
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)))
        {
          QMLog.i("MiniCacheFreeManager", "clearGamePkg finish. " + paramString);
          FileUtils.delete(str1 + localCharSequence, false);
        }
        i += 1;
      }
    }
    str1 = ApkgManager.RootPath.getAppPkgRoot();
    str2 = MD5Utils.toMD5(paramString);
    localObject = new File(str1);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list();
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)))
        {
          QMLog.i("MiniCacheFreeManager", "clearAppPkg finish. " + paramString);
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
  
  private static void clearStorageCache(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString1 = Storage.getCacheDir(AppLoaderFactory.g().getContext().getCacheDir().getAbsolutePath(), paramString1, paramString2);
      if (new File(paramString1).exists())
      {
        FileUtils.delete(paramString1, false);
        QMLog.i("MiniCacheFreeManager", "clearStorageCache finish. " + paramString2);
      }
    }
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    freeCache(paramString, paramMiniAppInfo, true);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    freeCache(paramString, paramMiniAppInfo, paramBoolean, null);
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
  
  private static void killSelf(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(paramString);
      QMLog.i("MiniCacheFreeManager", "kill process. " + paramString);
    }
  }
  
  public void freeCache()
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniCacheFreeManager.4(this));
  }
  
  public void freeCache(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniCacheFreeManager.3(this, paramString2, paramString1, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */