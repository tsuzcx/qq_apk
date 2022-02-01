package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerService$5
  implements Runnable
{
  LaunchManagerService$5(LaunchManagerService paramLaunchManagerService) {}
  
  public void run()
  {
    MiniAppCacheProxy localMiniAppCacheProxy = (MiniAppCacheProxy)ProxyManager.get(MiniAppCacheProxy.class);
    if ((localMiniAppCacheProxy != null) && (localMiniAppCacheProxy.enableMiniAppCache()) && (localMiniAppCacheProxy.deleteCacheByTimeStamp(System.currentTimeMillis() - localMiniAppCacheProxy.getDeleteIntervalTime()))) {
      QMLog.d("minisdk-start_LaunchManagerService", "deleteCacheByTimeStamp success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.5
 * JD-Core Version:    0.7.0.1
 */