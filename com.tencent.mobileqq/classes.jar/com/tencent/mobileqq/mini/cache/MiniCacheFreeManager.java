package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.MiniSDK;
import java.io.File;

public class MiniCacheFreeManager
{
  private static final String TAG = "MiniCacheFreeManager";
  
  private static void clearAllFileCaches()
  {
    MiniAppFileManager.getInstance().clearAllCache();
  }
  
  private static void clearAllPkgs()
  {
    com.tencent.mobileqq.utils.FileUtils.delete(ApkgManager.PATH_GAMEPKG_ROOT, false);
    com.tencent.mobileqq.utils.FileUtils.delete(ApkgManager.PATH_WXAPKG_ROOT, false);
    com.tencent.mobileqq.utils.FileUtils.delete(ApkgManager.PATH_APKG_TISSUE_ROOT, false);
  }
  
  private static void clearAllStorageCache()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.getContext().getCacheDir());
      localStringBuilder.append("/mini");
      com.tencent.mobileqq.utils.FileUtils.delete(localStringBuilder.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniCacheFreeManager", 1, "clearAllStorageCache failed", localException);
    }
  }
  
  private static void clearAuthSp(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    if (localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4).edit().clear().commit())
    {
      paramString = new StringBuilder();
      paramString.append("clearAuthSp finish. ");
      paramString.append(paramMiniAppInfo.appId);
      QLog.i("MiniCacheFreeManager", 1, paramString.toString());
    }
  }
  
  private static void clearAuthSp(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      if (localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4).edit().clear().commit())
      {
        paramString1 = new StringBuilder();
        paramString1.append("clearAuthSp finish. ");
        paramString1.append(paramString2);
        QLog.i("MiniCacheFreeManager", 1, paramString1.toString());
      }
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
      QLog.i("MiniCacheFreeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void clearDebugSp(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = StorageUtil.getPreference().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_debug");
      if (((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearDebugSp finish. ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("MiniCacheFreeManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static void clearFileCache(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        return;
      }
      MiniAppFileManager.getInstance().clearFileCache(paramMiniAppInfo.appId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFileCache finish. ");
      localStringBuilder.append(paramMiniAppInfo.appId);
      QLog.i("MiniCacheFreeManager", 1, localStringBuilder.toString());
    }
  }
  
  private static void clearFileCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MiniAppFileManager.getInstance().clearFileCache(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFileCache finish. ");
      localStringBuilder.append(paramString);
      QLog.i("MiniCacheFreeManager", 1, localStringBuilder.toString());
    }
  }
  
  private static void clearPkg(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    Object localObject = ApkgManager.getApkgFolderPath(paramMiniAppInfo);
    if (new File((String)localObject).exists())
    {
      com.tencent.mobileqq.utils.FileUtils.delete((String)localObject, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearPkg finish: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      QLog.i("MiniCacheFreeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void clearPkg(String paramString)
  {
    String str = ApkgManager.PATH_GAMEPKG_ROOT;
    Object localObject1 = MD5.toMD5(paramString);
    Object localObject2 = new File(str);
    int j;
    int i;
    Object localObject3;
    if (((File)localObject2).isDirectory())
    {
      localObject2 = ((File)localObject2).list();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith((String)localObject1)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearPkg delete pkg : ");
          localStringBuilder.append((String)localObject3);
          QLog.d("MiniCacheFreeManager", 1, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject3);
          com.tencent.mobileqq.mini.utils.FileUtils.delete(localStringBuilder.toString(), false);
        }
        i += 1;
      }
    }
    str = ApkgManager.PATH_WXAPKG_ROOT;
    paramString = MD5.toMD5(paramString);
    localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).list();
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(paramString)))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("clearPkg delete pkg : ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("MiniCacheFreeManager", 1, ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append((String)localObject2);
          com.tencent.mobileqq.mini.utils.FileUtils.delete(((StringBuilder)localObject3).toString(), false);
        }
        i += 1;
      }
    }
  }
  
  private static void clearStorageCache(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        return;
      }
      paramString = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), paramString, paramMiniAppInfo.appId);
      if (paramString != null)
      {
        paramString.clearStorage();
        paramString = new StringBuilder();
        paramString.append("clearStorageCache finish. ");
        paramString.append(paramMiniAppInfo.appId);
        QLog.i("MiniCacheFreeManager", 1, paramString.toString());
      }
    }
  }
  
  private static void clearStorageCache(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString1 = Storage.open(BaseApplicationImpl.getApplication().getBaseContext(), paramString1, paramString2);
      if (paramString1 != null)
      {
        paramString1.clearStorage();
        paramString1 = new StringBuilder();
        paramString1.append("clearStorageCache finish. ");
        paramString1.append(paramString2);
        QLog.i("MiniCacheFreeManager", 1, paramString1.toString());
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
  
  public static void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.2(paramMiniAppInfo, paramString, paramBoolean), 16, paramIThreadListener, true);
  }
  
  public static void freeCache(String paramString1, String paramString2, boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.3(paramString2, paramString1, paramBoolean), 16, paramIThreadListener, true);
  }
  
  public static void freeCache(boolean paramBoolean, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManagerV2.excute(new MiniCacheFreeManager.4(), 16, paramIThreadListener, true);
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
    if (MiniSdkUtil.a(paramMiniAppInfo.isEngineTypeMiniGame() ^ true)) {
      MiniSDK.stopMiniApp(BaseApplicationImpl.getContext(), MiniSdkLauncher.convert(paramMiniAppInfo));
    }
  }
  
  private static void killSelf(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString, null, null, new MiniCacheFreeManager.5());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */