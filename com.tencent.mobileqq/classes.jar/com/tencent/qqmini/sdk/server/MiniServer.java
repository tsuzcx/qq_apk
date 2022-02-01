package com.tencent.qqmini.sdk.server;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.Configuration.ProcessInfo;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@MiniKeep
public class MiniServer
  implements IMiniServer
{
  private static final String TAG = "MiniServer";
  private Context mContext;
  private final LaunchManagerService mLaunchManagerService = new LaunchManagerService();
  private final IMiniServiceManager mMiniServiceManager = MiniServiceManagerService.asInterface();
  
  public static final MiniServer g()
  {
    return (MiniServer)AppLoaderFactory.g().getMiniServer();
  }
  
  private void processConfiguration(Configuration paramConfiguration)
  {
    if (this.mContext == null)
    {
      QMLog.e("MiniServer", "processConfiguration with Context is null!");
      return;
    }
    if (paramConfiguration == null)
    {
      QMLog.e("MiniServer", "processConfiguration with Configuration is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramConfiguration = paramConfiguration.processInfoList.iterator();
    while (paramConfiguration.hasNext())
    {
      Object localObject = (Configuration.ProcessInfo)paramConfiguration.next();
      localObject = new MiniProcessorConfig(((Configuration.ProcessInfo)localObject).processType, ((Configuration.ProcessInfo)localObject).name, ((Configuration.ProcessInfo)localObject).uiClass, ((Configuration.ProcessInfo)localObject).internalUIClass, ((Configuration.ProcessInfo)localObject).receiverClass, ((Configuration.ProcessInfo)localObject).supportRuntimeType);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createConfiguration. Add processor config: ");
      localStringBuilder.append(localObject);
      QMLog.i("MiniServer", localStringBuilder.toString());
      localArrayList.add(localObject);
    }
    this.mLaunchManagerService.registerProcessInfo(localArrayList);
  }
  
  private void registerMiniServices()
  {
    try
    {
      this.mLaunchManagerService.init(this.mContext);
      this.mMiniServiceManager.addService("LAUNCH_SERVICE", this.mLaunchManagerService.getBinder());
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public IBinder getBinder()
  {
    return this.mLaunchManagerService.getBinder();
  }
  
  public LaunchManagerService getLaunchManagerService()
  {
    return this.mLaunchManagerService;
  }
  
  public MiniServiceFetcher getMiniServiceFetcher()
  {
    return new MiniServiceFetcher(this.mMiniServiceManager);
  }
  
  public IMiniServiceManager getMiniServiceManager()
  {
    return this.mMiniServiceManager;
  }
  
  public void init(Context paramContext, Configuration paramConfiguration)
  {
    try
    {
      if (this.mContext != null)
      {
        QMLog.d("MiniServer", "Already initialized");
        return;
      }
      if (paramContext == null)
      {
        QMLog.e("MiniServer", "Failed to init MiniServer. context is null");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Init MiniServer. MiniSdkVersion:1.15.0_944_fdf6368 QUA:");
      localStringBuilder.append(QUAUtil.getQUA());
      localStringBuilder.append(" PlatformQUA:");
      localStringBuilder.append(QUAUtil.getPlatformQUA());
      QMLog.i("MiniServer", localStringBuilder.toString());
      this.mContext = paramContext;
      processConfiguration(paramConfiguration);
      registerMiniServices();
      return;
    }
    finally {}
  }
  
  public void onHostAppBackground()
  {
    this.mLaunchManagerService.onHostAppBackground();
  }
  
  public void preloadMiniApp(Bundle paramBundle)
  {
    this.mLaunchManagerService.preloadMiniApp(paramBundle);
  }
  
  public void registerClientMessenger(String paramString, Messenger paramMessenger)
  {
    this.mLaunchManagerService.registerClientMessenger(paramString, paramMessenger);
  }
  
  public boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    return this.mLaunchManagerService.sendCmdToMiniProcess(paramInt, paramBundle, paramMiniAppInfo, paramResultReceiver);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    this.mLaunchManagerService.startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.MiniServer
 * JD-Core Version:    0.7.0.1
 */