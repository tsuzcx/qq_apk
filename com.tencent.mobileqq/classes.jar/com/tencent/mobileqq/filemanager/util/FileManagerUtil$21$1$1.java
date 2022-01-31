package com.tencent.mobileqq.filemanager.util;

import aoze;
import aozg;
import apgt;
import apug;
import apux;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class FileManagerUtil$21$1$1
  implements Runnable
{
  FileManagerUtil$21$1$1(FileManagerUtil.21.1 param1, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = apgt.a(apug.b(str));
    QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, set file download sucessed!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), "" }, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_Apux != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$21$1.this$0.jdField_a_of_type_Apux.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.21.1.1
 * JD-Core Version:    0.7.0.1
 */