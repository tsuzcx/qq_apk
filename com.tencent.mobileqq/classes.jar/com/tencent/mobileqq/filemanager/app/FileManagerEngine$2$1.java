package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.concurrent.Executor;

class FileManagerEngine$2$1
  implements QFileAppStorePromoteManager.IGetAppDetailCallback
{
  FileManagerEngine$2$1(FileManagerEngine.2 param2) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waterTest, onGetAppDetailTimeLimit. apkName[");
    localStringBuilder.append(this.a.a.yybApkName);
    localStringBuilder.append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
    QQFileManagerUtil.FileExecutor.a().execute(this.a.b);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.a.yybApkPackageName = paramAppDetail.packageName;
    this.a.a.yybApkName = paramAppDetail.appName;
    this.a.a.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.2.1
 * JD-Core Version:    0.7.0.1
 */