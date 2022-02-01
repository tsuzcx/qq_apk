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
    try
    {
      boolean bool = isMainProcess();
      if (bool) {
        return false;
      }
      Object localObject1 = this.mService;
      if (localObject1 != null) {
        return true;
      }
      bool = this.isConnecting;
      if (bool) {
        return false;
      }
      if (this.mService == null)
      {
        QMLog.w("minisdk-start_AppBrandProxy", "mService is null! Begin Bind Service!");
        localObject1 = AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.server.AppMainService");
        if (localObject1 == null)
        {
          QMLog.e("minisdk-start_AppBrandProxy", "Can not find AppMainService");
          return false;
        }
        localObject1 = new Intent(this.mContext, (Class)localObject1);
        ((Intent)localObject1).putExtra("mini_process_name", AppLoaderFactory.g().getCurrentProcessName());
        ((Intent)localObject1).putExtra("mini_process_messenger", this.mClientMessenger);
        this.isConnecting = true;
        try
        {
          this.mContext.bindService((Intent)localObject1, this.mConnection, 1);
        }
        catch (Throwable localThrowable)
        {
          QMLog.w("minisdk-start_AppBrandProxy", "exception when bind lbs service!!!", localThrowable);
        }
      }
      return false;
    }
    finally {}
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Messenger handleCmdFromMainProcess cmd=");
    localStringBuilder.append(paramInt);
    QMLog.i("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    if (paramInt != 1001)
    {
      if (paramInt != 1002) {
        return;
      }
      if (paramBundle == null)
      {
        QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE. bundle is null");
        sendResult(paramResultReceiver, -1, paramBundle);
        return;
      }
      notifyPeriodicCacheUpdate(paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    if (paramBundle == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_SHARE_RESULT. bundle is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
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
    try
    {
      boolean bool = this.mNeedSyncStatus;
      if (!bool) {
        return;
      }
      this.mNeedSyncStatus = false;
      try
      {
        String str = AppLoaderFactory.g().getCurrentProcessName();
        if (queryIsMiniProcess())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Sync Process Status=");
          localStringBuilder.append(this.mMiniAppStatus);
          QMLog.w("minisdk-start_AppBrandProxy", localStringBuilder.toString());
          notifyLifeCycleLocked(1, str, this.mAppConfig, this.mStartBundle);
          if (this.mMiniAppStatus == 3) {
            notifyLifeCycleLocked(3, str, this.mAppConfig, null);
          } else if (this.mMiniAppStatus == 2) {
            notifyLifeCycleLocked(2, str, this.mAppConfig, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
      }
      return;
    }
    finally {}
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
  
  public ILaunchManager getService()
  {
    try
    {
      if (this.mService != null)
      {
        localILaunchManager = this.mService;
        return localILaunchManager;
      }
      ensureService();
      ILaunchManager localILaunchManager = this.mService;
      return localILaunchManager;
    }
    finally {}
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateSubscribeJS ON_BACKGROUND_FETCH_DATA appid:");
    localStringBuilder.append(paramMiniAppInfo.appId);
    QMLog.i("minisdk-start_AppBrandProxy", localStringBuilder.toString());
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
    if (localShareState.requestEvent != null) {
      paramMiniAppInfo = localShareState.requestEvent.jsService;
    } else {
      paramMiniAppInfo = paramMiniAppInfo.getJsService();
    }
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      sendResult(paramResultReceiver, -1, paramBundle);
      return;
    }
    if (paramBundle.getInt("key_share_result") == 0) {
      paramBundle = ApiUtil.wrapCallbackOk(localShareState.shareEvent, null);
    } else {
      paramBundle = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
    }
    paramMiniAppInfo.evaluateCallbackJs(localShareState.shareCallbackId, paramBundle.toString());
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
        return;
      }
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppStart");
        notifyLifeCycleLocked(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          return;
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
    }
    else
    {
      this.mMiniAppStatus = paramInt;
      if (getService() == null)
      {
        paramString = new StringBuilder();
        paramString.append("onAppLifecycle IAppBrandService Connection is Null. lifecycle:");
        paramString.append(paramInt);
        QMLog.e("minisdk-start_AppBrandProxy", paramString.toString());
        return;
      }
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notify lifecycle:");
        localStringBuilder.append(paramInt);
        QMLog.i("minisdk-start_AppBrandProxy", localStringBuilder.toString());
        notifyLifeCycleLocked(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          releaseService();
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("onAppLifecycle exception. lifecycle:");
        paramMiniAppInfo.append(paramInt);
        QMLog.e("minisdk-start_AppBrandProxy", paramMiniAppInfo.toString(), paramString);
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
    Object localObject = getService();
    boolean bool2 = false;
    if (localObject == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "queryIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    boolean bool1;
    try
    {
      localObject = this.mService.requestAync("query_mini_process", AppLoaderFactory.g().getCurrentProcessName(), null);
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((Bundle)localObject).getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
      bool1 = bool2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryiIsMiniProcess ");
    localStringBuilder.append(bool1);
    QMLog.i("minisdk-start_AppBrandProxy", localStringBuilder.toString());
    return bool1;
  }
  
  protected void releaseService()
  {
    QMLog.w("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.mService == null) {
        break label40;
      }
      this.mContext.unbindService(this.mConnection);
      this.mService = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      label32:
      label40:
      break label32;
    }
    QMLog.w("minisdk-start_AppBrandProxy", "exception when releaseService.");
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (getService() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendCmd IAppBrandService Connection is Null. cmd=");
      localStringBuilder.append(paramString);
      QMLog.e("minisdk-start_AppBrandProxy", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient
 * JD-Core Version:    0.7.0.1
 */