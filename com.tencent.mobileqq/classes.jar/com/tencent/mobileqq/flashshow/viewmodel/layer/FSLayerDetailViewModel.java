package com.tencent.mobileqq.flashshow.viewmodel.layer;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.List;

public class FSLayerDetailViewModel
{
  private final MutableLiveData<UIStateData<FeedCloudRead.StGetFeedDetailRsp>> a = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FSFeedData>>> b = new MutableLiveData();
  
  public MutableLiveData<UIStateData<FeedCloudRead.StGetFeedDetailRsp>> a()
  {
    return this.a;
  }
  
  public FSLayerDetailViewModel.FeedDetailCall a(FSLayerPageInitBean paramFSLayerPageInitBean)
  {
    return new FSLayerDetailViewModel.FeedDetailCall(paramFSLayerPageInitBean, new FSLayerDetailViewModel.1(this));
  }
  
  public MutableLiveData<UIStateData<List<FSFeedData>>> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel
 * JD-Core Version:    0.7.0.1
 */