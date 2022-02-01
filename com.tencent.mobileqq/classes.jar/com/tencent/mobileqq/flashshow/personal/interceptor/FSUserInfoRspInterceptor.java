package com.tencent.mobileqq.flashshow.personal.interceptor;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

public class FSUserInfoRspInterceptor
  implements RspInterceptor<FSBaseRequest, BaseSenderChain>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramObject != null))
    {
      if ((paramObject instanceof FeedCloudRead.StGetMainPageRsp)) {
        FSThreadUtils.a(new FSUserInfoRspInterceptor.1(this, (FeedCloudRead.StGetMainPageRsp)paramObject, paramString, paramBaseSenderChain, paramLong, paramFSBaseRequest));
      }
    }
    else {
      paramBaseSenderChain.b(paramBoolean, paramLong, paramString, paramFSBaseRequest, null);
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramFSBaseRequest, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSUserInfoRspInterceptor
 * JD-Core Version:    0.7.0.1
 */