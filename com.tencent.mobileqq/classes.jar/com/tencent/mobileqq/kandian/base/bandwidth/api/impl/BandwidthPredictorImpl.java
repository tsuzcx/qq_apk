package com.tencent.mobileqq.kandian.base.bandwidth.api.impl;

import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthPredictor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/api/impl/BandwidthPredictorImpl;", "Lcom/tencent/mobileqq/kandian/base/bandwidth/api/IBandwidthPredictor;", "()V", "getCurrentPrediction", "", "getLastBandwidth", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BandwidthPredictorImpl
  implements IBandwidthPredictor
{
  public BandwidthPredictorImpl()
  {
    BandwidthPredictor localBandwidthPredictor = BandwidthPredictor.from();
    Intrinsics.checkExpressionValueIsNotNull(localBandwidthPredictor, "BandwidthPredictor.from()");
    this.$$delegate_0 = localBandwidthPredictor;
  }
  
  public long getCurrentPrediction()
  {
    return this.$$delegate_0.getCurrentPrediction();
  }
  
  public long getLastBandwidth()
  {
    return this.$$delegate_0.getLastBandwidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.api.impl.BandwidthPredictorImpl
 * JD-Core Version:    0.7.0.1
 */