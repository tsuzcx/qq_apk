package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$7
  implements Runnable
{
  ExpandManager$7(ExpandManager paramExpandManager) {}
  
  public void run()
  {
    Object localObject = ExpandManager.b(this.this$0);
    if (localObject == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "parseConfig() try preload qflutter engine && app");
    }
    localObject = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
    EarlyHandler localEarlyHandler = ((IEarlyDownloadService)localObject).getEarlyHandler(QFlutterEngineData.STR_RES_NAME);
    if (localEarlyHandler != null) {
      localEarlyHandler.o();
    }
    localObject = ((IEarlyDownloadService)localObject).getEarlyHandler(QFlutterAppData.STR_RES_NAME);
    if (localObject != null) {
      ((EarlyHandler)localObject).o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.7
 * JD-Core Version:    0.7.0.1
 */