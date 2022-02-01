package com.tencent.mobileqq.filemanager.app;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.GetAppInfoManager;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.appinfo.data.AppParam;
import java.util.List;

class QFileAppStorePromoteManager$2
  implements Runnable
{
  QFileAppStorePromoteManager$2(QFileAppStorePromoteManager paramQFileAppStorePromoteManager, String paramString, QFileAppStorePromoteManager.IGetAppDetailCallback paramIGetAppDetailCallback) {}
  
  public void run()
  {
    Object localObject = new AppDetailReqParam();
    AppParam localAppParam = new AppParam();
    localAppParam.packageName = this.a;
    ((AppDetailReqParam)localObject).apps.add(localAppParam);
    ((AppDetailReqParam)localObject).biz = "mobileqq_file";
    int i = GetAppInfoManager.get().requestAppInfo((AppDetailReqParam)localObject, QFileAppStorePromoteManager.a(this.this$0));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApkInfoByPackageName. reqId[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    if (i < 0)
    {
      ThreadManagerV2.getUIHandlerV2().post(new QFileAppStorePromoteManager.2.1(this));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QFileAppStorePromoteManager.2.2(this, i));
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileAppStorePromoteManager.2.3(this, i), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2
 * JD-Core Version:    0.7.0.1
 */