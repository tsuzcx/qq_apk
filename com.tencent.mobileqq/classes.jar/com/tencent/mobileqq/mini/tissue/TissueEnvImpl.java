package com.tencent.mobileqq.mini.tissue;

import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import cooperation.qzone.util.QZLog;
import java.util.List;

public class TissueEnvImpl
{
  public static final String BUNDLE_KEY_TISSUE_NATIVE_LIB_DIR = "tissuenativelibdir";
  public static final String LOG_TAG = "Tissue";
  private static boolean sCheckLibUpdate = false;
  
  public static String getNativeLibDir()
  {
    if (!sCheckLibUpdate)
    {
      localObject = TissueWnsConfig.getBaseLibInfo();
      if (localObject != null) {
        EngineManager.g().installBaseLib((BaseLibInfo)localObject, null);
      }
      sCheckLibUpdate = true;
    }
    Object localObject = EngineManager.g().getEngineList(99);
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getInstalledEngineList success ");
      localStringBuilder.append(i);
      QZLog.i("Tissue", localStringBuilder.toString());
      if (i > 0)
      {
        localObject = (InstalledEngine)((List)localObject).get(0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("verify engine ");
        localStringBuilder.append(localObject);
        QZLog.i("Tissue", localStringBuilder.toString());
        if (verifyTissueEngine(((InstalledEngine)localObject).engineDir)) {
          return ((InstalledEngine)localObject).engineDir;
        }
      }
    }
    return null;
  }
  
  public static String getNativeLibDirInSubProgress()
  {
    ICommonManager localICommonManager = AppLoaderFactory.g().getCommonManager();
    if (localICommonManager == null) {
      return null;
    }
    return localICommonManager.getTissueSoPath();
  }
  
  public static boolean verifyTissueEngine(String paramString)
  {
    ICommonManager localICommonManager = AppLoaderFactory.g().getCommonManager();
    if (localICommonManager == null) {
      return false;
    }
    return localICommonManager.verifyTissueEngine(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tissue.TissueEnvImpl
 * JD-Core Version:    0.7.0.1
 */