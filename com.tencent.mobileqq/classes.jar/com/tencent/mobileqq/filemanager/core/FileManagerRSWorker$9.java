package com.tencent.mobileqq.filemanager.core;

import aowc;
import aozm;
import aptb;
import apug;
import awzy;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$9
  implements Runnable
{
  public FileManagerRSWorker$9(aozm paramaozm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + awzy.a());
    }
    aptb localaptb = new aptb();
    localaptb.jdField_a_of_type_JavaLangString = this.this$0.e;
    localaptb.jdField_a_of_type_Long = this.this$0.d;
    this.this$0.jdField_a_of_type_ArrayOfByte = apug.d(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_ArrayOfByte = apug.a(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.c = apug.c(this.this$0.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null) || (this.this$0.c == null))
    {
      this.this$0.a(null, 0);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
    localaptb.c = this.this$0.jdField_a_of_type_ArrayOfByte;
    localaptb.d = this.this$0.jdField_b_of_type_ArrayOfByte;
    localaptb.e = this.this$0.c;
    try
    {
      localaptb.jdField_b_of_type_ArrayOfByte = apug.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localaptb.jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localaptb, aozm.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.9
 * JD-Core Version:    0.7.0.1
 */