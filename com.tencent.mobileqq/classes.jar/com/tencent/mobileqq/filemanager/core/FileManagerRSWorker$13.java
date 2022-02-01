package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class FileManagerRSWorker$13
  implements FMSettingInterface.MoveFileCallback
{
  FileManagerRSWorker$13(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(2005);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_b_of_type_Long, this.a.c, this.a.e, this.a.jdField_a_of_type_Int, 12, null, paramInt, null);
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.j, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.i, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "sdcard full", null);
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.k, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.e, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.i, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sdcard full", null);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramString1))
    {
      this.a.jdField_d_of_type_JavaLangString = paramString2;
      return;
    }
    if (this.a.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString1))
    {
      paramString1 = this.a;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.13
 * JD-Core Version:    0.7.0.1
 */