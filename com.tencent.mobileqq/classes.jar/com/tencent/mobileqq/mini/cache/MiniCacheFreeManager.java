package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bdhb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MiniCacheFreeManager
{
  private static final String TAG = "MiniCacheFreeManager";
  
  private static void clearAuthSp(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!BaseApplicationImpl.getApplication().getSharedPreferences(paramMiniAppInfo.appId + "_" + paramString, 4).edit().clear().commit()) {
      return;
    }
    QLog.i("MiniCacheFreeManager", 1, "clearAuthSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearDebugSp(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    while (!StorageUtil.getPreference().edit().putBoolean(paramMiniAppInfo.appId + "_debug", false).commit()) {
      return;
    }
    QLog.i("MiniCacheFreeManager", 1, "clearDebugSp finish. " + paramMiniAppInfo.appId);
  }
  
  private static void clearFileCache(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return;
    }
    MiniAppFileManager.getInstance();
    MiniAppFileManager.clearFileCache(paramMiniAppInfo.appId);
    QLog.i("MiniCacheFreeManager", 1, "clearFileCache finish. " + paramMiniAppInfo.appId);
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
    bdhb.a(str, false);
    QLog.i("MiniCacheFreeManager", 1, "clearPkg finish: " + paramMiniAppInfo.appId);
  }
  
  private static void clearStorageCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {}
    do
    {
      return;
      paramString = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), paramString, paramMiniAppInfo.appId);
    } while (paramString == null);
    paramString.clearStorage();
    QLog.i("MiniCacheFreeManager", 1, "clearStorageCache finish. " + paramMiniAppInfo.appId);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    freeCache(paramString, paramMiniAppInfo, true);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    freeCache(paramString, paramMiniAppInfo, paramBoolean, null);
  }
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.2(paramMiniAppInfo, paramString, paramBoolean), 16, paramIThreadListener, true);
  }
  
  public static void freeCacheDialog(Activity paramActivity, String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2)
  {
    AppBrandTask.runTaskOnUiThread(new MiniCacheFreeManager.1(paramActivity, paramString2, paramString1, paramMiniAppInfo));
  }
  
  private static void killSelf(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    do
    {
      return;
      localMiniAppSubProcessorInfo = AppBrandLaunchManager.g().getCacheApp(paramMiniAppInfo);
    } while (localMiniAppSubProcessorInfo == null);
    AppBrandLaunchManager.g().forceKillProcess(localMiniAppSubProcessorInfo);
    QLog.i("MiniCacheFreeManager", 1, "kill process. " + paramMiniAppInfo.appId + "; " + localMiniAppSubProcessorInfo.processName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */