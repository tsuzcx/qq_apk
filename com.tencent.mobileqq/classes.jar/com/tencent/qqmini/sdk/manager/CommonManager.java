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
    if (TextUtils.isEmpty(paramString1))
    {
      QMLog.w("Tissue", "basePath is empty");
      return false;
    }
    Object localObject = new File(paramString1);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        return false;
      }
      localObject = EngineVersion.fromFolderName(((File)localObject).getName());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currentVersion:");
      localStringBuilder.append(localObject);
      localStringBuilder.append(",requiredVersion:");
      localStringBuilder.append(paramString2);
      QMLog.i("Tissue", localStringBuilder.toString());
      boolean bool;
      if ((localObject != null) && (EngineVersion.compareVersion(((EngineVersion)localObject).mMinor, paramString2) >= 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (!bool)
      {
        paramString1 = new StringBuilder();
        paramString1.append("versionCheck:");
        paramString1.append(bool);
        QMLog.i("Tissue", paramString1.toString());
        return false;
      }
      return checkFileExists(paramString1, paramArrayOfString);
    }
    return false;
  }
  
  private static boolean checkFileExists(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = new File(paramString, paramArrayOfString[i]);
      if (!localFile.exists())
      {
        paramString = new StringBuilder();
        paramString.append(localFile.getAbsolutePath());
        paramString.append(" not exists");
        QMLog.w("Tissue", paramString.toString());
        return false;
      }
      if (!localFile.isFile())
      {
        paramString = new StringBuilder();
        paramString.append(localFile.getAbsolutePath());
        paramString.append(" not a file");
        QMLog.w("Tissue", paramString.toString());
        return false;
      }
      if (!localFile.canRead())
      {
        paramString = new StringBuilder();
        paramString.append(localFile.getAbsolutePath());
        paramString.append(" not readable");
        QMLog.w("Tissue", paramString.toString());
        return false;
      }
      i += 1;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append(paramString);
    paramArrayOfString.append(" is fine");
    QMLog.i("Tissue", paramArrayOfString.toString());
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.CommonManager
 * JD-Core Version:    0.7.0.1
 */