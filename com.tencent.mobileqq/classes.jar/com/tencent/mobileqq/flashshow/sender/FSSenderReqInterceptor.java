package com.tencent.mobileqq.flashshow.sender;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

public class FSSenderReqInterceptor
  implements ReqInterceptor<BaseRequest, BaseSenderChain>
{
  public String a()
  {
    return "FSSenderReqInterceptor";
  }
  
  public void a(BaseRequest paramBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (paramBaseRequest != null)
    {
      if (paramBaseSenderChain == null) {
        return;
      }
      VSNetworkHelper.getInstance().sendRequest(RFApplication.getApplication(), paramBaseRequest, new FSSenderReqInterceptor.1(this, paramBaseSenderChain, paramBaseRequest));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.sender.FSSenderReqInterceptor
 * JD-Core Version:    0.7.0.1
 */