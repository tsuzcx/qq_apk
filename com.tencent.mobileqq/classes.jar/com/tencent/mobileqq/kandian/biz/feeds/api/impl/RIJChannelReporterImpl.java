package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJChannelReporterImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJChannelReporter;", "()V", "reportForEnterChannel", "", "channelId", "", "source", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelReporterImpl
  implements IRIJChannelReporter
{
  public void reportForEnterChannel(int paramInt, @Nullable String paramString)
  {
    RIJChannelReporter.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelReporterImpl
 * JD-Core Version:    0.7.0.1
 */