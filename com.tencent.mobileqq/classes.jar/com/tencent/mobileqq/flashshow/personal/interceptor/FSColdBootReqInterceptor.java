package com.tencent.mobileqq.flashshow.personal.interceptor;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.request.feed.FSTabFeedRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class FSColdBootReqInterceptor
  implements ReqInterceptor<FSBaseRequest, BaseSenderChain>
{
  public String a()
  {
    return "FSColdBootReqInterceptor";
  }
  
  public void a(FSBaseRequest paramFSBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramFSBaseRequest instanceof FSTabFeedRequest))
    {
      Object localObject = (FSTabFeedRequest)paramFSBaseRequest;
      if ((((FSTabFeedRequest)localObject).getRequestSource() == 41) && (((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).isAvailable()))
      {
        String str = ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).doGetAttachInfo();
        byte[] arrayOfByte = ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).doGetPreloadRspData();
        FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
        try
        {
          localStGetFeedListRsp.mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if ((!TextUtils.isEmpty(str)) && (localStGetFeedListRsp.has()))
        {
          ((FSTabFeedRequest)localObject).setAttachInfo(str);
          paramBaseSenderChain.a(true, 0L, "", paramFSBaseRequest, localStGetFeedListRsp);
          QLog.d(a(), 1, "direct return cold boot preload rsp");
          ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).inactivate();
          return;
        }
        localObject = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invalid preload data attachInfo:");
        localStringBuilder.append(str);
        localStringBuilder.append(",rsp:");
        localStringBuilder.append(localStGetFeedListRsp.has());
        localStringBuilder.append(",request through normal flow");
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        b(paramFSBaseRequest, paramBaseSenderChain);
        return;
      }
      b(paramFSBaseRequest, paramBaseSenderChain);
    }
  }
  
  void b(FSBaseRequest paramFSBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    paramBaseSenderChain.a(paramFSBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSColdBootReqInterceptor
 * JD-Core Version:    0.7.0.1
 */