package com.tencent.mobileqq.flashshow.data.call;

import android.os.Bundle;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSPreloadReqInterceptor;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSUIStateBaseManager;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.sender.FSSenderReqInterceptor;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.chain.BaseSenderChain.BaseSenderChainBuilder;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSRequestCall
  extends BaseCall<FSBaseRequest>
{
  private WeakReference<FSUIStateBaseManager> g;
  private FSPreloadReqInterceptor h;
  
  private void a(List<ReqInterceptor> paramList)
  {
    WeakReference localWeakReference = this.g;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      paramList.add(this.g.get());
    }
  }
  
  private void b(List<RspInterceptor> paramList)
  {
    WeakReference localWeakReference = this.g;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      paramList.add(this.g.get());
    }
  }
  
  private void c(List<ReqInterceptor> paramList)
  {
    FSPreloadReqInterceptor localFSPreloadReqInterceptor = this.h;
    if (localFSPreloadReqInterceptor != null)
    {
      paramList.add(localFSPreloadReqInterceptor);
      return;
    }
    paramList.add(new FSSenderReqInterceptor());
  }
  
  public FSRequestCall a(FSUIStateBaseManager paramFSUIStateBaseManager)
  {
    this.g = new WeakReference(paramFSUIStateBaseManager);
    return this;
  }
  
  public FSRequestCall a(String paramString)
  {
    this.h = new FSPreloadReqInterceptor(paramString, false);
    return this;
  }
  
  public FSRequestCall a(String paramString, FSBaseRequest paramFSBaseRequest)
  {
    this.h = new FSPreloadReqInterceptor(paramString, true);
    a(paramFSBaseRequest);
    return this;
  }
  
  public FSRequestCall a(boolean paramBoolean)
  {
    this.d.putBoolean("fs_extra_data_key_is_load_more", paramBoolean);
    return this;
  }
  
  public void a()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    a((List)localObject1);
    ((List)localObject1).addAll(this.a);
    c((List)localObject1);
    ((List)localObject2).addAll(this.b);
    b((List)localObject2);
    localObject1 = BaseSenderChain.BaseSenderChainBuilder.a().a((List)localObject1).b((List)localObject2).a(new WeakReference(this.c)).a(0).b(0).a(this.d).c(this.f).b();
    localObject2 = this.e.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((BaseSenderChain)localObject1).a((FSBaseRequest)((Iterator)localObject2).next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.call.FSRequestCall
 * JD-Core Version:    0.7.0.1
 */