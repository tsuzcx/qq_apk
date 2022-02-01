package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.download.ReadInJoyDownloader;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyDownloaderImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDownloader;", "()V", "pauseDownload", "", "url", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyDownloaderImpl
  implements IReadInJoyDownloader
{
  public ReadInJoyDownloaderImpl()
  {
    ReadInJoyDownloader localReadInJoyDownloader = ReadInJoyDownloader.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyDownloader, "ReadInJoyDownloader.getInstance()");
    this.$$delegate_0 = localReadInJoyDownloader;
  }
  
  public void pauseDownload(@Nullable String paramString)
  {
    this.$$delegate_0.pauseDownload(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ReadInJoyDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */