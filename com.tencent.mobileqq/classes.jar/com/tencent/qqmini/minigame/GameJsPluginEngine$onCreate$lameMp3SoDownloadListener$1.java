package com.tencent.qqmini.minigame;

import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.LameMp3SoDownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onLameMp3SoDownloadSucceed"}, k=3, mv={1, 1, 16})
final class GameJsPluginEngine$onCreate$lameMp3SoDownloadListener$1
  implements DownloaderProxy.LameMp3SoDownloadListener
{
  GameJsPluginEngine$onCreate$lameMp3SoDownloadListener$1(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public final void onLameMp3SoDownloadSucceed(String paramString)
  {
    GameRuntime localGameRuntime = GameJsPluginEngine.access$getGameRuntime$p(this.this$0);
    if (localGameRuntime == null) {
      Intrinsics.throwNpe();
    }
    AudioRecorderJsPlugin.setLameMp3SoPath(localGameRuntime.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine.onCreate.lameMp3SoDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */