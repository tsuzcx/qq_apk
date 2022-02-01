package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IMiniServer
{
  public abstract IBinder getBinder();
  
  public abstract IMiniServiceManager getMiniServiceManager();
  
  public abstract void init(Context paramContext, Configuration paramConfiguration);
  
  public abstract void onHostAppBackground();
  
  public abstract void preloadMiniApp(Bundle paramBundle);
  
  public abstract void registerClientMessenger(String paramString, Messenger paramMessenger);
  
  public abstract boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniServer
 * JD-Core Version:    0.7.0.1
 */