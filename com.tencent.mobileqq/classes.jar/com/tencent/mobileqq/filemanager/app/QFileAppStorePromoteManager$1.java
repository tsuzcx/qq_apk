package com.tencent.mobileqq.filemanager.app;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.GetAppInfoManager;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class QFileAppStorePromoteManager$1
  implements Runnable
{
  QFileAppStorePromoteManager$1(QFileAppStorePromoteManager paramQFileAppStorePromoteManager) {}
  
  public void run()
  {
    QLog.i("QFileAppStorePromoteManager<QFile>", 1, "initAppStoreSDK.");
    BaseApplication localBaseApplication = BaseApplication.getContext();
    TMAssistantCallYYB_V2.getInstance().initTMAssistantCallYYBApi(localBaseApplication);
    GetAppInfoManager.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1
 * JD-Core Version:    0.7.0.1
 */