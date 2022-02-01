package com.tencent.mobileqq.flashshow.data.interceptor;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.inject.FSToast;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.request.follow.FSDoFollowRequest;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowReq;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class FSFollowRspInterceptor
  implements RspInterceptor<FSBaseRequest, BaseSenderChain>
{
  public static String a = "req_extra_key_new_follow_state";
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    int i = paramBaseSenderChain.b().getInt(a);
    if ((paramBoolean) && (paramLong == 0L) && (paramObject != null))
    {
      if (((paramObject instanceof FeedCloudWrite.StDoFollowRsp)) && ((paramFSBaseRequest instanceof FSDoFollowRequest)))
      {
        FSDoFollowRequest localFSDoFollowRequest = (FSDoFollowRequest)paramFSBaseRequest;
        String str = localFSDoFollowRequest.getRequest().user.id.get();
        FSDataCenter.a().a(str, i);
        if (!FSCommonUtil.a(i)) {
          SimpleEventBus.getInstance().dispatchEvent(new FSFeedEvent(2).setUin(localFSDoFollowRequest.getRequest().user.id.get()));
        } else {
          SimpleEventBus.getInstance().dispatchEvent(new FSFeedEvent(3).setUin(localFSDoFollowRequest.getRequest().user.id.get()));
        }
      }
    }
    else
    {
      int j = FSToast.c;
      if (FSCommonUtil.a(i)) {
        i = 2131889715;
      } else {
        i = 2131889703;
      }
      FSToast.a(j, i, 0);
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramFSBaseRequest, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.interceptor.FSFollowRspInterceptor
 * JD-Core Version:    0.7.0.1
 */