package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJChannelStayTimeMonitorImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJChannelStayTimeMonitor;", "()V", "endMonitor", "", "enterChannel", "channelId", "", "exitChannel", "pos", "channelVersion", "", "isChannelShow", "", "isLastExitChannelOverTimeLimit", "onAccountChanged", "onChannelChanged", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "curPos", "startMonitor", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelStayTimeMonitorImpl
  implements IRIJChannelStayTimeMonitor
{
  public void endMonitor()
  {
    this.$$delegate_0.endMonitor();
  }
  
  public void enterChannel(int paramInt)
  {
    this.$$delegate_0.enterChannel(paramInt);
  }
  
  public void exitChannel(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    this.$$delegate_0.exitChannel(paramInt1, paramInt2, paramString);
  }
  
  public boolean isChannelShow(int paramInt)
  {
    return this.$$delegate_0.isChannelShow(paramInt);
  }
  
  public boolean isLastExitChannelOverTimeLimit(int paramInt)
  {
    return this.$$delegate_0.isLastExitChannelOverTimeLimit(paramInt);
  }
  
  public void onAccountChanged()
  {
    this.$$delegate_0.onAccountChanged();
  }
  
  public void onChannelChanged(@Nullable TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    this.$$delegate_0.onChannelChanged(paramTabChannelCoverInfo, paramInt);
  }
  
  public void startMonitor()
  {
    this.$$delegate_0.startMonitor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitorImpl
 * JD-Core Version:    0.7.0.1
 */