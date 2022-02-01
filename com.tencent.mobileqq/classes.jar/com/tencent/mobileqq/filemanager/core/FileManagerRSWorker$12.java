package com.tencent.mobileqq.filemanager.core;

import atht;
import atll;
import aucv;
import auea;
import bcrg;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$12
  implements Runnable
{
  public FileManagerRSWorker$12(atll paramatll) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + bcrg.a());
    }
    aucv localaucv = new aucv();
    localaucv.jdField_a_of_type_JavaLangString = this.this$0.e;
    localaucv.jdField_a_of_type_Long = this.this$0.d;
    this.this$0.jdField_a_of_type_ArrayOfByte = auea.e(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_ArrayOfByte = auea.a(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.c = auea.d(this.this$0.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null) || (this.this$0.c == null))
    {
      this.this$0.a(null, 0);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
    localaucv.c = this.this$0.jdField_a_of_type_ArrayOfByte;
    localaucv.e = this.this$0.jdField_b_of_type_ArrayOfByte;
    localaucv.f = this.this$0.c;
    try
    {
      localaucv.jdField_b_of_type_ArrayOfByte = auea.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localaucv.jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(localaucv, atll.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12
 * JD-Core Version:    0.7.0.1
 */