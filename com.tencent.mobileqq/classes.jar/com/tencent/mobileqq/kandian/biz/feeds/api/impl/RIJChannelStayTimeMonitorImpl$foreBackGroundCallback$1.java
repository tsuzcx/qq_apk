package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJChannelStayTimeMonitorImpl$foreBackGroundCallback$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "background", "", "foreground", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelStayTimeMonitorImpl$foreBackGroundCallback$1
  implements IForeBackGroundCallback
{
  public void a()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = RIJChannelStayTimeMonitorImpl.access$getCurrentChannel$p(this.a);
    if (localTabChannelCoverInfo != null) {
      this.a.enterChannel(localTabChannelCoverInfo.mChannelCoverId);
    }
  }
  
  public void ax_()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = RIJChannelStayTimeMonitorImpl.access$getCurrentChannel$p(this.a);
    if (localTabChannelCoverInfo != null)
    {
      Object localObject = (CharSequence)localTabChannelCoverInfo.mChannelVersion;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localObject = "0";
      } else {
        localObject = localTabChannelCoverInfo.mChannelVersion;
      }
      this.a.exitChannel(localTabChannelCoverInfo.mChannelCoverId, RIJChannelStayTimeMonitorImpl.access$getCurrentChannelPos$p(this.a), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitorImpl.foreBackGroundCallback.1
 * JD-Core Version:    0.7.0.1
 */