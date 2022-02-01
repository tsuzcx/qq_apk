package com.tencent.mobileqq.flashshow.request.base;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;

public abstract class FSFakeInterceptor
  implements ReqInterceptor<FSBaseRequest, BaseSenderChain>, RspInterceptor<FSBaseRequest, BaseSenderChain>
{
  private Object a;
  private boolean b;
  
  public FSFakeInterceptor(boolean paramBoolean, Object paramObject)
  {
    this.b = paramBoolean;
    this.a = paramObject;
  }
  
  public void a(FSBaseRequest paramFSBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (this.b)
    {
      a(paramFSBaseRequest, this.a, paramBaseSenderChain);
      paramBaseSenderChain.b(true, 0L, "", paramFSBaseRequest, this.a);
    }
    paramBaseSenderChain.a(paramFSBaseRequest);
  }
  
  public abstract void a(FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain);
  
  public abstract void a(FSBaseRequest paramFSBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2);
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FSBaseRequest paramFSBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interceptReturnRsp retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramString);
    QLog.d("QCircleFakeInterceptor", 1, localStringBuilder.toString());
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramFSBaseRequest, paramObject);
    if ((this.b) && (paramLong != 0L))
    {
      a(paramFSBaseRequest, paramObject, paramBaseSenderChain, this.a);
      paramBaseSenderChain.b(false, paramLong, "", paramFSBaseRequest, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.base.FSFakeInterceptor
 * JD-Core Version:    0.7.0.1
 */