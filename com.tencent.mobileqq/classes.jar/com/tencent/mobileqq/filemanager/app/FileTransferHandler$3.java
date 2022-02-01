package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class FileTransferHandler$3
  implements Runnable
{
  FileTransferHandler$3(FileTransferHandler paramFileTransferHandler, String paramString, int paramInt, short paramShort, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.a.getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.msgSeq = this.jdField_a_of_type_Short;
      localFileManagerEntity.msgUid = this.jdField_a_of_type_Long;
      localFileManagerEntity.msgTime = this.b;
      this.this$0.a.getFileManagerProxy().f(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "online change to offline, update offline msg seq , uid and msgTime" + FileManagerUtil.a(localFileManagerEntity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.3
 * JD-Core Version:    0.7.0.1
 */