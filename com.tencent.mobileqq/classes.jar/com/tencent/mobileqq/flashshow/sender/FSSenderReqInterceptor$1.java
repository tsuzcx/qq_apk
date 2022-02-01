package com.tencent.mobileqq.flashshow.sender;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;

class FSSenderReqInterceptor$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  FSSenderReqInterceptor$1(FSSenderReqInterceptor paramFSSenderReqInterceptor, BaseSenderChain paramBaseSenderChain, BaseRequest paramBaseRequest) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    String str = this.c.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestCmd: ");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append("traceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append("isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    this.a.a(paramBoolean, paramLong, paramString, this.b, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.sender.FSSenderReqInterceptor.1
 * JD-Core Version:    0.7.0.1
 */