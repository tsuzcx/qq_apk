package com.tencent.mobileqq.minigame.api;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/api/QQMiniDownloader$download$1", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "onDownloadCanceled", "", "p0", "", "onDownloadFailed", "p1", "Lcom/tencent/component/network/downloader/DownloadResult;", "onDownloadProgress", "all", "", "percent", "", "onDownloadSucceed", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class QQMiniDownloader$download$1
  implements Downloader.DownloadListener
{
  QQMiniDownloader$download$1(Downloader.Listener paramListener) {}
  
  public void onDownloadCanceled(@Nullable String paramString)
  {
    Downloader.Listener localListener = this.$listener;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancled ");
    localStringBuilder.append(paramString);
    localListener.onFail(localStringBuilder.toString());
  }
  
  public void onDownloadFailed(@Nullable String paramString, @Nullable DownloadResult paramDownloadResult)
  {
    Downloader.Listener localListener = this.$listener;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramDownloadResult);
    localListener.onFail(localStringBuilder.toString());
  }
  
  public void onDownloadProgress(@Nullable String paramString, long paramLong, float paramFloat)
  {
    this.$listener.onProgress(((float)paramLong * paramFloat), paramLong);
  }
  
  public void onDownloadSucceed(@Nullable String paramString, @Nullable DownloadResult paramDownloadResult)
  {
    this.$listener.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniDownloader.download.1
 * JD-Core Version:    0.7.0.1
 */