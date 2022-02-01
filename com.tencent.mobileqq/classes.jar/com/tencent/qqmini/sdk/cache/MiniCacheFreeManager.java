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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppLoaderFactory.g().getContext().getCacheDir());
      localStringBuilder.append("/mini");
      FileUtils.delete(localStringBuilder.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniCacheFreeManager", "clearAllStorageCache failed", localException);
    }
  }
  
  private static void clearAuthSp(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    Context localContext = AppLoaderFactory.g().getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    if (localContext.getSharedPreferences(localStringBuilder.toString(), 4).edit().clear().commit())
    {
      paramString = new StringBuilder();
      paramString.append("clearAuthSp finish. ");
      paramString.append(paramMiniAppInfo.appId);
      QMLog.i("MiniCacheFreeManager", paramString.toString());
    }
  }
  
  private static void clearDebugSp()
  {
    StorageUtil.getPreference().edit().clear().commit();
  }
  
  private static void clearDebugSp(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    Object localObject = StorageUtil.getPreference().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_debug");
    if (((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearDebugSp finish. ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      QMLog.i("MiniCacheFreeManager", ((StringBuilder)localObject).toString());
    }
  }
  
  private static void clearFileCache(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        return;
      }
      Object localObject = MiniAppFileManager.getMiniAppFileManager(paramMiniAppInfo.apkgInfo);
      if (localObject != null)
      {
        ((MiniAppFileManager)localObject).clearFileCache(paramMiniAppInfo.appId);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearFileCache finish. ");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        QMLog.i("MiniCacheFreeManager", ((StringBuilder)localObject).toString());
      }
    }
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clear Pkg finish. ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" dir:");
          localStringBuilder.append(str1);
          QMLog.i("MiniCacheFreeManager", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(localCharSequence);
          FileUtils.delete(localStringBuilder.toString(), false);
        }
        i += 1;
      }
    }
  }
  
  private static void clearStorageCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    paramString = Storage.getCacheDir(AppLoaderFactory.g().getContext().getCacheDir().getAbsolutePath(), paramString, paramMiniAppInfo.appId);
    if (new File(paramString).exists())
    {
      FileUtils.delete(paramString, false);
      paramString = new StringBuilder();
      paramString.append("clearStorageCache finish. ");
      paramString.append(paramMiniAppInfo.appId);
      QMLog.i("MiniCacheFreeManager", paramString.toString());
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kill process. ");
    localStringBuilder.append(paramMiniAppInfo.appId);
    QMLog.i("MiniCacheFreeManager", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */