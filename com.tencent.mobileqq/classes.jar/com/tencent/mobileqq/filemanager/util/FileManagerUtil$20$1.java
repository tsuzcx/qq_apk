package com.tencent.mobileqq.filemanager.util;

import asgz;
import aszt;
import atad;
import atae;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

class FileManagerUtil$20$1
  implements Runnable
{
  FileManagerUtil$20$1(FileManagerUtil.20 param20) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    if (QLog.isColorLevel()) {
      QLog.i("CHECK_FILE_EXISTED", 1, "find file size[" + ((List)localObject).size() + "]");
    }
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label359;
        }
        localObject = (FileManagerEntity)localIterator.next();
        if (localObject != this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)
        {
          long l = new VFSFile(((FileManagerEntity)localObject).getFilePath()).lastModified();
          if (((FileManagerEntity)localObject).localModifyTime == l) {
            break;
          }
          QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, but local modified,localModifyTime[" + ((FileManagerEntity)localObject).localModifyTime + "], fileModified[" + l + "]");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("CHECK_FILE_EXISTED", 1, ((FileManagerEntity)localObject).fileName + " findFile 10md5[" + ((FileManagerEntity)localObject).str10Md5 + "], sha3[" + ((FileManagerEntity)localObject).strFileSha3 + "], md5[" + ((FileManagerEntity)localObject).strFileMd5 + "]");
      }
    } while (!aszt.a((FileManagerEntity)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    for (;;)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CHECK_FILE_EXISTED", 1, "cann't find exsited file,entity[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "]");
        }
        if (this.this$0.jdField_a_of_type_Atad != null) {
          this.this$0.jdField_a_of_type_Atad.a(false);
        }
        return;
      }
      atae.a().execute(new FileManagerUtil.20.1.1(this, (FileManagerEntity)localObject));
      return;
      label359:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.20.1
 * JD-Core Version:    0.7.0.1
 */