package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJChannelStayTimeMonitor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "endMonitor", "", "enterChannel", "channelId", "", "exitChannel", "pos", "channelVersion", "", "isChannelShow", "", "isLastExitChannelOverTimeLimit", "onAccountChanged", "onChannelChanged", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "curPos", "startMonitor", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJChannelStayTimeMonitor
  extends QRouteApi
{
  public abstract void endMonitor();
  
  public abstract void enterChannel(int paramInt);
  
  public abstract void exitChannel(int paramInt1, int paramInt2, @Nullable String paramString);
  
  public abstract boolean isChannelShow(int paramInt);
  
  public abstract boolean isLastExitChannelOverTimeLimit(int paramInt);
  
  public abstract void onAccountChanged();
  
  public abstract void onChannelChanged(@Nullable TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt);
  
  public abstract void startMonitor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor
 * JD-Core Version:    0.7.0.1
 */