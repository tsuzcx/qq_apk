package com.tencent.richframework.sender.call;

import android.os.Bundle;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCall<T>
  implements Call<T>
{
  protected List<ReqInterceptor<T, BaseSenderChain>> a = new ArrayList();
  protected List<RspInterceptor> b = new ArrayList();
  protected Call.OnRspCallBack c;
  protected Bundle d = new Bundle();
  protected List<T> e = new ArrayList();
  protected List<SenderChain> f = new ArrayList();
  
  public BaseCall<T> a(Bundle paramBundle)
  {
    this.d.putAll(paramBundle);
    return this;
  }
  
  public BaseCall<T> a(Call.OnRspCallBack paramOnRspCallBack)
  {
    this.c = paramOnRspCallBack;
    return this;
  }
  
  public BaseCall<T> a(SenderChain paramSenderChain)
  {
    if (paramSenderChain != null) {
      this.f.add(paramSenderChain);
    }
    return this;
  }
  
  public BaseCall<T> a(ReqInterceptor paramReqInterceptor)
  {
    if (paramReqInterceptor != null) {
      this.a.add(paramReqInterceptor);
    }
    return this;
  }
  
  public BaseCall<T> a(RspInterceptor paramRspInterceptor)
  {
    this.b.add(paramRspInterceptor);
    return this;
  }
  
  public BaseCall<T> a(T paramT)
  {
    if (paramT != null) {
      this.e.add(paramT);
    }
    return this;
  }
  
  public BaseCall<T> b(Object paramObject)
  {
    if ((paramObject instanceof ReqInterceptor)) {
      a((ReqInterceptor)paramObject);
    }
    if ((paramObject instanceof RspInterceptor)) {
      a((RspInterceptor)paramObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.call.BaseCall
 * JD-Core Version:    0.7.0.1
 */