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
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + MessageCache.a());
    }
    OfflineFileUploadPara localOfflineFileUploadPara = new OfflineFileUploadPara();
    localOfflineFileUploadPara.jdField_a_of_type_JavaLangString = this.this$0.e;
    localOfflineFileUploadPara.jdField_a_of_type_Long = this.this$0.d;
    this.this$0.jdField_a_of_type_ArrayOfByte = FileManagerUtil.e(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.c = FileManagerUtil.d(this.this$0.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null) || (this.this$0.c == null))
    {
      this.this$0.a(null, 0);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
    localOfflineFileUploadPara.c = this.this$0.jdField_a_of_type_ArrayOfByte;
    localOfflineFileUploadPara.e = this.this$0.jdField_b_of_type_ArrayOfByte;
    localOfflineFileUploadPara.f = this.this$0.c;
    try
    {
      localOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(localOfflineFileUploadPara, FileManagerRSWorker.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12
 * JD-Core Version:    0.7.0.1
 */