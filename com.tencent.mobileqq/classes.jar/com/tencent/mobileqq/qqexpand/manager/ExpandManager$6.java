package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$6
  implements Runnable
{
  ExpandManager$6(ExpandManager paramExpandManager) {}
  
  public void run()
  {
    Object localObject = ExpandManager.a(this.this$0);
    if (localObject == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "parseConfig() try preload qflutter engine && app");
    }
    localObject = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
    EarlyHandler localEarlyHandler = ((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.flutter.engine.v8.7.0_release");
    if (localEarlyHandler != null) {
      localEarlyHandler.e();
    }
    localObject = ((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.flutter.app.v8.7.0_release");
    if (localObject != null) {
      ((EarlyHandler)localObject).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.6
 * JD-Core Version:    0.7.0.1
 */