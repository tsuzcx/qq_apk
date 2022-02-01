package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@RuntimeLoaderConfig(loaders={@com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.flutter.FlutterRuntimeLoader", type=2), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.miniapp.AppRuntimeLoader", type=1), @com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo(className="com.tencent.qqmini.minigame.GameRuntimeLoader", type=4)})
public class AppRuntimeLoaderManager
{
  private static final String TAG = "minisdk-start_AppRuntimeLoaderManager";
  private static volatile AppRuntimeLoaderManager instance;
  private static volatile byte[] lock = new byte[0];
  private final LinkedList<BaseRuntimeLoader> loadedRuntimeLinkedList = new LinkedList();
  private final HashMap<Class<BaseRuntimeLoader>, BaseRuntimeLoader> mEmptyRuntimeLoaderList = new HashMap();
  private long mEnterBackgroundTimestamp = 0L;
  private final int mGameMaxLoaderCount;
  private Handler mHandler = ThreadManager.getSubThreadHandler();
  private int mMaxLoaderCount = 3;
  private final Vector<AppRuntimeEventCenter.RuntimeStateObserver> mObservers = new Vector();
  private BaseRuntimeLoader mPrelaunchRuntimeLoader;
  private Bundle mPreloadBundle;
  private BaseRuntimeLoader mPreloadRuntimeLoader;
  private int mProcessType = -1;
  private RuntimeLoaderConfiguration mRuntimeConfiguration = new RuntimeLoaderConfiguration(this);
  private long mRuntimeLoaderRecycleTime = 900000L;
  private final AppRuntimeEventCenter.RuntimeStateObserver mRuntimeObserver = new AppRuntimeLoaderManager.1(this);
  public Runnable processRecycleRunnable = new AppRuntimeLoaderManager.2(this);
  
