package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Messenger;
import android.os.Process;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class LaunchManagerClient
{
  private static final String TAG = "minisdk-start_AppBrandProxy";
  private static byte[] lock = new byte[0];
  private boolean isConnecting = false;
  private MiniAppInfo mAppConfig;
  private Messenger mClientMessenger;
  private ServiceConnection mConnection = new LaunchManagerClient.2(this);
  private Context mContext;
  private Handler.Callback mMessengerCallback = new LaunchManagerClient.1(this);
  private int mMiniAppStatus;
  private boolean mNeedSyncStatus = false;
  private ILaunchManager mService;
  private Bundle mStartBundle;
  private List<Runnable> mTaskAfterConnected = new ArrayList();
  
  public LaunchManagerClient(Context paramContext)
  {
    this.mContext = paramContext;
    if (!isMainProcess()) {
      this.mClientMessenger = new Messenger(new Handler(Looper.getMainLooper(), this.mMessengerCallback));
    }
    ensureService();
  }
  
  private void doAfterServiceConnected()
  {
    try
    {
      Object localObject = new ArrayList(this.mTaskAfterConnected);
      this.mTaskAfterConnected.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "doAfterServiceConnected exception!", localThrowable);
    }
  }
  
  private boolean ensureService()
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = isMainProcess();
        if (bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        if (this.mService != null)
        {
          bool1 = true;
          continue;
        }
        bool1 = bool2;
        if (this.isConnecting) {
          continue;
        }
        bool1 = bool2;
        if (this.mService != null) {
          continue;
        }
        QMLog.w("minisdk-start_AppBrandProxy", "mService is null! Begin Bind Service!");
        Class localClass1 = AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.server.AppMainService");
        if (localClass1 == null)
        {
          QMLog.e("minisdk-start_AppBrandProxy", "Can not find AppMainService");
          bool1 = bool2;
          continue;
        }
        localIntent = new Intent(this.mContext, localClass2);
      }
      finally {}
      Intent localIntent;
      localIntent.putExtra("mini_process_name", AppLoaderFactory.g().getCurrentProcessName());
      localIntent.putExtra("mini_process_messenger", this.mClientMessenger);
      this.isConnecting = true;
      try
      {
        this.mContext.bindService(localIntent, this.mConnection, 1);
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        QMLog.w("minisdk-start_AppBrandProxy", "exception when bind lbs service!!!", localThrowable);
        bool1 = bool2;
      }
    }
  }
  
  private static BaseRuntime getBaseRuntime(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return null;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return null;
    }
    return paramMiniAppInfo;
  }
  
  private void handleCmdFromMainProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    QMLog.i("minisdk-start_AppBrandProxy", "Messenger handleCmdFromMainProcess cmd=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if (paramBundle == null)
      {
        QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_SHARE_RESULT. bundle is null");
        sendResult(paramResultReceiver, -1, paramBundle);
        return;
      }
      notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    if (paramBundle == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE. bundle is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    notifyPeriodicCacheUpdate(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  private boolean isMainProcess()
  {
    return AppLoaderFactory.g().isMainProcess();
  }
  
  private void notifyLifeCycleLocked(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("CLIENT_PROCESS_DEATH_NOTIFIER", ProcessDeathNotifier.getInstance());
    localBundle.putInt("CLIENT_PROCESS_PID", Process.myPid());
    localBundle.putParcelableArrayList("bundle_key_runtime_list", AppRuntimeLoaderManager.g().getAllLoadedAppInfos());
    this.mService.onAppLifecycle(paramInt, paramString, paramMiniAppInfo, localBundle);
  }
  
  private void notifyToService()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mNeedSyncStatus;
        if (!bool) {
          return;
        }
        this.mNeedSyncStatus = false;
        try
        {
          String str1 = AppLoaderFactory.g().getCurrentProcessName();
          if (!queryIsMiniProcess()) {
            continue;
          }
          QMLog.w("minisdk-start_AppBrandProxy", "Sync Process Status=" + this.mMiniAppStatus);
          notifyLifeCycleLocked(1, str1, this.mAppConfig, this.mStartBundle);
          if (this.mMiniAppStatus != 3) {
            break label115;
          }
          notifyLifeCycleLocked(3, str1, this.mAppConfig, null);
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.mMiniAppStatus != 2) {
          continue;
        }
      }
      finally {}
      label115:
      notifyLifeCycleLocked(2, str2, this.mAppConfig, null);
    }
  }
  
  private void performStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    try
    {
      this.mService.startMiniApp(paramMiniAppInfo, paramBundle, new LaunchManagerClient.5(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp exception.", paramActivity);
    }
  }
  
  private static void sendResult(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    if (paramResultReceiver == null) {
      return;
    }
    paramResultReceiver.send(paramInt, paramBundle);
  }
  
  /* Error */
  public ILaunchManager getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/qqmini/sdk/ipc/LaunchManagerClient:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/ILaunchManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 101	com/tencent/qqmini/sdk/ipc/LaunchManagerClient:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/ILaunchManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 89	com/tencent/qqmini/sdk/ipc/LaunchManagerClient:ensureService	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 101	com/tencent/qqmini/sdk/ipc/LaunchManagerClient:mService	Lcom/tencent/qqmini/sdk/launcher/ipc/ILaunchManager;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	LaunchManagerClient
    //   13	15	1	localILaunchManager	ILaunchManager
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  public void notifyPeriodicCacheUpdate(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    localObject = ((BaseRuntimeLoader)localObject).getRuntime();
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    localObject = ((BaseRuntime)localObject).getJsService();
    if (localObject == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    QMLog.i("minisdk-start_AppBrandProxy", "evaluateSubscribeJS ON_BACKGROUND_FETCH_DATA appid:" + paramMiniAppInfo.appId);
    ((IJsService)localObject).evaluateSubscribeJS("onBackgroundFetchData", new JSONObject().toString(), 0);
    sendResult(paramResultReceiver, 0, paramBundle);
  }
  
  public void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    ShareState localShareState = GetShareState.obtain(paramMiniAppInfo);
    if (localShareState.requestEvent != null) {}
    for (paramMiniAppInfo = localShareState.requestEvent.jsService; paramMiniAppInfo == null; paramMiniAppInfo = paramMiniAppInfo.getJsService())
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    if (paramBundle.getInt("key_share_result") == 0) {}
    for (paramBundle = ApiUtil.wrapCallbackOk(localShareState.shareEvent, null);; paramBundle = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null))
    {
      paramMiniAppInfo.evaluateCallbackJs(localShareState.shareCallbackId, paramBundle.toString());
      return;
    }
  }
  
  public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    this.mAppConfig = paramMiniAppInfo;
    if (paramInt == 1)
    {
      if (this.mMiniAppStatus < 1) {
        this.mMiniAppStatus = 1;
      }
      if (getService() == null)
      {
        this.mNeedSyncStatus = true;
        this.mStartBundle = paramBundle;
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart IAppBrandService Connection is Null.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppStart");
        notifyLifeCycleLocked(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          continue;
        }
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppForeground after onAppStart");
        notifyLifeCycleLocked(2, paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", paramString);
        return;
      }
      this.mMiniAppStatus = paramInt;
      if (getService() == null)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + paramInt);
        return;
      }
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify lifecycle:" + paramInt);
        notifyLifeCycleLocked(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          releaseService();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle exception. lifecycle:" + paramInt, paramString);
      }
    }
  }
  
  public void preloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    ILaunchManager localILaunchManager = getService();
    paramMiniAppInfo = new LaunchManagerClient.3(this, localILaunchManager, paramMiniAppInfo);
    if (localILaunchManager != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.mTaskAfterConnected.add(paramMiniAppInfo);
  }
  
  public boolean queryIsMiniProcess()
  {
    bool2 = false;
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "queryIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    try
    {
      Bundle localBundle = this.mService.requestAync("query_mini_process", AppLoaderFactory.g().getCurrentProcessName(), null);
      bool1 = bool2;
      if (localBundle != null) {
        bool1 = localBundle.getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
        boolean bool1 = bool2;
      }
    }
    QMLog.i("minisdk-start_AppBrandProxy", "queryiIsMiniProcess " + bool1);
    return bool1;
  }
  
  protected void releaseService()
  {
    QMLog.w("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.mService != null)
      {
        this.mContext.unbindService(this.mConnection);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "exception when releaseService.");
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.mTaskAfterConnected.add(new LaunchManagerClient.8(this, paramString, paramMiniCmdCallback, paramBundle));
      return;
    }
    try
    {
      this.mService.sendCmd(paramString, AppLoaderFactory.g().getCurrentProcessName(), paramBundle, paramMiniCmdCallback);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", paramString);
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new LaunchManagerClient.4(this, paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver));
      return;
    }
    performStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopAllMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new LaunchManagerClient.7(this));
      return;
    }
    try
    {
      this.mService.stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (getService() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new LaunchManagerClient.6(this, paramMiniAppInfo));
      return;
    }
    try
    {
      this.mService.stopMiniApp(paramMiniAppInfo);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient
 * JD-Core Version:    0.7.0.1
 */