package com.tencent.mobileqq.filemanager.core;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

class FileManagerRSWorker$12
  implements Runnable
{
  FileManagerRSWorker$12(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("running OfflineFileHitReq:");
      ((StringBuilder)localObject).append(MessageCache.a());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new OfflineFileUploadPara();
    ((OfflineFileUploadPara)localObject).jdField_a_of_type_JavaLangString = this.this$0.e;
    ((OfflineFileUploadPara)localObject).jdField_a_of_type_Long = this.this$0.d;
    FileManagerRSWorker localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.jdField_a_of_type_ArrayOfByte = FileManagerUtil.d(localFileManagerRSWorker.jdField_b_of_type_JavaLangString);
    localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(localFileManagerRSWorker.jdField_b_of_type_JavaLangString);
    localFileManagerRSWorker = this.this$0;
    localFileManagerRSWorker.c = FileManagerUtil.c(localFileManagerRSWorker.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte != null) && (this.this$0.jdField_b_of_type_ArrayOfByte != null) && (this.this$0.c != null))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
      ((OfflineFileUploadPara)localObject).c = this.this$0.jdField_a_of_type_ArrayOfByte;
      ((OfflineFileUploadPara)localObject).e = this.this$0.jdField_b_of_type_ArrayOfByte;
      ((OfflineFileUploadPara)localObject).f = this.this$0.c;
      try
      {
        ((OfflineFileUploadPara)localObject).jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
        ((OfflineFileUploadPara)localObject).jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b((OfflineFileUploadPara)localObject, FileManagerRSWorker.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12
 * JD-Core Version:    0.7.0.1
 */