package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniDownloader;", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "()V", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniDownloader
  implements Downloader
{
  public static final MiniDownloader INSTANCE = new MiniDownloader();
  
  public void download(@NotNull String paramString, @NotNull File paramFile, @NotNull Downloader.Listener paramListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramFile, "toPath");
    Intrinsics.checkParameterIsNotNull(paramListener, "listener");
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, paramFile.getAbsolutePath(), 30, (DownloaderProxy.DownloadListener)new MiniDownloader.download.1(paramListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniDownloader
 * JD-Core Version:    0.7.0.1
 */