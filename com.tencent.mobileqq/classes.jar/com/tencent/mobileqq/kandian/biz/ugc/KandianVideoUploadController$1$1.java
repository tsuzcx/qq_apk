package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;

class KandianVideoUploadController$1$1
  implements Runnable
{
  KandianVideoUploadController$1$1(KandianVideoUploadController.1 param1) {}
  
  public void run()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.a.a.a.getRuntimeService(IWebProcessManagerService.class, "");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess()))
    {
      localIWebProcessManagerService.startWebProcess(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d("allentest", 2, "sbbbb");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController.1.1
 * JD-Core Version:    0.7.0.1
 */