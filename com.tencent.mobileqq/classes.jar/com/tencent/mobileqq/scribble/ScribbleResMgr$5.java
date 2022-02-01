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
    ScribbleResMgr.b(this.this$0, this.jdField_a_of_type_Int, 0, true);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new ScribbleResMgr.5.1(this);
    localHttpNetReq.mReqUrl = "";
    localHttpNetReq.mHttpMethod = 0;
    if (this.jdField_a_of_type_Int == 3)
    {
      localHttpNetReq.mReqUrl = ScribbleResMgr.e(this.this$0);
      localHttpNetReq.mOutPath = ScribbleResMgr.a(this.this$0);
    }
    if (this.jdField_a_of_type_Int == 4)
    {
      localHttpNetReq.mReqUrl = ScribbleResMgr.f(this.this$0);
      localHttpNetReq.mOutPath = ScribbleResMgr.c(this.this$0);
    }
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgrdownloading", 2, "startDownloadhttpscribbleRes, url: " + localHttpNetReq.mReqUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.5
 * JD-Core Version:    0.7.0.1
 */