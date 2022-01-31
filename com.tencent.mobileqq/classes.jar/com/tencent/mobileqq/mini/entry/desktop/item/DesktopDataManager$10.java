package com.tencent.mobileqq.mini.entry.desktop.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bbdx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class DesktopDataManager$10
  implements Runnable
{
  DesktopDataManager$10(DesktopDataManager paramDesktopDataManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str = ApkgManager.getApkgFolderPath(this.val$miniAppInfo);
    if (new File(str).exists())
    {
      bbdx.a(str, false);
      QLog.d("DesktopDataManager", 1, "clear apkgFile. " + this.val$miniAppInfo.appId);
    }
    str = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(this.val$miniAppInfo.appId);
    if (new File(str).exists())
    {
      bbdx.a(str, false);
      QLog.d("DesktopDataManager", 1, "clear cacheFile. " + this.val$miniAppInfo.appId);
    }
    str = Storage.getCacheDir(BaseApplicationImpl.getApplication().getBaseContext().getCacheDir().getAbsolutePath(), (String)localObject, this.val$miniAppInfo.appId);
    if (new File(str).exists())
    {
      bbdx.a(str, false);
      QLog.d("DesktopDataManager", 1, "clear storageFile. " + this.val$miniAppInfo.appId);
    }
    if (BaseApplicationImpl.getApplication().getSharedPreferences(this.val$miniAppInfo.appId + "_" + (String)localObject, 4).edit().clear().commit()) {
      QLog.d("DesktopDataManager", 1, "clear authorize info. " + this.val$miniAppInfo.appId);
    }
    if (StorageUtil.getPreference().edit().putBoolean(this.val$miniAppInfo.appId + "_debug", false).commit()) {
      QLog.d("DesktopDataManager", 1, "clear debug info. " + this.val$miniAppInfo.appId);
    }
    localObject = AppBrandLaunchManager.g().getCacheApp(this.val$miniAppInfo);
    if (localObject != null)
    {
      AppBrandLaunchManager.g().forceKillProcess((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject);
      QLog.d("DesktopDataManager", 1, "kill process. " + this.val$miniAppInfo.appId + "; " + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).processName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.10
 * JD-Core Version:    0.7.0.1
 */