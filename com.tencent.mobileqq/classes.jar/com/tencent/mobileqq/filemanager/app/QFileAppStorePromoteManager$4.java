package com.tencent.mobileqq.filemanager.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class QFileAppStorePromoteManager$4
  implements DialogInterface.OnClickListener
{
  QFileAppStorePromoteManager$4(QFileAppStorePromoteManager paramQFileAppStorePromoteManager, QFileAppStorePromoteManager.IAppStoreRemindCallback paramIAppStoreRemindCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE41", "0X800AE41", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$IAppStoreRemindCallback;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.4
 * JD-Core Version:    0.7.0.1
 */