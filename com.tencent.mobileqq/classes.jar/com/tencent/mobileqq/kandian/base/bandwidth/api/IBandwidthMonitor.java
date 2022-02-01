package com.tencent.mobileqq.kandian.base.bandwidth.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/api/IBandwidthMonitor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "start", "", "context", "Landroid/content/Context;", "stop", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBandwidthMonitor
  extends QRouteApi
{
  public abstract void start(@NotNull Context paramContext);
  
  public abstract void stop(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */