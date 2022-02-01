package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$5
  implements Runnable
{
  ScribbleResMgr$5(ScribbleResMgr paramScribbleResMgr, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ScribbleResMgr.b(this.this$0, this.a, 0, true);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new ScribbleResMgr.5.1(this);
    localHttpNetReq.mReqUrl = "";
    localHttpNetReq.mHttpMethod = 0;
    if (this.a == 3)
    {
      localHttpNetReq.mReqUrl = ScribbleResMgr.f(this.this$0);
      localHttpNetReq.mOutPath = ScribbleResMgr.b(this.this$0);
    }
    if (this.a == 4)
    {
      localHttpNetReq.mReqUrl = ScribbleResMgr.g(this.this$0);
      localHttpNetReq.mOutPath = ScribbleResMgr.d(this.this$0);
    }
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownloadhttpscribbleRes, url: ");
      localStringBuilder.append(localHttpNetReq.mReqUrl);
      QLog.i("ScribbleResMgrdownloading", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.5
 * JD-Core Version:    0.7.0.1
 */