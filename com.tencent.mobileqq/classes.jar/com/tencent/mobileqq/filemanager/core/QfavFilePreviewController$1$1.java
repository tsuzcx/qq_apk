package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$1$1
  implements Runnable
{
  QfavFilePreviewController$1$1(QfavFilePreviewController.1 param1, Bundle paramBundle) {}
  
  public void run()
  {
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRemoteCmd: mHost=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a));
      ((StringBuilder)localObject).append(", port=");
      ((StringBuilder)localObject).append(String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)));
      ((StringBuilder)localObject).append(", key=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a));
      ((StringBuilder)localObject).append(", retCode =");
      ((StringBuilder)localObject).append(String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)));
      QLog.i("QfavFilePreviewController", 2, ((StringBuilder)localObject).toString());
    }
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a.a;
      boolean bool;
      if (0L == QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)) {
        bool = true;
      } else {
        bool = false;
      }
      ((ControlerCallback)localObject).a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a)), QfavFilePreviewController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null, QfavFilePreviewController.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a), null);
    }
    QfavFilePreviewController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreQfavFilePreviewController$1.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */