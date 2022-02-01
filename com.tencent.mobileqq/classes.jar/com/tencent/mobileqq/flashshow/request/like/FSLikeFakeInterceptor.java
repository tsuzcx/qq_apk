package com.tencent.mobileqq.flashshow.request.like;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.events.FSFeedLikeStateUpdateEvent;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.request.base.FSFakeInterceptor;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class FSLikeFakeInterceptor
  extends FSFakeInterceptor
{
  public FSLikeFakeInterceptor(boolean paramBoolean, Object paramObject)
  {
    super(paramBoolean, paramObject);
  }
  
  public void a(FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramFSBaseRequest instanceof FSLikeRequest))
    {
      paramObject = (FSLikeRequest)paramFSBaseRequest;
      paramFSBaseRequest = paramObject.getFeed();
      int k = paramObject.getLikeType();
      int j = paramFSBaseRequest.likeInfo.count.get();
      int i;
      if (k == 1)
      {
        i = j;
        if (paramFSBaseRequest.likeInfo.status.get() != k) {
          i = j + 1;
        }
      }
      else
      {
        i = j;
        if (k == 0) {
          i = j - 1;
        }
      }
      paramObject = FSDataCenter.a().a(FeedCloudMeta.StFeed.class, paramFSBaseRequest.id.get());
      if (paramObject == null)
      {
        QLog.d("FSLikeFakeInterceptor", 1, "[startFake] mutable live data should not be null.");
        return;
      }
      paramBaseSenderChain = (FeedCloudMeta.StFeed)paramObject.getValue();
      paramBaseSenderChain.likeInfo.setHasFlag(true);
      paramBaseSenderChain.likeInfo.count.set(i);
      paramBaseSenderChain.likeInfo.status.set(k);
      paramObject.postValue(paramBaseSenderChain);
      FSDataCenter.a().a("FSFeedDataStore", new FSFeedData(paramFSBaseRequest));
      paramFSBaseRequest = new FSFeedLikeStateUpdateEvent(paramFSBaseRequest.id.get(), k);
      SimpleEventBus.getInstance().dispatchEvent(paramFSBaseRequest);
    }
  }
  
  public void a(FSBaseRequest paramFSBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.like.FSLikeFakeInterceptor
 * JD-Core Version:    0.7.0.1
 */