package com.tencent.qqmini.sdk.server;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.GameLaunchConfig;
import com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.LaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.LaunchStrategy.LaunchData;
import com.tencent.qqmini.sdk.server.launch.ProcessState;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LaunchManagerService
{
  private static final String TAG = "minisdk-start_LaunchManagerService";
  private AppLaunchStrategy mAppLaunchStrategy;
  private final LinkedList<MiniProcessorConfig> mAppProcessConfig = new LinkedList();
  private Context mContext;
  private LaunchStrategy mGameLaunchStrategy;
  private final LinkedList<MiniProcessorConfig> mGameProcessConfig = new LinkedList();
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private final LinkedList<MiniProcessorConfig> mInternalProcessConfig = new LinkedList();
  private final IBinder mServiceBinder = new LaunchManagerService.ServiceBinder(this);
  
  private void addProcessorInfo(MiniProcessorConfig paramMiniProcessorConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerProcessInfo ");
    localStringBuilder.append(paramMiniProcessorConfig);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    int i = LaunchManagerService.5.$SwitchMap$com$tencent$qqmini$sdk$launcher$shell$ProcessType[paramMiniProcessorConfig.processType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (paramMiniProcessorConfig.appUIClass != null) {
          this.mInternalProcessConfig.add(paramMiniProcessorConfig);
        }
      }
      else if (paramMiniProcessorConfig.appUIClass != null)
      {
        this.mGameProcessConfig.add(paramMiniProcessorConfig);
      }
    }
    else if (paramMiniProcessorConfig.appUIClass != null) {
      this.mAppProcessConfig.add(paramMiniProcessorConfig);
    }
  }
  
  private void checkMiniAppInfoCache()
  {
    ThreadManager.getSubThreadHandler().post(new LaunchManagerService.4(this));
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    try
    {
      Object localObject = getLaunchStrategy(paramMiniAppInfo).startMiniApp(paramMiniAppInfo);
      MiniAppReportManager2.reportPageView("2click", null, paramMiniAppInfo.launchParam.entryPath, paramMiniAppInfo);
      Intent localIntent = ((LaunchStrategy.LaunchData)localObject).getIntent();
      ProcessState localProcessState1 = ((LaunchStrategy.LaunchData)localObject).getProcessState();
      ProcessState localProcessState2 = ProcessState.EMPTY;
      int i = 2;
      if (localProcessState1 == localProcessState2) {
        localIntent.putExtra("start_mode", 3);
      } else if (((LaunchStrategy.LaunchData)localObject).getProcessState() == ProcessState.PRELOADED) {
        localIntent.putExtra("start_mode", 1);
      } else {
        localIntent.putExtra("start_mode", 2);
      }
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localIntent.putExtra("KEY_LOGININFO", new LoginInfo(((MiniAppProxy)localObject).getLoginType(), ((MiniAppProxy)localObject).getAccount(), ((MiniAppProxy)localObject).getNickName(), ((MiniAppProxy)localObject).getPayOpenId(), ((MiniAppProxy)localObject).getPayOpenKey(), ((MiniAppProxy)localObject).getPayAccessToken(), ((MiniAppProxy)localObject).getLoginSig(), ((MiniAppProxy)localObject).getPlatformId(), ((MiniAppProxy)localObject).getAppId()));
      localIntent.putExtra("KEY_APPINFO", paramMiniAppInfo);
      localIntent.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
      localIntent.putExtra("sdk_mode", true);
      localIntent.putExtra("receiver", paramResultReceiver);
      localIntent.putExtra("startDuration", System.currentTimeMillis());
      localObject = EngineManager.g();
      if (paramMiniAppInfo.engineType != 1) {
        i = 3;
      }
      localIntent.putExtra("engineChannel", ((EngineManager)localObject).getChannelForType(i));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      if (paramActivity != null)
      {
        paramActivity.startActivity(localIntent);
      }
      else if (paramResultReceiver != null)
      {
        paramActivity = new Bundle();
        paramActivity.putParcelable("LAUNCH_ACTIVITY_INTENT", localIntent);
        paramResultReceiver.send(1, paramActivity);
      }
      else
      {
        this.mContext.startActivity(localIntent);
      }
      paramActivity = new StringBuilder();
      paramActivity.append("---startApp----  appid:");
      paramActivity.append(paramMiniAppInfo.appId);
      paramActivity.append(" appName:");
      paramActivity.append(paramMiniAppInfo.name);
      paramActivity.append(" intent:");
      paramActivity.append(localIntent);
      QMLog.i("minisdk-start_LaunchManagerService", paramActivity.toString());
      return;
    }
    catch (IllegalStateException paramActivity)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("---startApp---- failed appid:");
      paramBundle.append(paramMiniAppInfo.appId);
      paramBundle.append(" appName:");
      paramBundle.append(paramMiniAppInfo.name);
      QMLog.e("minisdk-start_LaunchManagerService", paramBundle.toString(), paramActivity);
    }
  }
  
  @NonNull
  private LaunchStrategy getLaunchStrategy(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return this.mGameLaunchStrategy;
    }
    return this.mAppLaunchStrategy;
  }
  
  @NonNull
  private LaunchStrategy getLaunchStrategy(String paramString)
  {
    if (isMiniGameProcess(paramString)) {
      return this.mGameLaunchStrategy;
    }
    return this.mAppLaunchStrategy;
  }
  
  private void initWnsConfig()
  {
    if (QUAUtil.isQQApp()) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new LaunchManagerService.2(this));
  }
  
  private boolean isMiniAppProcess(String paramString)
  {
    Iterator localIterator = this.mAppProcessConfig.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((MiniProcessorConfig)localIterator.next()).processName)) {
        return true;
      }
    }
    localIterator = this.mInternalProcessConfig.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((MiniProcessorConfig)localIterator.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isMiniGameProcess(String paramString)
  {
    Iterator localIterator = this.mGameProcessConfig.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((MiniProcessorConfig)localIterator.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isMiniProcess(String paramString)
  {
    return (isMiniAppProcess(paramString)) || (isMiniGameProcess(paramString));
  }
  
  private void updateBaseLib()
  {
    try
    {
      boolean bool = QUAUtil.isQQMainApp();
      if (bool) {
        return;
      }
      try
      {
        BaseLibManager.g().updateBaseLib(new LaunchManagerService.3(this));
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "updateBaseLib failed ", localThrowable);
      }
      return;
    }
    finally {}
  }
  
  public IBinder getBinder()
  {
    return this.mServiceBinder;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void init(Context paramContext)
  {
    if (this.mContext == null)
    {
      this.mContext = paramContext;
      this.mAppLaunchStrategy = new AppLaunchStrategy(this.mContext, this.mAppProcessConfig, this.mInternalProcessConfig);
      this.mGameLaunchStrategy = new GameLaunchStrategy(this.mContext, this.mGameProcessConfig, GameLaunchConfig.fromWnsConfig(), new LaunchManagerService.GameProcessPreloader(this, null), ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion());
      checkMiniAppInfoCache();
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    getLaunchStrategy(paramMiniAppBaseInfo).onAppBackground(paramString, paramMiniAppBaseInfo, paramBundle);
  }
  
  public void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    getLaunchStrategy(paramMiniAppBaseInfo).onAppForeground(paramString, paramMiniAppBaseInfo, paramBundle);
  }
  
  public void onAppStart(String paramString, @Nullable MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    if (paramMiniAppBaseInfo != null) {
      getLaunchStrategy(paramMiniAppBaseInfo).onAppStart(paramString, paramMiniAppBaseInfo, paramBundle);
    } else {
      getLaunchStrategy(paramString).onPreloaded(paramString, paramBundle);
    }
    updateBaseLib();
    initWnsConfig();
  }
  
  public void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    getLaunchStrategy(paramMiniAppBaseInfo).onAppStop(paramString, paramMiniAppBaseInfo, paramBundle);
  }
  
  public void onHostAppBackground() {}
  
  public void onPreloadBaseLib(String paramString1, String paramString2) {}
  
  public void onRecvCommand(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.mAppLaunchStrategy.onRecvCommand(paramString1, paramString2, paramBundle);
    paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    if (("cmd_notify_runtime_lifecycle".equals(paramString1)) && ("first_frame".equals(paramBundle.getString("bundle_key_runtime_lifecycle", "N/A"))))
    {
      this.mGameLaunchStrategy.preloadProcess(null);
      return;
    }
    if ("cmd_notify_runtime_info".equals(paramString1))
    {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramString1 = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
      if (paramString1 != null) {
        getLaunchStrategy(paramString2).onReceiveProcessRunningAppInfos(paramString2, paramString1);
      }
    }
  }
  
  public void preloadMiniApp(Bundle paramBundle)
  {
    try
    {
      updateBaseLib();
      if (paramBundle == null) {
        return;
      }
      if (TextUtils.equals(paramBundle.getString("mini_key_preload_type"), "preload_game")) {
        this.mGameLaunchStrategy.preloadProcess(paramBundle);
      } else {
        this.mAppLaunchStrategy.preloadProcess(paramBundle);
      }
      return;
    }
    finally {}
  }
  
  public void registerClientMessenger(String paramString, Messenger paramMessenger)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramMessenger == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerClientMessenger pName=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" messenger:");
      localStringBuilder.append(paramMessenger);
      QMLog.w("minisdk-start_LaunchManagerService", localStringBuilder.toString());
      getLaunchStrategy(paramString).registerProcessMessenger(paramString, paramMessenger);
    }
  }
  
  public void registerProcessInfo(List<MiniProcessorConfig> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MiniProcessorConfig localMiniProcessorConfig = (MiniProcessorConfig)paramList.next();
        if ((localMiniProcessorConfig != null) && (!TextUtils.isEmpty(localMiniProcessorConfig.processName))) {
          addProcessorInfo(localMiniProcessorConfig);
        }
      }
    }
  }
  
  public boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmdToMiniProcess failed! miniAppInfo is null.");
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("KEY_APPINFO", paramMiniAppInfo);
    if (paramResultReceiver != null) {
      localBundle.putParcelable("receiver", paramResultReceiver);
    }
    localMessage.setData(localBundle);
    try
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Messenger sendCmdToMiniProcess cmd=");
      paramBundle.append(paramInt);
      QMLog.i("minisdk-start_LaunchManagerService", paramBundle.toString());
      getLaunchStrategy(paramMiniAppInfo).sendMessageToMiniProcess(paramMiniAppInfo, localMessage);
      return true;
    }
    catch (Throwable paramBundle)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "Messenger sendCmdToMiniProcess exception!", paramBundle);
      if (paramResultReceiver != null) {
        paramResultReceiver.send(-1, new Bundle());
      }
    }
    return false;
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("startMiniApp params is empty! ,appConfig=");
      paramBundle.append(paramMiniAppInfo);
      paramBundle.append(" Activity=");
      paramBundle.append(paramActivity);
      QMLog.e("minisdk-start_LaunchManagerService", paramBundle.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---startApp---- appid:");
    localStringBuilder.append(paramMiniAppInfo.appId);
    localStringBuilder.append(" appName:");
    localStringBuilder.append(paramMiniAppInfo.name);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    doStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
    if ((paramActivity != null) && (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.launchParam.scene != 2004)) {
      paramActivity.overridePendingTransition(R.anim.mini_sdk_activity_slide_in_from_bottom, R.anim.mini_sdk_activity_slide_out_to_back);
    }
    if ((!paramMiniAppInfo.isFakeAppInfo()) && (!paramMiniAppInfo.isShortcutFakeApp()))
    {
      paramResultReceiver = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (paramMiniAppInfo.launchParam != null) {
        paramActivity = String.valueOf(paramMiniAppInfo.launchParam.scene);
      } else {
        paramActivity = "";
      }
      if (paramMiniAppInfo.via != null) {
        paramBundle = paramMiniAppInfo.via;
      } else {
        paramBundle = "";
      }
      paramResultReceiver.useUserApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType, 0, paramActivity, paramBundle, null, new LaunchManagerService.1(this));
    }
  }
  
  public void stopAllMiniApp()
  {
    this.mAppLaunchStrategy.killAllProcess();
    this.mGameLaunchStrategy.killAllProcess();
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    getLaunchStrategy(paramMiniAppInfo).killMiniAppProcess(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService
 * JD-Core Version:    0.7.0.1
 */