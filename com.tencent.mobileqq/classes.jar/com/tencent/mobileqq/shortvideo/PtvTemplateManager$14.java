package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$14
  implements Runnable
{
  PtvTemplateManager$14(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a, true))
    {
      this.a.doodleUsable = true;
      return;
    }
    Object localObject1 = this.this$0.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reqApp:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = new PtvTemplateManager.14.1(this);
    ((HttpNetReq)localObject2).mReqUrl = this.a.doodleUrl;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    ((HttpNetReq)localObject2).mOutPath = new File(PtvTemplateManager.b, this.a.doodleName).getPath();
    ((HttpNetReq)localObject2).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)((QQAppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject1).append(this.a.doodleUrl);
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.14
 * JD-Core Version:    0.7.0.1
 */