package com.tencent.mobileqq.vas.download.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/download/api/impl/DownloaderFactoryImpl;", "Lcom/tencent/mobileqq/vas/download/api/IDownloaderFactory;", "()V", "download", "", "tsk", "Lcom/tencent/mobileqq/vip/DownloadTask;", "app", "Lmqq/app/AppRuntime;", "getDownloader", "Lcom/tencent/mobileqq/vip/DownloaderInterface;", "type", "unzipResource", "", "zipFile", "Ljava/io/File;", "dstDir", "delSrc", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DownloaderFactoryImpl
  implements IDownloaderFactory
{
  public int download(@NotNull DownloadTask paramDownloadTask, @NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "tsk");
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    return DownloaderFactory.a(paramDownloadTask, paramAppRuntime);
  }
  
  @NotNull
  public DownloaderInterface getDownloader(int paramInt)
  {
    Object localObject3 = (DownloaderFactory)null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface))
      {
        localObject1 = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (localObject1 != null) {
          break label87;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vip.DownloaderFactory");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = localObject3;
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new DownloaderFactory(MobileQQ.sMobileQQ.peekAppRuntime());
      }
      localObject2 = ((DownloaderFactory)localObject3).a(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mDownloaderFactory.getDownloader(type)");
      return localObject2;
      label87:
      localObject2 = (DownloaderFactory)localObject2;
    }
  }
  
  public boolean unzipResource(@Nullable File paramFile1, @Nullable File paramFile2, boolean paramBoolean)
  {
    return DownloaderFactory.a(paramFile1, paramFile2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.download.api.impl.DownloaderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */