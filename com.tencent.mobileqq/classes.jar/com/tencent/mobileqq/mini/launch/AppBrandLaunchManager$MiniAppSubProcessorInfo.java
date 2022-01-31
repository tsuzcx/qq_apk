package com.tencent.mobileqq.mini.launch;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class AppBrandLaunchManager$MiniAppSubProcessorInfo
{
  public Class<?> appBrandUIClass;
  public MiniAppConfig appConfig;
  public Class<?> appPreLoadClass;
  private long enterBackgroundTimestamp;
  public Class<?> gameUIClass;
  public boolean isForeground;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  public int pid;
  public String preloadGameBaseLibVersion;
  public String preloadType;
  public final String processName;
  public Runnable processRecycleRunnable = new AppBrandLaunchManager.MiniAppSubProcessorInfo.1(this);
  
  public AppBrandLaunchManager$MiniAppSubProcessorInfo(String paramString, Class paramClass1, Class paramClass2, Class paramClass3)
  {
    this.processName = paramString;
    this.appBrandUIClass = paramClass1;
    this.appPreLoadClass = paramClass3;
    this.gameUIClass = paramClass2;
  }
  
  public void clean()
  {
    this.mainHandler.removeCallbacks(this.processRecycleRunnable);
  }
  
  public boolean equalAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig == null) || (this.appConfig == null)) {}
    while ((this.appConfig.config == null) || (TextUtils.isEmpty(this.appConfig.config.appId)) || (paramMiniAppConfig.config == null) || (this.appConfig.config.getEngineType() != paramMiniAppConfig.config.getEngineType()) || (this.appConfig.config.getReportType() != paramMiniAppConfig.config.getReportType()) || (!this.appConfig.config.appId.equals(paramMiniAppConfig.config.appId))) {
      return false;
    }
    return true;
  }
  
  public boolean isAppStore()
  {
    return (this.appConfig != null) && (this.appConfig.config != null) && (this.appConfig.config.isAppStoreMiniApp());
  }
  
  public boolean isInternalAppProcess()
  {
    return AppBrandLaunchManager.access$000().processName.equals(this.processName);
  }
  
  public void onEnterBackground()
  {
    this.isForeground = false;
    if (this.appConfig == null) {}
    do
    {
      return;
      this.enterBackgroundTimestamp = System.currentTimeMillis();
      this.mainHandler.removeCallbacks(this.processRecycleRunnable);
    } while ((isAppStore()) && (!this.appConfig.isInternalApp()));
    Handler localHandler = this.mainHandler;
    Runnable localRunnable = this.processRecycleRunnable;
    if (this.appConfig.isEngineTypeMiniGame()) {}
    for (long l = AppBrandLaunchManager.g().gameProcessRecycleTime;; l = AppBrandLaunchManager.g().appProcessRecycleTime)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
  
  public void onEnterForeground()
  {
    this.isForeground = true;
    this.enterBackgroundTimestamp = 0L;
    this.mainHandler.removeCallbacks(this.processRecycleRunnable);
  }
  
  public String toString()
  {
    int k = -1;
    String str1;
    String str2;
    if ((this.appConfig != null) && (this.appConfig.config != null))
    {
      str1 = this.appConfig.config.appId;
      if ((this.appConfig == null) || (this.appConfig.config == null)) {
        break label244;
      }
      str2 = this.appConfig.config.name;
      label60:
      if ((this.appConfig == null) || (this.appConfig.config == null)) {
        break label251;
      }
    }
    label244:
    label251:
    for (int i = this.appConfig.config.getEngineType();; i = -1)
    {
      int j = k;
      if (this.appConfig != null)
      {
        j = k;
        if (this.appConfig.config != null) {
          j = this.appConfig.config.getReportType();
        }
      }
      String str4 = this.processName;
      String str3 = str4;
      if (str4.contains(":")) {
        str3 = str4.substring(str4.indexOf(":"));
      }
      return "pName:" + str3 + " pid:" + this.pid + " appId=" + str1 + " appName=" + str2 + " engineType=" + i + " reportType=" + j + " preloadType=" + this.preloadType;
      str1 = "N/A";
      break;
      str2 = "N/A";
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo
 * JD-Core Version:    0.7.0.1
 */