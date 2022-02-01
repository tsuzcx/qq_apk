package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.io.File;

@MiniKeep
public class CommonManager
  implements ICommonManager
{
  public static String sTissueRequiredVersion = "1.7.1";
  private String tissueSoPath;
  
  private boolean checkEngineAvailable(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QMLog.w("Tissue", "basePath is empty");
    }
    do
    {
      return false;
      localObject = new File(paramString1);
    } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
    Object localObject = EngineVersion.fromFolderName(((File)localObject).getName());
    QMLog.i("Tissue", "currentVersion:" + localObject + ",requiredVersion:" + paramString2);
    if ((localObject != null) && (EngineVersion.compareVersion(((EngineVersion)localObject).mMinor, paramString2) >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        QMLog.i("Tissue", "versionCheck:" + bool);
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = new File(paramString1, paramArrayOfString[i]);
        if (!paramString2.exists())
        {
          QMLog.w("Tissue", paramString2.getAbsolutePath() + " not exists");
          return false;
        }
        if (!paramString2.isFile())
        {
          QMLog.w("Tissue", paramString2.getAbsolutePath() + " not a file");
          return false;
        }
        if (!paramString2.canRead())
        {
          QMLog.w("Tissue", paramString2.getAbsolutePath() + " not readable");
          return false;
        }
        i += 1;
      }
      QMLog.i("Tissue", paramString1 + " is fine");
      return true;
    }
  }
  
  public void addActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    ActivityResultManager.g().addActivityResultListener(paramIActivityResultListener);
  }
  
  public void fetchPeriodicCacheIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    if (AppLoaderFactory.g().isMainProcess()) {
      PreCacheManager.g().fetchPeriodicCacheIfNeed(paramMiniAppInfo, new CommonManager.1(this, paramMiniAppInfo));
    }
  }
  
  public EngineChannel getChannelForType(int paramInt)
  {
    return EngineManager.g().getChannelForType(paramInt);
  }
  
  public BaseRuntime getCurrentRuntime()
  {
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
    if (localBaseRuntimeLoader != null) {
      return localBaseRuntimeLoader.getRuntime();
    }
    return null;
  }
  
  public String getTissueSoPath()
  {
    return this.tissueSoPath;
  }
  
  public void removeActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    ActivityResultManager.g().removeActivityResultListener(paramIActivityResultListener);
  }
  
  public void setTissueSoPath(String paramString)
  {
    this.tissueSoPath = paramString;
  }
  
  public boolean verifyTissueEngine(String paramString)
  {
    String str = sTissueRequiredVersion;
    return checkEngineAvailable(paramString, new String[] { "libtv8rt.so", "libflutter.so", "libapp.so" }, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.CommonManager
 * JD-Core Version:    0.7.0.1
 */