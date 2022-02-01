package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.concurrent.Executor;

class FileManagerEngine$2$1
  implements QFileAppStorePromoteManager.IGetAppDetailCallback
{
  FileManagerEngine$2$1(FileManagerEngine.2 param2) {}
  
  public void a()
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkName + "]");
    FileManagerUtil.FileExecutor.a().execute(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkPackageName = paramAppDetail.packageName;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkName = paramAppDetail.appName;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.2.1
 * JD-Core Version:    0.7.0.1
 */