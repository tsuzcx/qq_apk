package com.tencent.mobileqq.flashshow.viewmodel.layer;

import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.List;

abstract interface FSLayerDetailViewModel$GetFeedDetailRspListener
{
  public abstract void a(UIStateData<FeedCloudRead.StGetFeedDetailRsp> paramUIStateData);
  
  public abstract void b(UIStateData<FeedCloudRead.StGetFeedDetailRsp> paramUIStateData);
  
  public abstract void c(UIStateData<List<FSFeedData>> paramUIStateData);
  
  public abstract void d(UIStateData<List<FSFeedData>> paramUIStateData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.GetFeedDetailRspListener
 * JD-Core Version:    0.7.0.1
 */