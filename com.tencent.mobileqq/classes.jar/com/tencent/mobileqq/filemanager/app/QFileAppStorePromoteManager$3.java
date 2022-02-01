package com.tencent.mobileqq.filemanager.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class QFileAppStorePromoteManager$3
  implements DialogInterface.OnClickListener
{
  QFileAppStorePromoteManager$3(QFileAppStorePromoteManager paramQFileAppStorePromoteManager, QFileAppStorePromoteManager.IAppStoreRemindCallback paramIAppStoreRemindCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE40", "0X800AE40", 0, 0, "", "", "", "");
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.3
 * JD-Core Version:    0.7.0.1
 */