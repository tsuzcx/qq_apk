package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$1$1
  implements Runnable
{
  QfavFilePreviewController$1$1(QfavFilePreviewController.1 param1, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a))
    {
      localControlerCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)), QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null, QfavFilePreviewController.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null);
      QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, 3);
      return;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */