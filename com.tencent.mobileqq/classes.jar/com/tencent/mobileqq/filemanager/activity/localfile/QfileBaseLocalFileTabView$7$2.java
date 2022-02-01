package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;

class QfileBaseLocalFileTabView$7$2
  implements Runnable
{
  QfileBaseLocalFileTabView$7$2(QfileBaseLocalFileTabView.7 param7, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$7.a.f();
    QfileBaseLocalFileTabView.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$7.a).getFileManagerRSCenter().a(this.jdField_a_of_type_Long);
    if (!this.jdField_a_of_type_Boolean)
    {
      FileManagerUtil.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      OpenWeiyunVipHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$7.a.a, this.jdField_a_of_type_Int);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2
 * JD-Core Version:    0.7.0.1
 */