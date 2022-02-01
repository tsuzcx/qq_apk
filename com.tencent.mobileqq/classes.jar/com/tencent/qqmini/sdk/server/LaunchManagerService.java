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
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Intent localIntent;
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = getLaunchStrategy(paramMiniAppInfo).startMiniApp(paramMiniAppInfo);
        MiniAppReportManager2.reportPageView("2click", null, paramMiniAppInfo.launchParam.entryPath, paramMiniAppInfo);
        localIntent = ((LaunchStrategy.LaunchData)localObject).getIntent();
        if (((LaunchStrategy.LaunchData)localObject).getProcessState() == ProcessState.EMPTY)
        {
          localIntent.putExtra("start_mode", 3);
          localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
          localIntent.putExtra("KEY_LOGININFO", new LoginInfo(((MiniAppProxy)localObject).getLoginType(), ((MiniAppProxy)localObject).getAccount(), ((MiniAppProxy)localObject).getNickName(), ((MiniAppProxy)localObject).getPayOpenId(), ((MiniAppProxy)localObject).getPayOpenKey(), ((MiniAppProxy)localObject).getPayAccessToken(), ((MiniAppProxy)localObject).getLoginSig(), ((MiniAppProxy)localObject).getPlatformId(), ((MiniAppProxy)localObject).getAppId()));
          localIntent.putExtra("KEY_APPINFO", paramMiniAppInfo);
          localIntent.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
          localIntent.putExtra("sdk_mode", true);
          localIntent.putExtra("receiver", paramResultReceiver);
          localIntent.putExtra("startDuration", System.currentTimeMillis());
          localObject = EngineManager.g();
          if (paramMiniAppInfo.engineType != 1) {
            break label307;
          }
          i = 2;
          localIntent.putExtra("engineChannel", ((EngineManager)localObject).getChannelForType(i));
          if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
          }
          if (paramActivity == null) {
            break;
          }
          paramActivity.startActivity(localIntent);
          return;
        }
      }
      catch (IllegalStateException paramActivity)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "---startApp---- failed appid:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name, paramActivity);
        return;
      }
      if (((LaunchStrategy.LaunchData)localObject).getProcessState() == ProcessState.PRELOADED)
      {
        localIntent.putExtra("start_mode", 1);
      }
      else
      {
        localIntent.putExtra("start_mode", 2);
        continue;
        label307:
        i = 3;
      }
    }
    if (paramResultReceiver != null)
    {
      paramActivity = new Bundle();
      paramActivity.putParcelable("LAUNCH_ACTIVITY_INTENT", localIntent);
      paramResultReceiver.send(1, paramActivity);
      return;
    }
    this.mContext.startActivity(localIntent);
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
  
  /* Error */
  private void updateBaseLib()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 343	com/tencent/qqmini/sdk/utils/QUAUtil:isQQMainApp	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: invokestatic 348	com/tencent/qqmini/sdk/manager/BaseLibManager:g	()Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   16: new 350	com/tencent/qqmini/sdk/server/LaunchManagerService$3
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 351	com/tencent/qqmini/sdk/server/LaunchManagerService$3:<init>	(Lcom/tencent/qqmini/sdk/server/LaunchManagerService;)V
    //   24: invokevirtual 354	com/tencent/qqmini/sdk/manager/BaseLibManager:updateBaseLib	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   27: goto -17 -> 10
    //   30: astore_2
    //   31: ldc 8
    //   33: ldc_w 356
    //   36: aload_2
    //   37: invokestatic 258	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: goto -30 -> 10
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	LaunchManagerService
    //   5	2	1	bool	boolean
    //   30	7	2	localThrowable	Throwable
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	30	java/lang/Throwable
    //   2	6	43	finally
    //   13	27	43	finally
    //   31	40	43	finally
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
    if (this.mContext != null) {
      throw new IllegalArgumentException();
    }
    this.mContext = paramContext;
    this.mAppLaunchStrategy = new AppLaunchStrategy(this.mContext, this.mAppProcessConfig, this.mInternalProcessConfig);
    this.mGameLaunchStrategy = new GameLaunchStrategy(this.mContext, this.mGameProcessConfig, GameLaunchConfig.fromWnsConfig(), new LaunchManagerService.GameProcessPreloader(this, null), ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion());
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
    }
    for (;;)
    {
      updateBaseLib();
      initWnsConfig();
      return;
      getLaunchStrategy(paramString).onPreloaded(paramString, paramBundle);
    }
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
    if (("cmd_notify_runtime_lifecycle".equals(paramString1)) && ("first_frame".equals(paramBundle.getString("bundle_key_runtime_lifecycle", "N/A")))) {}
    do
    {
      this.mGameLaunchStrategy.preloadProcess(null);
      do
      {
        return;
      } while (!"cmd_notify_runtime_info".equals(paramString1));
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramString1 = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
    } while (paramString1 == null);
    getLaunchStrategy(paramString2).onReceiveProcessRunningAppInfos(paramString2, paramString1);
  }
  
  public void preloadMiniApp(Bundle paramBundle)
  {
    for (;;)
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
      }
      finally {}
    }
  }
  
  public void registerClientMessenger(String paramString, Messenger paramMessenger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMessenger == null)) {
      return;
    }
    QMLog.w("minisdk-start_LaunchManagerService", "registerClientMessenger pName=" + paramString + " messenger:" + paramMessenger);
    getLaunchStrategy(paramString).registerProcessMessenger(paramString, paramMessenger);
  }
  
  public void registerProcessInfo(List<MiniProcessorConfig> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MiniProcessorConfig localMiniProcessorConfig = (MiniProcessorConfig)paramList.next();
        if ((localMiniProcessorConfig != null) && (!TextUtils.isEmpty(localMiniProcessorConfig.processName)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "registerProcessInfo " + localMiniProcessorConfig);
          switch (LaunchManagerService.4.$SwitchMap$com$tencent$qqmini$sdk$launcher$shell$ProcessType[localMiniProcessorConfig.processType.ordinal()])
          {
          default: 
            break;
          case 1: 
            if (localMiniProcessorConfig.appUIClass != null) {
              this.mAppProcessConfig.add(localMiniProcessorConfig);
            }
            break;
          case 2: 
            if (localMiniProcessorConfig.appUIClass != null) {
              this.mGameProcessConfig.add(localMiniProcessorConfig);
            }
            break;
          case 3: 
            if (localMiniProcessorConfig.appUIClass != null) {
              this.mInternalProcessConfig.add(localMiniProcessorConfig);
            }
            break;
          }
        }
      }
    }
  }
  
  public boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmdToMiniProcess failed! miniAppInfo is null.");
    }
    do
    {
      return false;
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
        QMLog.i("minisdk-start_LaunchManagerService", "Messenger sendCmdToMiniProcess cmd=" + paramInt);
        getLaunchStrategy(paramMiniAppInfo).sendMessageToMiniProcess(paramMiniAppInfo, localMessage);
        return true;
      }
      catch (Throwable paramBundle)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "Messenger sendCmdToMiniProcess exception!", paramBundle);
      }
    } while (paramResultReceiver == null);
    paramResultReceiver.send(-1, new Bundle());
    return false;
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_LaunchManagerService", "startMiniApp params is empty! ,appConfig=" + paramMiniAppInfo + " Activity=" + paramActivity);
    }
    do
    {
      return;
      QMLog.i("minisdk-start_LaunchManagerService", "---startApp---- appid:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
      doStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      if ((paramActivity != null) && (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.launchParam.scene != 2004)) {
        paramActivity.overridePendingTransition(R.anim.mini_sdk_activity_slide_in_from_bottom, R.anim.mini_sdk_activity_slide_out_to_back);
      }
    } while ((paramMiniAppInfo.isFakeAppInfo()) || (paramMiniAppInfo.isShortcutFakeApp()));
    paramResultReceiver = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (paramMiniAppInfo.launchParam != null)
    {
      paramActivity = String.valueOf(paramMiniAppInfo.launchParam.scene);
      if (paramMiniAppInfo.via == null) {
        break label217;
      }
    }
    label217:
    for (paramBundle = paramMiniAppInfo.via;; paramBundle = "")
    {
      paramResultReceiver.useUserApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType, 0, paramActivity, paramBundle, null, new LaunchManagerService.1(this));
      return;
      paramActivity = "";
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService
 * JD-Core Version:    0.7.0.1
 */