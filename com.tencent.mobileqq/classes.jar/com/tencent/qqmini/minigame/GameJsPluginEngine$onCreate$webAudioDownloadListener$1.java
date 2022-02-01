package com.tencent.qqmini.minigame;

import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onWebAudioSoDownloadSucceed"}, k=3, mv={1, 1, 16})
final class GameJsPluginEngine$onCreate$webAudioDownloadListener$1
  implements DownloaderProxy.WebAudioDownloadListener
{
  GameJsPluginEngine$onCreate$webAudioDownloadListener$1(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public final void onWebAudioSoDownloadSucceed(String paramString)
  {
    WebAudioPlugin localWebAudioPlugin = GameJsPluginEngine.access$getWebAudio$p(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "it");
    localWebAudioPlugin.setWebAudioSoPath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine.onCreate.webAudioDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */