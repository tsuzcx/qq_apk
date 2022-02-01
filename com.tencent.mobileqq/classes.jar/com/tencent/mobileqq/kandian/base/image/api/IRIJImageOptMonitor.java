package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptMonitor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addMonitor", "", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJImageOptMonitor
  extends QRouteApi
{
  public abstract void addMonitor(@Nullable ImageRequest paramImageRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor
 * JD-Core Version:    0.7.0.1
 */