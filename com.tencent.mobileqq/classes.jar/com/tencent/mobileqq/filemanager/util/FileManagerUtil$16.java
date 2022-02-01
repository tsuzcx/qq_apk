package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

final class FileManagerUtil$16
  implements Runnable
{
  FileManagerUtil$16(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -3014, BaseApplicationImpl.getContext().getString(2131692638));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.16
 * JD-Core Version:    0.7.0.1
 */