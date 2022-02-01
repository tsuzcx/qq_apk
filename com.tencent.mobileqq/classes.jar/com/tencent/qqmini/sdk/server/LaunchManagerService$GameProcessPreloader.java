package com.tencent.qqmini.sdk.server;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.server.launch.ProcessPreloader;
import org.jetbrains.annotations.NotNull;

class LaunchManagerService$GameProcessPreloader
  implements ProcessPreloader
{
  private LaunchManagerService$GameProcessPreloader(LaunchManagerService paramLaunchManagerService) {}
  
  public void performPreloadProcess(@NotNull MiniProcessorConfig paramMiniProcessorConfig)
  {
    paramMiniProcessorConfig = new Intent(LaunchManagerService.access$100(this.this$0), paramMiniProcessorConfig.appPreLoadClass);
    paramMiniProcessorConfig.setAction("mini_preload_game");
    paramMiniProcessorConfig.putExtra("sdk_mode", true);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    paramMiniProcessorConfig.putExtra("KEY_LOGININFO", new LoginInfo(localMiniAppProxy.getLoginType(), localMiniAppProxy.getAccount(), localMiniAppProxy.getNickName(), localMiniAppProxy.getPayOpenId(), localMiniAppProxy.getPayOpenKey(), localMiniAppProxy.getPayAccessToken(), localMiniAppProxy.getLoginSig(), localMiniAppProxy.getPlatformId(), localMiniAppProxy.getAppId()));
    paramMiniProcessorConfig.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
    paramMiniProcessorConfig.putExtra("time_start_broadcast", System.currentTimeMillis());
    LaunchManagerService.access$100(this.this$0).sendBroadcast(paramMiniProcessorConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.GameProcessPreloader
 * JD-Core Version:    0.7.0.1
 */