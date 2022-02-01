package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownloadFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "create", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoWebPreDownloadFactory
  extends QRouteApi
{
  @NotNull
  public abstract IVideoWebPreDownload create();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownloadFactory
 * JD-Core Version:    0.7.0.1
 */