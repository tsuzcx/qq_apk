package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$4
  implements Runnable
{
  PtvTemplateManager$4(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a))
    {
      this.a.usable = true;
      return;
    }
    this.a.usable = false;
    Object localObject = this.this$0.j();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "preDownloadTemplates  null!");
      }
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new PtvTemplateManager.4.1(this);
    localHttpNetReq.mReqUrl = this.a.resurl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(PtvTemplateManager.e, this.a.name).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject).append(this.a.resurl);
      QLog.i("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */