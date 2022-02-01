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
    if ((paramMiniAppInfo == null) && (paramInt != 1))
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("handleAppLifecycle lifecycle:");
      paramMiniAppInfo.append(paramInt);
      paramMiniAppInfo.append(" process:");
      paramMiniAppInfo.append(paramString);
      paramMiniAppInfo.append(" miniAppInfo is null");
      QMLog.w("minisdk-start_LaunchManagerService", paramMiniAppInfo.toString());
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("handleAppLifecycle lifecycle:");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append(" process:");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" miniAppInfo:");
    localStringBuilder1.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder1.toString());
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            return;
          }
        }
      }
    }
    try
    {
      this.this$0.onAppStop(paramString, paramMiniAppInfo, paramBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onAppLifecycle() called with: lifecycle = [");
      localStringBuilder2.append(paramInt);
      localStringBuilder2.append("], processName = [");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("], miniAppInfo = [");
      localStringBuilder2.append(paramMiniAppInfo);
      localStringBuilder2.append("], bundle = [");
      localStringBuilder2.append(paramBundle);
      localStringBuilder2.append("]");
      QMLog.e("minisdk-start_LaunchManagerService", localStringBuilder2.toString());
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
        break label315;
      }
      ThreadPools.getComputationThreadPool().execute(new LaunchManagerService.ServiceBinder.1(this, localThrowable));
      throw new RuntimeException(localThrowable);
    }
    this.this$0.onAppBackground(paramString, paramMiniAppInfo, paramBundle);
    return;
    this.this$0.onAppForeground(paramString, paramMiniAppInfo, paramBundle);
    return;
    this.this$0.onAppStart(paramString, paramMiniAppInfo, paramBundle);
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    this.this$0.preDownloadPkg(paramMiniAppInfo, paramResultReceiver);
  }
  
  public Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("requestAync cmd:");
    paramBundle.append(paramString1);
    paramBundle.append(" process:");
    paramBundle.append(paramString2);
    QMLog.i("minisdk-start_LaunchManagerService", paramBundle.toString());
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
        if (paramMiniCmdCallback != null) {
          paramMiniCmdCallback.onCmdResult(true, new Bundle());
        }
      }
      else
      {
        if ("cmd_notify_runtime_lifecycle".equals(paramString1))
        {
          this.this$0.onRecvCommand(paramString1, paramString2, paramBundle);
          if (paramMiniCmdCallback == null) {
            return;
          }
          paramMiniCmdCallback.onCmdResult(true, new Bundle());
          return;
        }
        MiniAppCmdServlet.g().onMiniAppCmd(paramString1, paramBundle, paramMiniCmdCallback);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmd exception!", paramString1);
      return;
    }
    return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.ServiceBinder
 * JD-Core Version:    0.7.0.1
 */