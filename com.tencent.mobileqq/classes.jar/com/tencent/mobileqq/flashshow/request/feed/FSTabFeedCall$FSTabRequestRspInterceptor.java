package com.tencent.mobileqq.flashshow.request.feed;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class FSTabFeedCall$FSTabRequestRspInterceptor
  implements RspInterceptor<FSBaseRequest, BaseSenderChain>
{
  FSTabFeedCall.Param a;
  
  public FSTabFeedCall$FSTabRequestRspInterceptor(FSTabFeedCall paramFSTabFeedCall, FSTabFeedCall.Param paramParam)
  {
    this.a = paramParam;
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    paramBaseSenderChain = new StringBuilder();
    paramBaseSenderChain.append(" | Cmd = ");
    paramBaseSenderChain.append(paramFSBaseRequest.getCmdName());
    paramBaseSenderChain.append(" | TraceId:");
    paramBaseSenderChain.append(paramFSBaseRequest.getTraceId());
    paramBaseSenderChain.append(" | SeqId:");
    paramBaseSenderChain.append(paramFSBaseRequest.getCurrentSeq());
    paramBaseSenderChain.append(" | isSuc = ");
    paramBaseSenderChain.append(paramBoolean);
    paramBaseSenderChain.append(" | retCode = ");
    paramBaseSenderChain.append(paramLong);
    paramBaseSenderChain.append(" | errMsg = ");
    paramBaseSenderChain.append(paramString);
    paramFSBaseRequest = paramBaseSenderChain.toString();
    paramBaseSenderChain = new StringBuilder();
    paramBaseSenderChain.append("interceptReturnRsp recv rsp");
    paramBaseSenderChain.append(paramFSBaseRequest);
    QLog.d("FSTabFeedCall", 1, paramBaseSenderChain.toString());
    if (((!paramBoolean) || (paramLong != 0L) || (paramObject == null)) && (FSTabFeedCall.a(this.b, paramBoolean, paramString, this.a))) {
      return;
    }
    if ((paramObject instanceof FeedCloudRead.StGetFeedListRsp))
    {
      paramFSBaseRequest = this.b;
      paramObject = (FeedCloudRead.StGetFeedListRsp)paramObject;
      if (FSTabFeedCall.a(paramFSBaseRequest, paramObject, this.a)) {
        return;
      }
      FSTabFeedCall.a(this.b, paramString, paramObject, this.a);
      return;
    }
    QLog.e("FSTabFeedCall", 1, "interceptReturnRsp recv invalid rsp object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.FSTabRequestRspInterceptor
 * JD-Core Version:    0.7.0.1
 */