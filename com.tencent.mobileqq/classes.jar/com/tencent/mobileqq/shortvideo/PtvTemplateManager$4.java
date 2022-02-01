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
    if (this.this$0.a(this.a)) {
      this.a.usable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        this.a.usable = false;
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PtvTemplateManager", 2, "preDownloadTemplates  null!");
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new PtvTemplateManager.4.1(this);
      localHttpNetReq.mReqUrl = this.a.resurl;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(PtvTemplateManager.a, this.a.name).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */