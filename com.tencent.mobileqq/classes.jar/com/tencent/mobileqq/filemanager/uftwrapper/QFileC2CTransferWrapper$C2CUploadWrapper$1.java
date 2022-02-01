package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class QFileC2CTransferWrapper$C2CUploadWrapper$1
  implements Runnable
{
  QFileC2CTransferWrapper$C2CUploadWrapper$1(QFileC2CTransferWrapper.C2CUploadWrapper paramC2CUploadWrapper) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    int i = 0;
    ((FileManagerEntity)localObject).isReaded = false;
    localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
      i = 16;
    }
    ((FileManagerEntity)localObject).status = i;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ! Id[");
    ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("] frend in blacklist!");
    QLog.e("QFileC2CTransferWrapper<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, -1, HardCodeUtil.a(2131704639));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CUploadWrapper.1
 * JD-Core Version:    0.7.0.1
 */