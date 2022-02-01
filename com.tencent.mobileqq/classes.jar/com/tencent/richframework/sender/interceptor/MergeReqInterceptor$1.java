package com.tencent.richframework.sender.interceptor;

import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.util.EventControlUtils.OnDebounceListener;
import java.util.Map;

class MergeReqInterceptor$1
  implements EventControlUtils.OnDebounceListener
{
  MergeReqInterceptor$1(MergeReqInterceptor paramMergeReqInterceptor, String paramString, SenderChain paramSenderChain) {}
  
  public void a()
  {
    Object localObject = MergeReqInterceptor.a().get(this.a);
    if (localObject != null)
    {
      this.b.a(localObject);
      MergeReqInterceptor.a().remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.interceptor.MergeReqInterceptor.1
 * JD-Core Version:    0.7.0.1
 */