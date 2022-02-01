package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IAppMainService
  extends IInterface
{
  public abstract void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void preloadMiniApp();
  
  public abstract Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback);
  
  public abstract void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void stopAllMiniApp();
  
  public abstract void stopMiniApp(MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
 * JD-Core Version:    0.7.0.1
 */