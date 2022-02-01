package com.tencent.qqmini.minigame;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameJsPluginEngine$loadAudioSoAsync$1
  implements Runnable
{
  GameJsPluginEngine$loadAudioSoAsync$1(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public final void run()
  {
    DownloaderProxy localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
    localDownloaderProxy.getWebAudioDownloadPath((DownloaderProxy.WebAudioDownloadListener)new GameJsPluginEngine.loadAudioSoAsync.1.webAudioDownloadListener.1(this));
    localDownloaderProxy.getLameMp3SoDownloadPath((DownloaderProxy.LameMp3SoDownloadListener)new GameJsPluginEngine.loadAudioSoAsync.1.lameMp3SoDownloadListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine.loadAudioSoAsync.1
 * JD-Core Version:    0.7.0.1
 */