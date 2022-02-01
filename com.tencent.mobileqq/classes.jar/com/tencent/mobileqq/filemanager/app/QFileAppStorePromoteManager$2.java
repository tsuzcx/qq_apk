package com.tencent.mobileqq.filemanager.app;

import android.os.Handler;
import atae;
import atal;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.GetAppInfoManager;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.appinfo.data.AppParam;
import java.util.List;

public class QFileAppStorePromoteManager$2
  implements Runnable
{
  public QFileAppStorePromoteManager$2(atae paramatae, String paramString, atal paramatal) {}
  
  public void run()
  {
    AppDetailReqParam localAppDetailReqParam = new AppDetailReqParam();
    AppParam localAppParam = new AppParam();
    localAppParam.packageName = this.jdField_a_of_type_JavaLangString;
    localAppDetailReqParam.apps.add(localAppParam);
    localAppDetailReqParam.biz = "mobileqq_file";
    int i = GetAppInfoManager.get().requestAppInfo(localAppDetailReqParam, atae.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "getApkInfoByPackageName. reqId[" + i + "]");
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