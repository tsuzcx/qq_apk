package com.tencent.mobileqq.flashshow.viewmodel.layer;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.request.feed.FSFeedDetailRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.List;

public class FSLayerDetailViewModel$FeedDetailCall
{
  private final FSFeedDetailRequest a;
  private final FSLayerDetailViewModel.GetFeedDetailRspListener b;
  
  public FSLayerDetailViewModel$FeedDetailCall(FSLayerPageInitBean paramFSLayerPageInitBean, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener)
  {
    this.a = new FSFeedDetailRequest(paramFSLayerPageInitBean);
    this.b = paramGetFeedDetailRspListener;
  }
  
  private void a(String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    paramGetFeedDetailRspListener.b(UIStateData.a(bool).a(false, paramStGetFeedDetailRsp).c(true));
    paramString = new ArrayList();
    paramString.add(paramStGetFeedDetailRsp.feed.get());
    FSThreadUtils.d(new FSLayerDetailViewModel.FeedDetailCall.2(this, paramString, paramGetFeedDetailRspListener, bool));
  }
  
  private boolean a(FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener)
  {
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.feed.has())) {
      return false;
    }
    paramGetFeedDetailRspListener.a(UIStateData.a().c(true));
    paramGetFeedDetailRspListener.c(UIStateData.a().c(true));
    return true;
  }
  
  private boolean a(boolean paramBoolean, String paramString, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener)
  {
    if (!paramBoolean)
    {
      paramGetFeedDetailRspListener.a(UIStateData.a(paramString));
      paramGetFeedDetailRspListener.c(UIStateData.a(paramString));
      return true;
    }
    return false;
  }
  
  public void a()
  {
    a(this.a, this.b);
  }
  
  protected void a(FSBaseRequest paramFSBaseRequest, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener)
  {
    paramGetFeedDetailRspListener.a(UIStateData.b());
    VSNetworkHelper.getInstance().sendRequest(paramFSBaseRequest, new FSLayerDetailViewModel.FeedDetailCall.1(this, paramGetFeedDetailRspListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.FeedDetailCall
 * JD-Core Version:    0.7.0.1
 */