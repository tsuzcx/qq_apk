package com.tencent.qqmini.sdk.server;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager.Stub;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.concurrent.ExecutorService;

public class LaunchManagerService$ServiceBinder
  extends ILaunchManager.Stub
{
  public LaunchManagerService$ServiceBinder(LaunchManagerService paramLaunchManagerService) {}
  
  public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_LaunchManagerService", "handleAppLifecycle lifecycle:" + paramInt + " process:" + paramString + " miniAppInfo is null");
      return;
    }
    QMLog.i("minisdk-start_LaunchManagerService", "handleAppLifecycle lifecycle:" + paramInt + " process:" + paramString + " miniAppInfo:" + paramMiniAppInfo);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      try
      {
        this.this$0.onAppStart(paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "onAppLifecycle() called with: lifecycle = [" + paramInt + "], processName = [" + paramString + "], miniAppInfo = [" + paramMiniAppInfo + "], bundle = [" + paramBundle + "]");
        if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
          ThreadPools.getComputationThreadPool().execute(new LaunchManagerService.ServiceBinder.1(this, localThrowable));
        }
        throw new RuntimeException(localThrowable);
      }
    case 4: 
      this.this$0.onAppStop(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 2: 
      this.this$0.onAppForeground(paramString, paramMiniAppInfo, paramBundle);
      return;
    }
    this.this$0.onAppBackground(paramString, paramMiniAppInfo, paramBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo) {}
  
  public Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_LaunchManagerService", "requestAync cmd:" + paramString1 + " process:" + paramString2);
    try
    {
      if ("query_mini_process".equals(paramString1))
      {
        boolean bool = LaunchManagerService.access$200(this.this$0, paramString2);
        paramString1 = new Bundle();
        paramString1.putBoolean("key_result", bool);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "requestAync exception!", paramString1);
    }
    return null;
  }
  
  public void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    try
    {
      if ("cmd_notify_runtime_info".equals(paramString1))
      {
        this.this$0.onRecvCommand(paramString1, paramString2, paramBundle);
        if (paramMiniCmdCallback == null) {
          return;
        }
        paramMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      if ("cmd_notify_runtime_lifecycle".equals(paramString1))
      {
        this.this$0.onRecvCommand(paramString1, paramString2, paramBundle);
        if (paramMiniCmdCallback == null) {
          return;
        }
        paramMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmd exception!", paramString1);
      return;
    }
    MiniAppCmdServlet.g().onMiniAppCmd(paramString1, paramBundle, paramMiniCmdCallback);
  }
  
  public void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    this.this$0.startMiniApp(null, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    this.this$0.stopAllMiniApp();
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    this.this$0.stopMiniApp(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.ServiceBinder
 * JD-Core Version:    0.7.0.1
 */