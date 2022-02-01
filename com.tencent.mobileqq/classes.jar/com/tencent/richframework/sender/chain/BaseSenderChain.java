package com.tencent.richframework.sender.chain;

import android.os.Bundle;
import android.util.Log;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class BaseSenderChain<Q>
  implements SenderChain<Q>
{
  private List<ReqInterceptor> a;
  private List<RspInterceptor> b;
  private WeakReference<Call.OnRspCallBack> c;
  private Bundle d;
  private int e;
  private int f;
  private List<SenderChain> g;
  
  public Call.OnRspCallBack a()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference != null) {
      return (Call.OnRspCallBack)localWeakReference.get();
    }
    return null;
  }
  
  public void a(Q paramQ)
  {
    if (paramQ == null) {
      return;
    }
    if (this.e >= this.a.size())
    {
      Log.e("QCircleSendChain", "addRequest: errorIndex");
      return;
    }
    ReqInterceptor localReqInterceptor = (ReqInterceptor)this.a.get(this.e);
    BaseSenderChain.BaseSenderChainBuilder localBaseSenderChainBuilder = BaseSenderChain.BaseSenderChainBuilder.a().a(this.a).b(this.b).a(this.c);
    int i = this.e + 1;
    this.e = i;
    localReqInterceptor.a(paramQ, localBaseSenderChainBuilder.a(i).b(this.f).a(this.d).c(this.g).b());
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject)
  {
    if (this.f > this.b.size())
    {
      Log.e("QCircleSendChain", "handleRspAsync: errorIndex");
      return;
    }
    if (this.f == this.b.size())
    {
      b(paramBoolean, paramLong, paramString, paramQ, paramObject);
      return;
    }
    ((RspInterceptor)this.b.get(this.f)).interceptReturnRsp(paramBoolean, paramLong, paramString, paramQ, paramObject, BaseSenderChain.BaseSenderChainBuilder.a().a(this.a).b(this.b).a(this.c).a(this.e).b(this.f + 1).a(this.d).c(this.g).b());
  }
  
  public Bundle b()
  {
    return this.d;
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (Call.OnRspCallBack)((WeakReference)localObject).get();
      if (localObject != null) {
        ((Call.OnRspCallBack)localObject).a(paramBoolean, paramLong, paramString, paramQ, paramObject, this.d);
      } else {
        Log.d("QCircleSendChain", "callBack is null");
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SenderChain)((Iterator)localObject).next()).a(paramBoolean, paramLong, paramString, paramQ, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.chain.BaseSenderChain
 * JD-Core Version:    0.7.0.1
 */