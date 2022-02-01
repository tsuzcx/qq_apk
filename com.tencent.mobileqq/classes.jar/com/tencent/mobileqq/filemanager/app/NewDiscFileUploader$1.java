package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanageraux.discoperation.IDiscFileOperatorBase;
import com.tencent.qphone.base.util.QLog;

class NewDiscFileUploader$1
  implements IDiscFileOperatorBase
{
  NewDiscFileUploader$1(NewDiscFileUploader paramNewDiscFileUploader, NewDiscFileUploader.UploaderCallback paramUploaderCallback) {}
  
  public void a()
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile success");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader.a = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(true);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject, int paramInt)
  {
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppNewDiscFileUploader$UploaderCallback.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.NewDiscFileUploader.1
 * JD-Core Version:    0.7.0.1
 */