package com.tencent.mobileqq.kandian.base.bandwidth;

import com.tencent.superplayer.api.ISPBandwidthMonitor.Callback;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Stat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor$Stat;", "", "onBandwidthUpdate"}, k=3, mv={1, 1, 16})
final class BandwidthMonitor$start$1
  implements ISPBandwidthMonitor.Callback
{
  public static final 1 a = new 1();
  
  public final void onBandwidthUpdate(Map<String, ISPBandwidthMonitor.Stat> paramMap)
  {
    BandwidthMonitor localBandwidthMonitor = BandwidthMonitor.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "it");
    BandwidthMonitor.access$dealCallback(localBandwidthMonitor, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor.start.1
 * JD-Core Version:    0.7.0.1
 */