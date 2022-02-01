package com.tencent.qqmini.sdk.server;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LaunchManagerService$MiniAppSubProcessorInfo
{
  public final List<MiniAppBaseInfo> allMiniAppInfo = new CopyOnWriteArrayList();
  public Class<?> appPreLoadClass;
  public MiniAppBaseInfo currentAppInfo;
  private long enterBackgroundTimestamp = 0L;
  public Class<?> internalUIClass;
  public boolean isForeground = false;
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  public int pid;
  public String preloadGameBaseLibVersion;
  public String preloadType;
  public final String processName;
  public Runnable processRecycleRunnable = new LaunchManagerService.MiniAppSubProcessorInfo.1(this);
  public int supportRuntimeType;
  public Class<?> uiClass;
  
  public LaunchManagerService$MiniAppSubProcessorInfo(LaunchManagerService paramLaunchManagerService, String paramString, ProcessType paramProcessType, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
  {
    this(paramLaunchManagerService, paramString, paramClass1, paramClass2, paramClass3, paramInt);
  }
  
  public LaunchManagerService$MiniAppSubProcessorInfo(LaunchManagerService paramLaunchManagerService, String paramString, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
  {
    this.processName = paramString;
    this.uiClass = paramClass1;
    this.internalUIClass = paramClass2;
    this.appPreLoadClass = paramClass3;
    this.supportRuntimeType = paramInt;
  }
  
  public void clean()
  {
    this.mainHandler.removeCallbacks(this.processRecycleRunnable);
  }
  
  public boolean containsAppConfig(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Iterator localIterator = this.allMiniAppInfo.iterator();
    while (localIterator.hasNext()) {
      if (LaunchManagerService.equalAppInfo((MiniAppBaseInfo)localIterator.next(), paramMiniAppBaseInfo)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isIdleProcess()
  {
    return this.allMiniAppInfo.isEmpty();
  }
  
  public boolean isInternalAppProcess()
  {
    return (LaunchManagerService.access$100() != null) && (LaunchManagerService.access$100().processName.equals(this.processName));
  }
  
  public void onEnterBackground()
  {
    int i = 1;
    this.isForeground = false;
    if (this.allMiniAppInfo.isEmpty()) {
      return;
    }
    if (WnsConfig.getConfig("qqminiapp", "mini_app_screen_detect", 1) > 0) {}
    while ((i != 0) && (!DeviceInfoUtil.isScreenOn(LaunchManagerService.access$200(this.this$0))))
    {
      QMLog.i("minisdk-start_LaunchManagerService", "onAppBackground isScreenOn=false");
      return;
      i = 0;
    }
    this.enterBackgroundTimestamp = System.currentTimeMillis();
    this.mainHandler.removeCallbacks(this.processRecycleRunnable);
    Handler localHandler = this.mainHandler;
    Runnable localRunnable = this.processRecycleRunnable;
    if ("preload_game".equals(this.preloadType)) {}
    for (long l = this.this$0.gameProcessRecycleTime;; l = this.this$0.appProcessRecycleTime)
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
  
  public void setAllMiniAppInfo(MiniAppBaseInfo paramMiniAppBaseInfo, List<MiniAppInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.allMiniAppInfo.clear();
    if (paramMiniAppBaseInfo != null)
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!LaunchManagerService.equalAppInfo(paramMiniAppBaseInfo, (MiniAppInfo)localIterator.next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.allMiniAppInfo.add(paramMiniAppBaseInfo);
      }
      this.allMiniAppInfo.addAll(paramList);
      return;
    }
  }
  
  public boolean support(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.internalUIClass == null)) {}
    while ((this.supportRuntimeType & paramInt) == 0) {
      return false;
    }
    return true;
  }
  
  @NonNull
  public String toString()
  {
    Object localObject2 = this.processName;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains(":")) {
      localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf(":"));
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("pName:").append((String)localObject1).append(" pid:").append(this.pid).append(" reportType=").append(-1).append(" preloadType=").append(this.preloadType).append(" supportRuntimeType=").append(this.supportRuntimeType);
    ((StringBuilder)localObject2).append(" currentApp=").append(this.currentAppInfo);
    ((StringBuilder)localObject2).append(" allApp=[");
    localObject1 = this.allMiniAppInfo.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MiniAppBaseInfo localMiniAppBaseInfo = (MiniAppBaseInfo)((Iterator)localObject1).next();
      ((StringBuilder)localObject2).append("(appid:").append(localMiniAppBaseInfo.appId).append(" name:").append(localMiniAppBaseInfo.name).append("), ");
    }
    ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.MiniAppSubProcessorInfo
 * JD-Core Version:    0.7.0.1
 */