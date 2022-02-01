package com.tencent.mobileqq.flashshow.personal.interceptor;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class FSUserInfoRspInterceptor$1
  implements Runnable
{
  FSUserInfoRspInterceptor$1(FSUserInfoRspInterceptor paramFSUserInfoRspInterceptor, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, String paramString, BaseSenderChain paramBaseSenderChain, long paramLong, FSBaseRequest paramFSBaseRequest) {}
  
  public void run()
  {
    FSPersonalInfo localFSPersonalInfo = FSPersonalInfo.a(this.a);
    localFSPersonalInfo.k = VSNetworkHelper.isProtocolCache(this.b);
    FSThreadUtils.b(new FSUserInfoRspInterceptor.1.1(this, localFSPersonalInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSUserInfoRspInterceptor.1
 * JD-Core Version:    0.7.0.1
 */