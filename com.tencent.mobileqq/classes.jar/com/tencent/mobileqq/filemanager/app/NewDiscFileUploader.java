package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanageraux.discoperation.DiscFileUploader;
import com.tencent.mobileqq.filemanageraux.discoperation.FileHttpUploder;
import com.tencent.mobileqq.filemanageraux.discoperation.FileReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class NewDiscFileUploader
  implements IFileHttpBase
{
  long jdField_a_of_type_Long = FileManagerUtil.a().longValue();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  NewDiscFileUploader.UploaderCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback;
  DiscFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationDiscFileUploader = new DiscFileUploader();
  FileHttpUploder jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileHttpUploder;
  boolean jdField_a_of_type_Boolean = true;
  long b;
  
  public NewDiscFileUploader(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2, String paramString5, String paramString6, NewDiscFileUploader.UploaderCallback paramUploaderCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback = paramUploaderCallback;
    this.b = paramLong;
    paramQQAppInterface = new FileReportData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actDiscussFileUp");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationDiscFileUploader.a(paramString1, paramString2, paramLong, new NewDiscFileUploader.1(this, paramUploaderCallback));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationFileHttpUploder = new FileHttpUploder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQQAppInterface, paramString3, paramInt1, paramString5, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDiscoperationDiscFileUploader, paramBoolean, paramString4, paramString6);
  }
  
  public int a()
  {
    return 41;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public FileManagerEntity a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void aw_()
  {
    this.jdField_a_of_type_Boolean = false;
    FileManagerUtil.FileExecutor.a().execute(new NewDiscFileUploader.2(this));
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.e("FileMultiMsg", 1, "sendDiscFile faild:clearTask");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:networkBroken");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:userCancel");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:exceptBroken");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.NewDiscFileUploader
 * JD-Core Version:    0.7.0.1
 */