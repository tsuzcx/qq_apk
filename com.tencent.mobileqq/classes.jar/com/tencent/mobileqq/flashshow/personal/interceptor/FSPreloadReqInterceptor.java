package com.tencent.mobileqq.flashshow.personal.interceptor;

import android.text.TextUtils;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

public class FSPreloadReqInterceptor
  implements OnTaskListener<Object>, ReqInterceptor<FSBaseRequest, BaseSenderChain>
{
  private final String a;
  private FSBaseRequest b;
  private BaseSenderChain c;
  private final boolean d;
  
  public FSPreloadReqInterceptor(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.d = paramBoolean;
  }
  
  public String a()
  {
    return "FSPreloadReqInterceptor";
  }
  
  public void a(FSBaseRequest paramFSBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    this.b = paramFSBaseRequest;
    this.c = paramBaseSenderChain;
    if (TextUtils.isEmpty(this.a))
    {
      paramBaseSenderChain.a(paramFSBaseRequest);
      return;
    }
    if (this.d)
    {
      PreLoader.preLoad(this.a, new FSPreloadReqInterceptor.1(this, paramFSBaseRequest));
      return;
    }
    if (PreLoader.exists(this.a))
    {
      PreLoader.addListener(this.a, this);
      return;
    }
    paramBaseSenderChain.a(paramFSBaseRequest);
  }
  
  public void onComplete(Object... paramVarArgs)
  {
    if (this.c != null)
    {
      if (this.b == null) {
        return;
      }
      try
      {
        boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
        long l = ((Long)paramVarArgs[1]).longValue();
        String str = (String)paramVarArgs[2];
        paramVarArgs = paramVarArgs[3];
        this.c.a(bool, l, str, this.b, paramVarArgs);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e(a(), 1, paramVarArgs.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSPreloadReqInterceptor
 * JD-Core Version:    0.7.0.1
 */