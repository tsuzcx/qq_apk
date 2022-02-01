package com.tencent.mobileqq.filemanager.core;

import atrd;
import atuv;
import aume;
import aunj;
import bcrg;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class FileManagerRSWorker$12
  implements Runnable
{
  public FileManagerRSWorker$12(atuv paramatuv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + bcrg.a());
    }
    aume localaume = new aume();
    localaume.jdField_a_of_type_JavaLangString = this.this$0.e;
    localaume.jdField_a_of_type_Long = this.this$0.d;
    this.this$0.jdField_a_of_type_ArrayOfByte = aunj.e(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_ArrayOfByte = aunj.a(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.c = aunj.d(this.this$0.jdField_b_of_type_JavaLangString);
    if ((this.this$0.jdField_a_of_type_ArrayOfByte == null) || (this.this$0.jdField_b_of_type_ArrayOfByte == null) || (this.this$0.c == null))
    {
      this.this$0.a(null, 0);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.this$0.c);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ArrayOfByte);
    localaume.c = this.this$0.jdField_a_of_type_ArrayOfByte;
    localaume.e = this.this$0.jdField_b_of_type_ArrayOfByte;
    localaume.f = this.this$0.c;
    try
    {
      localaume.jdField_b_of_type_ArrayOfByte = aunj.a(this.this$0.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localaume.jdField_a_of_type_ArrayOfByte = this.this$0.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localaume, atuv.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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