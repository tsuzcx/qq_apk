package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
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
    if (this.this$0.a(this.a, true)) {
      this.a.doodleUsable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "reqApp:" + localQQAppInterface);
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new PtvTemplateManager.14.1(this);
      localHttpNetReq.mReqUrl = this.a.doodleUrl;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(PtvTemplateManager.b, this.a.doodleName).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.14
 * JD-Core Version:    0.7.0.1
 */