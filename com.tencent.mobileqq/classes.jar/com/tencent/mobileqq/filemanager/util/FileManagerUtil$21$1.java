package com.tencent.mobileqq.filemanager.util;

import aoza;
import apuq;
import apuv;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

class FileManagerUtil$21$1
  implements Runnable
{
  FileManagerUtil$21$1(FileManagerUtil.21 param21) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    if (QLog.isColorLevel()) {
      QLog.i("CHECK_FILE_EXISTED", 1, "find file size[" + ((List)localObject).size() + "]");
    }
    Iterator localIterator = ((List)localObject).iterator();
    FileManagerEntity localFileManagerEntity;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (localFileManagerEntity != this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)
        {
          long l = new VFSFile(localFileManagerEntity.getFilePath()).lastModified();
          if (localFileManagerEntity.localModifyTime != l)
          {
            QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, but local modified,localModifyTime[" + localFileManagerEntity.localModifyTime + "], fileModified[" + l + "]");
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("CHECK_FILE_EXISTED", 1, localFileManagerEntity.fileName + " findFile 10md5[" + localFileManagerEntity.str10Md5 + "], sha3[" + localFileManagerEntity.strFileSha3 + "], md5[" + localFileManagerEntity.strFileMd5 + "]");
            }
            if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid))) {
              localObject = localFileManagerEntity;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CHECK_FILE_EXISTED", 1, "cann't find exsited file,entity[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "]");
        }
        if (this.this$0.jdField_a_of_type_Apuv != null) {
          this.this$0.jdField_a_of_type_Apuv.a(false);
        }
        return;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA != null)
        {
          localObject = localFileManagerEntity;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA.equals(localFileManagerEntity.strFileSHA)) {
            continue;
          }
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null)
        {
          localObject = localFileManagerEntity;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.equals(localFileManagerEntity.strFileMd5)) {
            continue;
          }
          localObject = localFileManagerEntity;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.equals(localFileManagerEntity.str10Md5)) {
            continue;
          }
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileSha1 != null)
        {
          localObject = localFileManagerEntity;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileSha1.equals(localFileManagerEntity.strTroopFileSha1)) {
            continue;
          }
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 != null)
        {
          localObject = localFileManagerEntity;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3.equals(localFileManagerEntity.strFileSha3)) {
            continue;
          }
        }
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5.equals(localFileManagerEntity.str10Md5))) {
          break;
        }
        localObject = localFileManagerEntity;
        continue;
      }
      apuq.a().execute(new FileManagerUtil.21.1.1(this, (FileManagerEntity)localObject));
      return;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.21.1
 * JD-Core Version:    0.7.0.1
 */