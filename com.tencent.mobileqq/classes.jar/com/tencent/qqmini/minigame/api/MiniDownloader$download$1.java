package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/api/MiniDownloader$download$1", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;", "onDownloadFailed", "", "statusCode", "", "errorMsg", "", "onDownloadHeadersReceived", "headers", "", "", "onDownloadProgress", "progress", "", "totalBytesWritten", "", "totalBytesExpectedToWrite", "onDownloadSucceed", "filePath", "result", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniDownloader$download$1
  implements DownloaderProxy.DownloadListener
{
  MiniDownloader$download$1(Downloader.Listener paramListener) {}
  
  public void onDownloadFailed(int paramInt, @Nullable String paramString)
  {
    Downloader.Listener localListener = this.$listener;
    if (paramString == null) {
      paramString = "unknown failure";
    }
    localListener.onFail(paramString);
  }
  
  public void onDownloadHeadersReceived(int paramInt, @Nullable Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    this.$listener.onProgress(paramLong2, paramLong1);
  }
  
  public void onDownloadSucceed(int paramInt, @Nullable String paramString, @Nullable DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    this.$listener.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniDownloader.download.1
 * JD-Core Version:    0.7.0.1
 */