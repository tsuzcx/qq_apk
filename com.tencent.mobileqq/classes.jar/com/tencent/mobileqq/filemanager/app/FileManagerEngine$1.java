package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class FileManagerEngine$1
  implements Runnable
{
  FileManagerEngine$1(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong, String paramString5) {}
  
  public void run()
  {
    FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.a.getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, this.b, true, this.c, 0L, true, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, -1L, MessageCache.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfile[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "], peerType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType + "]");
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(this.e)) {
        localBundle.putString("emptyPathCallStack", this.e);
      }
      this.this$0.a.getFileManagerRSCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, localBundle);
      return;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfileToWeiyun[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */