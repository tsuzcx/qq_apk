package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.IGetAppDetailCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.concurrent.Executor;

class QFileC2CTransferWrapper$3$1
  implements QFileAppStorePromoteManager.IGetAppDetailCallback
{
  QFileC2CTransferWrapper$3$1(QFileC2CTransferWrapper.3 param3) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waterTest, onGetAppDetailTimeLimit. apkName[");
    localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkName);
    localStringBuilder.append("]");
    QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, localStringBuilder.toString());
    QQFileManagerUtil.FileExecutor.a().execute(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkPackageName = paramAppDetail.packageName;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkName = paramAppDetail.appName;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */