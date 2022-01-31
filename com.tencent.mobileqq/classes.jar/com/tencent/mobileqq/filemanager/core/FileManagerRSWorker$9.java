package com.tencent.mobileqq.filemanager.core;

import aqpa;
import aqsk;
import armd;
import arni;
import ayvc;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$9
  implements Runnable
{
  public FileManagerRSWorker$9(aqsk paramaqsk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + ayvc.a());
    }
    armd localarmd = new armd();
    localarmd.jdField_a_of_type_JavaLangString = this.this$0.e;
    localarmd.jdField_a_of_type_Long = this.this$0.d;
    this.this$0.jdField_a_of_type_ArrayOfByte = arni.d(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_ArrayOfByte = arni.a(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.c = arni.c(this.this$0.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null) || (this.this$0.c == null))
    {
      this.this$0.a(null, 0);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
    localarmd.c = this.this$0.jdField_a_of_type_ArrayOfByte;
    localarmd.d = this.this$0.jdField_b_of_type_ArrayOfByte;
    localarmd.e = this.this$0.c;
    try
    {
      localarmd.jdField_b_of_type_ArrayOfByte = arni.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localarmd.jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localarmd, aqsk.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */