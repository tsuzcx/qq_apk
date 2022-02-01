package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.widget.AdapterView;

public abstract interface RIJDynamicChannelGridViewAdapter$DynamicAdapterCallback
  extends RIJBaseChannelGridViewAdapter.AdapterCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter);
  
  public abstract void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt1, int paramInt2);
  
  public abstract void b(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback
 * JD-Core Version:    0.7.0.1
 */