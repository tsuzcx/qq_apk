package com.tencent.mobileqq.kandian.base.bandwidth.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/api/impl/BandwidthMonitorImpl;", "Lcom/tencent/mobileqq/kandian/base/bandwidth/api/IBandwidthMonitor;", "()V", "start", "", "context", "Landroid/content/Context;", "stop", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BandwidthMonitorImpl
  implements IBandwidthMonitor
{
  public void start(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.start(paramContext);
  }
  
  public void stop(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.stop(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.api.impl.BandwidthMonitorImpl
 * JD-Core Version:    0.7.0.1
 */