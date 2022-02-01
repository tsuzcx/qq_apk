package com.tencent.mobileqq.flashshow.personal.interceptor;

import android.os.Bundle;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class FSUIStateBaseManager<T, Q extends FSBaseRequest, R>
  implements ReqInterceptor<Q, BaseSenderChain>, RspInterceptor<Q, BaseSenderChain>
{
  private List<T> a;
  private boolean b = false;
  
  private List<T> b(List<T> paramList1, List<T> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.i(a(), 1, "cacheDatas and rspDatas both null");
      return new ArrayList();
    }
    if (paramList1 == null)
    {
      QLog.i(a(), 1, "cacheDatas is null");
      return paramList2;
    }
    if (paramList2 == null)
    {
      QLog.i(a(), 1, "rspDatas is null");
      return paramList1;
    }
    int i = paramList1.size();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      int m = 0;
      int j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= i) {
          break;
        }
        if (paramList1.get(j).equals(localObject))
        {
          paramList1.set(j, localObject);
          k = 1;
          break;
        }
        j += 1;
      }
      if (k == 0)
      {
        paramList1.add(localObject);
        i += 1;
      }
    }
    return paramList1;
  }
  
  private void c()
  {
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
    this.a = null;
  }
  
  public String a()
  {
    return "FSBaseUIStatusDataRspInterceptor";
  }
  
  protected abstract List<T> a(R paramR);
  
  protected List<T> a(List<T> paramList1, List<T> paramList2)
  {
    return b(paramList1, paramList2);
  }
  
  protected abstract void a(Q paramQ);
  
  public void a(Q paramQ, BaseSenderChain paramBaseSenderChain)
  {
    this.b = paramBaseSenderChain.b().getBoolean("fs_extra_data_key_is_load_more");
    if (this.b) {
      a(paramQ);
    }
    paramBaseSenderChain.b(false, 0L, "", paramQ, UIStateData.b().a(this.b, this.a));
    paramBaseSenderChain.a(paramQ);
  }
  
  public final void a(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if (!this.b) {
      c();
    }
    if ((paramBoolean) && (paramLong == 0L) && (paramObject != null))
    {
      paramBoolean = b(paramObject);
      this.a = a(this.a, a(paramObject));
      paramObject = this.a;
      if ((paramObject != null) && (!paramObject.isEmpty()))
      {
        paramBaseSenderChain.a(true, paramLong, paramString, paramQ, UIStateData.a(VSNetworkHelper.isProtocolCache(paramString)).a(this.b, this.a).c(paramBoolean));
        return;
      }
      paramBaseSenderChain.a(true, paramLong, paramString, paramQ, UIStateData.a().a(this.b, this.a).c(paramBoolean));
      return;
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQ, UIStateData.a(paramString).a(this.b, this.a).c(true));
  }
  
  public List<T> b()
  {
    return this.a;
  }
  
  protected abstract boolean b(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSUIStateBaseManager
 * JD-Core Version:    0.7.0.1
 */