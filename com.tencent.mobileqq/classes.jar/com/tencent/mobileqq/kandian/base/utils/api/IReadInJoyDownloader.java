package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDownloader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "pauseDownload", "", "url", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyDownloader
  extends QRouteApi
{
  public abstract void pauseDownload(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDownloader
 * JD-Core Version:    0.7.0.1
 */