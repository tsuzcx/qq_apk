package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class LebaQzoneAndPluginPart$6
  implements Runnable
{
  LebaQzoneAndPluginPart$6(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaBusinessPartImpl", 2, "checkPreloadGameCenter");
        }
        this.this$0.a(this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LebaBusinessPartImpl", 2, "checkPreloadGameCenter, send message delay");
      }
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "");
      if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess()) && (this.this$0.a != null))
      {
        this.this$0.a.removeMessages(1134010);
        this.this$0.a.sendEmptyMessageDelayed(1134010, 100L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("LebaBusinessPartImpl", 1, "checkPreloadGameCenter exception, e=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.6
 * JD-Core Version:    0.7.0.1
 */