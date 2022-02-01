package com.tencent.mobileqq.filemanager.util;

import atup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileManagerUtil$15
  implements Runnable
{
  public FileManagerUtil$15(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -3014, BaseApplicationImpl.getContext().getString(2131692355));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.15
 * JD-Core Version:    0.7.0.1
 */