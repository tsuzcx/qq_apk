package com.tencent.qqmini.sdk.server.launch;

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

public class AppLaunchStrategy$MiniAppSubProcessorInfo
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
  public Runnable processRecycleRunnable = new AppLaunchStrategy.MiniAppSubProcessorInfo.1(this);
  public int supportRuntimeType;
  public Class<?> uiClass;
  
  public AppLaunchStrategy$MiniAppSubProcessorInfo(AppLaunchStrategy paramAppLaunchStrategy, String paramString, ProcessType paramProcessType, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
  {
    this(paramAppLaunchStrategy, paramString, paramClass1, paramClass2, paramClass3, paramInt);
  }
  
  public AppLaunchStrategy$MiniAppSubProcessorInfo(AppLaunchStrategy paramAppLaunchStrategy, String paramString, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
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
      if (AppLaunchStrategy.equalAppInfo((MiniAppBaseInfo)localIterator.next(), paramMiniAppBaseInfo)) {
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
    return (AppLaunchStrategy.access$100() != null) && (AppLaunchStrategy.access$100().processName.equals(this.processName));
  }
  
  public void onEnterBackground()
  {
    int i = 0;
    this.isForeground = false;
    if (this.allMiniAppInfo.isEmpty()) {
      return;
    }
    if (WnsConfig.getConfig("qqminiapp", "mini_app_screen_detect", 1) > 0) {
      i = 1;
    }
    if ((i != 0) && (!DeviceInfoUtil.isScreenOn(AppLaunchStrategy.access$200(this.this$0))))
    {
      QMLog.i("minisdk-start_LaunchManagerService", "onAppBackground isScreenOn=false");
      return;
    }
    this.enterBackgroundTimestamp = System.currentTimeMillis();
    this.mainHandler.removeCallbacks(this.processRecycleRunnable);
    Handler localHandler = this.mainHandler;
    Runnable localRunnable = this.processRecycleRunnable;
    long l;
    if ("preload_game".equals(this.preloadType)) {
      l = this.this$0.gameProcessRecycleTime;
    } else {
      l = this.this$0.appProcessRecycleTime;
    }
    localHandler.postDelayed(localRunnable, l);
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
      int j = 0;
      Iterator localIterator = paramList.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!AppLaunchStrategy.equalAppInfo(paramMiniAppBaseInfo, (MiniAppInfo)localIterator.next()));
      int i = 1;
      if (i == 0) {
        this.allMiniAppInfo.add(paramMiniAppBaseInfo);
      }
    }
    this.allMiniAppInfo.addAll(paramList);
  }
  
  public boolean support(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramBoolean) && (this.internalUIClass == null)) {
      return false;
    }
    paramBoolean = bool;
    if ((this.supportRuntimeType & paramInt) != 0) {
      paramBoolean = true;
    }
    return paramBoolean;
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
    ((StringBuilder)localObject2).append("pName:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" pid:");
    ((StringBuilder)localObject2).append(this.pid);
    ((StringBuilder)localObject2).append(" reportType=");
    ((StringBuilder)localObject2).append(-1);
    ((StringBuilder)localObject2).append(" preloadType=");
    ((StringBuilder)localObject2).append(this.preloadType);
    ((StringBuilder)localObject2).append(" supportRuntimeType=");
    ((StringBuilder)localObject2).append(this.supportRuntimeType);
    ((StringBuilder)localObject2).append(" currentApp=");
    ((StringBuilder)localObject2).append(this.currentAppInfo);
    ((StringBuilder)localObject2).append(" allApp=[");
    localObject1 = this.allMiniAppInfo.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MiniAppBaseInfo localMiniAppBaseInfo = (MiniAppBaseInfo)((Iterator)localObject1).next();
      ((StringBuilder)localObject2).append("(appid:");
      ((StringBuilder)localObject2).append(localMiniAppBaseInfo.appId);
      ((StringBuilder)localObject2).append(" name:");
      ((StringBuilder)localObject2).append(localMiniAppBaseInfo.name);
      ((StringBuilder)localObject2).append("), ");
    }
    ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.MiniAppSubProcessorInfo
 * JD-Core Version:    0.7.0.1
 */