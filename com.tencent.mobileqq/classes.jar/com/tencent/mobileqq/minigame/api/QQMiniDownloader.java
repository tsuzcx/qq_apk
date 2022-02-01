package com.tencent.mobileqq.minigame.api;

import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniDownloader;", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "()V", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class QQMiniDownloader
  implements Downloader
{
  public static final QQMiniDownloader INSTANCE = new QQMiniDownloader();
  
  public void download(@NotNull String paramString, @NotNull File paramFile, @NotNull Downloader.Listener paramListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramFile, "toPath");
    Intrinsics.checkParameterIsNotNull(paramListener, "listener");
    MiniappDownloadUtil.getInstance().download(paramString, paramFile.getAbsolutePath(), true, (Downloader.DownloadListener)new QQMiniDownloader.download.1(paramListener), Downloader.DownloadMode.FastMode, null);
    paramListener = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", to:");
    localStringBuilder.append(paramFile);
    paramListener.i("[download]", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniDownloader
 * JD-Core Version:    0.7.0.1
 */