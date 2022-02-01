package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerService$3
  implements Runnable
{
  LaunchManagerService$3(LaunchManagerService paramLaunchManagerService) {}
  
  public void run()
  {
    QMLog.i("minisdk-start_LaunchManagerService", "zzconfig start to loadServer");
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy != null) {
      localWnsConfigProxy.loadConfigFromServer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.3
 * JD-Core Version:    0.7.0.1
 */