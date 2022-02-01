package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

class DatalineOldForwardHandler$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (DatalineOldForwardHandler.a(this.b).getIntExtra("forward_type", -1) == 11) {
      ReportCenter.a().a(this.b.a.getAccount(), "", String.valueOf(this.a), "1000", "52", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("DatalineOldForwardHandler", 2, "qbShowShareResultDialog stay");
    }
    if (DatalineOldForwardHandler.a(this.b).getBooleanExtra("MigSdkShareNotDone", false)) {
      DatalineOldForwardHandler.a(this.b).putExtra("MigSdkShareNotDone", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler.1
 * JD-Core Version:    0.7.0.1
 */