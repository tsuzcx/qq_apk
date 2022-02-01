package com.tencent.qqmini.sdk.launcher.dynamic;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniDynamicManager
{
  private static final String TAG = "minisdk-MiniAppDexLoader_MiniDynamicManager";
  private static volatile MiniDynamicManager instance;
  private static volatile byte[] lock = new byte[0];
  private String mConfigStr;
  private String mCurrDownloadConfigStr;
  private MiniDexConfig mMiniDexConfig;
  
  private void doDownloadDex(String paramString, MiniDexConfig paramMiniDexConfig)
  {
    if ((paramMiniDexConfig != null) && (!TextUtils.isEmpty(paramMiniDexConfig.dexUrl)))
    {
      String str = paramMiniDexConfig.getDexPath();
      if (TextUtils.isEmpty(str))
      {
        QMLog.e("minisdk-MiniAppDexLoader_MiniDynamicManager", "dex file path is null.");
        return;
      }
      this.mCurrDownloadConfigStr = paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("begin to download dex: ");
      localStringBuilder.append(paramMiniDexConfig.dexUrl);
      QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", localStringBuilder.toString());
      new Thread(new MiniDynamicManager.1(this, paramMiniDexConfig, str, paramString)).start();
      return;
    }
    QMLog.e("minisdk-MiniAppDexLoader_MiniDynamicManager", "dex url is null.");
  }
  
  public static MiniDynamicManager g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniDynamicManager();
        }
      }
    }
    return instance;
  }
  
  private void setValidDexConfig(String paramString, MiniDexConfig paramMiniDexConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set valid dex config: ");
    localStringBuilder.append(paramString);
    QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", localStringBuilder.toString());
    this.mMiniDexConfig = paramMiniDexConfig;
    this.mConfigStr = paramString;
  }
  
  public MiniDexConfig getValidDexConfig()
  {
    return this.mMiniDexConfig;
  }
  
  public void updateDexConfig(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(this.mConfigStr)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update dex config:");
      ((StringBuilder)localObject).append(paramString);
      QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", ((StringBuilder)localObject).toString());
      localObject = MiniDexConfig.convertFrom(paramString);
      if (localObject == null) {
        return;
      }
      if (!((MiniDexConfig)localObject).verifyDex())
      {
        if ((!((MiniDexConfig)localObject).isDexDownloaded()) && (AppLoaderFactory.g().isMainProcess())) {
          doDownloadDex(paramString, (MiniDexConfig)localObject);
        }
        return;
      }
      setValidDexConfig(paramString, (MiniDexConfig)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager
 * JD-Core Version:    0.7.0.1
 */