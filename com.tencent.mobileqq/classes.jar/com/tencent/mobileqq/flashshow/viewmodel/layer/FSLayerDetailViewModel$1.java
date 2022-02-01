package com.tencent.mobileqq.flashshow.viewmodel.layer;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.List;

class FSLayerDetailViewModel$1
  implements FSLayerDetailViewModel.GetFeedDetailRspListener
{
  FSLayerDetailViewModel$1(FSLayerDetailViewModel paramFSLayerDetailViewModel) {}
  
  public void a(UIStateData<FeedCloudRead.StGetFeedDetailRsp> paramUIStateData)
  {
    FSLayerDetailViewModel.a(this.a).postValue(paramUIStateData);
  }
  
  public void b(UIStateData<FeedCloudRead.StGetFeedDetailRsp> paramUIStateData)
  {
    FSLayerDetailViewModel.a(this.a).postValue(paramUIStateData);
  }
  
  public void c(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    FSLayerDetailViewModel.b(this.a).postValue(paramUIStateData);
  }
  
  public void d(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    FSLayerDetailViewModel.b(this.a).postValue(paramUIStateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.1
 * JD-Core Version:    0.7.0.1
 */