  private AppRuntimeLoaderManager()
  {
    initProcessConfig(null);
    this.mMaxLoaderCount = WnsConfig.getConfig("qqminiapp", "MiniAppRuntimeCacheMax", 3);
    this.mGameMaxLoaderCount = WnsConfig.getConfig("qqminiapp", "mini_game_multi_instance", 1);
    this.mRuntimeLoaderRecycleTime = WnsConfig.getConfig("qqminiapp", "mini_app_runtime_recycle_time", 900000L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RuntimeLoaderConfig:");
    localStringBuilder.append(this.mRuntimeConfiguration.toString());
    localStringBuilder.append(" ProcessType=");
    localStringBuilder.append(this.mProcessType);
    localStringBuilder.append(" maxRuntime=");
    localStringBuilder.append(this.mMaxLoaderCount);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
  }
  
  private void addRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if (paramBaseRuntimeLoader != null) {}
    for (;;)
    {
      try
      {
        if (paramBaseRuntimeLoader.getMiniAppInfo() != null) {
          this.loadedRuntimeLinkedList.addFirst(paramBaseRuntimeLoader);
        }
        int i = this.mMaxLoaderCount;
        if (this.mProcessType == 4) {
          i = this.mGameMaxLoaderCount;
        }
        if ((i >= 1) && (this.loadedRuntimeLinkedList.size() > i))
        {
          paramBaseRuntimeLoader = (BaseRuntimeLoader)this.loadedRuntimeLinkedList.removeLast();
          paramBaseRuntimeLoader.destroy();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("RuntimeLoader count exceed the maxcount, remove the last one! removed=");
          if (paramBaseRuntimeLoader != null)
          {
            paramBaseRuntimeLoader = paramBaseRuntimeLoader.toSimpleString();
            localStringBuilder.append(paramBaseRuntimeLoader);
            QMLog.w("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
          }
        }
        else
        {
          notifyRuntimeListInfo();
          return;
        }
      }
      finally {}
      paramBaseRuntimeLoader = "N/A";
    }
  }
  
  private void cleanRuntimeLoader()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "clean RuntimeLoader");
    try
    {
      if (this.loadedRuntimeLinkedList.size() <= 1) {
        return;
      }
      while (this.loadedRuntimeLinkedList.size() > 1)
      {
        BaseRuntimeLoader localBaseRuntimeLoader = (BaseRuntimeLoader)this.loadedRuntimeLinkedList.removeLast();
        if (localBaseRuntimeLoader != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removed RuntimeLoader:");
          localStringBuilder.append(localBaseRuntimeLoader.toSimpleString());
          QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
          localBaseRuntimeLoader.destroy();
        }
      }
      notifyRuntimeListInfo();
      preloadRuntime(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "cleanRuntimeLoader exception!", localThrowable);
    }
  }
  
  public static AppRuntimeLoaderManager g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new AppRuntimeLoaderManager();
        }
      }
    }
    return instance;
  }
  
  private boolean hasRunningRuntimeLoader()
  {
    try
    {
      Iterator localIterator = new ArrayList(this.loadedRuntimeLinkedList).iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((BaseRuntimeLoader)localIterator.next()).isRunning();
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "hasRunnintRumtimeLoader exception!", localThrowable);
    }
    return false;
  }
  
  private void initProcessConfig(Bundle paramBundle)
  {
    if (this.mProcessType >= 0) {
      return;
    }
    MiniProcessorConfig localMiniProcessorConfig = MiniAppEnv.g().getCurrentProcessConfig();
    if (localMiniProcessorConfig != null) {
      this.mProcessType = localMiniProcessorConfig.supportRuntimeType;
    }
    if (this.mProcessType >= 0) {
      return;
    }
    if ((paramBundle != null) && (paramBundle.containsKey("mini_key_preload_type")))
    {
      paramBundle = paramBundle.getString("mini_key_preload_type");
      if ("preload_app".equals(paramBundle))
      {
        this.mProcessType = 3;
        return;
      }
      if ("preload_game".equals(paramBundle)) {
        this.mProcessType = 4;
      }
    }
  }
  
  private boolean isMatch(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader != null)
    {
      if (paramMiniAppInfo == null) {
        return false;
      }
      Iterator localIterator = this.mRuntimeConfiguration.getLoaderInfoListForPreload().iterator();
      while (localIterator.hasNext())
      {
        RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)localIterator.next();
        if ((localRuntimeLoaderInfo != null) && (paramBaseRuntimeLoader.getClass() == localRuntimeLoaderInfo.runtimeLoaderClass) && (localRuntimeLoaderInfo.creator != null) && (localRuntimeLoaderInfo.creator.support(paramMiniAppInfo)) && ((paramBaseRuntimeLoader.getMiniAppInfo() == null) || (paramBaseRuntimeLoader.getMiniAppInfo().equals(paramMiniAppInfo)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void notifyAppStateMessageForAll(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    try
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((AppRuntimeEventCenter.RuntimeStateObserver)localIterator.next()).onStateChange(paramMiniAppStateMessage);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramMiniAppStateMessage;
    }
  }
  
  private void notifyRuntimeListInfo()
  {
    ArrayList localArrayList = getAllLoadedAppInfos();
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "notifyRuntime runtime info to main process.");
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("bundle_key_runtime_list", localArrayList);
    AppBrandCmdProxy.g().sendCmd("cmd_notify_runtime_info", localBundle, new AppRuntimeLoaderManager.5(this));
  }
  
  private BaseRuntimeLoader obtainEmptyRuntimeLoader(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.mRuntimeConfiguration.getLoaderInfoList().iterator();
    while (localIterator.hasNext())
    {
      RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)localIterator.next();
      if (!localRuntimeLoaderInfo.creator.isEnginePrepared(paramBundle))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RuntimeLoader engine is not prepared! ");
        localStringBuilder.append(localRuntimeLoaderInfo.creator);
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
      }
      else if (localRuntimeLoaderInfo.creator.support(paramMiniAppInfo))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("RuntimeLoader engine support: ");
        paramMiniAppInfo.append(localRuntimeLoaderInfo.creator);
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", paramMiniAppInfo.toString());
        if (this.mProcessType < 0)
        {
          paramMiniAppInfo = new StringBuilder();
          paramMiniAppInfo.append("set ProcessType to ");
          paramMiniAppInfo.append(this.mProcessType);
          QMLog.w("minisdk-start_AppRuntimeLoaderManager", paramMiniAppInfo.toString());
          this.mProcessType = localRuntimeLoaderInfo.type;
        }
        if (this.mEmptyRuntimeLoaderList.containsKey(localRuntimeLoaderInfo.runtimeLoaderClass)) {
          paramMiniAppInfo = (BaseRuntimeLoader)this.mEmptyRuntimeLoaderList.remove(localRuntimeLoaderInfo.runtimeLoaderClass);
        } else {
          paramMiniAppInfo = (BaseRuntimeLoader)localRuntimeLoaderInfo.creator.create(MiniAppEnv.g().getContext(), paramBundle);
        }
        paramMiniAppInfo.addRuntimeStateObserver(this.mRuntimeObserver);
        return paramMiniAppInfo;
      }
    }
    return null;
  }
  
  public void addAppEventObserverForAll(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    if (paramRuntimeStateObserver != null) {}
    try
    {
      if (!this.mObservers.contains(paramRuntimeStateObserver)) {
        this.mObservers.addElement(paramRuntimeStateObserver);
      }
    }
    finally {}
  }
  
  public void bringToFront(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    try
    {
      this.loadedRuntimeLinkedList.remove(paramBaseRuntimeLoader);
      this.loadedRuntimeLinkedList.addFirst(paramBaseRuntimeLoader);
      return;
    }
    catch (Throwable paramBaseRuntimeLoader)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "bringToFront exception!", paramBaseRuntimeLoader);
    }
  }
  
  public BaseRuntimeLoader createAppRuntimeLoader(MiniAppInfo paramMiniAppInfo, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to createAppRuntimeLoader, appInfo is null");
      return null;
    }
    try
    {
      if ((this.mPreloadRuntimeLoader != null) && (!isMatch(this.mPreloadRuntimeLoader, paramMiniAppInfo)) && (this.mPreloadRuntimeLoader.isRunning()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createAppRuntimeLoader, stop the preloading runtimeloader ");
        localStringBuilder.append(this.mPreloadRuntimeLoader.toSimpleString());
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
        this.mPreloadRuntimeLoader.pause();
      }
      if ((this.mPrelaunchRuntimeLoader != null) && (!isMatch(this.mPrelaunchRuntimeLoader, paramMiniAppInfo)) && (this.mPrelaunchRuntimeLoader.isRunning()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createAppRuntimeLoader, stop the prelaunch runtimeloader ");
        localStringBuilder.append(this.mPrelaunchRuntimeLoader.toSimpleString());
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
        this.mPrelaunchRuntimeLoader.pause();
      }
      paramBundle = obtainEmptyRuntimeLoader(paramMiniAppInfo, paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createAppRuntimeLoader appId=");
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append(" name=");
      localStringBuilder.append(paramMiniAppInfo.name);
      localStringBuilder.append(" versionType=");
      localStringBuilder.append(paramMiniAppInfo.verType);
      localStringBuilder.append(" version=");
      localStringBuilder.append(paramMiniAppInfo.version);
      localStringBuilder.append(" obtainRuntimeLoader:");
      localStringBuilder.append(paramBundle);
      QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
      paramBundle.setRuntimeLoadListener(new AppRuntimeLoaderManager.3(this, paramOnAppRuntimeLoadListener));
      paramBundle.setMiniAppInfo(paramMiniAppInfo);
      addRuntimeLoader(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void deleteAppEventObserverForAll(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    if (paramRuntimeStateObserver != null) {}
    try
    {
      this.mObservers.removeElement(paramRuntimeStateObserver);
    }
    finally {}
  }
  
  public ArrayList<MiniAppInfo> getAllLoadedAppInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = new ArrayList(this.loadedRuntimeLinkedList).iterator();
    while (localIterator.hasNext())
    {
      MiniAppInfo localMiniAppInfo = ((BaseRuntimeLoader)localIterator.next()).getMiniAppInfo();
      if (localMiniAppInfo != null) {
        localArrayList.add(localMiniAppInfo);
      }
    }
    return localArrayList;
  }
  
  @Deprecated
  public BaseRuntimeLoader getCurrentRunTimeLoader()
  {
    try
    {
      Object localObject = new LinkedList(this.loadedRuntimeLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (BaseRuntimeLoader)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public void onEnterBackground()
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "onEnterBackground");
    this.mEnterBackgroundTimestamp = System.currentTimeMillis();
    this.mHandler.removeCallbacks(this.processRecycleRunnable);
    this.mHandler.postDelayed(this.processRecycleRunnable, this.mRuntimeLoaderRecycleTime);
    preloadRuntime(null);
  }
  
  public void onEnterForeground(@NonNull BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "onEnterForeground");
    this.mEnterBackgroundTimestamp = 0L;
    bringToFront(paramBaseRuntimeLoader);
    this.mHandler.removeCallbacks(this.processRecycleRunnable);
  }
  
  public void preLaunchRuntimeLoader(MiniAppInfo paramMiniAppInfo, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to preLaunchRuntimeLoader, appInfo is null");
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "Failed to preLaunch RuntimeLoader, appInfo is null");
      return;
    }
    Object localObject = WnsConfig.getConfig("qqminiapp", "prelaunch_white_list", "1108291530,1109896843");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLaunch whitelist=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" appid=");
    localStringBuilder.append(paramMiniAppInfo.appId);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains(paramMiniAppInfo.appId)))
    {
      if (this.mPrelaunchRuntimeLoader != null)
      {
        QMLog.e("minisdk-start_AppRuntimeLoaderManager", "There is a preLaunch loader now! Stop preLaunch!");
        return;
      }
      MiniAppPrelaunchRecorder.get().onPrelaunch(paramMiniAppInfo.appId);
      try
      {
        localObject = queryAppRunTimeLoader(paramMiniAppInfo);
        if (localObject != null)
        {
          paramMiniAppInfo = new StringBuilder();
          paramMiniAppInfo.append("preLaunchRuntimeLoader, There is a loader now! No need PreLaunch! ");
          paramMiniAppInfo.append(((BaseRuntimeLoader)localObject).toSimpleString());
          QMLog.w("minisdk-start_AppRuntimeLoaderManager", paramMiniAppInfo.toString());
          return;
        }
        if (hasRunningRuntimeLoader())
        {
          QMLog.w("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader, There is a running loader now! Stop prelaunch!");
          return;
        }
        if ((this.mPreloadRuntimeLoader != null) && (this.mPreloadRuntimeLoader.isRunning()))
        {
          paramMiniAppInfo = new StringBuilder();
          paramMiniAppInfo.append("preLaunchRuntimeLoader, There is a running preload loader now ");
          paramMiniAppInfo.append(this.mPreloadRuntimeLoader.toSimpleString());
          QMLog.i("minisdk-start_AppRuntimeLoaderManager", paramMiniAppInfo.toString());
          return;
        }
        paramBundle = obtainEmptyRuntimeLoader(paramMiniAppInfo, paramBundle);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preLaunchRuntimeLoader, appId=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        ((StringBuilder)localObject).append(" name=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.name);
        ((StringBuilder)localObject).append(" versionType=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.verType);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(paramMiniAppInfo.version);
        ((StringBuilder)localObject).append(" obtainRuntimeLoader:");
        ((StringBuilder)localObject).append(paramBundle.toSimpleString());
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", ((StringBuilder)localObject).toString());
        paramBundle.setRuntimeLoadListener(new AppRuntimeLoaderManager.4(this, paramOnAppRuntimeLoadListener));
        paramBundle.setMiniAppInfo(paramMiniAppInfo);
        paramBundle.getAppStateManager().isFromPrelaunch = true;
        this.mPrelaunchRuntimeLoader = paramBundle;
        paramBundle.start();
        addRuntimeLoader(paramBundle);
        return;
      }
      catch (Throwable paramMiniAppInfo)
      {
        QMLog.e("minisdk-start_AppRuntimeLoaderManager", "preLaunchRuntimeLoader exception!", paramMiniAppInfo);
        return;
      }
    }
    QMLog.e("minisdk-start_AppRuntimeLoaderManager", "preLaunch white list not hit, Stop preLaunch!");
  }
  
  public void preloadRuntime(Bundle paramBundle)
  {
    initProcessConfig(paramBundle);
    if (paramBundle != null) {
      this.mPreloadBundle = paramBundle;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preloadRuntime with ProcessType=");
    ((StringBuilder)localObject1).append(this.mProcessType);
    QMLog.w("minisdk-start_AppRuntimeLoaderManager", ((StringBuilder)localObject1).toString());
    if (this.mProcessType < 0) {
      return;
    }
    if (hasRunningRuntimeLoader())
    {
      QMLog.w("minisdk-start_AppRuntimeLoaderManager", "There is a running loader now! Stop preload!");
      return;
    }
    localObject1 = this.mPreloadRuntimeLoader;
    if (localObject1 != null)
    {
      if (((BaseRuntimeLoader)localObject1).isPause())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Resume the preload runtime! ");
        paramBundle.append(this.mPreloadRuntimeLoader.toSimpleString());
        QMLog.w("minisdk-start_AppRuntimeLoaderManager", paramBundle.toString());
        this.mPreloadRuntimeLoader.resume();
        return;
      }
      if (this.mPreloadRuntimeLoader.isRunning())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("There is already a preload runtime now! ");
        paramBundle.append(this.mPreloadRuntimeLoader.toSimpleString());
        QMLog.w("minisdk-start_AppRuntimeLoaderManager", paramBundle.toString());
        return;
      }
    }
    Object localObject2 = this.mRuntimeConfiguration.getLoaderInfoListForPreload().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)((Iterator)localObject2).next();
      if ((this.mProcessType & ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).type) != 0)
      {
        Object localObject3;
        if (!((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator.isEnginePrepared(paramBundle))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("The loader engine is not prepared! ");
          ((StringBuilder)localObject3).append(((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass.getSimpleName());
          QMLog.e("minisdk-start_AppRuntimeLoaderManager", ((StringBuilder)localObject3).toString());
          ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator.doPrepareEngine(paramBundle);
        }
        else if (!this.mEmptyRuntimeLoaderList.containsKey(((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass))
        {
          localObject2 = ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).creator;
          localObject3 = MiniAppEnv.g().getContext();
          if (paramBundle == null) {
            paramBundle = new Bundle();
          }
          paramBundle = (BaseRuntimeLoader)((BaseRuntimeLoader.Creator)localObject2).create((Context)localObject3, paramBundle);
          paramBundle.addRuntimeStateObserver(this.mRuntimeObserver);
          paramBundle.getAppStateManager().isFromPreload = true;
          paramBundle.start();
          this.mEmptyRuntimeLoaderList.put(((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject1).runtimeLoaderClass, paramBundle);
          this.mPreloadRuntimeLoader = paramBundle;
        }
      }
    }
  }
  
  @Nullable
  public BaseRuntimeLoader queryAppRunTimeLoader(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queryAppRunTimeLoader appId=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
    ((StringBuilder)localObject).append(" name=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.name);
    ((StringBuilder)localObject).append(" versionType=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.verType);
    ((StringBuilder)localObject).append(" version=");
    ((StringBuilder)localObject).append(paramMiniAppInfo.version);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new ArrayList(this.loadedRuntimeLinkedList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseRuntimeLoader localBaseRuntimeLoader = (BaseRuntimeLoader)((Iterator)localObject).next();
        if (localBaseRuntimeLoader.getMiniAppInfo() != null)
        {
          boolean bool = localBaseRuntimeLoader.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localBaseRuntimeLoader;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void removeRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if (paramBaseRuntimeLoader != null) {}
    try
    {
      if (this.loadedRuntimeLinkedList.remove(paramBaseRuntimeLoader))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removed RuntimeLoader:");
        localStringBuilder.append(paramBaseRuntimeLoader.toSimpleString());
        QMLog.i("minisdk-start_AppRuntimeLoaderManager", localStringBuilder.toString());
        paramBaseRuntimeLoader.destroy();
        notifyRuntimeListInfo();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager
 * JD-Core Version:    0.7.0.1
 */