package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;

final class EnginePackageManager$1
  implements Runnable
{
  public void run()
  {
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 开始请求线上最新版本");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0.0.1", false, true, new EnginePackageManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.1
 * JD-Core Version:    0.7.0.1
 */