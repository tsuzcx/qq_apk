package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onWebAudioSoDownloadSucceed"}, k=3, mv={1, 1, 16})
final class QQMiniScriptPlugin$onCreate$listener$1
  implements DownloaderProxy.WebAudioDownloadListener
{
  QQMiniScriptPlugin$onCreate$listener$1(QQMiniScriptPlugin paramQQMiniScriptPlugin) {}
  
  public final void onWebAudioSoDownloadSucceed(String paramString)
  {
    WebAudioPlugin localWebAudioPlugin = QQMiniScriptPlugin.access$getWebAudio$p(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "it");
    localWebAudioPlugin.setWebAudioSoPath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniScriptPlugin.onCreate.listener.1
 * JD-Core Version:    0.7.0.1
 */