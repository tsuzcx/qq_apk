package com.tencent.mobileqq.filemanager.app;

import atae;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.GetAppInfoManager;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class QFileAppStorePromoteManager$1
  implements Runnable
{
  public QFileAppStorePromoteManager$1(atae paramatae) {}
  
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