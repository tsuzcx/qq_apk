package com.tencent.mobileqq.vas.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/download/api/IDownloaderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "download", "", "tsk", "Lcom/tencent/mobileqq/vip/DownloadTask;", "app", "Lmqq/app/AppRuntime;", "getDownloader", "Lcom/tencent/mobileqq/vip/DownloaderInterface;", "type", "unzipResource", "", "zipFile", "Ljava/io/File;", "dstDir", "delSrc", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IDownloaderFactory
  extends QRouteApi
{
  public abstract int download(@NotNull DownloadTask paramDownloadTask, @NotNull AppRuntime paramAppRuntime);
  
  @NotNull
  public abstract DownloaderInterface getDownloader(int paramInt);
  
  public abstract boolean unzipResource(@Nullable File paramFile1, @Nullable File paramFile2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.download.api.IDownloaderFactory
 * JD-Core Version:    0.7.0.1
 */