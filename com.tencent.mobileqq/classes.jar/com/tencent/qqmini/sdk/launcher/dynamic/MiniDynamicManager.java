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
    if ((paramMiniDexConfig == null) || (TextUtils.isEmpty(paramMiniDexConfig.dexUrl)))
    {
      QMLog.e("minisdk-MiniAppDexLoader_MiniDynamicManager", "dex url is null.");
      return;
    }
    String str = paramMiniDexConfig.getDexPath();
    if (TextUtils.isEmpty(str))
    {
      QMLog.e("minisdk-MiniAppDexLoader_MiniDynamicManager", "dex file path is null.");
      return;
    }
    this.mCurrDownloadConfigStr = paramString;
    QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", "begin to download dex: " + paramMiniDexConfig.dexUrl);
    new Thread(new MiniDynamicManager.1(this, paramMiniDexConfig, str, paramString)).start();
  }
  
  public static MiniDynamicManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniDynamicManager();
      }
      return instance;
    }
  }
  
  private void setValidDexConfig(String paramString, MiniDexConfig paramMiniDexConfig)
  {
    QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", "set valid dex config: " + paramString);
    this.mMiniDexConfig = paramMiniDexConfig;
    this.mConfigStr = paramString;
  }
  
  public MiniDexConfig getValidDexConfig()
  {
    return this.mMiniDexConfig;
  }
  
  public void updateDexConfig(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.mConfigStr))) {}
    MiniDexConfig localMiniDexConfig;
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-MiniAppDexLoader_MiniDynamicManager", "update dex config:" + paramString);
        localMiniDexConfig = MiniDexConfig.convertFrom(paramString);
      } while (localMiniDexConfig == null);
      if (localMiniDexConfig.verifyDex()) {
        break;
      }
    } while ((localMiniDexConfig.isDexDownloaded()) || (!AppLoaderFactory.g().isMainProcess()));
    doDownloadDex(paramString, localMiniDexConfig);
    return;
    setValidDexConfig(paramString, localMiniDexConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager
 * JD-Core Version:    0.7.0.1
 */