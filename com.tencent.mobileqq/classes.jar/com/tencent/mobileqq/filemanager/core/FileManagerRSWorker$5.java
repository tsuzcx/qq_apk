package com.tencent.mobileqq.filemanager.core;

import aozg;
import aozm;
import apue;
import apuf;
import apug;
import awzy;
import bbfj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerRSWorker$5
  implements Runnable
{
  public FileManagerRSWorker$5(aozm paramaozm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Running RSWorker:" + awzy.a());
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ("run task sessionid[" + String.valueOf(this.this$0.c) + "]," + " actionType[" + String.valueOf(this.this$0.jdField_b_of_type_Int) + "], " + "strUin[" + this.this$0.e == null) {
        break label380;
      }
      localObject = apug.e(this.this$0.e);
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, (String)localObject);
      if (bbfj.d(BaseApplicationImpl.getContext())) {
        break;
      }
      this.this$0.a(0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_b_of_type_Long, this.this$0.c, this.this$0.e, this.this$0.jdField_a_of_type_Int, 1, null, 2, null);
      apug.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_i_of_type_JavaLangString, this.this$0.jdField_g_of_type_Long, aozm.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", aozm.a(this.this$0), "NoNetWork", null);
      apug.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.j, this.this$0.jdField_g_of_type_Long, aozm.a(this.this$0), this.this$0.e, this.this$0.jdField_g_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.this$0.d, "", "", aozm.b(this.this$0), "NoNetWork", null);
      return;
      label380:
      if ("null], filePath[" + this.this$0.jdField_b_of_type_JavaLangString != null) {
        localObject = this.this$0.jdField_b_of_type_JavaLangString;
      } else {
        localObject = "null], uniseq[" + String.valueOf(this.this$0.jdField_b_of_type_Long) + "]";
      }
    }
    this.this$0.jdField_g_of_type_Long = System.currentTimeMillis();
    this.this$0.jdField_i_of_type_Long = 0L;
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    switch (this.this$0.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      return;
      localObject = new apuf();
      ((apuf)localObject).jdField_b_of_type_JavaLangString = "send_file_number";
      apue.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apuf)localObject);
      this.this$0.b();
      continue;
      localObject = new apuf();
      ((apuf)localObject).jdField_b_of_type_JavaLangString = "rece_file_number";
      apue.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apuf)localObject);
      this.this$0.f();
      continue;
      this.this$0.h();
      continue;
      aozm.a(this.this$0);
      continue;
      this.this$0.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.5
 * JD-Core Version:    0.7.0.1
 */