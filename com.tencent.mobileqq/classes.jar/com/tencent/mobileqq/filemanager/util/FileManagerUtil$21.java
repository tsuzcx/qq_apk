package com.tencent.mobileqq.filemanager.util;

import android.os.Handler;
import android.os.Looper;
import arnz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public final class FileManagerUtil$21
  implements Runnable
{
  public FileManagerUtil$21(FileManagerEntity paramFileManagerEntity, arnz paramarnz, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CHECK_FILE_EXISTED", 1, "checkFileExisted: entity is null");
      }
      if (this.jdField_a_of_type_Arnz != null) {
        this.jdField_a_of_type_Arnz.a(false);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("CHECK_FILE_EXISTED", 1, "checkFile 10md5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 + "], sha3[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 + "], md5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 2));
    new Handler(Looper.getMainLooper()).post(new FileManagerUtil.21.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.21
 * JD-Core Version:    0.7.0.1
 */