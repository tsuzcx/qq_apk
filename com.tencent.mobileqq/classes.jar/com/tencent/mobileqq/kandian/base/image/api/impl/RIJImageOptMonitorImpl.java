package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/impl/RIJImageOptMonitorImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptMonitor;", "()V", "addMonitor", "", "imageRequest", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJImageOptMonitorImpl
  implements IRIJImageOptMonitor
{
  public void addMonitor(@Nullable ImageRequest paramImageRequest)
  {
    RIJImageOptMonitor.a(paramImageRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.RIJImageOptMonitorImpl
 * JD-Core Version:    0.7.0.1
 */