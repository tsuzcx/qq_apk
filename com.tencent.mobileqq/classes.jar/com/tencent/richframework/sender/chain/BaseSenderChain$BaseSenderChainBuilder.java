package com.tencent.richframework.sender.chain;

import android.os.Bundle;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.lang.ref.WeakReference;
import java.util.List;

public final class BaseSenderChain$BaseSenderChainBuilder
{
  private static String a = "BaseSenderChainBuilder";
  private List<ReqInterceptor> b;
  private List<RspInterceptor> c;
  private WeakReference<Call.OnRspCallBack> d;
  private Bundle e;
  private int f;
  private int g;
  private List<SenderChain> h;
  
  public static BaseSenderChainBuilder a()
  {
    return new BaseSenderChainBuilder();
  }
  
  public BaseSenderChainBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public BaseSenderChainBuilder a(Bundle paramBundle)
  {
    this.e = paramBundle;
    return this;
  }
  
  public BaseSenderChainBuilder a(WeakReference<Call.OnRspCallBack> paramWeakReference)
  {
    this.d = paramWeakReference;
    return this;
  }
  
  public BaseSenderChainBuilder a(List<ReqInterceptor> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public BaseSenderChainBuilder b(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public BaseSenderChainBuilder b(List<RspInterceptor> paramList)
  {
    this.c = paramList;
    return this;
  }
  
  public BaseSenderChain b()
  {
    BaseSenderChain localBaseSenderChain = new BaseSenderChain();
    BaseSenderChain.a(localBaseSenderChain, this.g);
    BaseSenderChain.b(localBaseSenderChain, this.f);
    BaseSenderChain.a(localBaseSenderChain, this.d);
    BaseSenderChain.a(localBaseSenderChain, this.e);
    BaseSenderChain.a(localBaseSenderChain, this.b);
    BaseSenderChain.b(localBaseSenderChain, this.c);
    BaseSenderChain.c(localBaseSenderChain, this.h);
    return localBaseSenderChain;
  }
  
  public BaseSenderChainBuilder c(List<SenderChain> paramList)
  {
    this.h = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.chain.BaseSenderChain.BaseSenderChainBuilder
 * JD-Core Version:    0.7.0.1
 */